package com.usersnotifications.observer.notification;

import java.util.List;

import com.usersnotifications.model.Notification;

public interface NotificationObserver {

    public void update(List<Notification> funcionarioList);

}
