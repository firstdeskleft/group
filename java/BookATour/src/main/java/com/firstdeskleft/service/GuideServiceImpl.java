/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.service;

import com.firstdeskleft.dao.GuideDao;
import com.firstdeskleft.entities.Guide;
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
    private BCryptPasswordEncoder passwordEncoder;     
    
    @Override
    public List<Guide> getAllGuides() {
            return gdao.findAll();
    }

    @Override
    public void createOrUpdateGuide(Guide g) {
        g.setPassword(passwordEncoder.encode(g.getPassword()));
        gdao.saveOrUpdate(g);
    }
    
}
