package com.usersnotifications.command.sign;

import java.util.List;

import com.pss.senha.validacao.ValidadorSenha;
import com.usersnotifications.business.Encryptor.EncryptorPassword;
import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.dto.UserDTO;

public abstract class SignCommand {
  protected UserDAO userDAO;
  protected EncryptorPassword encryptorPassword;
  private ValidadorSenha validadorSenha;

  public SignCommand(UserDAO userDAO, EncryptorPassword encryptorPassword, ValidadorSenha validadorSenha) {
    this.userDAO = userDAO;
    this.encryptorPassword = encryptorPassword;
    this.validadorSenha = validadorSenha;
  }

  public abstract boolean execute(UserDTO user) throws Exception;

  protected boolean validatePassword(String password) throws Exception {
    List<String> validateList = validadorSenha.validar(password);

    if (!validateList.isEmpty()) {
      throw new Exception(validateList.toString());
    }

    return true;
  }
}
