/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usersnotifications.data.repository;

import com.usersnotifications.data.connection.SQLiteDB;
import com.usersnotifications.model.Notification;
import com.usersnotifications.observer.notification.NotificationReceivedObservable;
import com.usersnotifications.dto.UserDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

public class NotificationRepositorySQLite extends NotificationReceivedObservable implements NotificationRepository {
    private final SQLiteDB BD = new SQLiteDB();

    @Override
    public void add(Notification notification) throws Exception {
        BD.conectar();
        StringBuilder str = new StringBuilder();

        str.append("INSERT INTO notification (description, from_user_id, to_user_id, sent_at) VALUES ('");
        str.append(notification.getDescription()).append("', ");
        str.append(notification.getFromUserId()).append(", ");
        str.append(notification.getToUserId()).append(", '");
        str.append(notification.getSentAt()).append("');");

        BD.atualizar(str.toString());
        BD.close();
    }

    @Override
    public UserDTO getById(int notificationId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<Notification> getReceivedAll(int userId) throws Exception {
        return this.getAll(userId, false);
    }

    @Override
    public Collection<Notification> getSentAll(int userId) throws Exception {
        return this.getAll(userId, true);
    }

    private Collection<Notification> getAll(int userId, boolean sent) throws Exception {
        List<Notification> notifcationList = new ArrayList<>();

        try {
            StringBuilder str = new StringBuilder();
            str.append(
                    "SELECT notification.id, description, from_user.username as from_username, to_user.username as to_username, read_at, sent_at FROM notification ");
            str.append("JOIN user to_user on notification.to_user_id = to_user.id ");
            str.append("JOIN user from_user on notification.from_user_id = from_user.id ");

            if (sent) {
                str.append("WHERE notification.from_user_id = ");
            } else {
                str.append("WHERE notification.to_user_id = ");
            }

            str.append(userId);

            BD.conectar();
            BD.consultar(str.toString());

            while (BD.getRs().next()) {
                int notificationId = BD.getRs().getInt("id");
                String fromUsername = BD.getRs().getString("from_username");
                LocalDate sentAt = LocalDate.parse(BD.getRs().getString("sent_at"),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                Notification notification = new Notification(notificationId, fromUsername, sentAt);

                String toUsername = BD.getRs().getString("to_username");
                notification.setToUsername(toUsername);
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
    public boolean read(int notificationId, int userId) throws Exception {
        StringBuilder str = new StringBuilder();

        BD.conectar();

        str.append(" UPDATE notification ");
        str.append(" set ");
        str.append(" read_at = ").append("'").append(LocalDate.now()).append("'");
        str.append(" Where id =").append(notificationId);

        BD.atualizar(str.toString());
        BD.close();

        this.notifyReceivedObservers((List<Notification>) this.getReceivedAll(userId));
        return true;
    }

    @Override
    public boolean delete(int notificationId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void notifyReceivedObservers(List<Notification> notifications) {
        this.observerList.forEach(observer -> {
            observer.update(notifications);
        });
    }
}
