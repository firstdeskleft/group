/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.dao;

import com.firstdeskleft.entities.Role;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RoleDaoImpl implements RoleDao{
    
     @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    
    }

    @Override
    public Role findById(Integer id) {
        return getSession().byId(Role.class).load(id);
    }

    @Override
    public Role findByName(String rname) {
        Query q = getSession().createQuery("SELECT r FROM Role r WHERE r.rname=:name");
        q.setParameter("name", rname);
        Role role = (Role) q.getSingleResult();
        
        return role;
    }
    
}
