package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author deivis
 */
public class DAOPlace {

    public DAOPlace() {
    }
//Method to create a place 
    public void createPlace(Place place) {
        //Establishes the databases connection
        DBConnection db = new DBConnection();
        //Set the query 
        String consultaSQL = "INSERT INTO places ( name, address, city, postal_code, latitude, longitude, tripAdvisor_link) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            //Prepare the declaration
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, place.getName());
            ps.setString(2, place.getAddress());
            ps.setString(3, place.getCity());
            ps.setInt(4, place.getPostal_code());
            ps.setInt(5, place.getLatitude());
            ps.setInt(6, place.getLongitude());
            ps.setString(7, place.getTripAdvisor_link());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el lugar");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se insertó correctamente el lugar, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }
//Method to create a list to read a places 
    public List<Place> readPlace() {
        //Establishes the databases connection
        DBConnection db = new DBConnection();
        //Create a new list 
        List<Place> places = new ArrayList<>();
        //Set the query with SQL 
        String sql = "SELECT * FROM places";
        try {
            //Prepare the declaration 
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                int postal_code = resultSet.getInt("postal_code");
                int latitude = resultSet.getInt("latitude");
                int longitude = resultSet.getInt("longitude");
                String tripAdvisor_link = resultSet.getString("tripAdvisor_link");
                places.add(new Place(name, address, id, postal_code, latitude));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return places;
    }
//Method to update the place in database 
    public void updatePlace(Place place) {
        //Establishes databases connection
        DBConnection db = new DBConnection();
        //Set the query 
        String consultaSQL = "UPDATE users SET name=?, address=?, city=?, postal_code=?, latitude=?,longitude=?, tripAdvisor_link=? WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, place.getName());
            ps.setString(2, place.getAddress());
            ps.setString(3, place.getCity());
            ps.setInt(4, place.getPostal_code());
            ps.setInt(5, place.getLatitude());
            ps.setInt(6, place.getLongitude());
            ps.setString(7, place.getTripAdvisor_link());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modificó el usuario, error:" + e.toString());
        } finally {
            db.disconnect();
        }
    }
//Method to delete the place of databases 
    public void deletePlace(int id) {
        //Establishes databases connection
        DBConnection db = new DBConnection();
        //Set the query 
        String consultaSQL = "DELETE FROM places WHERE id=?";
        try {
            //Prepare the declaration
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente el lugar");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el lugar, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }

}
