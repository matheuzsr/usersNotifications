package com.usersnotifications.observer.notification;

import java.util.ArrayList;
import java.util.List;

import com.usersnotifications.model.Notification;


public abstract class NotificationReceivedObservable {

    protected List<NotificationReceivedObserver> observerList = new ArrayList<>();

    public final void addObserver(NotificationReceivedObserver observer) {
        observerList.add(observer);
    }

    public final void removerObserver(NotificationReceivedObserver observer) {
        int indexObserver = observerList.indexOf(observer);
        if (indexObserver >= 0) {
            observerList.remove(observer);
        }
    }

    protected abstract void notifyReceivedObservers(List<Notification> notifications);
}
