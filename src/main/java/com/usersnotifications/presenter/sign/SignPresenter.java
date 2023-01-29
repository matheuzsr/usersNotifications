/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usersnotifications.presenter.sign;

import javax.swing.JOptionPane;

import com.pss.senha.validacao.ValidadorSenha;
import com.usersnotifications.business.Encryptor.EncryptorPassword;
import com.usersnotifications.command.sign.SignInCommand;
import com.usersnotifications.command.sign.SignUpCommand;
import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.presenter.MainWindowPresenter;
import com.usersnotifications.presenter.sign.state.SignPresenterState;
import com.usersnotifications.presenter.sign.state.signInState.SignInPresenterState;
import com.usersnotifications.presenter.sign.state.signUp.SignUpPresenterAdminState;
import com.usersnotifications.view.SignView;

/**
 *
 * @author matheus-ufes
 */
public class SignPresenter {

    protected SignView view;
    private MainWindowPresenter mainWindowPresenter;
    protected EncryptorPassword encryptorPassword;
    protected UserDAO userDAO;
    private SignPresenterState state;
    public ValidadorSenha validadorSenha;

    public SignPresenter(
            UserDAO userDAO,
            MainWindowPresenter mainWindowPresenter,
            EncryptorPassword encryptorPassword,
            ValidadorSenha validadorSenha) {
        this.mainWindowPresenter = mainWindowPresenter;
        this.view = new SignView();
        this.encryptorPassword = encryptorPassword;
        this.userDAO = userDAO;
        this.validadorSenha = validadorSenha;

        this.handleOpenState();
    }

    public SignPresenterState getState() {
        return state;
    }

    public void setState(SignPresenterState state) {
        this.state = state;
    }

    public SignView getView() {
        return view;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public EncryptorPassword getEncryptorPassword() {
        return encryptorPassword;
    }

    public void openMainWindow() {
        this.mainWindowPresenter.setVisibleView();
    }

    private void handleOpenState() {
        try {
            Boolean dontHaveUserRegistered = this.getUserDAO().getAll().isEmpty();

            // TODO: Passar os commands por injeção de dependência
            if (dontHaveUserRegistered) {
                this.setState(new SignUpPresenterAdminState(this,
                        new SignUpCommand(this.getUserDAO(), this.getEncryptorPassword(), this.validadorSenha,
                                "admin")));
            } else {
                this.setState(new SignInPresenterState(this,
                        new SignInCommand(this.getUserDAO(), this.getEncryptorPassword())));
            }
        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null, "Erro ao carregar o banco de dados!");
            e.printStackTrace();
        }
    }
}
