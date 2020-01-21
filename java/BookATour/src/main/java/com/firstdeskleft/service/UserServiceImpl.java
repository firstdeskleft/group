package com.firstdeskleft.service;

import com.firstdeskleft.dao.UserDao;
import com.firstdeskleft.entities.Role;
import com.firstdeskleft.entities.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nick.sabanis
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao udao;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User findByUserName(String username) {
        return udao.findByUserName(username);
    }

    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        udao.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = udao.findByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("=========================================================Invalid username");
        }
        
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles())
        );

        return userDetails;

    }

    private List<? extends GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList();
        for (Role r : roles) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(r.getRname());
            authorities.add(authority);
        }
        return authorities;
    }

    @Override
    public User findById(Integer Id) {
       return null;
    }

}
