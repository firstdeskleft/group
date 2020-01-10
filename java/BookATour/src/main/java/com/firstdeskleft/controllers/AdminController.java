
package com.firstdeskleft.controllers;

import com.firstdeskleft.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    
     @Autowired
    CustomerService service;
    
    
    
    
}
