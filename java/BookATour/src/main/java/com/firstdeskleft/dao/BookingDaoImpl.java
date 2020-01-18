/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.dao;

import com.firstdeskleft.entities.Booking;
import com.firstdeskleft.entities.Customer;
import com.firstdeskleft.entities.Guide;
import com.firstdeskleft.entities.Tour;
import static java.util.Collections.list;
import java.util.List;
import javax.persistence.Query;
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
    public void save(Booking booking) {
        
         getSession().save(booking);
         
    }

    @Override
    public  List <Booking> findByCustomerId(Integer Id) {
        Query q = getSession().createQuery("SELECT b FROM Booking b WHERE b.bid=:id");
        q.setParameter("id", Id);
        List<Booking> list = q.getResultList();
        return list;
    }
    
}
