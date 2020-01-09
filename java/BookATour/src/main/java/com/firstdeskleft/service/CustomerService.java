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



    public Customer findByUsername(String username);

    public void save(Customer customer);

    public void UpdateCustomer(Customer c);
    
}
