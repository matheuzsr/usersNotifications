package com.usersnotifications.presenter.user.state;

import java.awt.event.ActionEvent;
import java.time.LocalDate;

import javax.swing.JOptionPane;

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

    view.getUserNameTxt().setEditable(true);
    view.getTypeUserTxt().setEditable(false);
    view.getcBoxAuthorizedUser().setEnabled(true);
    view.getSaveBtn().setVisible(true);

    view.getEditBtn().setVisible(false);
    view.getDeleteBtn().setVisible(false);

    view.getSaveBtn().addActionListener((ActionEvent ae) -> {
      this.save();
    });

    view.getcBoxAuthorizedUser().addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        handleAuthorizedUser(view.getcBoxAuthorizedUser().isSelected());
      }

    });

    view.getCloseBtn().addActionListener((ActionEvent ae) -> {
      this.closeView();
    });
  }

  private void closeView() {
    this.presenter.getView().dispose();
  }

  private void handleAuthorizedUser(boolean enabledAuthorized) {
    LocalDate authorizDate = null;

    if (enabledAuthorized) {
      authorizDate = LocalDate.now();
    }
    this.userDTO.setActivedAt(authorizDate);
  }

  @Override
  public void save() {
    try {
      this.presenter.getUserDAO().update(this.userDTO);
      JOptionPane.showMessageDialog(null, "Alterações salvas com sucesso!");

      this.closeView();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Erro ao salvar alterações!");
    }
  }
}
