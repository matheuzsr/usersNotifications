package com.usersnotifications.business.Encryptor;

import org.jasypt.util.text.BasicTextEncryptor;

import io.github.cdimascio.dotenv.Dotenv;

public class EncryptorPassword {
  // TODO: Criar aqui um adapter
  private BasicTextEncryptor encryptor;

  public EncryptorPassword(Dotenv dotenv) {
    String localPasswordEncryptor = dotenv.get("PASSWORD_ENCRYPTOR");
    this.encryptor = new BasicTextEncryptor();
    encryptor.setPasswordCharArray(localPasswordEncryptor.toCharArray());
  }

  public String encrypt(String password) {
    return this.encryptor.encrypt(password);

  }

  public String decript(String passwordEncrypted) {
    return this.encryptor.decrypt(passwordEncrypted);

  }

  public Boolean comparePassword(String password, String passwordEncrypted) {
    return password.equals(this.encryptor.decrypt(passwordEncrypted));
  }
}
