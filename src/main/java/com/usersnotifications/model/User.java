package com.usersnotifications.model;

public class User {
  private int idUser;
  private String nome;

  public User(int idUser, String nome) {
    this.idUser = idUser;
    this.nome = nome;
  }

  public User() {
  }

  public int getIdUser() {
    return idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

}
