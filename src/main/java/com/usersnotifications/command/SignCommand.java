package com.usersnotifications.command;

import com.usersnotifications.business.Encryptor.EncryptorPassword;
import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.dto.UserDTO;

public abstract class SignCommand {
  protected UserDAO userDAO;
  protected EncryptorPassword encryptorPassword;
    public SignCommand(UserDAO userDAO, EncryptorPassword encryptorPassword) {
      this.userDAO = userDAO;
      this.encryptorPassword = encryptorPassword;
    }

    public abstract boolean execute(UserDTO user)  throws Exception;
}
