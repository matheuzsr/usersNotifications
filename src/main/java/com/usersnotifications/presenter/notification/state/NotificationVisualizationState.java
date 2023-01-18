package com.usersnotifications.presenter.notification.state;

import com.usersnotifications.presenter.notification.NotificationPresenter;

public class NotificationVisualizationState extends NotificationState {
  public NotificationVisualizationState(NotificationPresenter presenter) {
    super(presenter, "Visualizar notificação");
    this.screenConfiguration();
  }

  private void screenConfiguration() {
    // TODO: Desabilitar aqui o campo e ocultar o botão de enviar
  }
}
