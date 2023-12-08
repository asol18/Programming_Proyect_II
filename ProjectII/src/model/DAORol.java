package model;

import model.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabri
 */
public class DAORol {

    public DAORol() {

    }

    public List<Rol> readEvent() {
        DBConnection db = new DBConnection();
        List<Rol> roles = new ArrayList<>();
        String sql = "SELECT * from roles";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                roles.add(new Rol(id, name));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return roles;
    }

    //Retrieve the ID of a role based on its name.
    public int getIDRole(String name) {
        int value = 0;
        DBConnection db = new DBConnection();
        String sql = "SELECT id FROM roles WHERE name = ?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                value = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return value;
    }

    public String getNameRol(int id) {
        String value = "";
        DBConnection db = new DBConnection();
        String sql = "SELECT name FROM roles WHERE id = ?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                value = resultSet.getString("name");
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return value;
    }

    public String determineRol(String email, String pasword) {
        DBConnection db = new DBConnection();
        String rol = "";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement("SELECT rol_id FROM users WHERE email = ? AND password = ?");
            ps.setString(1, email);
            ps.setString(2, pasword);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                rol = resultSet.getString("rol_id");
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return rol;
    }
}
