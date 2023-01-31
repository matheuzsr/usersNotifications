/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.usersnotifications.view;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *
 * @author matheus-ufes
 */
public class ChangePasswordView extends javax.swing.JInternalFrame {

    /**
     * Creates new form SendNotification
     */
    public ChangePasswordView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLbl = new javax.swing.JLabel();
        usernameLbl = new javax.swing.JLabel();
        passwordLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        changePasswordBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JToggleButton();
        currentPasswordTxt = new javax.swing.JPasswordField();
        newPasswordTxt = new javax.swing.JPasswordField();
        confirmNewPasswordTxt = new javax.swing.JPasswordField();

        titleLbl.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        titleLbl.setText("Alteração de Senha");

        usernameLbl.setText("Senha atual");

        passwordLbl.setText("Senha nova");

        jLabel1.setText("Confirmar senha");

        changePasswordBtn.setText("Alterar");

        closeBtn.setText("Fechar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changePasswordBtn)
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(usernameLbl, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordLbl, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(currentPasswordTxt, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newPasswordTxt, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmNewPasswordTxt, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(60, 60, 60))
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(titleLbl)
                .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(titleLbl)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLbl)
                    .addComponent(currentPasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLbl)
                    .addComponent(newPasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(confirmNewPasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changePasswordBtn)
                    .addComponent(closeBtn))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getChangePasswordBtn() {
        return changePasswordBtn;
    }

    public JTextField getConfirmNewPasswordTxt() {
        return confirmNewPasswordTxt;
    }

    public JTextField getCurrentPasswordTxt() {
        return currentPasswordTxt;
    }

    public JTextField getNewPasswordTxt() {
        return newPasswordTxt;
    }

    public JToggleButton getCloseBtn() {
        return closeBtn;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changePasswordBtn;
    private javax.swing.JToggleButton closeBtn;
    private javax.swing.JPasswordField confirmNewPasswordTxt;
    private javax.swing.JPasswordField currentPasswordTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField newPasswordTxt;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JLabel usernameLbl;
    // End of variables declaration//GEN-END:variables
}
