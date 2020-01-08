/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.dao;

import com.firstdeskleft.entities.Customer;
import java.util.List;

/**
 *
 * @author User
 */
public interface CustomerDao {

    public List<Customer> findAll();

    public void saveOrUpdate(Customer c);

    public Customer findByUsername(String username);
    
}
