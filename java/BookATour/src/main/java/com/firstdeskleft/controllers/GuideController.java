package com.firstdeskleft.controllers;

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

@Controller
@RequestMapping("/guide")
public class GuideController {

    @Autowired
    GuideService service;

    @GetMapping("/list")
    public String showGuides(Model m) {
        List<Guide> list = service.getAllGuides();
        m.addAttribute("listOfGuides", list);
        return "listGuides";
    }

   

    @PostMapping("/update")
    public String createOrUpdateGuide(Guide g) { 

        service.UpdateGuide(g);

        return "profile";
    }

}
