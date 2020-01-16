package com.firstdeskleft.controllers;

import com.firstdeskleft.entities.User;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/")
@SessionAttributes("user")
public class HomeController {

    @GetMapping
    public String home() {
        System.out.println("---------------------------------------------------Homehome");
        return "Home";
    }

    @GetMapping("/HomeAdmin")
    public String adminHome(
  @SessionAttribute("user") User user, Model model,
                                     HttpServletRequest request) {
            System.out.println("----------------------------------ADminHome" +user);
        return "HomeAdmin";
    }

    @GetMapping("/HomeGuide")
    public String guideHome() {

        return "HomeGuide";
    }

    @GetMapping("/HomeCustomer")
    public String customerHome() {

        return "HomeCustomer";
    }

    @ModelAttribute("user")
    public User getuser() {
        return new User();
    }

}
