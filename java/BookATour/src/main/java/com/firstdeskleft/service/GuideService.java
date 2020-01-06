
package com.firstdeskleft.service;

import com.firstdeskleft.entities.Guide;
import java.util.List;


public interface GuideService {

    public List<Guide> getAllGuides();

    public void createOrUpdateGuide(Guide g);
    
}
