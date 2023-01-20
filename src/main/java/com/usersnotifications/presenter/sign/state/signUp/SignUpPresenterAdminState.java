/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usersnotifications.presenter.sign.state.signUp;

import com.usersnotifications.business.Encryptor.EncryptorPassword;
import com.usersnotifications.command.SignCommand;
import com.usersnotifications.command.SignInCommand;
import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.dto.UserDTO;
import com.usersnotifications.presenter.sign.SignPresenter;
import com.usersnotifications.presenter.sign.state.SignPresenterState;
import com.usersnotifications.presenter.sign.state.signInState.SignInPresenterState;
import com.usersnotifications.view.SignView;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author matheus-ufes
 */
public class SignUpPresenterAdminState extends SignPresenterState {

    public SignUpPresenterAdminState(SignPresenter presenter, SignCommand signCommand) {
        super(presenter, signCommand);
        this.screenConfiguration();
    }

    private void screenConfiguration() {
        SignView view = this.presenter.getView();

        view.setVisible(false);
        view.getTitleLbl().setText("Cadastre e torne-se o administrador");

        view.getClickHereRegisterBtn().setVisible(false);
        view.getRegisterLbl().setVisible(false);

        this.presenter.getView().getLoginBtn().setText("Cadastrar");

        view.getLoginBtn().addActionListener((ActionEvent ae) -> {
            this.register();
        });

        this.presenter.getView().setVisible(true);
    }

    @Override
    public void register() {
        //TODO: Lembrar de usar a utils do professor para validar a senha
        
        UserDTO user = this.getFieldsInformation();
        try {
            this.signCommand.execute(user);

            UserDAO userDAO = this.presenter.getUserDAO();
            EncryptorPassword encryptorPassword = this.presenter.getEncryptorPassword();
            SignInCommand signInCommand = new SignInCommand(userDAO, encryptorPassword);

            this.presenter.setState(new SignInPresenterState(this.presenter, signInCommand));
            
            JOptionPane.showMessageDialog(null, "Usuário admin registrado com sucesso!");
        } catch (Exception e) {
            // TODO: Chamar o logger
            JOptionPane.showMessageDialog(null, "Não foi possível registrar o admin!");

        }
    }
}
