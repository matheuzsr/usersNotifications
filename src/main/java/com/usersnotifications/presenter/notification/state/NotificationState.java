package com.usersnotifications.presenter.notification.state;

import com.usersnotifications.dto.NotificationDTO;
import com.usersnotifications.presenter.notification.NotificationPresenter;
import com.usersnotifications.view.NotificationView;

public abstract class NotificationState {
  protected NotificationPresenter presenter;

  public NotificationState(NotificationPresenter presenter, String title) {
    this.presenter = presenter;
    this.setTitle(title);
  }

  public void setTitle(String title) {
    NotificationView view  = this.presenter.getView();

    view.setTitle(title);
  }

  public void send(NotificationDTO notificationDTO) throws Exception {
    throw new RuntimeException("Você deve implementar o método send!");
  }

  // private void clearListeners() {
	// 	for (Component c : this.presenter.getView().getContentPane().getComponents()) {
	// 		if (c instanceof JButton) {
	// 			for (ActionListener al : ((JButton) c).getActionListeners()) {
	// 				((JButton) c).removeActionListener(al);
	// 			}
	// 		}
	// 	}
	// }
}
