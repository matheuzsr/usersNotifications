package com.usersnotifications.observer.user;

import java.util.List;

import com.usersnotifications.model.User;

public interface UserObserver {

    public void update(List<User> funcionarioList);

}
