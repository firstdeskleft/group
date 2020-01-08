/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.service;

import com.firstdeskleft.entities.Customer;
import java.util.List;

/**
 *
 * @author User
 */
public interface CustomerService {

    public List<Customer> getAllCustomers();

    public void createOrUpdateCustomer(Customer c);

    public Customer findByUsername(String username);
    
}
