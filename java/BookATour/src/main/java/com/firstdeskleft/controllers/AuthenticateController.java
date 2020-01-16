package com.firstdeskleft.controllers;

import com.firstdeskleft.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author nick.sabanis
 */
@Controller
@SessionAttributes("user")
public class AuthenticateController {

    @GetMapping("/Login")
    public String showLoginForm(Model model, @ModelAttribute("user") User user) {
        System.out.println("$$$$ On authenticate Controller, user=" + user + " , model:" + model);
        return "Login";
    }

    @GetMapping("/access-denied")
    public String denyAccess() {
        return "access-denied";
    }

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

}
