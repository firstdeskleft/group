/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.service;

import com.firstdeskleft.dao.CustomerDao;
import com.firstdeskleft.entities.Customer;
import com.firstdeskleft.entities.Role;
import java.util.ArrayList;
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
    public Customer findByUsername(String username) {
        return cdao.findByUsername(username);
    }

    public void saveWithBonusCredits(Customer customer,Integer bonus) {

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        List<Role> list = new ArrayList();
        Role role = roleService.findByName("ROLE_CUSTOMER");
        list.add(role);
        customer.setRoles(list);
        customer.deposit(bonus);
        cdao.save(customer);
    }

    @Override
    public void save(Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        List<Role> list = new ArrayList();
        Role role = roleService.findByName("ROLE_CUSTOMER");
        list.add(role);
        customer.setRoles(list);

        cdao.save(customer);
    }

    @Override
    public void UpdateCustomer(Customer c) {
        cdao.update(c);
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return cdao.findById(id);
    }

    @Override
    public void deleteCustomer(Integer id) {
        cdao.delete(id);

    }

}
