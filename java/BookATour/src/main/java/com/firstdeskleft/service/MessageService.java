package com.firstdeskleft.service;

import com.firstdeskleft.entities.Message;
import java.util.List;

public interface MessageService {

    public void addMessage(Message message);    

    public List<Message> findByTargetId(Integer id);
    
    
}
