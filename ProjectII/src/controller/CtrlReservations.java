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
                reservation.getIDUser(),
                reservation.getDate(),
                reservation.getQuantity(),
                reservation.getEventID()
            };
            model.addRow(row);
        }

    }

    public void addReservation(JTable tblReservations, JTextField txtUserReservation, JTextField txtdateReservation, JTextField txtquantityReservation,
            JComboBox<String> cbxeventsReservation) {
        if (!validateNonEmptyFields(txtUserReservation, txtdateReservation, txtquantityReservation)) {
            return;
        }

        try {
            Date reservationDate = parseDate(txtdateReservation.getText());
            int quantity = parseInteger(txtquantityReservation.getText());

            validateName(txtUserReservation.getText());

            this.dr.createReservation(new Reservation(
                    parseInteger(txtUserReservation.getText()),
                    reservationDate,
                    quantity,
                    Integer.parseInt(cbxeventsReservation.getSelectedItem().toString())
            ));

            clearFields(txtUserReservation, txtdateReservation, txtquantityReservation);
        } catch (NumberFormatException | ParseException e) {
            JOptionPane.showMessageDialog(null, "El dia y la cantidad deben ser números enteros", "Error", JOptionPane.ERROR_MESSAGE);
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

    public void updatePlace(JTable tblReservations, JTextField txtUserReservation, JTextField txtdateReservation, JTextField txtquantityReservation,
            JComboBox<String> cbxeventsReservation) {

        if (!validateNonEmptyFields(txtUserReservation, txtdateReservation, txtquantityReservation)) {
            return;
        }

        try {
            Date reservationDate = parseDate(txtdateReservation.getText());
            int quantity = parseInteger(txtquantityReservation.getText());

            validateName(txtUserReservation.getText());
            this.dr.updateReservation(new Reservation(
                    parseInteger(txtUserReservation.getText()),
                    reservationDate,
                    quantity,
                    Integer.parseInt(cbxeventsReservation.getSelectedItem().toString())
            ));

            clearFields(txtUserReservation, txtdateReservation, txtquantityReservation);
        } catch (NumberFormatException | ParseException e) {
            JOptionPane.showMessageDialog(null, "El dia y la cantidad deben ser números enteros", "Error", JOptionPane.ERROR_MESSAGE);
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
}