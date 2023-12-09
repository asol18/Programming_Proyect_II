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

    public void createEvent(Event event) {
        DBConnection db = new DBConnection();
        String consultaSQL = "INSERT INTO events ( name, description, date, address, city, postal_code, price, room, place_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
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

    public List<Event> readEvent() {
        DBConnection db = new DBConnection();
        List<Event> event = new ArrayList<>();
        String sql = "SELECT * FROM events";

        try {
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

    public void updateEvent(Event event) {
        DBConnection db = new DBConnection();
        String consultaSQL = "UPDATE users SET name=?, description=?, date=?, address=?, city=?, postal_code=?, price=?, room=?, place_id=? WHERE id=?";

        try {
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

    public void deleteEvent(int id) {
        DBConnection db = new DBConnection();
        String consultaSQL = "DELETE FROM events WHERE id=?";

        try {
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

    public List<Event> readEventt(String name) {
        DBConnection db = new DBConnection();
        List<Event> event = new ArrayList<>();
        String sql = "SELECT * FROM events where name = ?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String description = resultSet.getString("description");
                Date date = resultSet.getDate("date");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                Double price = resultSet.getDouble("price");
                int room = resultSet.getInt("room");
                event.add(new Event(name, description, date, address, city, price, room));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return event;
    }

    public List<Event> readNameEvent() {
        DBConnection db = new DBConnection();
        List<Event> event = new ArrayList<>();
        String sql = "SELECT name FROM events";

        try {
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
