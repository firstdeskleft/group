
package com.firstdeskleft.service;

import com.firstdeskleft.entities.Customer;
import com.firstdeskleft.entities.Guide;
import java.util.List;


public interface GuideService {

    public List<Guide> getAllGuides();

    public void UpdateGuide(Guide g);

    public void save(Guide guide);

    public Guide findByUsername(String username);

    public Guide findCustomerById(Integer id);
    
}
