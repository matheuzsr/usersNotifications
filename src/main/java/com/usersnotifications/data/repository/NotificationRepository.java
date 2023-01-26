package com.usersnotifications.data.repository;

import com.usersnotifications.model.Notification;
import com.usersnotifications.dto.UserDTO;
import java.util.Collection;

// Foi criado como repository pois utiliza-se de duas tabelas 
public interface NotificationRepository {

    public void add(Notification notification) throws Exception;

    public UserDTO getById(int notificationId) throws Exception;

    public Collection<Notification> getReceivedAll(int userId) throws Exception;
    
    public Collection<Notification> getSentAll(int userId) throws Exception;

    public boolean read(int notificationId) throws Exception;

    public boolean delete(int notificationId) throws Exception;
}
