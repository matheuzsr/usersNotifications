package com.usersnotifications.data.dao;

import com.usersnotifications.data.connection.SQLiteDB;
import com.usersnotifications.dto.UserDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDAOSQLite implements UserDAO {

    private final SQLiteDB BD = SQLiteDB.getInstance();

    @Override
    public void add(UserDTO user) throws Exception {
        BD.conectar();

        StringBuilder str = new StringBuilder();

        // TODO: Alterar maneira paleativa de tratativa para null (getType e getActivedAt)
        str.append("INSERT INTO");
        str.append(" user(username, encrypt_password, type, actived_at)");
        str.append(" VALUES ('");
        str.append(user.getName()).append("'").append(",").append("'");
        str.append(user.getPassword()).append("'").append(",").append("'");
        str.append(
                user.getType() == null ? "" : user.getType()).append("'").append(",").append("'");
        str.append(
                user.getActivedAt() == null ? "" : user.getActivedAt()).append("'");
        str.append(")");

        BD.atualizar(str.toString());

        BD.close();
    }

    @Override
    public UserDTO getUserByName(String searchName) throws Exception {
        UserDTO currentUser = null;

        StringBuilder str = new StringBuilder();
        str.append("SELECT * FROM user");
        str.append(" WHERE username='");
        str.append(searchName).append("'");
        ;

        BD.conectar();
        BD.consultar(str.toString());

        while (BD.getRs().next()) {
            int id = BD.getRs().getInt("id");
            String name = BD.getRs().getString("username");
            String encryptPassword = BD.getRs().getString("encrypt_password");

            currentUser = new UserDTO(id, name, encryptPassword);
        }

        BD.close();

        return currentUser;
    }

    @Override
    public UserDTO getById(int searchId) throws Exception {
        return null;
    }

    @Override
    public Collection<UserDTO> getAll() throws Exception {
        List<UserDTO> users = new ArrayList<>();

        StringBuilder str = new StringBuilder();
        str.append("SELECT * FROM user");

        BD.conectar();
        BD.consultar(str.toString());

        while (BD.getRs().next()) {
            int id = BD.getRs().getInt("id");
            String name = BD.getRs().getString("username");
            String encryptPassword = BD.getRs().getString("encrypt_password");

            UserDTO userDTO = new UserDTO(id, name, encryptPassword);

            users.add(userDTO);
        }

        BD.close();

        return users;
    }

    @Override
    public boolean update(UserDTO userDTO) throws Exception {
        return false;
    }

    @Override
    public boolean delete(int idUser) throws Exception {

        StringBuilder str = new StringBuilder();

        BD.conectar();

        str.append(" UPDATE user");
        str.append(" set ");
        str.append(" deleted_at = ").append("'").append(LocalDate.now()).append("'");
        str.append(" WHERE id =").append(idUser);

        BD.atualizar(str.toString());
        BD.close();

        return true;
    }
}
