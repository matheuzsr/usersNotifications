package com.usersnotifications.dto;

import java.time.LocalDate;

public class UserDTO {

    private int idUser;
    private String name;
    private String password;
    private String passwordConfirm;
    private LocalDate activedAt;
    private String type;
    private LocalDate createdAt;

    public UserDTO(int idUser, String name, String password) {
        this.idUser = idUser;
        this.name = name;
        this.password = password;
    }

    public UserDTO() {
    }

    public int getIdUser() {
        return idUser;
    }

    public UserDTO setIdUser(int idUser) {
        this.idUser = idUser;

        return this;
    }

    public String getName() {
        return name;
    }

    public UserDTO setName(String name) {
        this.name = name;

        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO setPassword(String password) {
        this.password = password;

        return this;
    }

    public LocalDate getActivedAt() {
        return activedAt;
    }

    public UserDTO setActivedAt(LocalDate activedAt) {
        this.activedAt = activedAt;

        return this;

    }

    public String getType() {
        return type;
    }

    public UserDTO setType(String type) {
        this.type = type;

        return this;

    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public UserDTO setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;

        return this;
    }

    public UserDTO setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;

        return this;

    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
