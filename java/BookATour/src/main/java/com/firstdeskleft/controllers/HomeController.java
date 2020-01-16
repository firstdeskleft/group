package com.firstdeskleft.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/")
@SessionAttributes("user")
public class HomeController {

    @GetMapping
    public String home() {
        System.out.println("$$$$$ entered home()");
        return "Home";
    }

    @GetMapping("/HomeAdmin")
    public String adminHome(Model m) {
        System.out.println("$$$$$$ Entered HomeAdmin");
        System.out.println("$$$$$$ model" + m);
        System.out.println("$$$$$$ model.user" + m.getAttribute("user"));
        return "HomeAdmin";
    }

    @GetMapping("/HomeGuide")
    public String guideHome() {

        System.out.println("$$$$$$ Entered HomeGuide");

        return "HomeGuide";
    }

    @GetMapping("/HomeCustomer")
    public String customerHome() {
        System.out.println("$$$$$$ Entered HomeCustomer");

        return "HomeCustomer";
    }

}
