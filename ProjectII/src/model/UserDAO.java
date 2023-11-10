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
 * @author lpper
 */
public class UserDAO {

    public UserDAO() {
    }

    public void create(user user) {
        DBConnection db = new DBConnection();
        String consultaSQL = "INSERT INTO users (ID_Number, name, birth_date, email, phone_number, password, rol_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, user.getID_Number());
            ps.setString(2, user.getName());
            ps.setString(3, user.getLast_name());
            ps.setDate(3, (Date) user.getBirth_date());
            ps.setString(4, user.getEmail());
            ps.setInt(5, user.getPhone_number());
            ps.setString(6, user.getPassword());
            ps.setInt(7, user.getRol_id());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el usuario");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se insertó correctamente el usuario, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }

    public List<user> read() {
        DBConnection db = new DBConnection();
        List<user> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int ID_Number = resultSet.getInt("ID_Number");
                String name = resultSet.getString("name");
                String last_name = resultSet.getString("last_name");
                Date birth_date = resultSet.getDate("birth_date");
                String email = resultSet.getString("email");
                int phone_number = resultSet.getInt("phone_number");
                String password = resultSet.getString("password");
                int rol_id = resultSet.getInt("rol_id");
                users.add(new user(id, ID_Number, name, last_name, birth_date, email, phone_number, password, rol_id));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return users;
    }

    public void update(user user) {
        DBConnection db = new DBConnection();
        String consultaSQL = "UPDATE users SET ID_Number, name=?, last_name=?, birth_date=?, email=?, phone_number=?,password=?, rol_id=? WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, user.getID_Number());
            ps.setString(2, user.getName());
            ps.setString(3, user.getLast_name());
            ps.setDate(3, (Date) user.getBirth_date());
            ps.setString(5, user.getEmail());
            ps.setInt(6, user.getPhone_number());
            ps.setString(7, user.getPassword());
            ps.setInt(8, user.getRol_id());
            ps.setInt(9, user.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modificó el usuario, error:" + e.toString());
        } finally {
            db.disconnect();
        }
    }

    public void delete(int id) {
        DBConnection db = new DBConnection();
        String consultaSQL = "DELETE FROM users WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente el usuario");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el usuario, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }

    public user getUserByEmailAndPassword(String email, String password) {
        DBConnection db = new DBConnection();
        user user = null;
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int ID_Number = resultSet.getInt("ID_Number");
                String name = resultSet.getString("name");
                String last_name = resultSet.getString("last_name");
                Date birth_date = resultSet.getDate("birth_date");
                email = resultSet.getString("email");
                int phone_number = resultSet.getInt("phone_number");
                password = resultSet.getString("password");
                int rol_id = resultSet.getInt("rol_id");
                user = new user(id, ID_Number, name, last_name, birth_date, email, phone_number, password, rol_id);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return user;
    }

    public user getUserInfo(int userId) {
        DBConnection db = new DBConnection();
        user user = new user();
        String sql = "SELECT * FROM users WHERE id = ?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, userId); 
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                int ID_Number = resultSet.getInt("ID_Number");
                String name = resultSet.getString("name");
                String last_name = resultSet.getString("last_name");
                Date birth_date = resultSet.getDate("birth_date");
                String email = resultSet.getString("email");
                int phone_number = resultSet.getInt("phone_number");
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return user;
    }

    public boolean updateUserInfo(user user) {
        DBConnection db = new DBConnection();
        String sql = "UPDATE users SET ID_Number, name=?, last_name=?, birth_date=?, email=?, phone_number=?,password=?  WHERE id=?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
              ps.setInt(1, user.getID_Number());
            ps.setString(2, user.getName());
            ps.setString(3, user.getLast_name());
            ps.setDate(3, (Date) user.getBirth_date());
            ps.setString(5, user.getEmail());
            ps.setInt(6, user.getPhone_number());
            ps.setString(7, user.getPassword());
            ps.setInt(8, user.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        } finally {
            db.disconnect();
        }
    }
}
