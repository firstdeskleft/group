package com.firstdeskleft.controllers;

import com.firstdeskleft.entities.Customer;
import com.firstdeskleft.entities.Guide;
import com.firstdeskleft.entities.User;
import com.firstdeskleft.service.CustomerService;
import com.firstdeskleft.service.GuideService;
import com.firstdeskleft.service.UserService;
import java.security.Principal;
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
    UserService userService;
    @Autowired
    GuideService guideService;
    @Autowired
    CustomerService customerService;

    @GetMapping
    public String home() {
        System.out.println("$$$$$ entered home()");
        return "Home";
    }

    @GetMapping("/HomeAdmin")
    public String adminHome(Principal principal, Model model) {
        String username = principal.getName();
        User user = userService.findByUserName(username);
        model.addAttribute("user", user);
        printModel(model);
        return "HomeAdmin";
    }

    @GetMapping("/HomeGuide")
    public String guideHome(Principal principal, Model model) {
        String username = principal.getName();
        Guide guide = guideService.findByUsername(username);
        model.addAttribute("user", guide);
        printModel(model);
        return "HomeGuide";
    }
    @GetMapping("/HomeCustomer")
    public String customerHome(Principal principal, Model model) {
        String username = principal.getName();
        Customer customer = customerService.findByUsername(username);
        model.addAttribute("user", customer);
        printModel(model);
        return "HomeCustomer";
    }
    public void printModel(Model model) {
        System.out.println("ModelAttribute.user: {" + model.getAttribute("user") + "}");
    }

}
