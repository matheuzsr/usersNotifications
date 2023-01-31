package com.usersnotifications.presenter;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JOptionPane;

import com.pss.senha.validacao.ValidadorSenha;
import com.usersnotifications.business.Session;
import com.usersnotifications.business.Encryptor.EncryptorPassword;
import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.dto.UserDTO;
import com.usersnotifications.utils.ArrayToString;
import com.usersnotifications.utils.LoggerService;
import com.usersnotifications.view.ChangePasswordView;

public class ChangePasswordPresenter {
  private ChangePasswordView view;
  private UserDAO userDAO;
  private EncryptorPassword encryptorPassword;
  private ValidadorSenha validatorPassword;

  public ChangePasswordPresenter(UserDAO userDAO, EncryptorPassword encryptorPassword, ValidadorSenha validatorPassword)
      throws Exception {
    this.view = new ChangePasswordView();
    this.userDAO = userDAO;
    this.encryptorPassword = encryptorPassword;
    this.validatorPassword = validatorPassword;

    this.screenConfiguration();
  }

  private void screenConfiguration() {
    this.view.getChangePasswordBtn().addActionListener((ActionEvent ae) -> {
      this.handleChangePassword();
    });

    this.view.getCloseBtn().addActionListener((ActionEvent ae) -> {
      this.view.dispose();
    });
  }

  private void handleChangePassword() {
    int currentUserId = Session.getInstance().getUser().getIdUser();

    String currentPasswordTxt = this.view.getCurrentPasswordTxt().getText();
    String newPasswordTxt = this.view.getNewPasswordTxt().getText();
    String confirmNewPasswordTxt = this.view.getConfirmNewPasswordTxt().getText();

    try {
      UserDTO user = this.userDAO.getById(currentUserId);

      if (this.handleValidateNewPassword(newPasswordTxt, confirmNewPasswordTxt)
          && this.handleValidadeCurrentPassword(currentPasswordTxt, user.getPassword())) {
        user.setPassword(this.encryptorPassword.encrypt(newPasswordTxt));
        this.userDAO.updatePassword(user);

        LoggerService.getInstance().write(LoggerService.CHANGE, "Alteração de senha do usuário ",
            Session.getInstance().getUser().getName());

        JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
        this.view.dispose();
      }

    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage());
    }

  }

  private boolean handleValidateNewPassword(String newPassword, String confirmNewPassword) throws Exception {
    boolean isEquals = newPassword.equals(confirmNewPassword);

    if (!isEquals) {
      throw new Exception("A senha nova e a confirmação iguais devem ser iguais!");
    }

    List<String> validateList = this.validatorPassword.validar(newPassword);
    if (!validateList.isEmpty()) {
      throw new Exception(ArrayToString.convert(validateList.toString()));
    }

    return isEquals;
  }

  private boolean handleValidadeCurrentPassword(String currentPasswordInformed, String currentUserPassword)
      throws Exception {
    boolean isEquals = this.encryptorPassword.comparePassword(currentPasswordInformed, currentUserPassword);

    if (!isEquals) {
      throw new Exception("A senha atual inserida esta incorreta!");
    }

    return isEquals;
  }

  public ChangePasswordView getView() {
    return view;
  }

}
