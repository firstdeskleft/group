
package com.firstdeskleft.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    
    @GetMapping
    public String home(){
        System.out.println("-------------------------------------------------------HOMEHOME");
        return "Home";
    }
    
    @GetMapping("/HomeAdmin")
    public String adminHome(){
        
        return "HomeAdmin";
    }
    
    @GetMapping("/HomeGuide")
    public String guideHome(){
        
        return "HomeGuide";
    }
    
    @GetMapping("/HomeCustomer")
    public String customerHome(){
        System.out.println("=======================================HOMECONTROLLER customer");
        return "HomeCustomer";
    }
    
}