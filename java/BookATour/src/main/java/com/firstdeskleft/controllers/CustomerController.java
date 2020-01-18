package com.firstdeskleft.controllers;
import com.firstdeskleft.entities.Customer;
import com.firstdeskleft.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
@Controller
@RequestMapping("/customer")
@SessionAttributes("user")
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
        System.out.println("In CustomerController, GET");
        printModel(model);
        return "CustomerProfile";
    }
    @PostMapping("/update")
    public String editCustomerPost(@ModelAttribute("user") Customer c) {
        
        System.out.println("In CustomerController, POST");
        service.UpdateCustomer(c);
        
        return "CustomerProfile";
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") Integer id) {
        service.deleteCustomer(id);
        return "redirect:/customer/list";
    }
    public void printModel(Model model) {
        System.out.println("ModelAttribute.user: {" + model.getAttribute("user") + "}");
    }
}