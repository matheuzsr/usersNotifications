package com.usersnotifications.command;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import com.usersnotifications.business.Encryptor.EncryptorPassword;
import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.dto.UserDTO;

public class SignUpCommand extends SignCommand {

  private String type;

  public SignUpCommand(UserDAO userDAO, EncryptorPassword encryptorPassword, String type) {
    super(userDAO, encryptorPassword);
    this.type = type;
  }

  @Override
  public boolean execute(UserDTO user) throws Exception {
    UserDTO existUser = this.userDAO.getUserByName(user.getName());

    if (existUser != null) {
      throw new Exception("Nome de usuário já existe!");
    }

    if (type == "admin") {
      user.setType("admin");
      user.setActivedAt(LocalDate.now());
    } else {
      user.setType("user");
    }

    String password = user.getPassword();
    String encryptedPassword = this.encryptorPassword.encrypt(password);

    user.setPassword(encryptedPassword);
    this.userDAO.add(user);

    return true;
  }
}
