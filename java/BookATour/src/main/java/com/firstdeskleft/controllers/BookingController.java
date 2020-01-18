/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.controllers;

import com.firstdeskleft.entities.Customer;
import com.firstdeskleft.entities.Tour;
import com.firstdeskleft.service.BookingService;
import com.firstdeskleft.service.CustomerService;
import com.firstdeskleft.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bservice;
    
    @Autowired
    TourService tservice;

    @GetMapping("/create")
    public String createBooking(
            @RequestParam("tid") Integer tid) {
        //Model Customer Id or Name
        
        Tour t = tservice.findTourById(tid);
                
       
        return "Tours";
    }

}
