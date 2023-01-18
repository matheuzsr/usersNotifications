package com.usersnotifications.presenter;

import java.awt.event.ActionEvent;

import javax.management.Notification;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import com.usersnotifications.data.repository.NotificationUserRepositorySQLite;
import com.usersnotifications.presenter.notification.NotificationPresenter;
import com.usersnotifications.presenter.notification.state.NotificationSendState;
import com.usersnotifications.presenter.notification.state.NotificationState;
import com.usersnotifications.view.MainWindowView;

public class MainWindowPresenter {

    private MainWindowView view;

    public MainWindowPresenter() {
        this.view = new MainWindowView();
        this.screenConfiguration();
    }

    public void screenConfiguration() {
        // TODO: Aqui poderia estar o add do menu para admin e para o normal
        
        this.view.getSendNotificationMenuItem().addActionListener((ActionEvent e) -> {
            try {
                NotificationPresenter presenter = new NotificationPresenter(new NotificationUserRepositorySQLite(), null);
                
                showPanel(presenter.getView(), false, false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, ex.getMessage());
            }
        });

        this.view.getViewNotificationMenuItem().addActionListener((ActionEvent e) -> {
            try {
                NotificationListPresenter presenter = new NotificationListPresenter(new NotificationUserRepositorySQLite());
                
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

            for (JInternalFrame  f : allFrames) {
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
