/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.service;

import com.firstdeskleft.dao.BookingDao;
import com.firstdeskleft.dao.TourDao;
import com.firstdeskleft.entities.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BookingServiceImpl implements BookingService{

    @Autowired
    BookingDao bdao;
    
    
    
    @Override
    public void createBooking(Tour t) {
        
        bdao.save(t);
    }
    
}
