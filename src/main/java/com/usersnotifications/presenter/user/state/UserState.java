package com.usersnotifications.presenter.user.state;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import java.awt.event.ActionListener;

import com.usersnotifications.dto.UserDTO;
import com.usersnotifications.presenter.user.UserPresenter;
import com.usersnotifications.view.UserView;

public class UserState {
  UserPresenter presenter;
  UserDTO userDTO;

  public UserState(UserPresenter presenter, UserDTO userDTO) {
    this.presenter = presenter;
    this.userDTO = userDTO;
    this.limpaListeners();
  }

  public void save() throws Exception {
    throw new RuntimeException("Você deve implementar o método de save!");
  }

  public void edit() throws Exception {
    throw new RuntimeException("Você deve implementar o método de edit!");
  }

  public void delete() throws Exception {
    throw new RuntimeException("Você deve implementar o método de delete!");
  }

  public void close() {
    throw new RuntimeException("Você deve implementar o método de close!");
  }

  private void limpaListeners() {
    for (Component c : this.presenter.getView().getContentPane().getComponents()) {
      if (c instanceof JButton) {
        for (ActionListener al : ((JButton) c).getActionListeners()) {
          ((JButton) c).removeActionListener(al);
        }
      }
    }
  }
}
