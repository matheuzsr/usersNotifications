package com.usersnotifications.observer.user;

import java.util.ArrayList;
import java.util.List;

import com.usersnotifications.dto.UserDTO;
import com.usersnotifications.model.User;

public abstract class UserObservable {

    protected List<CurrentUserObserver> observerList = new ArrayList<>();

    public final void addObserver(CurrentUserObserver observer) {
        observerList.add(observer);
    }

    public final void removerObserver(CurrentUserObserver observer) {
        int indexObserver = observerList.indexOf(observer);
        if (indexObserver >= 0) {
            observerList.remove(observer);
        }
    }

    protected abstract void notifyObservers(UserDTO user);
}
