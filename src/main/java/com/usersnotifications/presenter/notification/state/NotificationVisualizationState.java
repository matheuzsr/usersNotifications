package com.usersnotifications.presenter.notification.state;

import com.usersnotifications.model.Notification;
import com.usersnotifications.presenter.notification.NotificationPresenter;
import com.usersnotifications.view.NotificationView;

public class NotificationVisualizationState extends NotificationState {
  public NotificationVisualizationState(NotificationPresenter presenter) {
    super(presenter, "Visualizar notificação");
    this.screenConfiguration();
  }

  private void screenConfiguration() {
    // TODO: Desabilitar aqui o campo e ocultar o botão de enviar

    NotificationView view = this.presenter.getView();
    Notification visualizeNotification = this.presenter.getNotification();

    view.getTitleLbl().setText("Notificação recebida");
    view.getToLbl().setText("De");
    view.getToUserSelect().addItem(visualizeNotification.getFromUsername());
    view.getToUserSelect().setEnabled(false);

    view.getDescriptionMessageTxtArea().setText(visualizeNotification.getDescription());

    view.getSendBtn().setVisible(false);

    // UserDAO userDAO = this.presenter.getUserDAO();

    // try {
    // this.carregarSelectToUser(userDAO.getAllWithoutCurrentUser());
    // } catch (Exception ex) {
    // JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de usuário para
    // enviar as notificações");
    // }
  }
}
