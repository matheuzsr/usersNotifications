/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usersnotifications.presenter.sign.state.signInState;

import com.usersnotifications.business.Encryptor.EncryptorPassword;
import com.usersnotifications.command.sign.SignCommand;
import com.usersnotifications.command.sign.SignUpCommand;
import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.dto.UserDTO;
import com.usersnotifications.presenter.sign.SignPresenter;
import com.usersnotifications.presenter.sign.state.SignPresenterState;
import com.usersnotifications.presenter.sign.state.signUp.SignUpPresenterState;
import com.usersnotifications.view.SignView;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

/**
 *
 * @author matheus-ufes
 */
public class SignInPresenterState extends SignPresenterState {

    public SignInPresenterState(SignPresenter presenter, SignCommand signCommand) {
        super(presenter, signCommand);
        this.screenConfiguration();
    }

    private void screenConfiguration() {
        SignView view = this.presenter.getView();

        view.getTitleLbl().setText("Digite o login e senha para entrar");

        view.getPasswordConfirmLabel().setVisible(false);
        view.getConfirmPasswordTxt().setVisible(false);
        view.getLoginBtn().setText("Entrar");

        view.getRegisterLbl().setText("Se ainda não é usuário.");
        view.getClickHereRegisterBtn().setText("Cadastre-se aqui");

        view.getClickHereRegisterBtn().addActionListener((ActionEvent ae) -> {
            UserDAO userDAO = this.presenter.getUserDAO();
            EncryptorPassword encryptorPassword = this.presenter.getEncryptorPassword();
            SignUpCommand signUpCommand = new SignUpCommand(userDAO, encryptorPassword, this.presenter.validadorSenha,
                    null);

            this.presenter.setState(new SignUpPresenterState(this.presenter, signUpCommand));
        });

        view.getLoginBtn().addActionListener((ActionEvent ae) -> {
            this.login();
        });

        view.setVisible(true);
    }

    @Override
    public void login() {
        UserDTO user = this.getFieldsInformation();

        try {
            boolean isSigned = this.signCommand.execute(user);

            if (isSigned) {
                this.presenter.getView().dispose();
                this.presenter.openMainWindow();
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
