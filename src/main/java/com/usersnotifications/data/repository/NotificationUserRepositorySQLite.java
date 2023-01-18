/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usersnotifications.data.repository;

import com.usersnotifications.data.connection.SQLiteDB;
import com.usersnotifications.dto.NotificationDTO;
import com.usersnotifications.dto.UserDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

public class NotificationUserRepositorySQLite implements NotificationUserRepository {
    private final SQLiteDB BD = new SQLiteDB();

    @Override
    public void add(NotificationDTO notificationDTO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public UserDTO getById(int notificationId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<NotificationDTO> getAll(int userId) throws Exception {
        List<NotificationDTO> notifcationList = new ArrayList<>();

        try {
            StringBuilder str = new StringBuilder();
            str.append(
                    "SELECT notification.id as notification_id, notification.description as description,  user.username as from_username, read_at, sent_at FROM notification ");
            str.append("JOIN notification_user on notification.id = notification_user.notification_id ");
            str.append("JOIN user on user.id = notification_user.from_user_id ");
            str.append("WHERE notification_user.to_user_id = ");
            str.append(userId);

            BD.conectar();
            BD.consultar(str.toString());

            while (BD.getRs().next()) {
                int notificationId = BD.getRs().getInt("notification_id");
                String fromUsername = BD.getRs().getString("from_username");
                LocalDate sentAt = LocalDate.parse(BD.getRs().getString("sent_at"),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                NotificationDTO notification = new NotificationDTO(notificationId, fromUsername, sentAt);

                String description = BD.getRs().getString("description");
                notification.setDescription(description);

                if (BD.getRs().getString("read_at") != null) {
                    LocalDate readedAt = LocalDate.parse(BD.getRs().getString("read_at"),
                            DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                    notification.setReadAt(readedAt);
                }

                notifcationList.add(notification);
            }
            BD.close();
        } catch (Exception ex) {
            // Mover lá para a presenter
            JOptionPane.showMessageDialog(null, ex.getStackTrace());
        }

        return notifcationList;
    }

    @Override
    public boolean read(int notificationId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(int notificationId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
