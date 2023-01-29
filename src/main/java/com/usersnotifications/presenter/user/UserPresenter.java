package com.usersnotifications.presenter.user;

import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.dto.UserDTO;
import com.usersnotifications.presenter.user.state.UserState;
import com.usersnotifications.presenter.user.state.UserVisualizationState;
import com.usersnotifications.view.UserView;

public class UserPresenter {
  private UserView view;
  private UserDAO userDAO;
  private UserState state;

  public UserPresenter(UserDAO userDAO, UserDTO userDTO) throws Exception {
    this.view = new UserView();
    this.userDAO = userDAO;

    this.setState(new UserVisualizationState(this, userDTO));
  }

  public void save() throws Exception {
    this.state.save();
  }

  public void edit() throws Exception {
    this.state.edit();
  }

  public void delete() throws Exception {
    this.state.delete();
  }

  public void close() {
    this.state.close();
  }

  public UserView getView() {
    return view;
  }

  public UserState getState() {
    return state;
  }

  public void setState(UserState state) {
    this.state = state;
  }

  public UserDAO getUserDAO() {
    return userDAO;
  }
}
