/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.entities;

import com.firstdeskleft.listeners.GenericListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity(name = "Customer")
@Table(name = "customer")
@EntityListeners(GenericListener.class)
@PrimaryKeyJoinColumn(name = "id")
public class Customer extends User implements Serializable {

    private String firstName;
    private String lastName;
    private Integer credits;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "booking",
            joinColumns = {
                @JoinColumn(name = "cid", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "tid", referencedColumnName = "tid")
            }
    )
    private List<Tour> tours;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(String firstName, String lastName, Integer credits) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.credits = credits;
    }

    public Customer(String firstName, String lastName, Integer credits, List<Tour> tours) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.credits = credits;
        this.tours = tours;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }
    public void addCredits(Integer credits){
        this.credits= credits;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.firstName);
        hash = 67 * hash + Objects.hashCode(this.lastName);
        hash = 67 * hash + Objects.hashCode(this.credits);
        hash = 67 * hash + Objects.hashCode(this.tours);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.credits, other.credits)) {
            return false;
        }
        if (!Objects.equals(this.tours, other.tours)) {
            return false;
        }
        return true;
    }

    public boolean addTour(Tour tour) {
        if (tours == null) {
            tours = new ArrayList();
        }

        Boolean addedTour, addedCustomer;
        addedTour = tours.add(tour);
        addedCustomer = tour.getCustomers().add(this);

        return addedTour && addedCustomer;
    }
    
    public boolean removeTour(Tour tour){
        if (tours == null) {
            tours = new ArrayList();
        }
        boolean removedTour, removedCustomer;
        removedTour = tours.remove(tour); 
        removedCustomer = tours.remove(this);
        
        return removedTour && removedCustomer;
    }
    
    

//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 67 * hash + Objects.hashCode(this.firstName);
//        hash = 67 * hash + Objects.hashCode(this.lastName);
//        hash = 67 * hash + Objects.hashCode(this.credits);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Customer other = (Customer) obj;
//        if (!Objects.equals(this.firstName, other.firstName)) {
//            return false;
//        }
//        if (!Objects.equals(this.lastName, other.lastName)) {
//            return false;
//        }
//        if (!Objects.equals(this.credits, other.credits)) {
//            return false;
//        }
//        return true;
//    }
    @Override
    public String toString() {
        return "Customer{" + "firstName=" + firstName + ", lastName=" + lastName + ", credits=" + credits +  '}';
    }

}
