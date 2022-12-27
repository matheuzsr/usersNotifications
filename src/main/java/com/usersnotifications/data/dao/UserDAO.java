package com.usersnotifications.data.dao;

import java.util.Collection;
import java.util.List;

import com.usersnotifications.model.User;

public interface UserDAO {

    public boolean add(User user) throws Exception;

    public boolean delete(int idUser) throws Exception;

    public List<User> getUserByName(String nome) throws Exception;

    public boolean contains(User user);

    public User getById(int searchId) throws Exception;

    public Collection<User> getAll() throws Exception;

    public boolean update(User user) throws Exception;
}
