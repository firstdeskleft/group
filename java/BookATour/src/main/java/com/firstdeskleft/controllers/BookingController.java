package com.firstdeskleft.controllers;

import com.firstdeskleft.entities.Customer;
import com.firstdeskleft.entities.Guide;
import com.firstdeskleft.entities.Tour;
import com.firstdeskleft.service.CustomerService;
import com.firstdeskleft.service.GuideService;
import com.firstdeskleft.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/booking")
@SessionAttributes({"user", "errorMessage", "hasError"})
public class BookingController {

//    @Autowired
//    BookingService bservice;
    @Autowired
    TourService tourService;

    @Autowired
    CustomerService customerService;

    @Autowired
    GuideService guideService;

    @GetMapping("/create")
    public String createBooking(Model model, @RequestParam("tid") Integer tid, @ModelAttribute("user") Customer customer) {

        String errorMessage = "";


        Tour tour = tourService.findTourById(tid);
        
        if(tour == null){
            
            errorMessage="Tour not found";
            
            forwardToTourListError(model, errorMessage);
        }

        Integer tourCost = tour.getCost();

        Integer customerCredits = customer.getCredits();

        if (customerCredits < tourCost) {

            errorMessage = "Insufficient credits";

            forwardToTourListError(model, errorMessage);

        }

        Boolean withdrawAccomplished = customer.withdraw(tourCost);

        if (!withdrawAccomplished) {

            errorMessage = "Error withdrawing ammount";

            forwardToTourListError(model, errorMessage);
        }

        Guide guide = tour.getGuide();

        if (guide == null) {

            errorMessage = "Error finding guide. Cancelling transaction and removing tour from database.";

            customer.deposit(tourCost);

            tourService.deleteTour(tour.getTid());

            forwardToTourListError(model, errorMessage);

        }

        Boolean depositAccomplised = guide.deposit(tourCost);

        if (!depositAccomplised) {

            errorMessage = "Error depositing ammount. Cancelling transaction";

            customer.deposit(tourCost);

            forwardToTourListError(model, errorMessage);
        }

        Boolean customerAddedTour = customer.addTour(tour);

        if (!customerAddedTour) {

            errorMessage = "Error linking customer to tour. Cancelling transaction";

            customer.deposit(tourCost);

            guide.withdraw(tourCost);

            forwardToTourListError(model, errorMessage);

        }



        customerService.UpdateCustomer(customer);
        tourService.save(tour);
        guideService.UpdateGuide(guide);

        System.out.println("Transaction completed successfully");

        return "Bookings";

    }

    public String forwardToTourListError(Model model, String errorMessage) {

        model.addAttribute("hasError", true);
        model.addAttribute("errorMessage", errorMessage);
        
        System.out.println("Returning to tour page");

        return "forward:/tour/listforcustomer";
    }

    @GetMapping("/delete")
    public String cancelBooking(@RequestParam("tid") Integer tid, @ModelAttribute("user") Customer customer) {
        Tour t = tourService.findTourById(tid);
        System.out.println("--------------------------BookingController before remove tour" + customer.getTours());
        customer.removeTour(t);

        customerService.UpdateCustomer(customer);
        System.out.println("--------------------------BookingController before remove tour" + customer.getTours());
        return "Bookings";
    }

}
