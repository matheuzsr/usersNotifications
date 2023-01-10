package com.usersnotifications.model;

public class User {
  private int idUser;
  private String name;
  private String type;

  public User(int idUser, String name) {
    this.idUser = idUser;
    this.name = name;
  }

  public User() {
  }

  public int getIdUser() {
    return idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
