package com.usersnotifications.observer.notification;

import java.util.List;
import com.usersnotifications.model.Notification;

public interface NotificationReceivedObserver {

    public void update(List<Notification> notifications);

}
