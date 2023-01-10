/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usersnotifications.presenter.sign.state.signUp;

import com.usersnotifications.business.Encryptor.EncryptorPassword;
import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.dto.UserDTO;
import com.usersnotifications.presenter.sign.SignPresenter;
import com.usersnotifications.presenter.sign.command.SignCommand;
import com.usersnotifications.presenter.sign.command.SignInCommand;
import com.usersnotifications.presenter.sign.command.SignUpCommand;
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
        view.getTitleLbl().setText("Cadastre-se");

        view.getClickHereRegisterBtn().setVisible(false);
        view.getRegisterLbl().setVisible(false);

        view.getPasswordConfirmLabel().setVisible(true);
        view.getConfirmPasswordConfirmTxt().setVisible(true);

        this.presenter.getView().getLoginBtn().setText("Cadastrar");

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

        } catch (Exception e) {
            // TODO: Chamar o logger
            JOptionPane.showMessageDialog(null, "Não foi possível registrar o usuário!");
        }
    }
}
