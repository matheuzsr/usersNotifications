package com.usersnotifications.presenter.notification;

import com.usersnotifications.model.Notification;
import com.usersnotifications.presenter.notification.state.NotificationSendState;
import com.usersnotifications.presenter.notification.state.NotificationState;
import com.usersnotifications.presenter.notification.state.NotificationVisualizationState;
import com.usersnotifications.view.NotificationView;
import com.usersnotifications.command.notification.NotificationCommand;
import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.data.repository.NotificationRepository;

public class NotificationPresenter {
  private NotificationView view;
  private NotificationState state;
  private NotificationRepository notificationRepository;
  private UserDAO userDAO;
  private NotificationCommand notificationCommand;
  private Notification notification;

  public NotificationPresenter(NotificationRepository notificationRepository, UserDAO userDAO,
      NotificationCommand notificationCommand, Notification notification) {
    this.view = new NotificationView();

    this.notificationRepository = notificationRepository;
    this.userDAO = userDAO;
    this.notificationCommand = notificationCommand;
    this.notification = notification;

    if (notification == null) {
      this.setState(new NotificationSendState(this));
    } else {
      this.setState(new NotificationVisualizationState(this));
    }
  }

  public void send() throws Exception {
    this.state.send();
  }

  public void setState(NotificationState state) {
    this.state = state;
  }

  public void setTitle(String title) {
    this.state.setTitle(title);
  }

  public NotificationView getView() {
    return this.view;
  }

  public NotificationState getState() {
    return this.state;
  }

  public NotificationRepository getNotificationRepository() {
    return this.notificationRepository;
  }

  public UserDAO getUserDAO() {
    return userDAO;
  }

  public NotificationCommand getNotificationCommand() {
    return notificationCommand;
  }

  public Notification getNotification() {
    return notification;
  }

  public void setNotification(Notification notification) {
    this.notification = notification;
  }
}
