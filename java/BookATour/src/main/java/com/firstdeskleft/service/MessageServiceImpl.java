package com.firstdeskleft.service;

import com.firstdeskleft.dao.MessageDao;
import com.firstdeskleft.entities.Message;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessageServiceImpl implements MessageService{
    
    @Autowired
    MessageDao mDao;
    

    @Override
    public void addMessage(Message message) {
        
        System.out.println("6. Inside MessageServiceImpl.addMessage. Message: " +message);
        
        mDao.saveMessage(message);
        
        System.out.println("9. Inside MessageServiceImpl.addMessage. After save message");
        
    }

    @Override
    public List<Message> findByTargetId(Integer id) {
        
        return mDao.findByTargetId(id);
    }
    
    
    
}
