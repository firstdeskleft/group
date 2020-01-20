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
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/guide")
@SessionAttributes("user")
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
    public String UpdateGuide(Model model, @ModelAttribute("user") Guide guide) {

        return "GuideProfile";
    }

     @PostMapping("/update")
    public String editGuidePost(@ModelAttribute("user") Guide guide) {
        
    
        service.UpdateGuide(guide);
        
        return "redirect:/HomeGuide";
    }
    
    
    
    @GetMapping("/delete")
    public String deleteGuide(@RequestParam("id") Integer id) {
        service.deleteGuide(id);

        return "redirect:/guide/list";
    }

}
