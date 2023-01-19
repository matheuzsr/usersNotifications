package com.usersnotifications.observer.user;

import java.util.ArrayList;
import java.util.List;

import com.usersnotifications.model.User;

public abstract class UserObservable {

    protected List<UserObserver> observerList = new ArrayList<>();

    public final void addObserver(UserObserver observer) {
        observerList.add(observer);
    }

    public final void removerObserver(UserObserver observer) {
        int indexObserver = observerList.indexOf(observer);
        if (indexObserver >= 0) {
            observerList.remove(observer);
        }
    }

    protected abstract void notificarObservers(List<User> funcionarios);
}
