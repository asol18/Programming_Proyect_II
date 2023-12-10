
package model;
import java.sql.Date;
import model.Reservation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author allys
 */
public class DAOReservation {

    public DAOReservation() {
    }
    //Method to create a reservation 
    public void createReservation(Reservation reservation) {
        //Establishes the databases connection
        DBConnection db = new DBConnection();
        //Set the query 
        String consultaSQL = "INSERT INTO reservations (user_name, date, quantity, event_id) VALUES (?, ?, ?, ?)";
        try {
            //Prepare the declaration
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);               
            ps.setString(1, reservation.getUserName());
           ps.setTimestamp(2, new java.sql.Timestamp(reservation.getDate().getTime()));
            ps.setInt(3, reservation.getQuantity());
            ps.setInt(4, reservation.getEventID());
            ps.execute();
            JOptionPane.showMessageDialog(null, "La reservación se registró correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puedo registrar la reservación:  " + e.toString());
        } finally {
            db.disconnect();
        }
    }
    //Method to create a list to read reservation 
    public List<Reservation> readReservation() {
        //Establishes the databases connection
        DBConnection db = new DBConnection();
        //Create a new list 
        List<Reservation> reservations = new ArrayList<>();
        //Set the query with sql
        String sql = "SELECT * FROM reservations";
        try {
            //Prepare the declaration
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("user_name");
                Date date = resultSet.getDate("date");
                int quantity = resultSet.getInt("quantity");
                int eventID = resultSet.getInt("event_id");
                reservations.add(new Reservation(id, name, date, quantity, eventID));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return reservations;
    }
//Method to update reservation in databases 
    public void updateReservation(Reservation reservation) {
        //Establishes the databases connection
        DBConnection db = new DBConnection();
        //Set the query with sql
        String consultaSQL = "UPDATE reservations SET user_name=?, date=?, quantity=?, event_id=? WHERE id=?";
        try {
            //Prepare the declaration
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, reservation.getUserName());
            ps.setDate(2, new java.sql.Date(reservation.getDate().getTime()));
            ps.setInt(3, reservation.getQuantity());
            ps.setInt(4, reservation.getEventID());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modificación exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se modificó la reservación: " + e.toString());
        } finally {
            db.disconnect();
        }
    }
//Method to delete reservation in databases
    public void deleteReservation(int id) {
        //Establishes the databases connection
        DBConnection db = new DBConnection();
        //Set the qery with sql
        String consultaSQL = "DELETE FROM reservations WHERE id=?";
        try {
            //Prepare the declaration
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "La reservación se eliminó correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se pudo eliminar la reservación: " + e.toString());
        } finally {
            db.disconnect();
        }
    }
}
