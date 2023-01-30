package com.usersnotifications.command.sign;

import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import com.pss.senha.validacao.ValidadorSenha;
import com.usersnotifications.business.Session;
import com.usersnotifications.business.Encryptor.EncryptorPassword;
import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.dto.UserDTO;
import com.usersnotifications.utils.LoggerService;

public class SignUpCommand extends SignCommand {

  private String type;

  public SignUpCommand(UserDAO userDAO, EncryptorPassword encryptorPassword, ValidadorSenha validadorSenha,
      String type) {
    super(userDAO, encryptorPassword, validadorSenha);
    this.type = type;
  }

  @Override
  public boolean execute(UserDTO user) throws Exception {
    if (user.getName().isEmpty()) {
      throw new Exception("Nome de usuário não pode ser vazio!");
    }

    if (!user.getPassword().equals(user.getPasswordConfirm())) {
      throw new Exception("As senhas precisam ser iguais!");
    }

    String password = user.getPassword();
    this.validatePassword(password);

    String encryptedPassword = this.encryptorPassword.encrypt(password);
    user.setPassword(encryptedPassword);

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

    this.userDAO.add(user);

    LoggerService.getInstance().write(LoggerService.INCLUDE,
        "Criação do usuário " + user.getName(), "");

    return true;
  }
}
