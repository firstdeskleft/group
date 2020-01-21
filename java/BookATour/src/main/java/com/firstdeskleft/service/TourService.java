package com.firstdeskleft.service;

import com.firstdeskleft.entities.Tour;
import java.util.List;

/**
 *
 * @author User
 */
public interface TourService {

    public List<Tour> getAllTours();
    
    public void save(Tour tour);

    public List<Tour> findByGuideId(Integer Id);

    public void deleteTour(Integer id);

    public Tour findTourById(Integer id);

    public List<Tour> getUnbookedTours(Integer id);
}
