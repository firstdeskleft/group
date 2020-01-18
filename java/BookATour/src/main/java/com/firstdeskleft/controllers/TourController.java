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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ///
 */
@Controller
@RequestMapping("/tour")

public class TourController {

    @Autowired
    TourService tservice;

    @Autowired
    GuideService gService;

    @GetMapping("/list")
    public String showTours(Model m) {
        List<Tour> list = tservice.getAllTours();
        m.addAttribute("listOfTours", list);

        return "Tours";
    }
    
    @GetMapping("/listforcustomer")
    public String showToursforCustomer(Model m){
        List<Tour> list = tservice.getAllTours();
        m.addAttribute("listOfTours", list);
        return "ToursForBooking";
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

        tservice.save(t);

        Guide g = (Guide) session.getAttribute("guide");
        System.out.println("--------------------------- Post Create from tour ----find guide by id guide=  " +g);
        List<Tour> list = tservice.getAllTours(); // PROSORINA TO GETALL  MEXRI NA LIHEI TO PROBLIMA ME TO MODEL GUIDE
//        System.out.println("--------------------------- Post Create from tour ----find tours by id,  tours=   "+list);
        m.addAttribute("listOfTours", list);

        return "Tours-Guide";
    }

    @GetMapping("guidetours")
    public String showGuideTours(Model m, HttpSession session) {
        Guide g = (Guide) session.getAttribute("guide");
        System.out.println("------------------------------getmapping guidetours getguide "+ g);
        List<Tour> list = tservice.getAllTours(); // PROSORINA TO GETALL  MEXRI NA LIHEI TO PROBLIMA ME TO MODEL GUIDE
//System.out.println("------------------------------getmapping guidetours listtoursbyguide "+ list);
        m.addAttribute("listOfTours", list);
        System.out.println("-------------------------------List of tours in modelattribute "+ m.getAttribute("listOfTours"));
        return "Tours-Guide";
    }
    
     @GetMapping("/delete")
    public String deleteTour(@RequestParam("tid") Integer  id) {
        tservice.deleteTour(id);

        return "redirect:/tour/guidetours";
    }

    @GetMapping("/update")
    public String showUpdateTouForm(
            @RequestParam("tid") Integer id, Model model
    ) {
        Tour t = tservice.findTourById(id);
        model.addAttribute("tour", t);
        return "CreateTour";
    }
    
    
    
    
    
}
