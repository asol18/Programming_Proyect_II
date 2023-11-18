package controller;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.PlaceDAO;
import model.place;

/**
 *
 * @author deivis
 */
public class CtrlPlace {

    PlaceDAO dao = new PlaceDAO();
    int id;

    public void loadDataPlace(JTable tbluser) {
        DefaultTableModel model = (DefaultTableModel) tbluser.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<TableModel>(model);
        tbluser.setRowSorter(order);
        model.setRowCount(0);
        List<place> places = dao.readPlace();
        for (User user : places) {
            String entityName = daoentity.nameEntity(user.getEntity_id());
            String rolName = daorol.getNameRol(user.getRol_id());
            Object[] row = {user.getId(), user.getName(), user.getFirst_lastname(),
                user.getSecond_lastname(), user.getEmail(), user.getPassword(),
                entityName, rolName};
            model.addRow(row);
        }
    }

    public void addUser(JTextField txtnameuser, JTextField txtfirst_lastname, JTextField txtsecond_lastname,
            JTextField txtemailuser, JTextField txtpassworduser, JComboBox cbxrolid, JComboBox cbxentityid) {

        String rolName = cbxrolid.getSelectedItem().toString();
        int rolId = daorol.getIDRol(rolName);
        String entityName = cbxentityid.getSelectedItem().toString();

        User user = new User(txtnameuser.getText(), txtfirst_lastname.getText(), txtsecond_lastname.getText(),
                txtemailuser.getText(), txtpassworduser.getText(), 0, rolId);
        dao.createUser(user);
    }

    public void clearFields(JTextField txtnameuser, JTextField txtlastnameuser, JTextField txtlasstnameuser, JTextField txtemailuser, JTextField txtpassworduser) {
        txtnameuser.setText("");
        txtlastnameuser.setText("");
        txtlasstnameuser.setText("");
        txtemailuser.setText("");
        txtpassworduser.setText("");

    }

    public void updateUser(JTextField txtnameuser, JTextField txtfirst_lastname, JTextField txtsecond_lastname,
            JTextField txtemailuser, JTextField txtpassworduser, JComboBox cbxrolid) {

        String rolName = cbxrolid.getSelectedItem().toString();
        int rolId = daorol.getIDRol(rolName);

        User user = new User(this.id, txtnameuser.getText(), txtfirst_lastname.getText(), txtsecond_lastname.getText(),
                txtemailuser.getText(), txtpassworduser.getText(), 0, rolId);
        dao.updateUser(user);
    }

    public void deleteUser() {
        this.dao.deleteUser(this.id);
    }

    public void selectedRowUsers(JTable tbluser, JTextField txtnameuser, JTextField txtfirst_lastname, JTextField txtsecond_lastname,
            JTextField txtemailuser, JTextField txtpassworduser, JComboBox cbxrolid, JComboBox cbxentityid) {
        try {
            int row = tbluser.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(tbluser.getValueAt(row, 0).toString());
                txtnameuser.setText(tbluser.getValueAt(row, 1).toString());
                txtfirst_lastname.setText(tbluser.getValueAt(row, 2).toString());
                txtsecond_lastname.setText(tbluser.getValueAt(row, 3).toString());
                txtemailuser.setText(tbluser.getValueAt(row, 4).toString());
                txtpassworduser.setText(tbluser.getValueAt(row, 5).toString());
                String entityName = tbluser.getValueAt(row, 6).toString();
                cbxentityid.setSelectedItem(entityName);
                String rolName = tbluser.getValueAt(row, 7).toString();
                cbxrolid.setSelectedItem(rolName);
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
        }
    }

    public void loadRoles(JComboBox cbxrolid) {
        List<Rol> roles = daorol.readRoles();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Rol r : roles) {
            model.addElement(r.getName());
        }
        cbxrolid.setModel(model);
    }

    public void loadEntities(JComboBox cbxentityid) {
        List<Entity> entities = daoentity.readEntity();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        for (Entity e : entities) {
            model.addElement(e.getName());
        }
        cbxentityid.setModel(model);
    }
}
