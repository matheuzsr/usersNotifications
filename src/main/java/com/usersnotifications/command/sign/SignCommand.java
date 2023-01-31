package com.usersnotifications.command.sign;

import java.util.List;

import com.pss.senha.validacao.ValidadorSenha;
import com.usersnotifications.business.Encryptor.EncryptorPassword;
import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.dto.UserDTO;
import com.usersnotifications.utils.ArrayToString;

public abstract class SignCommand {
  protected UserDAO userDAO;
  protected EncryptorPassword encryptorPassword;
  private ValidadorSenha validatorPassword;

  public SignCommand(UserDAO userDAO, EncryptorPassword encryptorPassword, ValidadorSenha validatorPassword) {
    this.userDAO = userDAO;
    this.encryptorPassword = encryptorPassword;
    this.validatorPassword = validatorPassword;
  }

  public abstract boolean execute(UserDTO user) throws Exception;

  protected boolean validatePassword(String password) throws Exception {
    List<String> validateList = this.validatorPassword.validar(password);

    if (!validateList.isEmpty()) {
      throw new Exception(ArrayToString.convert(validateList.toString()));
    }

    return true;
  }
}
