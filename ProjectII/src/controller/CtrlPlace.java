package controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.DAOPlace;
import model.Place;

/**
 *
 * @author deivis
 */
public class CtrlPlace {

    DAOPlace dao = new DAOPlace();
    int id;

    public void loadDataPlace(JTable tblPlaces) {
        DefaultTableModel model = (DefaultTableModel) tblPlaces.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<>(model);
        tblPlaces.setRowSorter(order);
        model.setRowCount(0);
        List<Place> places = dao.readPlace();
        for (Place place : places) {
            Object[] row = {
                place.getId(),
                place.getName(),
                place.getAddress(),
                place.getCity(),
                place.getPostal_code(),
                place.getLatitude(),
                place.getLongitude()
            };
            model.addRow(row);
        }
    }

    public void addPlace(JTable tblPlaces, JTextField txtnamePlace, JTextField txtaddressPlace, JTextField txtcityPlace,
            JTextField txtpostalcodePlace, JTextField txtlatitudePlace, JTextField txtlongitudePlace) {

        if (validateAndCreatePlace(txtnamePlace, txtaddressPlace, txtcityPlace,
                txtpostalcodePlace, txtlatitudePlace, txtlongitudePlace)) {
            clearFields(txtnamePlace, txtaddressPlace, txtcityPlace, txtpostalcodePlace, txtlatitudePlace, txtlongitudePlace);
        }
    }
//Method to verify and create a new place

    private boolean validateAndCreatePlace(JTextField txtnamePlace, JTextField txtaddressPlace, JTextField txtcityPlace,
            JTextField txtpostalcodePlace, JTextField txtlatitudePlace, JTextField txtlongitudePlace) {

        if (txtnamePlace.getText().isEmpty() || txtaddressPlace.getText().isEmpty() || txtcityPlace.getText().isEmpty()
                || txtpostalcodePlace.getText().isEmpty() || txtlatitudePlace.getText().isEmpty() || txtlongitudePlace.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return false; // Stop the operation if there are empty fields
        }

        try {
            Integer.parseInt(txtpostalcodePlace.getText());
            Integer.parseInt(txtlatitudePlace.getText());
            Integer.parseInt(txtlongitudePlace.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La identificación, latitud y longitud deben ser números enteros", "Error", JOptionPane.ERROR_MESSAGE);
            return false; // Stop the operation if there is an error converting to integer
        }

        if (!txtnamePlace.getText().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
            JOptionPane.showMessageDialog(null, "El nombre debe contener solo letras", "Error", JOptionPane.ERROR_MESSAGE);
            return false; // Stop the operation if there are illegal characters
        }

        // Create a new place and save it to the database
        this.dao.createPlace(new Place(txtnamePlace.getText(), txtaddressPlace.getText(), Integer.parseInt(txtpostalcodePlace.getText()),
                Integer.parseInt(txtlatitudePlace.getText()), Integer.parseInt(txtlongitudePlace.getText())));

        return true;
    }
//Method to clear fields

    public void clearFields(JTextField txtnamePlace, JTextField txtaddressPlace, JTextField txtcityPlace,
            JTextField txtpostalcodePlace, JTextField txtlatitudePlace, JTextField txtlongitudePlace) {
        txtnamePlace.setText("");
        txtaddressPlace.setText("");
        txtcityPlace.setText("");
        txtpostalcodePlace.setText("");
        txtlatitudePlace.setText("");
        txtlongitudePlace.setText("");
    }

    public void updatePlace(JTextField txtnamePlace, JTextField txtaddressPlace, JTextField txtcityPlace,
            JTextField txtpostalcodePlace, JTextField txtlatitudePlace, JTextField txtlongitudePlace) {

        try {
            // Validate that required fields are not empty
            if (txtnamePlace.getText().isEmpty() || txtaddressPlace.getText().isEmpty() || txtcityPlace.getText().isEmpty()
                    || txtpostalcodePlace.getText().isEmpty() || txtlatitudePlace.getText().isEmpty() || txtlongitudePlace.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Stop the operation if there are empty fields
            }

            // Validate that numeric values ​​are integers
            int postalCode = Integer.parseInt(txtpostalcodePlace.getText());
            int latitude = Integer.parseInt(txtlatitudePlace.getText());
            int longitude = Integer.parseInt(txtlongitudePlace.getText());

            // Create a Place object with the provided data
            Place place = new Place(txtnamePlace.getText(), txtaddressPlace.getText(), txtcityPlace.getText(),
                    postalCode, latitude, longitude);

           // Call the update method in the DAO
            dao.updatePlace(place);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error de formato numérico: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deletePlace() {
        this.dao.deletePlace(id);
    }

    public void selectedRowPlace(JTable tblPlaces, JTextField txtnamePlace, JTextField txtaddressPlace, JTextField txtcityPlace,
            JTextField txtpostalcodePlace, JTextField txtlatitudePlace, JTextField txtlongitudePlace) {
        try {
            int row = tblPlaces.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(tblPlaces.getValueAt(row, 0).toString());
                txtnamePlace.setText(tblPlaces.getValueAt(row, 1).toString());
                txtaddressPlace.setText(tblPlaces.getValueAt(row, 2).toString());
                txtcityPlace.setText(tblPlaces.getValueAt(row, 3).toString());
                txtpostalcodePlace.setText(tblPlaces.getValueAt(row, 4).toString());
                txtlatitudePlace.setText(tblPlaces.getValueAt(row, 5).toString());
                txtlongitudePlace.setText(tblPlaces.getValueAt(row, 6).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
        }
    }

}
