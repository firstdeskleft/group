
package com.firstdeskleft.entities;

import com.firstdeskleft.listeners.GenericListener;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@EntityListeners(GenericListener.class)
@Table(name = "message")
public class Message implements Serializable{
    
    @Id
    private int id;
    
    @Column(name = "source_id")
    @NotNull
    private int sourceId;
    
    @Column(name = "target_id")
    @NotNull
    private int targetId;
    
    
    private String body;

    public Message() {
    }

    public Message(int sourceId, int targetId) {
        this.sourceId = sourceId;
        this.targetId = targetId;
    }       

    public Message(int sourceId, int targetId, String body) {
        this.sourceId = sourceId;
        this.targetId = targetId;
        this.body = body;
    }

    public Message(int id, int sourceId, int targetId, String body) {
        this.id = id;
        this.sourceId = sourceId;
        this.targetId = targetId;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        hash = 17 * hash + this.sourceId;
        hash = 17 * hash + this.targetId;
        hash = 17 * hash + Objects.hashCode(this.body);
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
        final Message other = (Message) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.sourceId != other.sourceId) {
            return false;
        }
        if (this.targetId != other.targetId) {
            return false;
        }
        if (!Objects.equals(this.body, other.body)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", sourceId=" + sourceId + ", targetId=" + targetId + ", body=" + body + '}';
    }
    
    
    
    
    
    
}
