/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity(name = "Booking")
@Table(name = "booking")
public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bid;

    @ManyToOne
    @JoinColumn  (name = "tid")
    private Tour tour;
    @ManyToOne
    @JoinColumn  (name = "cid")
    private Customer customer;

    public Booking() {
    }

    public Booking(Tour tour, Customer customer) {
        this.tour = tour;
        this.customer = customer;
    }

    public Booking(Integer bid, Tour tour, Customer customer) {
        this.bid = bid;
        this.tour = tour;
        this.customer = customer;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.bid);
        hash = 17 * hash + Objects.hashCode(this.tour);
        hash = 17 * hash + Objects.hashCode(this.customer);
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
        final Booking other = (Booking) obj;
        if (!Objects.equals(this.bid, other.bid)) {
            return false;
        }
        if (!Objects.equals(this.tour, other.tour)) {
            return false;
        }
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Booking{" + "bid=" + bid + ", tour=" + tour + ", customer=" + customer + '}';
    }

}
