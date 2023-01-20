package com.usersnotifications.command.notification;

import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.data.repository.NotificationRepository;
import com.usersnotifications.model.Notification;

public abstract class NotificationCommand {
  NotificationRepository notificationRepository;
  UserDAO userDAO;

  public NotificationCommand(NotificationRepository notificationRepository, UserDAO userDAO) {
    this.notificationRepository = notificationRepository;
    this.userDAO = userDAO;
  }

  public abstract boolean execute(Notification notification) throws Exception;

}