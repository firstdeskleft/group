/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.service;

import com.firstdeskleft.dao.CustomerDao;
import com.firstdeskleft.entities.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    
     @Autowired
    CustomerDao cdao;
     @Autowired
     RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<Customer> getAllCustomers() {
        return cdao.findAll();
    }

    @Override
    public void createOrUpdateCustomer(Customer c) {
        c.setPassword(passwordEncoder.encode(c.getPassword()));
        roleService.findById(1);
        cdao.saveOrUpdate(c);
    }

    @Override
    public Customer findByUsername(String username) {
         return  cdao.findByUsername(username);
    }

    
    
}
