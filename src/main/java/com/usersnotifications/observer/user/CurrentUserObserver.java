package com.usersnotifications.observer.user;

import java.util.List;

import com.usersnotifications.dto.UserDTO;

public interface CurrentUserObserver {

    public void update(UserDTO user);

}
