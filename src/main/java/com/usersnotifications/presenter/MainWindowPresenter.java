package com.usersnotifications.presenter;

import com.usersnotifications.business.Encryptor.EncryptorPassword;
import com.pss.senha.validacao.ValidadorSenha;
import com.usersnotifications.business.Session;
import com.usersnotifications.command.notification.NotificationCommand;
import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.data.repository.NotificationRepositorySQLite;
import com.usersnotifications.dto.UserDTO;
import com.usersnotifications.model.User;
import com.usersnotifications.observer.user.CurrentUserObserver;
import com.usersnotifications.presenter.notification.NotificationPresenter;
import com.usersnotifications.view.MainWindowView;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class MainWindowPresenter implements CurrentUserObserver {

    private MainWindowView view;
    private NotificationRepositorySQLite notificationRepository;
    private UserDAO userDAO;
    private NotificationCommand notificationCommand;
    private EncryptorPassword encryptorPassword;
    private ValidadorSenha validatorPassword;

    public MainWindowPresenter(NotificationRepositorySQLite notificationRepository, UserDAO userDAO,
            NotificationCommand notificationCommand, EncryptorPassword encryptorPassword, ValidadorSenha validatorPassword) {
        this.notificationRepository = notificationRepository;
        this.userDAO = userDAO;
        this.notificationCommand = notificationCommand;
        this.encryptorPassword = encryptorPassword;
        this.validatorPassword = validatorPassword;

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

            notificationRepository.addObserver(presenter);

                showPanel(presenter.getView(), false, false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, ex.getMessage());
            }
        });

        this.view.getChangePassordMenuItem().addActionListener((ActionEvent e) -> {
            try {
                ChangePasswordPresenter presenter = new ChangePasswordPresenter(this.userDAO, this.encryptorPassword, this.validatorPassword);

                showPanel(presenter.getView(), false, false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, ex.getMessage());
            }
        });

        this.view.getUsersChangeAuthorizedMenuItem().addActionListener((ActionEvent e) -> {
            try {
                UserListPresenter presenter = new UserListPresenter(this.userDAO);

                showPanel(presenter.getView(), false, false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, ex.getMessage());
            }
        });

        this.view.getLogConfigurationMenuItem().addActionListener((ActionEvent e) -> {
            try {
                LogsPresenter presenter = new LogsPresenter();

                showPanel(presenter.getView(), false, false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, ex.getMessage());
            }
        });
    }

    // TODO: Como é só uma aba preferi manter só essa config(mas o ideal seria usar
    // o state caso aumentasse)
    public void handleShowMenuProducts() {
        if (!Session.getInstance().getUser().getType().equals("admin")) {
            this.view.getManagerMenu().setVisible(false);
            this.view.getSendNotificationMenuItem().setVisible(false);
        }
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
        this.handleShowMenuProducts();
        this.handleUserInformation();

        this.view.setVisible(true);
    }

    private void handleUserInformation() {
        User user = Session.getInstance().getUser();
        this.view.getUsernameLbl().setText(user.getName());
        this.view.getUserTypeLbl().setText(user.getType());

        int total;
        try {
            total = this.notificationRepository.getReceivedAll(user.getIdUser()).size();
            this.view.getNotificationTotalLbl().setText(String.valueOf(total));

        } catch (Exception e) {
            this.view.getNotificationTotalLbl().setText("");
        }
    }

    @Override
    public void update(UserDTO user) {
        this.view.getUsernameLbl().setText(user.getName());
    }
}
