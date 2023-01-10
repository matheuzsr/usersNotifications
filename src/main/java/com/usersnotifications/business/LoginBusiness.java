package com.usersnotifications.business;

import com.usersnotifications.dto.UserDTO;

public class LoginBusiness {

    private UserDTO user;

    public LoginBusiness(UserDTO user) {
        this.user = user;
    }

    public void handleLogin() {

    }

    public boolean handleValidateLogin() {
        return true;
    }
}
