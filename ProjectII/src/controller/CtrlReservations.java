package controller;

import java.text.DecimalFormat;
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

    public void loadDataReservations(JTable tblReservations) {
        DefaultTableModel model = (DefaultTableModel) tblReservations.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<>(model);
        tblReservations.setRowSorter(order);
        model.setRowCount(0);
        List<Reservation> reservations = dr.readReservation();
        for (Reservation reservation : reservations) {
            Object[] row = {
                reservation.getId(),
                reservation.getName(),
                reservation.getDate(),
                reservation.getQuantity(),
                reservation.getEventID()
            };
            model.addRow(row);
        }

    }

    public void addReservation(JTable tblReservations, JTextField txtName, JTextField txtdateReservation, JTextField txtquantityReservation,
            JComboBox<String> cbxeventsReservation) {
        if (!validateNonEmptyFields(txtName, txtdateReservation, txtquantityReservation)) {
            return;
        }

        try {
            Date reservationDate = parseDate(txtdateReservation.getText());
            int quantity = parseInteger(txtquantityReservation.getText());

            validateName(txtName.getText());

            this.dr.createReservation(new Reservation(
                    txtName.getText(), // Utilizar txtName como una cadena (String)
                    reservationDate,
                    quantity,
                    Integer.parseInt(cbxeventsReservation.getSelectedItem().toString())
            ));

            clearFields(txtName, txtdateReservation, txtquantityReservation);
        } catch (NumberFormatException | ParseException e) {
            JOptionPane.showMessageDialog(null, "El día y la cantidad deben ser números enteros", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("DIA-MES-ANO");
        return dateFormat.parse(text);
    }

    private void validateName(String name) {
        if (!name.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
            JOptionPane.showMessageDialog(null, "El nombre debe contener solo letras", "Error", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Formato de Nombre Invalido");
        }
    }

    public void clearFields(JTextField txtUserReservation, JTextField txtdateReservation, JTextField txtquantityReservation) {
        txtUserReservation.setText("");
        txtdateReservation.setText("");
        txtquantityReservation.setText("");

    }

    public void updatePlace(JTable tblReservations, JTextField txtName, JTextField txtdateReservation, JTextField txtquantityReservation,
            JComboBox<String> cbxeventsReservation) {

        if (!validateNonEmptyFields(txtName, txtdateReservation, txtquantityReservation)) {
            return;
        }

        try {
            Date reservationDate = parseDate(txtdateReservation.getText());
            int quantity = parseInteger(txtquantityReservation.getText());

            validateName(txtName.getText());

            // Cambio en la línea siguiente para obtener el nombre como una cadena
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

    public void deletePlace() {
        this.de.deleteEvent(id);
    }

    public void selectedRowPlace(JTable tblReservations, JTextField txtUserReservation, JTextField txtdateReservation, JTextField txtquantityReservation,
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
  
    public void selectedRowEvent(JTable tblEvent, JLabel lblName, JLabel lblDescription, JLabel lblDatee,
            JLabel lblAddress, JLabel lblCity, JLabel lblPrice, JLabel lblRoom) {
        try {
            int row = tblEvent.getSelectedRow();
            if (row >= 0) {
                lblName.setText(tblEvent.getValueAt(row, 0).toString());
                lblDescription.setText(tblEvent.getValueAt(row, 1).toString());
                lblDatee.setText(tblEvent.getValueAt(row, 2).toString());
                lblAddress.setText(tblEvent.getValueAt(row, 3).toString());
                lblCity.setText(tblEvent.getValueAt(row, 4).toString());
                lblPrice.setText(tblEvent.getValueAt(row, 5).toString());
                lblRoom.setText(tblEvent.getValueAt(row, 6).toString());
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
            int quantity = cbxQuantity.getSelectedIndex() + 1;
            double totalPrice = price * quantity;
            lblTotalPrice.setText(String.format("%.2f", totalPrice)); // Muestra el total con dos decimales
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al calcular el precio, error: " + e.toString());
        }
    }

  
}
