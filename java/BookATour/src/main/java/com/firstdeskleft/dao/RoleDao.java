/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.dao;

import com.firstdeskleft.entities.Role;

/**
 *
 * @author User
 */
public interface RoleDao {

    public Role findById(Integer id);

    public Role findByName(String rname);
    
}
