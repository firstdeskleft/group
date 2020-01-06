package com.firstdeskleft.dao;

import com.firstdeskleft.entities.User;

/**
 *
 * @author nick.sabanis
 */
public interface UserDao {

    public User findByUserName(String username);

    public void save(User user);
    
}
