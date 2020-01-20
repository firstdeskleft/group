/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.controllers;

import com.firstdeskleft.entities.Customer;
import com.firstdeskleft.entities.Tour;
import com.firstdeskleft.service.CustomerService;
import com.firstdeskleft.service.TourService;
import java.util.List;
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
    TourService tservice;

    @Autowired
    CustomerService cservice;

    @GetMapping("/create")
    public String createBooking(Model model,
            @RequestParam("tid") Integer tid, @ModelAttribute("user") Customer customer) {
        Boolean isNegative=false;
        
        Tour t = tservice.findTourById(tid);

        if (t.getCost() > customer.getCredits()) {
            isNegative=true;
            model.addAttribute("isNegative",isNegative);
            
            
            
            return "forward:/tour/listforcustomer";
        } else {

            Integer Credits = customer.getCredits() - t.getCost();
            customer.setCredits(customer.getCredits() - t.getCost());
            t.getGuide().setProfits(t.getCost() + t.getGuide().getProfits());
        }

        customer.addTour(t);
        cservice.UpdateCustomer(customer);

        return "Bookings";
    }

    @GetMapping("/delete")
    public String cancelBooking(@RequestParam("tid") Integer tid, @ModelAttribute("user") Customer customer) {
        Tour t = tservice.findTourById(tid);
        System.out.println("--------------------------BookingController before remove tour" + customer.getTours());
        customer.removeTour(t);

        cservice.UpdateCustomer(customer);
        System.out.println("--------------------------BookingController before remove tour" + customer.getTours());
        return "Bookings";
    }

}
