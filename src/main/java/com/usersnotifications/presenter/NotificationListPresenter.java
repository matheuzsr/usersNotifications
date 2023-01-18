package com.usersnotifications.presenter;

import java.util.Collection;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.usersnotifications.data.repository.NotificationUserRepository;
import com.usersnotifications.dto.NotificationDTO;
import com.usersnotifications.view.NotificationListView;

public class NotificationListPresenter {
  private NotificationListView view;
  private DefaultTableModel table;
  private NotificationUserRepository repository;

  public NotificationListPresenter(NotificationUserRepository repository) throws Exception {
    this.view = new NotificationListView();
    this.repository = repository;
    
    this.screenConfiguration();
  }

  private void screenConfiguration() {
    try {
      this.createTable();
      this.carregarTabela(this.repository.getAll(2));
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, ex.getStackTrace());
    }

  }

  private void createTable() {
    this.table = new DefaultTableModel(
        new Object[][] {},
        new String[] {
            "id", "De", "Data de envio", "Lida", "Descrição"
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
      // TODO: Usar NotificationDTO para preencer a tabela

      NotificationDTO notification = (NotificationDTO) it.next();
      this.table.addRow(new Object[] {
      notification.getId(),
      notification.getFromUsername(),
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

  public NotificationListView getView() {
    return view;
  }

}
