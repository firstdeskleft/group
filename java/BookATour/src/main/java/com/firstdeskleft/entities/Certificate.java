package com.firstdeskleft.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Certificate")
@Table(name = "certificate")
public class Certificate implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cert_id")
    private Integer certId;
    private String title;
   

    public Certificate() {
    }

    public Certificate(Integer certId, String title) {
        this.certId = certId;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Certificate(String title) {
        this.title = title;
    }
       
    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCertId() {
        return certId;
    }

    public void setCertId(Integer certId) {
        this.certId = certId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.certId);
        hash = 59 * hash + Objects.hashCode(this.title);
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
        final Certificate other = (Certificate) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.certId, other.certId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Certificate{" + "certId=" + certId + ", title=" + title + '}';
    }      
    
}
