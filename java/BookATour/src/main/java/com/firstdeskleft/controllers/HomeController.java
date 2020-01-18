package com.firstdeskleft.controllers;

import com.firstdeskleft.entities.Guide;
import com.firstdeskleft.service.GuideService;
import java.security.Principal;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/")
@SessionAttributes("user")
public class HomeController {

    @Autowired
    GuideService gservice;

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
    public String guideHome(Model m) {
        m.getAttribute("user");
        System.out.println("----------------------------------Model attribute user" + m.getAttribute("user"));
        return "HomeGuide";
    }

    @GetMapping("/HomeCustomer")
    public String customerHome(Model m) {
        m.getAttribute("user");
        System.out.println("$$$$$$ Entered HomeCustomer");
        System.out.println("----------------------------------Model attribute user" + m.getAttribute("user"));
        return "HomeCustomer";
    }

}
