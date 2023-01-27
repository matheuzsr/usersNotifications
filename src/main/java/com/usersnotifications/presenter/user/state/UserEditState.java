package com.usersnotifications.presenter.user.state;

import java.awt.event.ActionEvent;

import com.usersnotifications.dto.UserDTO;
import com.usersnotifications.presenter.user.UserPresenter;
import com.usersnotifications.view.UserView;

public class UserEditState extends UserState {

    public UserEditState(UserPresenter presenter, UserDTO userDTO) {
      super(presenter, userDTO);
      this.screenConfiguration();
    }

  private void screenConfiguration() {
    UserView view = this.presenter.getView();

    view.getEditBtn().setVisible(false);
    view.getDeleteBtn().setVisible(false);

    view.getSaveBtn().addActionListener((ActionEvent ae) -> {
      // Botão de salvar o user
    });
  }

  @Override
  public void save() throws Exception {
    System.out.println("Edição salva!");
  }
}
