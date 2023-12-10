package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author fabri
 */
public class DAOEvent {

    public DAOEvent() {
    }
//Method to create a event
    public void createEvent(Event event) {
        //establishes the connection to the databases
        DBConnection db = new DBConnection();
        //Set the query
        String consultaSQL = "INSERT INTO events ( name, description, date, address, city, postal_code, price, room, place_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            //Prepare the declaration
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, event.getName());
            ps.setString(2, event.getDescription());
            ps.setDate(3, new java.sql.Date(event.getDate().getTime()));
            ps.setString(4, event.getAddress());
            ps.setString(5, event.getCity());
            ps.setInt(6, event.getPostal_code());
            ps.setDouble(7, event.getPrice());
            ps.setInt(8, event.getRoom());
            ps.setInt(9, event.getPlace_id());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el evento");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se insertó correctamente el evento, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }
//Method to create a list to read events
    public List<Event> readEvent() {
        //Establishes the connection to the databases
        DBConnection db = new DBConnection();
        //Create a new list 
        List<Event> event = new ArrayList<>();
        //Set the query with sql
        String sql = "SELECT * FROM events";
        try {
            //Prepare the declaration
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Date date = resultSet.getDate("date");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                int postal_code = resultSet.getInt("postal_code");
                Double price = resultSet.getDouble("price");
                int room = resultSet.getInt("room");
                int place_id = resultSet.getInt("place_id");
                event.add(new Event(id, name, description, date, address, city, postal_code, price, room, place_id));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return event;
    }
//Method to update event in databases
    public void updateEvent(Event event) {
        //Establishes the connection to the databases
        DBConnection db = new DBConnection();
        //Set the query with sql
        String consultaSQL = "UPDATE users SET name=?, description=?, date=?, address=?, city=?, postal_code=?, price=?, room=?, place_id=? WHERE id=?";
        try {
            //Prepare the declaration
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, event.getName());
            ps.setString(2, event.getDescription());
            ps.setDate(3, new java.sql.Date(event.getDate().getTime()));
            ps.setString(4, event.getAddress());
            ps.setString(5, event.getCity());
            ps.setInt(6, event.getPostal_code());
            ps.setDouble(7, event.getPrice());
            ps.setInt(8, event.getRoom());
            ps.setInt(9, event.getPlace_id());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modificó el evento, error:" + e.toString());
        } finally {
            db.disconnect();
        }
    }
 //Method to delete the event of databases
    public void deleteEvent(int id) {
        //Establishes the connection to the databases
        DBConnection db = new DBConnection();
        //Set the query with sql
        String consultaSQL = "DELETE FROM events WHERE id=?";
        try {
            //Prepare the declaration
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente el evento");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el evento, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }
//Method to create a list to read events based on name of event 
    public List<Event> readEventt(String name) {
        //Establishes the connection to the databases
        DBConnection db = new DBConnection();
        //Create a new list 
        List<Event> event = new ArrayList<>();
        //Set the query with sql
        String sql = "SELECT * FROM events where name = ?";
        try {
            //Prepare the declaration
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String description = resultSet.getString("description");
                Date date = resultSet.getDate("date");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                Double price = resultSet.getDouble("price");
                int room = resultSet.getInt("room");
                event.add(new Event(id,name, description, date, address, city, price, room));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return event;
    }
//Method to create a list to read events name
    public List<Event> readNameEvent() {
        //Establishes the connection to the databases
        DBConnection db = new DBConnection();
        //Create a new list 
        List<Event> event = new ArrayList<>();
        //Set the query with sql
        String sql = "SELECT name FROM events";
        try {
            //Prepare the declaration
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                event.add(new Event(name));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return event;
    }
}
