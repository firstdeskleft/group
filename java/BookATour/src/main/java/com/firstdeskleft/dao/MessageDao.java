package com.firstdeskleft.dao;

import com.firstdeskleft.entities.Message;
import java.util.List;

public interface MessageDao {

    public void saveMessage(Message message);

    public List<Message> findByTargetId(Integer id);

    public void deleteMessage(Integer id);
    
}
