package com.firstdeskleft.controllers;

import com.firstdeskleft.entities.Customer;
import com.firstdeskleft.entities.Guide;
import com.firstdeskleft.service.GuideService;
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

@Controller
@RequestMapping("/guide")
public class GuideController {

    @Autowired
    GuideService service;

    @GetMapping("/list")
    public String showGuides(Model m) {
        List<Guide> list = service.getAllGuides();
        m.addAttribute("listOfGuides", list);
        return "Guides";
    }

   

    @GetMapping("/update")
    public String UpdateCustomer(Model model) {
        
        
        Integer id=null;
        Guide g=service.findCustomerById(id);
//        
         model.addAttribute("guide", g);
        

        return "!!!!!!!formGuide";
    }
    
    @GetMapping("/delete")
    public String deleteGuide(@RequestParam("id") Integer  id) {
        service.deleteGuide(id);

        return "redirect:/guide/list";
    }
    

}
