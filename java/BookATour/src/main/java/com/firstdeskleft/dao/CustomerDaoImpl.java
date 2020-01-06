/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.dao;

import com.firstdeskleft.entities.Customer;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class CustomerDaoImpl implements CustomerDao{

      @Autowired
    private SessionFactory sessionfactory;

    private Session getSession() {

        return sessionfactory.getCurrentSession();
    }
    
    @Override
    public List<Customer> findAll() {
         Query q = getSession().createQuery("FROM Customer c");
        List<Customer> list = q.getResultList();
        return list;
    }

    @Override
    public void saveOrUpdate(Customer c) {
         getSession().saveOrUpdate(c);
    }
    
}
