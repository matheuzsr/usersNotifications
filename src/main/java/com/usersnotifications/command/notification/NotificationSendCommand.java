package com.usersnotifications.command.notification;

import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.data.repository.NotificationRepository;
import com.usersnotifications.model.Notification;

public class NotificationSendCommand extends NotificationCommand {
  public NotificationSendCommand(NotificationRepository notificationRepository, UserDAO userDAO) {
    super(notificationRepository, userDAO);
  }

  @Override
  public boolean execute(Notification notification) throws Exception {
    // if(notification.getToUserId() == null) {
    // int toUserId = this.userDAO.getUserByName(notification.getToUsername());
    // notification.setToUserId(toUserId);
    return true;
  }
}