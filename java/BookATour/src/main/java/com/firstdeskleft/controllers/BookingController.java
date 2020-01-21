package com.firstdeskleft.controllers;

import com.firstdeskleft.entities.Customer;
import com.firstdeskleft.entities.Tour;
import com.firstdeskleft.service.BookingService;
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

    @Autowired
    BookingService bookingService;

    @Autowired
    TourService tourService;

    @Autowired
    CustomerService customerService;

    @Autowired
    GuideService guideService;

    @GetMapping("/create")
    public String createBooking(Model model, @RequestParam("tid") Integer tid, @ModelAttribute("user") Customer customer) {

        String resultBooking = bookingService.attempBooking(tid, customer);

        if (resultBooking.equals("success")) {

            System.out.println("BookingContoller after success. Before updating customer:" + customer);

            customerService.UpdateCustomer(customer);

            System.out.println("BookingContoller after updating customer:" + customer);

            System.out.println("Transaction completed successfully");

            return "Bookings";

        } else {
            model.addAttribute("hasError", true);
            model.addAttribute("errorMessage", resultBooking);

            System.out.println("Returning to tour page");

            return "forward:/tour/listforcustomer";
        }

    }

    @GetMapping("/delete")
    public String cancelBooking(@RequestParam("tid") Integer tid, @ModelAttribute("user") Customer customer) {
        System.out.println("--------------------------------------------------------------------Tour id =" +tid);
        Tour t = tourService.findTourById(tid);
        System.out.println("--------------------------------------------------------------------Tour is= "  +t);
        System.out.println("--------------------------BookingController before remove tour" + customer.getTours());
        customer.removeTour(t);
        System.out.println("---------------------------");
        customerService.UpdateCustomer(customer);
        System.out.println("--------------------------BookingController after  remove tour" + customer.getTours());
        return "Bookings";
    }

}
