package com.usersnotifications.presenter;

import java.util.Collection;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

import com.usersnotifications.model.Notification;
import com.usersnotifications.presenter.notification.NotificationPresenter;
import com.usersnotifications.view.NotificationListView;
import com.usersnotifications.business.Session;
import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.data.repository.NotificationRepository;

public class NotificationListPresenter {
  private NotificationListView view;
  private DefaultTableModel table;
  private NotificationRepository repository;
  private UserDAO userDAO;

  public NotificationListPresenter(NotificationRepository repository, UserDAO userDAO) throws Exception {
    this.view = new NotificationListView();
    this.repository = repository;
    this.userDAO = userDAO;

    this.screenConfiguration();
  }

  private void screenConfiguration() {

    view.getVisualizationBtn().addActionListener((ActionEvent ae) -> {
      this.handleNotificationVisualization();
    });

    view.getCloseBtn().addActionListener((ActionEvent ae) -> {
      view.dispose();
    });
    try {
      this.createTable();
      int currentUserId = Session.getInstance().getUser().getIdUser();

      this.carregarTabela(this.repository.getReceivedAll(currentUserId));
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, ex.getStackTrace());
    }
  }

  private void createTable() {
    this.table = new DefaultTableModel(
        new Object[][] {},
        new String[] {
            "id", "De", "Para", "Data de envio", "Lida", "Descrição"
        }) {
      @Override
      public boolean isCellEditable(int row, int col) {
        return false;
      }
    };

  }

  private void carregarTabela(Collection c) {
    this.table.setNumRows(0);

    Iterator<?> it = c.iterator();
    while (it.hasNext()) {
      Notification notification = (Notification) it.next();
      this.table.addRow(new Object[] {
          notification.getId(),
          notification.getFromUsername(),
          notification.getToUsername(),
          notification.getSentAt(),
          notification.getReadAt(),
          notification.getDescription()
      });
    }

    this.view.getNotificationTbl().setModel(this.table);
    this.view.getNotificationTbl().getColumnModel().getColumn(0).setMaxWidth(40);
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    view.getNotificationTbl().getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
  }

  private void handleNotificationVisualization() {
    int row = this.view.getNotificationTbl().getSelectedRow();
    this.showMessageIfNotSelectedList(row);

    int notificationId = (int) view.getNotificationTbl().getValueAt(row, 0);
    String fromUser = (String) view.getNotificationTbl().getValueAt(row, 1);
    String toUser = (String) view.getNotificationTbl().getValueAt(row, 2);
    String description = (String) view.getNotificationTbl().getValueAt(row, 5);

    Notification notification = new Notification();
    notification.setId(notificationId);
    notification.setFromUsername(fromUser);
    notification.setToUsername(toUser);
    notification.setDescription(description);

    try {
      if (this.repository.read(notificationId)) {
        NotificationPresenter presenter = new NotificationPresenter(this.repository, this.userDAO, null, notification);

        MainWindowPresenter.showPanel(presenter.getView(), false, false);
      }

    } catch (Exception ex) {
      JOptionPane.showMessageDialog(view, ex.getMessage());
    }
  }

  private void showMessageIfNotSelectedList(int row) {
    if (row == -1) {
      JOptionPane.showMessageDialog(view, "Você precisa selecionar uma LINHA da tabela!");
      return;
    }
  }

  public NotificationListView getView() {
    return view;
  }

}
