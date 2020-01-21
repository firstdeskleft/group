package com.firstdeskleft.entities;

import com.firstdeskleft.listeners.GenericListener;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;


@Entity(name = "Tour")
@Table(name = "tour")
@EntityListeners(GenericListener.class)
public class Tour implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;
    private String location;
    private Integer cost=0;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tdate;
    @ManyToOne
    @JoinColumn(name = "gid")
    private Guide guide;

    @ManyToMany(mappedBy = "tours", fetch = FetchType.EAGER)
    private List<Customer> customers;
    
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

    public Tour(Integer tid, String location, Integer cost, LocalDate tdate, Guide guide, List<Customer> customers) {
        this.tid = tid;
        this.location = location;
        this.cost = cost;
        this.tdate = tdate;
        this.guide = guide;
        this.customers = customers;
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

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public boolean addCustomer(Customer customer){
        if(customers == null ){
            customers = new ArrayList();
        }
        boolean addedCustomer, addedTour;
        
        addedCustomer = customers.add(customer);
        addedTour= customer.getTours().add(this);
        
        return addedCustomer && addedTour;
        
    }
    
    public boolean removeCustomer(Customer removeCustomer){
        if(customers == null ){
            customers = new ArrayList();
        }
        
        for (Customer customer : customers) {
            if (customer.getId().equals(removeCustomer.getId())) {
                customers.remove(customer);
                return true;
            }
        }
        
        return false;         
      
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.tid);
        hash = 17 * hash + Objects.hashCode(this.location);
        hash = 17 * hash + Objects.hashCode(this.cost);
        hash = 17 * hash + Objects.hashCode(this.tdate);
        hash = 17 * hash + Objects.hashCode(this.guide);
        hash = 17 * hash + Objects.hashCode(this.customers);
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
        if (!Objects.equals(this.customers, other.customers)) {
            return false;
        }
        return true;
    }
    
    
    

    @Override
    public String toString() {
        return "Tour{" + "tid=" + tid + ", location=" + location + ", cost=" + cost + ", tdate=" + tdate + ", guide=" + guide  + '}';
    }      
    
}
