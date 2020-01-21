package com.firstdeskleft.controllers;

import com.firstdeskleft.entities.Customer;
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
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author ///
 */
@Controller
@RequestMapping("/tour")
@SessionAttributes({"user", "hasError"})
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

    @GetMapping("/listforAdmin")
    public String showToursforAdmin(Model m) {
        List<Tour> list = tservice.getAllTours();
        m.addAttribute("listOfTours", list);
        return "ToursAdmin";
    }

    @GetMapping("/listforcustomer")
    public String showToursforCustomer(Model m) {
        List<Tour> list = tservice.getAllTours();
        m.addAttribute("listOfTours", list);

        return "ToursForBooking";
    }

    @GetMapping("/create")
    public String createTour(Model m) {

        m.addAttribute(new Tour());

        return "CreateTour";
    }

    @PostMapping("/create")
    public String respondTour(@ModelAttribute("tour") Tour tour, @ModelAttribute("user") Guide guide) {

        guide.getTours().add(tour);
        tour.setGuide(guide);

        tservice.save(tour);

        return "Tours-Guide";
    }

    @GetMapping("guidetours")
    public String showGuideTours() {

        return "Tours-Guide";
    }

    @GetMapping("/delete")
    public String deleteTour(@RequestParam("tid") Integer id) {
        System.out.println("----------------------------------------GETMAPPING DELETE TOUR" );
        tservice.deleteTour(id);

        return "redirect:/tour/guidetours";
    }

    @GetMapping("/update")
    public String showUpdateTouForm(
            @RequestParam("tid") Integer id, Model model
    ) {
        Tour t = tservice.findTourById(id);
        model.addAttribute("tour", t);
        return "EditTour";
    }

}
