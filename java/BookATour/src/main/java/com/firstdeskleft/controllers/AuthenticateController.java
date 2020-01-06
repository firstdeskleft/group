package com.firstdeskleft.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author nick.sabanis
 */
@Controller
public class AuthenticateController {
    
    @GetMapping("/loginPage")
    public String showLoginForm(){
        return "form-login";
    }
    
    @GetMapping("/access-denied")
    public String denyAccess(){
        return "access-denied";
    }
    
    
}
