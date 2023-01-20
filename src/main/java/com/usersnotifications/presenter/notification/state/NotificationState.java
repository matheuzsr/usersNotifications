package com.usersnotifications.presenter.notification.state;
import java.awt.event.ActionEvent;

import com.usersnotifications.model.Notification;
import com.usersnotifications.presenter.notification.NotificationPresenter;
import com.usersnotifications.view.NotificationView;

public abstract class NotificationState {
  protected NotificationPresenter presenter;

  public NotificationState(NotificationPresenter presenter, String title) {
    this.presenter = presenter;
    this.setTitle(title);

    this.screenConfiguration();
  }

  public void setTitle(String title) {
    NotificationView view = this.presenter.getView();

    view.setTitle(title);
  }

  private void screenConfiguration() {
    NotificationView view = this.presenter.getView();

    view.getCloseBtn().addActionListener((ActionEvent e) -> {
      view.dispose();
    });
  }

  public void send() throws Exception {
    throw new RuntimeException("Você deve implementar o método send!");
  }

  // private void clearListeners() {
  // for (Component c : this.presenter.getView().getContentPane().getComponents())
  // {
  // if (c instanceof JButton) {
  // for (ActionListener al : ((JButton) c).getActionListeners()) {
  // ((JButton) c).removeActionListener(al);
  // }
  // }
  // }
  // }
}
