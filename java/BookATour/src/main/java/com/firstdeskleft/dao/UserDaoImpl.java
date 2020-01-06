package com.firstdeskleft.dao;

import com.firstdeskleft.entities.User;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

/**
 *
 * @author nick.sabanis
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public User findByUserName(String username) {
        Query q = getSession().createQuery("SELECT u FROM User u WHERE u.username= :name");
        q.setParameter("name", username);

        User user = null;
        try {
            user = (User) q.getSingleResult();

        } catch (Exception e) {
            System.out.println("===============UDAO=================No user found");
        }finally{
            return user;
        }
    }

    @Override
    public void save(User user) {
        getSession().saveOrUpdate(user);

    }

}
