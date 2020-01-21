package com.firstdeskleft.entities;

import com.firstdeskleft.listeners.GenericListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name = "Guide")
@EntityListeners(GenericListener.class)
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "guide")
public class Guide extends User {

    private String firstName;
    private String lastName;
    private String subject;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "cert_id")

    private Certificate certificate;

    private Integer profits;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "guide", cascade = CascadeType.ALL)
    @Column(name = "tid")
    private List<Tour> tours = new ArrayList();

    public Guide() {
    }

    public Guide(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Guide(String firstName, String lastName, Integer profits) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profits = profits;
    }

    public Guide(String firstName, String lastName, String subject, Certificate certificate, Integer profits, List<Tour> tours) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
        this.certificate = new Certificate();
        this.profits = profits;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Integer getProfits() {
        return profits;
    }

    public void setProfits(Integer profits) {
        this.profits = profits;
    }

    public boolean deposit(Integer ammount) {

        if (!ensureAmmountPositive(ammount)) {
            return false;
        }

        profits += ammount;
        return true;
    }

    public boolean withdraw(Integer ammount) {

        if (!ensureAmmountPositive(ammount)) {
            return false;
        }

        profits -= ammount;
        return true;

    }

    public boolean creditsLessThanAmmount(Integer ammount) {
        return profits < ammount;
    }

    public boolean creditsEqualToAmmount(Integer ammount) {
        return Objects.equals(profits, ammount);
    }

    protected boolean ensureAmmountPositive(Integer ammount) {

        if (creditsLessThanAmmount(ammount)) {
            System.err.println("Error. Negative credits. No transaction.");
            return false;
        }

        if (creditsEqualToAmmount(ammount)) {
            System.out.println("Credits are zero. No transaction.");
            return false;
        }

        return true;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.firstName);
        hash = 17 * hash + Objects.hashCode(this.lastName);
        hash = 17 * hash + Objects.hashCode(this.subject);
        hash = 17 * hash + Objects.hashCode(this.certificate);
        hash = 17 * hash + Objects.hashCode(this.profits);
        hash = 17 * hash + Objects.hashCode(this.tours);
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
        if (!Objects.equals(this.certificate, other.certificate)) {
            return false;
        }
        if (!Objects.equals(this.profits, other.profits)) {
            return false;
        }
        if (!Objects.equals(this.tours, other.tours)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Guide{" + "firstName=" + firstName + ", lastName=" + lastName
                + ", subject=" + subject + ", certificate=" + certificate
                + ", profits=" + profits + '}';
    }

}
