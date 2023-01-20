package com.usersnotifications.presenter;

import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import com.usersnotifications.command.notification.NotificationCommand;
import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.data.repository.NotificationRepository;
import com.usersnotifications.presenter.notification.NotificationPresenter;
import com.usersnotifications.view.MainWindowView;

public class MainWindowPresenter {

    private MainWindowView view;
    private NotificationRepository notificationRepository;
    private UserDAO userDAO;
    private NotificationCommand notificationCommand;

    public MainWindowPresenter(NotificationRepository notificationRepository, UserDAO userDAO,
            NotificationCommand notificationCommand) {
        this.notificationRepository = notificationRepository;
        this.userDAO = userDAO;
        this.notificationCommand = notificationCommand;

        this.view = new MainWindowView();
        this.screenConfiguration();
    }

    public void screenConfiguration() {
        // TODO: Aqui poderia estar o add do menu para admin e para o normal

        this.view.getSendNotificationMenuItem().addActionListener((ActionEvent e) -> {
            try {
                NotificationPresenter presenter = new NotificationPresenter(this.notificationRepository, this.userDAO,
                        this.notificationCommand, null);

                showPanel(presenter.getView(), false, false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, ex.getMessage());
            }
        });

        this.view.getViewNotificationMenuItem().addActionListener((ActionEvent e) -> {
            try {
                NotificationListPresenter presenter = new NotificationListPresenter(this.notificationRepository,
                        this.userDAO);

                showPanel(presenter.getView(), false, false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, ex.getMessage());
            }
        });
    }

    public static void showPanel(JInternalFrame frame, Boolean maximize, Boolean closable) throws Exception {
        if (closable) {
            MainWindowView.getDesktop().add(frame);
        } else {
            boolean isFrameShow = false;
            JInternalFrame[] allFrames = MainWindowView.getDesktop().getAllFrames();

            for (JInternalFrame f : allFrames) {
                if (f.getTitle().equals(frame.getTitle())) {
                    isFrameShow = true;
                }
            }

            if (!isFrameShow) {
                MainWindowView.getDesktop().remove(frame);
                MainWindowView.getDesktop().add(frame);
            }
        }

        frame.setVisible(true);
        frame.moveToFront();
        frame.requestFocus();
    }

    public void setVisibleView() {
        this.view.setVisible(true);
    }

}
