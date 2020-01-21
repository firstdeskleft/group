package com.firstdeskleft.entities;

import com.firstdeskleft.listeners.GenericListener;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@EntityListeners(GenericListener.class)
@Table(name = "role")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rid;
    private String rname;    
            
    public Role() {
    }

    public Role(String rname) {
        this.rname = rname;
    }

    public Role(Integer rid, String rname) {
        this.rid = rid;
        this.rname = rname;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.rid);
        hash = 29 * hash + Objects.hashCode(this.rname);
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
        final Role other = (Role) obj;
        if (!Objects.equals(this.rname, other.rname)) {
            return false;
        }
        if (!Objects.equals(this.rid, other.rid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Role{" + "rid=" + rid + ", rname=" + rname + '}';
    }

}
