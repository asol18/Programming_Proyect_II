package Controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import Model.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import model.DAOUser;
import model.User;

/**
 *
 * @author fabri
 */
public class CtrlUser {

    DAOUser dao = new DAOUser();
    DAORol daorol = new DAORol();
    int id;
    int idRol;

    public void loadDataUser(JTable tbluser) {
        DefaultTableModel model = (DefaultTableModel) tbluser.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<TableModel>(model);
        tbluser.setRowSorter(order);
        model.setRowCount(0);
        List<User> users = dao.read();
        for (User user : users) {

            String rolName = daorol.getNameRol(user.getRol_id());
            Object[] row = {user.getId(), user.getNumber_ID(), user.getName(),
                user.getLast_name(), user.getBirth_date(), user.getEmail(), user.getPhone_number(), user.getPassword(),
                rolName};
            model.addRow(row);
        }
    }

    public void addUser(JTable tbluser, JTextField txtNumber_ID, JTextField txtName, JTextField txtLast_name,
            JTextField txtBirth_date, JTextField txtEmail, JTextField txtPhone_number, JTextField txtPassword, JTextField txtRolName) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fecha = formato.parse(txtBirth_date.getText());
            this.dao.create(new User(Integer.parseInt(txtNumber_ID.getText()), txtName.getName(), txtLast_name.getText(),
                    fecha,
                    txtEmail.getText(),
                    Integer.parseInt(txtPhone_number.getText()),
                    txtPassword.getText(),
                    this.idRol));
        } catch (ParseException e) {

        }
    }

    public void clearFields(JTextField txtNumber_ID, JTextField txtName, JTextField txtLast_name, JTextField txtBirth_date, JTextField txtEmail, JTextField txtPhone_number, JTextField txtPassword, JTextField txtRolName) {
        txtNumber_ID.setText("");
        txtName.setText("");
        txtLast_name.setText("");
        txtBirth_date.setText("");
        txtEmail.setText("");
        txtPhone_number.setText("");
        txtPassword.setText("");
        txtRolName.setText("");
    }

    public void updateUser(JTable tbluser, JTextField txtNumber_ID, JTextField txtName, JTextField txtLast_name,
            JTextField txtBirth_date, JTextField txtEmail, JTextField txtPhone_number, JTextField txtPassword, JTextField txtRolName) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fecha = formato.parse(txtBirth_date.getText());
            this.dao.update(new User(this.id, Integer.parseInt(txtNumber_ID.getText()), txtName.getName(), txtLast_name.getText(),
                    fecha,
                    txtEmail.getText(),
                    Integer.parseInt(txtPhone_number.getText()),
                    txtPassword.getText(),
                    this.idRol));
        } catch (ParseException e) {

        }

    }

    public void deleteUser() {
        this.dao.delete(this.id);
    }

    public void selectedRowUsers(JTable tblUser, JTextField txtidnumberUser, JTextField txtnameUser, JTextField txtlastnameUser, JTextField txtdirthdateUser,
            JTextField txtemailUser, JTextField txtphoneUser, JTextField txtpasswordUser, JComboBox<String> cbxrolesUser) {
        try {
            int row = tblUser.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(tblUser.getValueAt(row, 0).toString());
                txtidnumberUser.setText(tblUser.getValueAt(row, 1).toString());
                txtnameUser.setText(tblUser.getValueAt(row, 2).toString());
                txtlastnameUser.setText(tblUser.getValueAt(row, 3).toString());
                txtdirthdateUser.setText(tblUser.getValueAt(row, 4).toString());
                txtemailUser.setText(tblUser.getValueAt(row, 5).toString());
                txtphoneUser.setText(tblUser.getValueAt(row, 6).toString());
                txtpasswordUser.setText(tblUser.getValueAt(row, 7).toString());
                String selectedRole = tblUser.getValueAt(row, 8).toString();
                cbxrolesUser.setSelectedItem(selectedRole);
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
        }
    }

}
