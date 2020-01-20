/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.dao;

import com.firstdeskleft.entities.Customer;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.Query;
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
    public Customer findByUsername(String username) {
           Query q =getSession().createQuery("SELECT c FROM Customer c WHERE c.username=:name");
       q.setParameter("name", username);
       Customer customer;
       try{
           customer = (Customer) q.getSingleResult();
       }catch(NoResultException e){
           
           System.out.println("There is no result");
           customer = null;
       }
      
       return customer;
    }

    @Override
    public void save(Customer customer) {
         getSession().saveOrUpdate(customer);
    }

    @Override
    public void update(Customer c) {
         getSession().saveOrUpdate(c);
    }

    @Override
    public Customer findById(Integer id) {
       return (Customer) getSession().get(Customer.class, id);
    }

    @Override
    public void delete(Integer id) {
        Query q = getSession().createQuery("DELETE FROM Customer c WHERE c.id=:id");
        q.setParameter("id", id);
        int result = q.executeUpdate();
        
        
    }

  
    
}
