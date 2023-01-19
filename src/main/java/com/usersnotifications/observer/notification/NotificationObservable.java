package com.usersnotifications.observer.notification;

import java.util.ArrayList;
import java.util.List;

import com.usersnotifications.model.Notification;

public abstract class NotificationObservable {

    protected List<NotificationObserver> observerList = new ArrayList<>();

    public final void addObserver(NotificationObserver observer) {
        observerList.add(observer);
    }

    public final void removerObserver(NotificationObserver observer) {
        int indexObserver = observerList.indexOf(observer);
        if (indexObserver >= 0) {
            observerList.remove(observer);
        }
    }

    protected abstract void notificarObservers(List<Notification> funcionarios);
}
