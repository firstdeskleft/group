package com.firstdeskleft.controllers;

import com.firstdeskleft.entities.Guide;
import com.firstdeskleft.entities.Tour;
import com.firstdeskleft.service.GuideService;
import com.firstdeskleft.service.TourService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("/tour")
public class TourController {
    
    @Autowired
    TourService service;
    
    @Autowired
    GuideService gService;

    @GetMapping("/list")
    public String showTours(Model m) {
        List<Tour> list = service.getAllTours();
        m.addAttribute("listOfTours",list);
        
        return "Tours";
    }
    
    @GetMapping("/create")
    public String createTour(Model m){
        Guide g = gService.findByUsername("guide1");
        
        
        
        m.addAttribute("tour", new Tour());
        
        
        
        return "CreateTour";
    }
    
    @PostMapping("/create")
    public String respondTour(Model m){
        String name = "guide1";
        List<Tour> list = service.findByUsername( name);
        m.addAttribute("listToursByUsername", service);
                
        return "Tours";
    }
    

}
