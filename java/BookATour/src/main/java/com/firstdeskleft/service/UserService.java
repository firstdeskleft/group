package com.firstdeskleft.service;

import com.firstdeskleft.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author nick.sabanis
 */
public interface UserService extends UserDetailsService{

    public User findByUserName(String username);

    public void save(User user);
    
}
