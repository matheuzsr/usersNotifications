package com.usersnotifications.data.dao;

import com.usersnotifications.dto.UserDTO;
import java.util.Collection;

public interface UserDAO {

    public void add(UserDTO userDTO) throws Exception;

    public UserDTO getUserByName(String nome) throws Exception;

    public UserDTO getById(int searchId) throws Exception;

    public Collection<UserDTO> getAll() throws Exception;

    public boolean update(UserDTO userDTO) throws Exception;

    public boolean delete(int idUser) throws Exception;
}
