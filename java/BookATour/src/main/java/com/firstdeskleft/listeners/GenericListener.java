package com.firstdeskleft.listeners;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

/**
 *
 * @author nick.sabanis
 * @param <T>
 */
public class GenericListener<T> {

    @PrePersist
    public void prePersist(T t) {
        printEntityState(t, "PRE PERSIST");
    }

    @PostPersist
    public void PostPersist(T t) {
        printEntityState(t, "POST PERSIST");
    }

    @PreRemove
    public void preRemove(T t) {
        printEntityState(t, "PRE REMOVE");
    }

    @PostRemove
    public void PostRemove(T t) {
        printEntityState(t, "POST REMOVE");
    }

    @PreUpdate
    public void PreUpdate(T t) {
        printEntityState(t, "PRE UPDATE");
    }

    @PostUpdate
    public void PostUpdate(T t) {
        printEntityState(t, "POST UPDATE");
    }

    @PostLoad
    public void PostLoad(T t) {
        printEntityState(t, "POST LOAD");
    }

    public void printEntityState(T t, String state) {
        System.out.println("\n###################");
        System.out.println(t + " on " + state + " state");
        System.out.println("###################\n");
    }

}



