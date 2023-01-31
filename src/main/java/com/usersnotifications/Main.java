/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.usersnotifications;

import com.pss.senha.validacao.ValidadorSenha;
import com.usersnotifications.business.Session;
import com.usersnotifications.business.Encryptor.EncryptorPassword;
import com.usersnotifications.command.notification.NotificationCommand;
import com.usersnotifications.command.notification.NotificationSendCommand;
import com.usersnotifications.data.dao.UserDAOSQLite;
import com.usersnotifications.data.repository.NotificationRepository;
import com.usersnotifications.data.repository.NotificationRepositorySQLite;
import com.usersnotifications.presenter.MainWindowPresenter;
import com.usersnotifications.presenter.sign.SignPresenter;

import io.github.cdimascio.dotenv.Dotenv;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author logcomex
 */
public class Main {
    public static void main(String[] args) {
        try {
            Dotenv dotenv = Dotenv.configure().load();
            UserDAOSQLite userDAO = new UserDAOSQLite();
            ValidadorSenha validadorSenha = new ValidadorSenha();

            NotificationRepositorySQLite notificationRepository = new NotificationRepositorySQLite();
            NotificationCommand notificationCommand = new NotificationSendCommand(notificationRepository, userDAO);

            EncryptorPassword encryptorPassword = new EncryptorPassword(dotenv);

            MainWindowPresenter mainWindowPresenter = new MainWindowPresenter(notificationRepository, userDAO,
                    notificationCommand, encryptorPassword, validadorSenha);

            new SignPresenter(userDAO, mainWindowPresenter, encryptorPassword, validadorSenha);

            userDAO.addObserver(Session.getInstance());
            userDAO.addObserver(mainWindowPresenter);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
