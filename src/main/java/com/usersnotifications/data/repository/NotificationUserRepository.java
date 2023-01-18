package com.usersnotifications.data.repository;

import com.usersnotifications.dto.NotificationDTO;
import com.usersnotifications.dto.UserDTO;
import java.util.Collection;

public interface NotificationUserRepository {

    public void add(NotificationDTO notificationDTO) throws Exception;

    public UserDTO getById(int notificationId) throws Exception;

    public Collection<NotificationDTO> getAll(int userId) throws Exception;

    public boolean read(int notificationId) throws Exception;

    public boolean delete(int notificationId) throws Exception;
}
