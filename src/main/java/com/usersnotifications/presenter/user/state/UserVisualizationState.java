package com.usersnotifications.presenter.user.state;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import com.usersnotifications.dto.UserDTO;
import com.usersnotifications.presenter.user.UserPresenter;
import com.usersnotifications.view.UserView;

public class UserVisualizationState extends UserState {

  public UserVisualizationState(UserPresenter presenter, UserDTO userDTO) {
    super(presenter, userDTO);
    this.screenConfiguration();
  }

  private void screenConfiguration() {
    UserView view = this.presenter.getView();

    view.getUserNameTxt().setText(this.userDTO.getName());
    view.getTypeUserTxt().setText(this.userDTO.getType());
    view.getcBoxAuthorizedUser().setSelected(this.userDTO.getActivedAt() != null);

    view.getUserNameTxt().setEditable(false);
    view.getTypeUserTxt().setEditable(false);
    view.getcBoxAuthorizedUser().setEnabled(false);

    view.getEditBtn().addActionListener((ActionEvent ae) -> {
      try {
        this.edit();
      } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Erro ao editar o usuário!");
      }
    });

    view.getDeleteBtn().addActionListener((ActionEvent ae) -> {
      try {
        this.delete();
      } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Erro ao deletar o usuário!");
      }
    });

    view.getCloseBtn().addActionListener((ActionEvent ae) -> {
      view.dispose();
    });

    view.getSaveBtn().setVisible(false);
  }

  @Override
  public void delete() throws Exception {
    // TODO: Chamar a DAO e inserir o delete

  }

  @Override
  public void edit() throws Exception {
    this.presenter.setState(new UserEditState(presenter, this.userDTO));
  }

}