/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author User
 */
@Entity(name = "Tour")
@Table(name = "tour")
public class Tour implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;
    private String location;
    private Integer cost;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tdate;
    @ManyToOne
    @JoinColumn(name = "gid")
    private Guide guide;

    public Tour() {
    }

    public Tour(Integer tid, String location, Integer cost, LocalDate tdate, Guide guide) {
        this.tid = tid;
        this.location = location;
        this.cost = cost;
        this.tdate = tdate;
        this.guide = guide;
    }

    public Tour(String location, Integer cost, LocalDate tdate, Guide guide) {
        this.location = location;
        this.cost = cost;
        this.tdate = tdate;
        this.guide = guide;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public LocalDate getTdate() {
        return tdate;
    }

    public void setTdate(LocalDate tdate) {
        this.tdate = tdate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.tid);
        hash = 11 * hash + Objects.hashCode(this.location);
        hash = 11 * hash + Objects.hashCode(this.cost);
        hash = 11 * hash + Objects.hashCode(this.tdate);
        hash = 11 * hash + Objects.hashCode(this.guide);
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
        final Tour other = (Tour) obj;
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.tid, other.tid)) {
            return false;
        }
        if (!Objects.equals(this.cost, other.cost)) {
            return false;
        }
        if (!Objects.equals(this.tdate, other.tdate)) {
            return false;
        }
        if (!Objects.equals(this.guide, other.guide)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tour{" + "tid=" + tid + ", location=" + location + ", cost=" + cost + ", tdate=" + tdate + ", guide=" + guide + '}';
    }
    
    
    

}
