/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.service;

import com.firstdeskleft.dao.GuideDao;
import com.firstdeskleft.entities.Customer;
import com.firstdeskleft.entities.Guide;
import com.firstdeskleft.entities.Role;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class GuideServiceImpl implements GuideService {

    @Autowired
    GuideDao gdao;
    
     @Autowired
     RoleService roleService;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;     
    
    @Override
    public List<Guide> getAllGuides() {
            return gdao.findAll();
    }

    @Override
    public void UpdateGuide(Guide g) {
       gdao.update(g);
       
    }

    @Override
    public void save(Guide guide) {
        guide.setPassword(passwordEncoder.encode(guide.getPassword()));
         List<Role> list = new ArrayList();
       Role role = roleService.findByName("ROLE_GUIDE");
       list.add(role);
       guide.setRoles(list);
        
        gdao.save(guide);
    }

    @Override
    public Guide findByUsername(String username) {
        return  gdao.findByUsername(username);
    }

    @Override
    public Guide findCustomerById(Integer id) {
        return gdao.findById(id);
    }
    
}
