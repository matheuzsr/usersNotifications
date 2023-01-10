/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usersnotifications.presenter.sign.state;

import com.usersnotifications.dto.UserDTO;
import com.usersnotifications.presenter.sign.SignPresenter;
import com.usersnotifications.presenter.sign.command.SignCommand;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 *
 * @author matheus-ufes
 */
public abstract class SignPresenterState {
	protected SignPresenter presenter;
	protected SignCommand signCommand;

	public SignPresenterState(SignPresenter presenter, SignCommand signCommand) {
		this.presenter = presenter;
		this.signCommand = signCommand;
		this.limpaListeners();
	}

	public void login() throws Exception {
		throw new RuntimeException("Você deve implementar o método de login!");

	}

	public void register() {
		throw new RuntimeException("Você deve implementar o método de register!");

	}

	public final void fechar() {
		this.presenter.getView().setVisible(false);
		this.presenter.getView().dispose();
	}

	protected UserDTO getFieldsInformation() {
		String username = this.presenter.getView().getUsernameTxt().getText();
		String password = this.presenter.getView().getPasswordTxt().getText();
		String confirmPassword = this.presenter.getView().getPasswordTxt().getText();

		// EncryptorPassword encryptorPassword = this.presenter.getEncryptorPassword();
		// String passwordEncrypted = encryptorPassword.encrypt(password);

		return new UserDTO()
				.setName(username)
				.setPassword(password)
				.setPasswordConfirm(confirmPassword);
	}

	public void limpaListeners() {
		for (Component c : this.presenter.getView().getContentPane().getComponents()) {
			if (c instanceof JButton) {
				for (ActionListener al : ((JButton) c).getActionListeners()) {
					((JButton) c).removeActionListener(al);
				}
			}
		}
	}
}
