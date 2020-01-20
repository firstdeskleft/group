package com.firstdeskleft.dao;

import com.firstdeskleft.entities.Message;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDaoImpl implements MessageDao {

    @Autowired
    SessionFactory factory;

    private Session getSession() {
        return factory.getCurrentSession();
    }

    @Override
    public void saveMessage(Message message) {

        System.out.println("7. Inside MessageDaoImpl.saveMessage. Message: " + message);

        getSession().save(message);

        System.out.println("8. Inside MessageDaoImpl.saveMessage. After sage messag");
    }

    @Override
    public List<Message> findByTargetId(Integer id) {

        Query q = getSession().createQuery("FROM Message m WHERE m.targetId = :id");
        q.setParameter("id", id);

        List<Message> list = q.getResultList();

        return list;

    }

}
