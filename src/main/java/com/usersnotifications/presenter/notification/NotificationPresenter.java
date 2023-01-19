package com.usersnotifications.presenter.notification;

import com.usersnotifications.model.Notification;
import com.usersnotifications.presenter.notification.state.NotificationSendState;
import com.usersnotifications.presenter.notification.state.NotificationState;
import com.usersnotifications.presenter.notification.state.NotificationVisualizationState;
import com.usersnotifications.view.NotificationView;
import com.usersnotifications.data.repository.NotificationRepository;

public class NotificationPresenter {
  private NotificationView view;
  private NotificationState state;
  private NotificationRepository repository;

  public NotificationPresenter(NotificationRepository repository, Notification notification) {
    this.view = new NotificationView();
    this.repository = repository;

    if (notification == null) {
      this.setState(new NotificationSendState(this));
    } else {
      this.setState(new NotificationVisualizationState(this));
    }
  }

  public void send(Notification notification) throws Exception {
    this.state.send(notification);
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

  public NotificationRepository getRepository() {
    return this.repository;
  }
}
