/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.service;

import com.firstdeskleft.dao.BookingDao;
import com.firstdeskleft.entities.Customer;
import com.firstdeskleft.entities.Guide;
import com.firstdeskleft.entities.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Service
@Transactional
@SessionAttributes("user")
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingDao bdao;

    @Autowired
    TourService tourService;

    @Autowired
    CustomerService customerService;

    @Autowired
    GuideService guideService;

    @Override
    public String attempBooking(Integer tourId, @ModelAttribute("user") Customer customer) {

        Tour tour = tourService.findTourById(tourId);

        if (tour == null) {
            return "Tour not found";
        }

        Integer tourCost = tour.getCost();
        Integer customerCredits = customer.getCredits();

        if (customerCredits < tourCost) {
            return "Insufficient credits";
        }

        Boolean withdrawAccomplished = customer.withdraw(tourCost);

        if (!withdrawAccomplished) {
            return "Error withdrawing ammount";
        }

        Guide guide = tour.getGuide();

        if (guide == null) {

            customer.deposit(tourCost);

            tourService.deleteTour(tour.getTid());

            return "Error finding guide. Cancelling transaction and removing tour from database.";

        }

        Boolean depositAccomplised = guide.deposit(tourCost);

        if (!depositAccomplised) {

            customer.deposit(tourCost);

            return "Error depositing ammount. Cancelling transaction";

        }

        Boolean customerAddedTour = customer.addTour(tour);

        if (!customerAddedTour) {

            customer.deposit(tourCost);

            guide.withdraw(tourCost);

            return "Error linking customer to tour. Cancelling transaction";

        }

//        System.out.println("----------------------------------------------------SUCCESS");
//        customerService.UpdateCustomer(customer);
//        System.out.println("------------------------------AfterCUstomerUpdate");
//
        System.out.println("Passed errors. Before updating guide:" + guide);

        guideService.UpdateGuide(guide);
        
        System.out.println("After updating guide:" + guide);
        System.out.println("Returning to BookingController");

        return "success";

    }

}
