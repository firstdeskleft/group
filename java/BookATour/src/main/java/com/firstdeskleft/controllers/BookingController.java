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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/booking")
@SessionAttributes("user")
public class BookingController {

//    @Autowired
//    BookingService bservice;

    @Autowired
    TourService tservice;

    @Autowired
    CustomerService cservice;

    @GetMapping("/create")
    public String createBooking(
            @RequestParam("tid") Integer tid, @ModelAttribute("user") Customer customer) {

        System.out.println("-----------------------BookingControoler create. | customer = " + customer);

        Tour t = tservice.findTourById(tid);
        System.out.println("-----------------------BookingControoler create. | tour= " + t);
        customer.addTour(t);
        cservice.UpdateCustomer(customer);
        System.out.println("Customer with tours after addition: "+ customer.getTours());
        
       
        
        
//
//        System.out.println("---------------------------BookingController FindTourByID:" + t);
//        Customer c = cservice.findCustomerById(3);
//        System.out.println("---------------------------Booking Controller FuindCustomer" + c);
//
//        bservice.createBooking(t, c);
//
//        Integer Id = 3;
//        List<Booking> list = bservice.findByCustomerId(Id);

        return "Bookings";
    }

}
