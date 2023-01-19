/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.usersnotifications;

import com.usersnotifications.business.Encryptor.EncryptorPassword;
import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.data.dao.UserDAOSQLite;
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
            UserDAO userDAO = new UserDAOSQLite();

            EncryptorPassword encryptorPassword = new EncryptorPassword(dotenv);
//            new MainWindowPresenter().setVisibleView();
            new SignPresenter(userDAO, new MainWindowPresenter(), encryptorPassword);

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
