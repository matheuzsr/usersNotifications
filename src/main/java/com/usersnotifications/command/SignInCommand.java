package com.usersnotifications.command;

import com.usersnotifications.business.Session;
import com.usersnotifications.business.Encryptor.EncryptorPassword;
import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.dto.UserDTO;
import com.usersnotifications.model.User;

public class SignInCommand extends SignCommand {

  public SignInCommand(UserDAO userDAO, EncryptorPassword encryptorPassword) {
    super(userDAO, encryptorPassword);
  }

  @Override
  public boolean execute(UserDTO user) throws Exception {
    UserDTO existUser = this.userDAO.getUserByName(user.getName());
    String encryptedPassword = existUser.getPassword();

    boolean isEquals = this.encryptorPassword.comparePassword(user.getPassword(), encryptedPassword);

    if (!isEquals) {
      throw new Exception("Senha incorreta");
    }

    this.setSession(existUser);

    return isEquals;
  }

  private void setSession(UserDTO user) {
    Session session = Session.getInstance();
    User userSession = new User();

    userSession.setIdUser(user.getIdUser());
    userSession.setName(user.getName());
    userSession.setType(user.getType());
    session.setUser(userSession);
  }
}
