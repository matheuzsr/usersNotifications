package com.usersnotifications.data.dao;

import com.usersnotifications.business.Session;
import com.usersnotifications.data.connection.SQLiteDB;
import com.usersnotifications.dto.UserDTO;
import com.usersnotifications.model.User;
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

        // TODO: Alterar maneira paleativa de tratativa para null (getType e
        // getActivedAt)
        str.append("INSERT INTO");
        str.append(" user(username, encrypt_password, type, actived_at, created_at)");
        str.append(" VALUES ('");
        str.append(user.getName()).append("'").append(",").append("'");
        str.append(user.getPassword()).append("'").append(",");
        str.append(" '").append(user.getType()).append("' ,");

        if (user.getActivedAt() == null) {
            str.append(" NULL, ");
        } else {
            str.append(" '").append(user.getActivedAt()).append("', ");
        }

        str.append("'").append(LocalDate.now()).append("')");

        BD.atualizar(str.toString());

        BD.close();
    }

    @Override
    public UserDTO getUserByName(String searchName) throws Exception {
        UserDTO currentUser = null;

        StringBuilder str = new StringBuilder();
        str.append("SELECT * FROM user");
        str.append(" WHERE user.deleted_at is NULL");
        str.append(" AND username='");
        str.append(searchName).append("'");
        ;

        BD.conectar();
        BD.consultar(str.toString());

        while (BD.getRs().next()) {
            int id = BD.getRs().getInt("id");
            String name = BD.getRs().getString("username");
            String encryptPassword = BD.getRs().getString("encrypt_password");
            String type = BD.getRs().getString("type");

            LocalDate createdAt = LocalDate.parse(BD.getRs().getString("created_at"),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate activedAt = LocalDate.parse(BD.getRs().getString("actived_at"),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            currentUser = new UserDTO(id, name, encryptPassword);
            currentUser.setCreatedAt(createdAt);
            currentUser.setActivedAt(activedAt);
            currentUser.setType(type);
        }

        BD.close();

        return currentUser;
    }

    @Override
    public UserDTO getById(int searchId) throws Exception {
        StringBuilder str = new StringBuilder();
        str.append("SELECT * FROM user");
        str.append(" WHERE user.deleted_at is NULL");
        str.append(" AND id='");
        str.append(searchId).append("'");

        BD.conectar();
        BD.consultar(str.toString());

        int id = BD.getRs().getInt("id");
        String name = BD.getRs().getString("username");
        String encryptPassword = BD.getRs().getString("encrypt_password");
        String type = BD.getRs().getString("type");

        LocalDate createdAt = LocalDate.parse(BD.getRs().getString("created_at"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate activedAt = LocalDate.parse(BD.getRs().getString("actived_at"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        UserDTO userDTO = new UserDTO(id, name, encryptPassword);
        userDTO.setCreatedAt(createdAt);
        userDTO.setActivedAt(activedAt);
        userDTO.setType(type);

        BD.close();

        return userDTO;
    }

    @Override
    public Collection<UserDTO> getAll() throws Exception {
        List<UserDTO> users = new ArrayList<>();

        StringBuilder str = new StringBuilder();
        str.append("SELECT * FROM user");
        str.append(" WHERE user.deleted_at is NULL");

        BD.conectar();
        BD.consultar(str.toString());

        while (BD.getRs().next()) {
            int id = BD.getRs().getInt("id");
            String name = BD.getRs().getString("username");
            String encryptPassword = BD.getRs().getString("encrypt_password");
            String type = BD.getRs().getString("type");

            LocalDate createdAt = LocalDate.parse(BD.getRs().getString("created_at"),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate activedAt = LocalDate.parse(BD.getRs().getString("actived_at"),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            UserDTO userDTO = new UserDTO(id, name, encryptPassword);
            userDTO.setCreatedAt(createdAt);
            userDTO.setActivedAt(activedAt);
            userDTO.setType(type);

            users.add(userDTO);
        }

        BD.close();

        return users;
    }

    @Override
    public Collection<UserDTO> getAllWithoutCurrentUser() throws Exception {
        User currentUser = Session.getInstance().getUser();
        List<UserDTO> users = new ArrayList<>();

        StringBuilder str = new StringBuilder();
        str.append("SELECT * FROM user");
        str.append(" WHERE user.deleted_at is NULL");
        str.append(" AND id <> ");
        str.append(currentUser.getIdUser());

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
    public boolean updatePassword(UserDTO userDTO) throws Exception {
        StringBuilder str = new StringBuilder();
        BD.conectar();

        str.append(" UPDATE user");
        str.append(" set ");
        str.append(" encrypt_password = ").append("'").append(userDTO.getPassword()).append("'");
        str.append(" WHERE user.deleted_at is NULL");
        str.append(" AND id =").append(userDTO.getIdUser());

        BD.atualizar(str.toString());
        BD.close();

        return true;
    }

    @Override
    public boolean delete(int idUser) throws Exception {
        StringBuilder str = new StringBuilder();

        BD.conectar();

        str.append(" UPDATE user");
        str.append(" set ");
        str.append(" deleted_at = ").append("'").append(LocalDate.now()).append("'");
        str.append(" WHERE user.deleted_at is NULL");
        str.append(" AND id =").append(idUser);

        BD.atualizar(str.toString());
        BD.close();

        return true;
    }
}
