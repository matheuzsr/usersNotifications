package com.usersnotifications.presenter;

import java.util.Collection;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

import com.usersnotifications.presenter.user.UserPresenter;
import com.usersnotifications.view.UserListView;
import com.usersnotifications.data.dao.UserDAO;
import com.usersnotifications.dto.UserDTO;

public class UserListPresenter {
  private UserListView view;
  private DefaultTableModel table;
  private UserDAO userDAO;

  public UserListPresenter(UserDAO userDAO) throws Exception {
    this.view = new UserListView();
    this.userDAO = userDAO;

    this.screenConfiguration();
  }

  private void screenConfiguration() {

    view.getVisualizationBtn().addActionListener((ActionEvent ae) -> {
      this.handleUserVisualization();
    });

    view.getCloseBtn().addActionListener((ActionEvent ae) -> {
      view.dispose();
    });
    try {
      this.createTable();
      this.carregarTabela(this.userDAO.getAll());
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, ex.getStackTrace());
    }
  }

  private void createTable() {
    this.table = new DefaultTableModel(
        new Object[][] {},
        new String[] {
            "id", "Username", "Tipo", "Data de criação", "Ativação"
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
      UserDTO user = (UserDTO) it.next();
      this.table.addRow(new Object[] {
          user.getIdUser(),
          user.getName(),
          user.getCreatedAt(),
          user.getType(),
          user.getActivedAt()
      });
    }

    this.view.getUserTbl().setModel(this.table);
    this.view.getUserTbl().getColumnModel().getColumn(0).setMaxWidth(40);
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    view.getUserTbl().getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
  }

  private void handleUserVisualization() {
    int row = this.view.getUserTbl().getSelectedRow();
    this.showMessageIfNotSelectedList(row);

    try {
      int userId = (int) view.getUserTbl().getValueAt(row, 0);
      UserDTO user = this.userDAO.getById(userId);
      UserPresenter presenter = new UserPresenter(userDAO, user);

      view.dispose();
      MainWindowPresenter.showPanel(presenter.getView(), false, false);
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "Não foi possível visualizar o usuário!");
    }

  }

  private void showMessageIfNotSelectedList(int row) {
    if (row == -1) {
      JOptionPane.showMessageDialog(view, "Você precisa selecionar uma LINHA da tabela!");
      return;
    }
  }

  public UserListView getView() {
    return view;
  }

}
