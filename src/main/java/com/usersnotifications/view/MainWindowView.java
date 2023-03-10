/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package com.usersnotifications.view;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author logcomex
 */
public class MainWindowView extends javax.swing.JFrame {

    /**
     * Creates new form NewMDIApplication
     */
    public MainWindowView() {
        super("Notificações do usuários");

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        notificationTotalLbl = new javax.swing.JLabel();
        usernameLbl = new javax.swing.JLabel();
        userTypeLbl = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        notificationMenu = new javax.swing.JMenu();
        sendNotificationMenuItem = new javax.swing.JMenuItem();
        viewNotificationMenuItem = new javax.swing.JMenuItem();
        managerAccountMenu = new javax.swing.JMenu();
        changePassordMenuItem = new javax.swing.JMenuItem();
        managerMenu = new javax.swing.JMenu();
        usersChangeAuthorizedMenuItem = new javax.swing.JMenuItem();
        configurationMenu = new javax.swing.JMenu();
        logConfigurationMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Username:");

        jLabel5.setText("Tipo:");

        jLabel2.setText("Total de notificações recebidas: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usernameLbl)
                .addGap(54, 54, 54)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userTypeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 667, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(notificationTotalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userTypeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(notificationTotalLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5)
                        .addComponent(usernameLbl)))
                .addContainerGap())
        );

        jLabel2.getAccessibleContext().setAccessibleName("Total notificações: ");

        desktopPane.add(jPanel1);
        jPanel1.setBounds(0, 780, 1200, 40);

        notificationMenu.setMnemonic('e');
        notificationMenu.setText("Notificações");

        sendNotificationMenuItem.setMnemonic('t');
        sendNotificationMenuItem.setText("Enviar Notificação");
        sendNotificationMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendNotificationMenuItemActionPerformed(evt);
            }
        });
        notificationMenu.add(sendNotificationMenuItem);

        viewNotificationMenuItem.setMnemonic('y');
        viewNotificationMenuItem.setText("Visualizar notificações");
        notificationMenu.add(viewNotificationMenuItem);

        menuBar.add(notificationMenu);

        managerAccountMenu.setMnemonic('h');
        managerAccountMenu.setText("Gestão de conta");

        changePassordMenuItem.setMnemonic('a');
        changePassordMenuItem.setText("Alterar senha");
        managerAccountMenu.add(changePassordMenuItem);

        menuBar.add(managerAccountMenu);

        managerMenu.setMnemonic('h');
        managerMenu.setText("Gestão de usuários");

        usersChangeAuthorizedMenuItem.setText("Alterar/Autorizar usuários");
        managerMenu.add(usersChangeAuthorizedMenuItem);

        menuBar.add(managerMenu);

        configurationMenu.setMnemonic('h');
        configurationMenu.setText("Configuração");

        logConfigurationMenuItem.setText("Configurar Log");
        logConfigurationMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logConfigurationMenuItemActionPerformed(evt);
            }
        });
        configurationMenu.add(logConfigurationMenuItem);

        menuBar.add(configurationMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1197, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logConfigurationMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logConfigurationMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logConfigurationMenuItemActionPerformed

    private void sendNotificationMenuItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_sendNotificationMenuItemActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_sendNotificationMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindowView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindowView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindowView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindowView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindowView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem changePassordMenuItem;
    private javax.swing.JMenu configurationMenu;
    private static javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem logConfigurationMenuItem;
    private javax.swing.JMenu managerAccountMenu;
    private javax.swing.JMenu managerMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu notificationMenu;
    private javax.swing.JLabel notificationTotalLbl;
    private javax.swing.JMenuItem sendNotificationMenuItem;
    private javax.swing.JLabel userTypeLbl;
    private javax.swing.JLabel usernameLbl;
    private javax.swing.JMenuItem usersChangeAuthorizedMenuItem;
    private javax.swing.JMenuItem viewNotificationMenuItem;
    // End of variables declaration//GEN-END:variables

    public static JDesktopPane getDesktop() {
        return desktopPane;
    }

    public JMenuItem getChangePassordMenuItem() {
        return changePassordMenuItem;
    }

    public JMenu getNotificationMenu() {
        return notificationMenu;
    }

    public JMenuItem getSendNotificationMenuItem() {
        return sendNotificationMenuItem;
    }

    public JMenuItem getUsersChangeAuthorizedMenuItem() {
        return usersChangeAuthorizedMenuItem;
    }

    public JMenuItem getViewNotificationMenuItem() {
        return viewNotificationMenuItem;
    }

    public JMenu getManagerMenu() {
        return managerMenu;
    }

    public JLabel getNotificationTotalLbl() {
        return notificationTotalLbl;
    }

    public JLabel getUserTypeLbl() {
        return userTypeLbl;
    }

    public JLabel getUsernameLbl() {
        return usernameLbl;
    }

    public JMenuItem getLogConfigurationMenuItem() {
        return logConfigurationMenuItem;
    }

}
