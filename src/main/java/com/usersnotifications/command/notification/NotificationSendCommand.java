package com.usersnotifications.command.notification;

import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.data.repository.NotificationRepository;
import com.usersnotifications.dto.UserDTO;
import com.usersnotifications.model.Notification;

public class NotificationSendCommand extends NotificationCommand {
  public NotificationSendCommand(NotificationRepository notificationRepository, UserDAO userDAO) {
    super(notificationRepository, userDAO);
  }

  @Override
  public boolean execute(Notification notification) throws Exception {
    if(Integer.valueOf(notification.getToUserId()) == null) {
    UserDTO toUser = this.userDAO.getUserByName(notification.getToUsername());
    
    notification.setToUserId(toUser.getIdUser());
    }

    this.notificationRepository.add(notification);

    return true;
  }
}