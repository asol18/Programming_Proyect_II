package Controller;

import model.DAORol;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import model.DAOUser;
import model.User;

/**
 *
 * @author fabri
 */
public class CtrlUser {

    DAOUser dao = new DAOUser();
    DAORol daoRol = new DAORol();
    int id;
    int idRol;
//Method to load the user into the table

    public void loadDataUser(JTable tbluser) {
        //Creates a new table model
        DefaultTableModel model = (DefaultTableModel) tbluser.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<>(model);
        tbluser.setRowSorter(order);
        model.setRowCount(0);
        List<User> users = dao.read();
        for (User user : users) {
            Object[] row = {
                user.getId(), user.getNumber_ID(), user.getName(),
                user.getLast_name(), user.getBirth_date(), user.getEmail(),
                user.getPhone_number(), user.getPassword(), user.getRol_id()
            };
            model.addRow(row);
        }
    }
//Method to create a new user 

    public void addUsers(JTextField txtNumber_ID, JTextField txtName, JTextField txtLast_name,
            JTextField txtBirthday, JTextField txtEmail, JTextField txtPhone_number,
            JTextField txtPassword, JComboBox cbxRol) {
        // Validations here              
        if (txtName.getText().isEmpty() || txtLast_name.getText().isEmpty() || txtNumber_ID.getText().isEmpty()
                || txtEmail.getText().isEmpty() || txtPassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Stop operation if there are empty fields
        }
        try {
            // Validate age as an integer
            Integer.parseInt(txtNumber_ID.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La identificación debe ser números enteros", "Error", JOptionPane.ERROR_MESSAGE);
            return;  // Stop operation if there is an error converting to integer
        }
        // Validate that the name and last name contain only letters
        if (!txtName.getText().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+$") || !txtLast_name.getText().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+$")) {
            JOptionPane.showMessageDialog(null, "El nombre y apellidos deben contener solo letras", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Stop operation if there are disallowed characters
        }
        Date birth_date;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date utilDate = dateFormat.parse(txtBirthday.getText());
            birth_date = new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Debe ser dd/MM/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Stop operation if there is an error parsing the date
        }
        this.dao.create(new User(Integer.parseInt(txtNumber_ID.getText()), txtName.getText(),
                txtLast_name.getText(), birth_date, txtEmail.getText(),
                Integer.parseInt(txtPhone_number.getText()), txtPassword.getText(),
                cbxRol.getSelectedItem().toString()));
        this.dao.reorganizeIDs();
    }
//Method to create a new user 

    public void addUser(JTable tbluser, JTextField txtNumber_ID, JTextField txtName, JTextField txtLast_name,
            JTextField txtBirth_date, JTextField txtEmail, JTextField txtPhone_number,
            JTextField txtPassword, JComboBox cbxRol) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fecha = formato.parse(txtBirth_date.getText());
            dao.create(new User(Integer.parseInt(txtNumber_ID.getText()), txtName.getText(),
                    txtLast_name.getText(), fecha, txtEmail.getText(),
                    Integer.parseInt(txtPhone_number.getText()), txtPassword.getText(),
                    cbxRol.getSelectedItem().toString()));
        } catch (ParseException e) {
            // Handle parse exception
        }
    }
    //Method to clean the table fields 

    public void clearFields(JTextField txtNumber_ID, JTextField txtName, JTextField txtLast_name,
            JTextField txtBirth_date, JTextField txtEmail, JTextField txtPhone_number,
            JTextField txtPassword, JTextField txtRolName) {
        txtNumber_ID.setText("");
        txtName.setText("");
        txtLast_name.setText("");
        txtBirth_date.setText("");
        txtEmail.setText("");
        txtPhone_number.setText("");
        txtPassword.setText("");
        txtRolName.setText("");
    }
//Method to update the user in databases

    public void updateUser(JTable tbluser, JTextField txtNumber_ID, JTextField txtName, JTextField txtLast_name,
            JTextField txtBirth_date, JTextField txtEmail, JTextField txtPhone_number,
            JTextField txtPassword, JComboBox cbxRol) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fecha = formato.parse(txtBirth_date.getText());
            dao.update(new User(this.id, Integer.parseInt(txtNumber_ID.getText()), txtName.getText(),
                    txtLast_name.getText(), fecha, txtEmail.getText(),
                    Integer.parseInt(txtPhone_number.getText()), txtPassword.getText(),
                    cbxRol.getSelectedItem().toString()));
        } catch (ParseException e) {
            // Handle parse exception
        }
    }

    //Method to remove user in databases 
    public void deleteUser() {
        dao.delete(this.id);
    }

    //This method is used to get the ID of the selected role in the JComboBox. 
    public void getIdRole(JComboBox cbxRol) {
        this.idRol = this.daoRol.getIDRole(cbxRol.getSelectedItem().toString());
    }

    public void dateReservation(JLabel lblDate) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(dateFormat);

        lblDate.setText(formattedDateTime);
    }
    //Method to select and access a table row 

    public void selectedRowUsers(JTable tblUser, JTextField txtidnumberUser, JTextField txtnameUser,
            JTextField txtlastnameUser, JTextField txtdirthdateUser, JTextField txtemailUser,
            JTextField txtphoneUser, JTextField txtpasswordUser, JComboBox<String> cbxrolesUser) {
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
