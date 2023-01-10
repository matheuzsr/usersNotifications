package com.usersnotifications.presenter;

import com.usersnotifications.view.MainWindowView;

public class MainWindowPresenter {
  private MainWindowView view;

  public MainWindowPresenter() {
    this.view = new MainWindowView();
  }

  public void setVisibleView() {
    this.view.setVisible(true);
  }
}
