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
@SessionAttributes({"user"})
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

        Boolean insufficientCredits = false;

        Tour tour = tourService.findTourById(tid);

        Integer tourCost = tour.getCost();

        Integer customerCredits = customer.getCredits();

        if (customerCredits < tourCost) {

            insufficientCredits = true;

            model.addAttribute("isNegative", insufficientCredits);

            errorMessage = "Insufficient credits";

            forwardToTourList(model, errorMessage);

        } else {

            //Integer Credits = customer.getCredits() - tour.getCost();
            //customer.setCredits(customer.getCredits() - tour.getCost());
            //tour.getGuide().setProfits(tour.getCost() + tour.getGuide().getProfits());
            Boolean withdrawAccomplished = customer.withdraw(tourCost);

            if (!withdrawAccomplished) {

                System.err.println("Error withdrawing ammount");

                errorMessage = "Error withdrawing ammount";

                forwardToTourList(model, errorMessage);
            }

            Guide guide = tour.getGuide();

            if (guide == null) {

                System.err.println("Error finding guide. Cancelling transaction and removing tour from database.");

                errorMessage = "Error finding guide. Cancelling transaction and removing tour from database.";

                customer.deposit(tourCost);

                tourService.deleteTour(tour.getTid());

                forwardToTourList(model, errorMessage);

            }

            Boolean depositAccomplised = guide.deposit(tourCost);

            if (!depositAccomplised) {

                System.err.println("Error depositing ammount. Cancelling transaction");
                errorMessage = "Error depositing ammount. Cancelling transaction";

                customer.deposit(tourCost);

                forwardToTourList(model, errorMessage);
            }

            Boolean customerAddedTour = customer.addTour(tour);

            if (!customerAddedTour) {

                System.err.println("Error adding tour to customer's booked tours. Cancelling transaction");
                errorMessage = "Error adding tour to customer's booked tours. Cancelling transaction";
                
                customer.deposit(tourCost);

                guide.withdraw(tourCost);

                forwardToTourList(model, errorMessage);

            }

            Boolean tourAddedCustomer = tour.getCustomers().add(customer);

            if (!tourAddedCustomer) {
                
                System.out.println("Error adding customer to tour's customers list. Cancelling transaction");
                errorMessage = "Error adding customer to tour's customers list. Cancelling transaction";
                
                customer.deposit(tourCost);

                guide.withdraw(tourCost);

                forwardToTourList(model, errorMessage);

            }

            customerService.UpdateCustomer(customer);
            guideService.UpdateGuide(guide);
        }
        
        System.out.println("Transaction completed successfully");
        
        return "Bookings";
        
    }

    public String forwardToTourList(Model model, String errorMessage) {

        model.addAttribute("isNegative", errorMessage);

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
