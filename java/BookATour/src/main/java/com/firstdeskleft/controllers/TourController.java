package com.firstdeskleft.controllers;

import com.firstdeskleft.entities.Guide;
import com.firstdeskleft.entities.Tour;
import com.firstdeskleft.service.GuideService;
import com.firstdeskleft.service.TourService;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("/tour")

public class TourController {

    @Autowired
    TourService service;

    @Autowired
    GuideService gService;

    @GetMapping("/list")
    public String showTours(Model m) {
        List<Tour> list = service.getAllTours();
        m.addAttribute("listOfTours", list);

        return "Tours";
    }

    @GetMapping("/create")
    public String createTour(Model m) {
        Tour tour = new Tour();

//        tour.setGuide((Guide) session.getAttribute("guide"));
        m.addAttribute("tour", tour);

        System.out.println("------------------------GET create" + tour + " --------- tour guide" + tour.getGuide() + "--------session attribute ");
        return "CreateTour";
    }

    @PostMapping("/create")
    public String respondTour(@ModelAttribute("tour") Tour t, HttpSession session, Model m) {
        t.setGuide((Guide) session.getAttribute("guide"));
        System.out.println("---------------------------Post CReate form  tour:  " + t + "  ---------session" + session);

        service.save(t);

        Guide g = (Guide) session.getAttribute("guide");

        List<Tour> list = service.findByGuideId(g.getId());

        m.addAttribute("listOfTours", list);

        return "Tours-Guide";
    }

    @GetMapping("guide-tours")
    public String showGuideTours(Model m, HttpSession session) {
        Guide g = (Guide) session.getAttribute("guide");

        List<Tour> list = service.findByGuideId(g.getId());

        m.addAttribute("listOfTours", list);

        return "Tours-Guide";
    }
}
