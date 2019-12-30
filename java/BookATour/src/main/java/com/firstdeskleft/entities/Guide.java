/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity(name = "Guide")
@Table(name = "guide")
public class Guide implements Serializable {
    
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer gid;
     private String firstName;
     private String lastName;
     private String subject;
    
     @ManyToOne
     @JoinColumn(name = "cert_id")
     private Certificate certificate;
     
     private Integer profits;
     
     @OneToMany(mappedBy = "guide")
     @Column (name = "tid")
     private List<Tour> tours;

    public Guide() {
    }

    public Guide(Integer gid, String firstName, String lastName, String subject, Certificate certificate, Integer profits) {
        this.gid = gid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
        this.certificate = certificate;
        this.profits = profits;
    }

    public Guide(String firstName, String lastName, String subject, Certificate certificate, Integer profits) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
        this.certificate = certificate;
        this.profits = profits;
    }

    public Guide(String firstName, String lastName, String subject, Certificate certificate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
        this.certificate = certificate;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    
    
    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getProfits() {
        return profits;
    }

    public void setProfits(Integer profits) {
        this.profits = profits;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.gid);
        hash = 19 * hash + Objects.hashCode(this.firstName);
        hash = 19 * hash + Objects.hashCode(this.lastName);
        hash = 19 * hash + Objects.hashCode(this.subject);
        hash = 19 * hash + Objects.hashCode(this.certificate);
        hash = 19 * hash + Objects.hashCode(this.profits);
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
        final Guide other = (Guide) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        if (!Objects.equals(this.gid, other.gid)) {
            return false;
        }
        if (!Objects.equals(this.certificate, other.certificate)) {
            return false;
        }
        if (!Objects.equals(this.profits, other.profits)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Guide{" + "gid=" + gid + ", firstName=" + firstName + ", lastName=" + lastName + ", subject=" + subject + ", certificate=" + certificate + ", profits=" + profits + '}';
    }
     
     
     
    
}
