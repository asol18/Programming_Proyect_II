package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.*;

/**
 *
 * @author deivi
 */
public class CtrlEvents {

    Event event = new Event();
    DAOEvent de = new DAOEvent();
    int id;
    //Method to load the Reservation into the table

    public void loadDataReservations(JTable tblReservations) {
        //Creates a new table model
        DefaultTableModel model = (DefaultTableModel) tblReservations.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<>(model);
        tblReservations.setRowSorter(order);
        model.setRowCount(0);
        List<Event> events = de.readEvent();
        for (Event event : events) {
            Object[] row = {
                event.getId(),
                event.getName(),
                event.getDescription(),
                event.getDate(),
                event.getAddress(),
                event.getCity(),
                event.getPostal_code(),
                event.getPlace_id(),
                event.getRoom()
            };
            model.addRow(row);
        }
    }

    //Method to add new Events
    public void addEvent(JTable tblEvents, JTextField txtnameEvent, JTextField txtdescriptionEvent, JTextField txtdateEvent,
            JTextField txtaddressEvent, JTextField txtcityEvent, JTextField txtpostalcodeEvent, JTextField txtpriceEvent,
            JTextField txtplace_idEvent) {
        //validate that there are no empty fields 
        if (!validateNonEmptyFields(txtnameEvent, txtdescriptionEvent, txtdateEvent,
                txtaddressEvent, txtcityEvent, txtpostalcodeEvent, txtpriceEvent,
                txtplace_idEvent)) {
            return;
        }
        try {
            Date eventDate = parseDate(txtdateEvent.getText());
            int postal_code = parseInteger(txtpostalcodeEvent.getText());
            validateName(txtnameEvent.getText());

            this.de.createEvent(new Event(
                    txtnameEvent.getText(),
                    txtdescriptionEvent.getText(),
                    eventDate,
                    txtaddressEvent.getText(),
                    txtcityEvent.getText(),
                    postal_code,
                    Integer.parseInt(txtpostalcodeEvent.getText()),
                    Double.parseDouble(txtpriceEvent.getText()),
                    txtplace_idEvent.getText()
            ));
            clearFields(txtnameEvent, txtdescriptionEvent, txtdateEvent, txtaddressEvent, txtcityEvent, txtpostalcodeEvent,
                    txtpriceEvent, txtplace_idEvent);
        } catch (NumberFormatException | ParseException e) {
            JOptionPane.showMessageDialog(null, "El dia y el precio deben ser números ", "Error", JOptionPane.ERROR_MESSAGE);
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

    //Method to clean the table fields 
    public void clearFields(JTextField txtnameEvent, JTextField txtdescriptionEvent, JTextField txtdateEvent,
            JTextField txtaddressEvent, JTextField txtcityEvent, JTextField txtpostalcodeEvent, JTextField txtpriceEvent,
            JTextField txtplace_idEvent) {
        txtnameEvent.setText("");
        txtdescriptionEvent.setText("");
        txtdateEvent.setText("");
        txtaddressEvent.setText("");
        txtcityEvent.setText("");
        txtpostalcodeEvent.setText("");
        txtpriceEvent.setText("");
        txtplace_idEvent.setText("");
    }
    //Method to update the event from the table 

    public void updateEvent(JTable tblEvents, JTextField txtnameEvent, JTextField txtdescriptionEvent, JTextField txtdateEvent,
            JTextField txtaddressEvent, JTextField txtcityEvent, JTextField txtpostalcodeEvent, JTextField txtpriceEvent,
            JTextField txtplace_idEvent) {
        //validate that there are no empty fields 
        if (!validateNonEmptyFields(txtnameEvent, txtdescriptionEvent, txtdateEvent,
                txtaddressEvent, txtcityEvent, txtpostalcodeEvent, txtpriceEvent,
                txtplace_idEvent)) {
            return;
        }
        try {
            Date eventDate = parseDate(txtdateEvent.getText());
            int postal_code = parseInteger(txtpostalcodeEvent.getText());
            validateName(txtnameEvent.getText());

            this.de.updateEvent(new Event(
                    txtnameEvent.getText(),
                    txtdescriptionEvent.getText(),
                    eventDate,
                    txtaddressEvent.getText(),
                    txtcityEvent.getText(),
                    postal_code,
                    Integer.parseInt(txtpostalcodeEvent.getText()),
                    Double.parseDouble(txtpriceEvent.getText()),
                    txtplace_idEvent.getText()
            ));
            clearFields(txtnameEvent, txtdescriptionEvent, txtdateEvent, txtaddressEvent, txtcityEvent, txtpostalcodeEvent,
                    txtpriceEvent, txtplace_idEvent);
        } catch (NumberFormatException | ParseException e) {
            JOptionPane.showMessageDialog(null, "El dia y el precio deben ser números ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    //Method to remove an event from the table

    public void deleteEvent() {
        this.de.deleteEvent(id);
    }

    //Method to select and access a table row 
    public void selectedRowEvent(JTable tblEvents, JTextField txtnameEvent, JTextField txtdescriptionEvent, JTextField txtdateEvent,
            JTextField txtaddressEvent, JTextField txtcityEvent, JTextField txtpostalcodeEvent, JTextField txtpriceEvent,
            JTextField txtplace_idEvent) {
        try {
            int row = tblEvents.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(tblEvents.getValueAt(row, 0).toString());
                txtnameEvent.setText(tblEvents.getValueAt(row, 1).toString());
                txtdescriptionEvent.setText(tblEvents.getValueAt(row, 2).toString());
                txtdateEvent.setText(tblEvents.getValueAt(row, 3).toString());
                txtaddressEvent.setText(tblEvents.getValueAt(row, 4).toString());
                txtcityEvent.setText(tblEvents.getValueAt(row, 5).toString());
                txtpostalcodeEvent.setText(tblEvents.getValueAt(row, 6).toString());
                txtpriceEvent.setText(tblEvents.getValueAt(row, 7).toString());
                txtplace_idEvent.setText(tblEvents.getValueAt(row, 8).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
        }
    }

    //Method to load event data into table
    public void loadDataEvent(JTable tblEvent, JComboBox cbxtypeEvent) {
        String name = cbxtypeEvent.getSelectedItem().toString();
        DefaultTableModel model = (DefaultTableModel) tblEvent.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<>(model);
        tblEvent.setRowSorter(order);
        model.setRowCount(0);
        List<Event> events = de.readEventt(name);
        for (Event event : events) {
            Object[] row = {
                event.getId(),
                event.getName(),
                event.getDescription(),
                event.getDate(),
                event.getAddress(),
                event.getCity(),
                event.getPrice(),
                event.getRoom()
            };
            model.addRow(row);
        }
    }

    //Method to load the event into the combobox
    public void loadcbxEvent(JComboBox cbxtypeEvent) {
        List<Event> e = de.readNameEvent();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Event events : e) {
            model.addElement(events.getName());
        }
        cbxtypeEvent.setModel(model);
    }
}
