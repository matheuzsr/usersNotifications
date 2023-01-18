package com.usersnotifications.presenter.notification;

import com.usersnotifications.data.repository.NotificationUserRepository;
import com.usersnotifications.dto.NotificationDTO;
import com.usersnotifications.presenter.notification.state.NotificationSendState;
import com.usersnotifications.presenter.notification.state.NotificationState;
import com.usersnotifications.presenter.notification.state.NotificationVisualizationState;
import com.usersnotifications.view.NotificationView;

public class NotificationPresenter {
  private NotificationView view;
  private NotificationState state;
  private NotificationUserRepository repository;

  public NotificationPresenter(NotificationUserRepository repository, NotificationDTO notificationDTO) {
    this.view = new NotificationView();
    this.repository = repository;

    if (notificationDTO == null) {
      this.setState(new NotificationSendState(this));
    } else {
      this.setState(new NotificationVisualizationState(this));
    }
  }

  public void send(NotificationDTO notificationDTO) throws Exception {
    this.state.send(notificationDTO);
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

  public NotificationUserRepository getRepository() {
    return this.repository;
  }
}
