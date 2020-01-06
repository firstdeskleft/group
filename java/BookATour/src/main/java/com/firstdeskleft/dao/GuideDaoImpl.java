
package com.firstdeskleft.dao;

import com.firstdeskleft.entities.Guide;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GuideDaoImpl implements GuideDao{
    
    @Autowired
    private SessionFactory sessionfactory;
    
    private Session getSession(){
        
        return sessionfactory.getCurrentSession();
    }

    @Override
    public List<Guide> findAll() {
       Query q = getSession().createQuery("FROM Guide g");
        List<Guide> list = q.getResultList();
        return list;
    }

    @Override
    public void saveOrUpdate(Guide g) {
        getSession().saveOrUpdate(g);
    }
    
    
}
