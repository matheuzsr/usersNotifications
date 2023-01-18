package com.usersnotifications.presenter.notification.state;

import com.usersnotifications.dto.NotificationDTO;
import com.usersnotifications.presenter.notification.NotificationPresenter;

public class NotificationSendState extends NotificationState {
  public NotificationSendState(NotificationPresenter presenter) {
    super(presenter, "Enviar notificação");
    this.screenConfiguration();
  }

  private void screenConfiguration() {

  }

  @Override
  public void send(NotificationDTO notificationDTO) throws Exception {
    throw new RuntimeException("Você deve implementar o método send!");
  }
}
