/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.dao;

import com.firstdeskleft.entities.Customer;
import com.firstdeskleft.entities.Guide;
import java.util.List;

/**
 *
 * @author User
 */
public interface GuideDao {

    public List<Guide> findAll();



    public void save(Guide guide);

    public Guide findByUsername(String username);

    public void update(Guide g);

    public Guide findById(Integer id);

    public void delete(Integer id);
    
}
