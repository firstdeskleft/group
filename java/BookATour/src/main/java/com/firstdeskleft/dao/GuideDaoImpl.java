
package com.firstdeskleft.dao;

import com.firstdeskleft.entities.Customer;
import com.firstdeskleft.entities.Guide;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
    public void save(Guide guide) {
       getSession().saveOrUpdate(guide);
    }

    @Override
    public Guide findByUsername(String username) {
            Query q =getSession().createQuery("SELECT g FROM Guide g WHERE g.username=:name");
       q.setParameter("name", username);
       Guide guide;
       try{
           guide = (Guide) q.getSingleResult();
       }catch(NoResultException e){
           
           System.out.println("There is no result");
           guide = null;
       }
      
       return guide;
    }

    @Override
    public void update(Guide g) {
        getSession().saveOrUpdate(g);
    }

    @Override
    public Guide findById(Integer id) {
        return (Guide) getSession().get(Guide.class, id);
    }

    @Override
    public void delete(Integer id) {
        Query q = getSession().createQuery("DELETE FROM Guide  g WHERE g.id=:id");
        q.setParameter("id", id);
        int result = q.executeUpdate();
    }
    
    
}
