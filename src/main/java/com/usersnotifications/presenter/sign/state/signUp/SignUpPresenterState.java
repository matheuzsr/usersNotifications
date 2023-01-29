/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usersnotifications.presenter.sign.state.signUp;

import com.usersnotifications.business.Encryptor.EncryptorPassword;
import com.usersnotifications.command.sign.SignCommand;
import com.usersnotifications.command.sign.SignInCommand;
import com.usersnotifications.command.sign.SignUpCommand;
import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.dto.UserDTO;
import com.usersnotifications.presenter.sign.SignPresenter;
import com.usersnotifications.presenter.sign.state.SignPresenterState;
import com.usersnotifications.presenter.sign.state.signInState.SignInPresenterState;
import com.usersnotifications.view.SignView;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

/**
 *
 * @author matheus-ufes
 */
public class SignUpPresenterState extends SignPresenterState {

    public SignUpPresenterState(SignPresenter presenter, SignCommand signCommand) {
        super(presenter, signCommand);
        this.screenConfiguration();
    }

    private void screenConfiguration() {
        SignView view = this.presenter.getView();

        view.setVisible(false);
        view.getTitleLbl().setText("Cadastre e torne-se um usuário");

        view.getConfirmPasswordTxt().setVisible(true);
        view.getPasswordConfirmLabel().setVisible(true);

        this.presenter.getView().getLoginBtn().setText("Cadastrar");

        view.getRegisterLbl().setText("Caso já seja usuário.");
        view.getClickHereRegisterBtn().setText("Logar");
        view.getClickHereRegisterBtn().addActionListener((ActionEvent ae) -> {
            UserDAO userDAO = this.presenter.getUserDAO();
            EncryptorPassword encryptorPassword = this.presenter.getEncryptorPassword();
            SignInCommand signInCommand = new SignInCommand(userDAO, encryptorPassword);

            this.presenter.setState(new SignInPresenterState(this.presenter, signInCommand));
        });

        view.getLoginBtn().addActionListener((ActionEvent ae) -> {
            this.register();
        });

        this.presenter.getView().setVisible(true);
    }

    @Override
    public void register() {
        // TODO: Lembrar de usar a utils do professor para validar a senha

        UserDTO user = this.getFieldsInformation();
        try {
            this.signCommand.execute(user);

            UserDAO userDAO = this.presenter.getUserDAO();
            EncryptorPassword encryptorPassword = this.presenter.getEncryptorPassword();
            SignInCommand signInCommand = new SignInCommand(userDAO, encryptorPassword);

            this.presenter.setState(new SignInPresenterState(this.presenter, signInCommand));
            JOptionPane.showMessageDialog(null, "Usuário registrado com sucesso!");

        } catch (Exception ex) {
            // TODO: Chamar o logger
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
