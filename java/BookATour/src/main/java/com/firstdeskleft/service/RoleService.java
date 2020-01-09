
package com.firstdeskleft.service;

import com.firstdeskleft.entities.Role;



public interface RoleService {

    public Role findById(Integer id);
    
    public Role findByName(String rname);
}
