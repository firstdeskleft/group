/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.dao;

import com.firstdeskleft.entities.Tour;
import java.util.List;

/**
 *
 * @author User
 */
public interface TourDao {

    public List<Tour> findAll();
    
     public void save(Tour tour);

    public List<Tour> findByGuideId(Integer Id);

    public void delete(Integer id);

    public Tour findById(Integer id);

    public List<Tour> getUnbookedToursByGuideId(Integer id);
    
    
}
