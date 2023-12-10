
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
    public void createReservation(Reservation reservation) {
        DBConnection db = new DBConnection();
        String consultaSQL = "INSERT INTO reservations (user_name, date, quantity, event_id) VALUES (?, ?, ?, ?)";
        try {
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
    


    public List<Reservation> readReservation() {
        DBConnection db = new DBConnection();
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations";

        try {
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

    public void updateReservation(Reservation reservation) {
        DBConnection db = new DBConnection();
        String consultaSQL = "UPDATE reservations SET user_name=?, date=?, quantity=?, event_id=? WHERE id=?";
        try {
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

    public void deleteReservation(int id) {
        DBConnection db = new DBConnection();
        String consultaSQL = "DELETE FROM reservations WHERE id=?";

        try {
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
