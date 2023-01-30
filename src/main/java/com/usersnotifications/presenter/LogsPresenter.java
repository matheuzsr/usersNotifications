/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usersnotifications.presenter;

import com.usersnotifications.utils.LoggerService;
import com.usersnotifications.view.LogsView;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author matheus-ufes
 */
public class LogsPresenter {

    private LogsView view;

    public LogsPresenter() {
        this.view = new LogsView();
        this.screenConfiguration();
    }

    public void screenConfiguration() {
        this.view.getCbLog().addItem("JSON");
        this.view.getCbLog().addItem("CSV");

        this.view.getBtSave().addActionListener((ActionEvent ae) -> {
            this.save();
            view.dispose();
        });
    }

    private void save() {
        String logType = (String) this.view.getCbLog().getSelectedItem();

        try {
            LoggerService.getInstance().setLogService(logType);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getStackTrace());
        }
    }

    public LogsView getView() {
        return view;
    }

}
