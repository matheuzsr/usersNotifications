package com.usersnotifications.business;

import com.usersnotifications.dto.UserDTO;
import com.usersnotifications.model.User;
import com.usersnotifications.observer.user.CurrentUserObserver;

public class Session implements CurrentUserObserver {
  private static Session instance;
  private User user;

  private Session() {}

  public static Session getInstance() {
    if (instance == null) {
      instance = new Session();
    }
    return instance;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public void update(UserDTO user) {
   this.user.setName(user.getName());
  }
}