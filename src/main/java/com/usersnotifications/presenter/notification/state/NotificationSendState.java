package com.usersnotifications.presenter.notification.state;

import java.util.Collection;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

import com.usersnotifications.business.Session;
import com.usersnotifications.command.notification.NotificationCommand;
import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.data.repository.NotificationRepository;
import com.usersnotifications.dto.UserDTO;
import com.usersnotifications.model.Notification;
import com.usersnotifications.model.User;
import com.usersnotifications.presenter.notification.NotificationPresenter;
import com.usersnotifications.view.NotificationView;

public class NotificationSendState extends NotificationState {
  public NotificationSendState(NotificationPresenter presenter) {
    super(presenter, "Enviar notificação");
    this.screenConfiguration();
  }

  private void screenConfiguration() {
    NotificationView view = this.presenter.getView();

    view.getSendBtn().addActionListener((ActionEvent ae) -> {
      try {
        this.send();
        JOptionPane.showMessageDialog(null, "Notificação enviada com sucesso!");
        view.dispose();
      } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Não foi possível enviar a notificação");
      }
    });
    UserDAO userDAO = this.presenter.getUserDAO();

    try {
      this.carregarSelectToUser(userDAO.getAllWithoutCurrentUser());
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de usuário para enviar as notificações");
    }
  }

  private void carregarSelectToUser(Collection c) {
    NotificationView view = this.presenter.getView();
    JComboBox toUserSelect = view.getToUserSelect();

    Iterator<?> it = c.iterator();
    while (it.hasNext()) {
      UserDTO user = (UserDTO) it.next();
      toUserSelect.addItem(user.getName());
    }
  }

  @Override
  public void send() throws Exception {
    NotificationView view = this.presenter.getView();
    String toUsername = (String) view.getToUserSelect().getSelectedItem();
    UserDTO toUser = this.presenter.getUserDAO().getUserByName(toUsername);

    int fromUserId = Session.getInstance().getUser().getIdUser();
    int toUserId = toUser.getIdUser();
    String description = view.getDescriptionMessageTxtArea().getText();
    LocalDate sentAt = LocalDate.now();

    Notification notification = new Notification(fromUserId, toUserId, description, sentAt);

    NotificationCommand command = this.presenter.getNotificationCommand();
    command.execute(notification);
  }
}
