package com.firstdeskleft.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author nick.sabanis
 */
@Controller
public class AuthenticateController {
    
    @GetMapping("/Login")
    public String showLoginForm(){
        return "Login";
    }
    
    @GetMapping("/access-denied")
    public String denyAccess(){
        return "access-denied";
    }
    
    
}
