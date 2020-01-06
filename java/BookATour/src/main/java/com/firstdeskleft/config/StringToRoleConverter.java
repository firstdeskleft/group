package com.firstdeskleft.config;


import com.firstdeskleft.entities.Role;
import com.firstdeskleft.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author nick.sabanis
 */
@Component
public class StringToRoleConverter implements Converter<Object, Role>{
    
    @Autowired
    RoleService roleService;
    
    @Override
    public Role convert(Object source){
        Integer id = Integer.parseInt((String)source);
        return roleService.findById(id);
    }
    
}
