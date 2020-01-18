/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.dao;

import com.firstdeskleft.entities.Tour;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




@Repository
public class BookingDaoImpl implements BookingDao{

     @Autowired
    SessionFactory factory;
    
    private Session getSession(){
        return factory.getCurrentSession();
    }
    
    
    
    
    @Override
    public void save(Tour t) {
        
         getSession().saveOrUpdate(t);
    }
    
}
