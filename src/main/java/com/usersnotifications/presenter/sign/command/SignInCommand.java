package com.usersnotifications.presenter.sign.command;

import com.usersnotifications.business.Encryptor.EncryptorPassword;
import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.dto.UserDTO;

public class SignInCommand extends SignCommand {

  public SignInCommand(UserDAO userDAO, EncryptorPassword encryptorPassword) {
    super(userDAO, encryptorPassword);
  }

  @Override
  public boolean execute(UserDTO user) throws Exception {
    UserDTO existUser = this.userDAO.getUserByName(user.getName());
    String encryptedPassword = existUser.getPassword();

    boolean isEquals = this.encryptorPassword.comparePassword(user.getPassword(), encryptedPassword);

    if(!isEquals) {
      throw new Exception("Senha incorreta");
    }
    
    return isEquals;
  }
}
