/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.controllers;

import com.firstdeskleft.config.*;
import com.firstdeskleft.entities.Customer;
import com.firstdeskleft.entities.Role;
import com.firstdeskleft.service.CustomerService;
import com.firstdeskleft.service.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/customer")

public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping("/list")
    public String showCustomers(Model m) {
        List<Customer> list = service.getAllCustomers();
        System.out.println("------------------------------CUstomer COntroller get all" + list);
        m.addAttribute("listOfCustomers", list);
        return "Customers";
    }

    @GetMapping("/update")
    public String UpdateCustomer(Model model) {
        Integer id= null;
        Customer c = service.findCustomerById(id);
        
         model.addAttribute("customer", c);
        

        return "CustomerProfile";
    }

   @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") Integer  id) {
        service.deleteCustomer(id);

        return "redirect:/customer/list";
    }

}
