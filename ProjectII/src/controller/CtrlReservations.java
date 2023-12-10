package controller;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import javax.swing.JLabel;

/**
 *
 * @author deivis
 */
public class CtrlReservations {

    DAOReservation dr = new DAOReservation();
    DAOEvent de = new DAOEvent();
    int id;
 //Method to load the Reservation into the table
    public void loadDataReservations(JTable tblReservations) {
        //Creates a new table model
        DefaultTableModel model = (DefaultTableModel) tblReservations.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<>(model);
        tblReservations.setRowSorter(order);
        model.setRowCount(0);
        List<Reservation> reservations = dr.readReservation();
        for (Reservation reservation : reservations) {
            Object[] row = {
                reservation.getId(),
                reservation.getUserName(),
                reservation.getDate(),
                reservation.getQuantity(),
                reservation.getEventID()
            };
            model.addRow(row);
        }
    }
 //Method to add new reservations
    public void addReservation(JTable tblReservations, JTextField txtName, JTextField txtdateReservation, JTextField txtquantityReservation,
            JComboBox<String> cbxeventsReservation) {
        //Validate that there are no empty fields
        if (!validateNonEmptyFields(txtName, txtdateReservation, txtquantityReservation)) {
            return;
        }
        try {
            //Converts the date type object to a string object and assigns it the reservationDate variable
            Date reservationDate = parseDate(txtdateReservation.getText());
            //Converts the integer type object to a string object 
            int quantity = parseInteger(txtquantityReservation.getText());
            validateName(txtName.getText());

            this.dr.createReservation(new Reservation(
                    txtName.getText(),
                    reservationDate,
                    quantity,
                    Integer.parseInt(cbxeventsReservation.getSelectedItem().toString())
            ));
            clearFields(txtName, txtdateReservation, txtquantityReservation);
        } catch (NumberFormatException | ParseException e) {
            JOptionPane.showMessageDialog(null, "El día y la cantidad deben ser números enteros", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
//Method to add newreservation based in the user 
    public void addReservationByUser(JLabel lblUser, JLabel lblDate, JComboBox cbxQuantity, JTable tblEvent) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            int row = tblEvent.getSelectedRow();
            // Handle possible ParseException
            Date date = formato.parse(lblDate.getText());
            // Get the selected value instead of the index
            int quantity = cbxQuantity.getSelectedIndex()+1;
            String user_name = lblUser.getText();
            if (user_name != null && !user_name.trim().isEmpty()) {

                dr.createReservation(new Reservation(user_name, date, quantity, Integer.parseInt(String.valueOf(tblEvent.getValueAt(row, 0)))));
            } else {
                JOptionPane.showMessageDialog(null, "El nombre de usuario no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error al convertir la fecha", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
//Validation that there are no empty fields
    private boolean validateNonEmptyFields(JTextField... fields) {
        for (JTextField field : fields) {
            if (field.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
    private int parseInteger(String text) throws NumberFormatException {
        return Integer.parseInt(text);
    }
    private Date parseDate(String text) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.parse(text);
    }
    public Date parseDates(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.parse(dateString);
    }
    private void validateName(String name) {
        if (!name.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
            JOptionPane.showMessageDialog(null, "El nombre debe contener solo letras", "Error", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Formato de Nombre Invalido");
        }
    }
//Method to clean the table fields 
    public void clearFields(JTextField txtUserReservation, JTextField txtdateReservation, JTextField txtquantityReservation) {
        txtUserReservation.setText("");
        txtdateReservation.setText("");
        txtquantityReservation.setText("");

    }
//Method to update places in the databases 
    public void updateReservation(JTable tblReservations, JTextField txtName, JTextField txtdateReservation, JTextField txtquantityReservation,
            JComboBox<String> cbxeventsReservation) {
//Validate that there are no empty fields
        if (!validateNonEmptyFields(txtName, txtdateReservation, txtquantityReservation)) {
            return;
        }
        try {
            Date reservationDate = parseDate(txtdateReservation.getText());
            int quantity = parseInteger(txtquantityReservation.getText());
            validateName(txtName.getText());

            // Change in the next line to get the name as a string
            this.dr.updateReservation(new Reservation(
                    txtName.getText(),
                    reservationDate,
                    quantity,
                    Integer.parseInt(cbxeventsReservation.getSelectedItem().toString())
            ));
            clearFields(txtName, txtdateReservation, txtquantityReservation);
        } catch (NumberFormatException | ParseException e) {
            JOptionPane.showMessageDialog(null, "El día y la cantidad deben ser números enteros", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
//Method to remove places of the databases
    public void deleteReservationPlace() {
        this.de.deleteEvent(id);
    }

    public void selectedRowReservationPlace(JTable tblReservations, JTextField txtUserReservation, JTextField txtdateReservation, JTextField txtquantityReservation,
            JComboBox<String> cbxeventsReservation) {
        try {
            int row = tblReservations.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(tblReservations.getValueAt(row, 0).toString());
                txtUserReservation.setText(tblReservations.getValueAt(row, 1).toString());
                txtdateReservation.setText(tblReservations.getValueAt(row, 2).toString());
                txtquantityReservation.setText(tblReservations.getValueAt(row, 3).toString());
                cbxeventsReservation.setSelectedItem(tblReservations.getValueAt(row, 4).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
        }
    }
  //Method to select and access a table row 
    public void selectedRowEvent(JTable tblEvent, JLabel lblName, JLabel lblDescription, JLabel lblDatee,
            JLabel lblAddress, JLabel lblCity, JLabel lblPrice, JLabel lblRoom) {
        try {
            int row = tblEvent.getSelectedRow();
            if (row >= 0) {
                lblName.setText(tblEvent.getValueAt(row, 1).toString());
                lblDescription.setText(tblEvent.getValueAt(row, 2).toString());
                lblDatee.setText(tblEvent.getValueAt(row, 3).toString());
                lblAddress.setText(tblEvent.getValueAt(row, 4).toString());
                lblCity.setText(tblEvent.getValueAt(row, 5).toString());
                lblPrice.setText(tblEvent.getValueAt(row, 6).toString());
                lblRoom.setText(tblEvent.getValueAt(row, 7).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
        }
    }
    public void countPrice(JLabel lblPrice, JLabel lblTotalPrice, JComboBox cbxQuantity) {
        try {
            double price = Double.parseDouble(lblPrice.getText());
            int quantity = cbxQuantity.getSelectedIndex()+ 1;
            double totalPrice = price * quantity;
            lblTotalPrice.setText(String.format("%.2f", totalPrice)); // Muestra el total con dos decimales
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al calcular el precio, error: " + e.toString());
        }
    }

}
