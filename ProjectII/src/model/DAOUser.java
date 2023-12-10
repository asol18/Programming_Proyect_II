package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author lpper
 */
public class DAOUser {

    public DAOUser() {
    }
//Method to create a user
    public void create(User user) {
        //Establishes the databases connection
        DBConnection db = new DBConnection();
        //Set the query
        String consultaSQL = "INSERT INTO users (ID_Number, name, last_name, birth_date, email, phone_number, password, rol_id) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, user.getNumber_ID());
            ps.setString(2, user.getName());
            ps.setString(3, user.getLast_name());
            ps.setDate(4, (Date) user.getBirth_date());
            ps.setString(5, user.getEmail());
            ps.setInt(6, user.getPhone_number());
            ps.setString(7, user.getPassword());
            ps.setString(8, user.getRol_id());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el usuario");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se insertó correctamente el usuario, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }
//Method to create a list to read user 
    public List<User> read() {
        //Establishes the databases connection
        DBConnection db = new DBConnection();
        //Create a new list 
        List<User> users = new ArrayList<>();
        //Set the query
        String sql = "SELECT * FROM users";
        try {
            //Prepare the declaration
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
                String rol_id = resultSet.getString("rol_id");
                users.add(new User(id, ID_Number, name, last_name, birth_date, email, phone_number, password, rol_id));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return users;
    }
//Method to update the user
    public void update(User user) {
        //Establishes the databases connection
        DBConnection db = new DBConnection();
        //Set the query
        String consultaSQL = "UPDATE users SET ID_Number, name=?, last_name=?, birth_date=?, email=?, phone_number=?,password=?, rol_id=? WHERE id=?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, user.getNumber_ID());
            ps.setString(2, user.getName());
            ps.setString(3, user.getLast_name());
            ps.setDate(3, (Date) user.getBirth_date());
            ps.setString(5, user.getEmail());
            ps.setInt(6, user.getPhone_number());
            ps.setString(7, user.getPassword());
            ps.setString(8, user.getRol_id());
            ps.setInt(9, user.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modificó el usuario, error:" + e.toString());
        } finally {
            db.disconnect();
        }
    }
//Method to delete user of databases 
    public void delete(int id) {
        //Establishes the databases connection
        DBConnection db = new DBConnection();
        //Set the query 
        String consultaSQL = "DELETE FROM users WHERE id=?";
        try {
            //Prepare the declaration 
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
//Take the user based on their email and password 
    public User getUserByEmailAndPassword(String email, String password) {
        //Establishes the databases connection 
        DBConnection db = new DBConnection();
        User user = null;
        //Set the query with sql 
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try {
            //Prepare the declaration 
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                // Query to get the name 
                String getNameSql = "SELECT name FROM users WHERE id = ?";
                PreparedStatement getNamePs = db.getConnection().prepareStatement(getNameSql);
                getNamePs.setInt(1, id);
                ResultSet nameResultSet = getNamePs.executeQuery();

                if (nameResultSet.next()) {
                    name = nameResultSet.getString("name");
                    // The user object is created 
                    user = new User(id, name);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return user;
    }
    //Take the user name based on their email and password
    public String getUserNameByEmailAndPassword(String email, String password) {
    //Establishes the databases connection 
    DBConnection db = new DBConnection();
    String userName = null;
    //Set the query with sql 
    String sql = "SELECT name FROM users WHERE email = ? AND password = ?";
    try {
        //Prepare the declaration 
        PreparedStatement ps = db.getConnection().prepareStatement(sql);
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            //The name is directly obtained
            userName = resultSet.getString("name");
        }
    } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
    } finally {
        db.disconnect();
        }
        return userName;
    }
    //Method to verificate user 
    public void authenticateAndShowUser(JLabel lblUser, String email, String password) {
        // Method is called to get the name directly
        String userName = getUserNameByEmailAndPassword(email, password);

        if (userName != null) {
            //The 'user' method is called with the JLabel and the user's name
            user(lblUser, userName);
        } else {
            // Handling of case where authentication fails (optional)
            lblUser.setText(userName);
        }
    }
    public void user(JLabel lblUser, String userName) {
        // Establishes the user name in the JLabel
        lblUser.setText(userName);
    }
//Method to get the user information based in the id
    public User getUserInfo(int userId) {
        //Establishes the databases connection
        DBConnection db = new DBConnection();
        User user = new User();
        //Set the query with sql 
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            //Prepare the declaration 
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
//Method to update the user information in databases
    public boolean updateUserInfo(User user) {
        //Establishes the databases connection 
        DBConnection db = new DBConnection();
        String sql = "UPDATE users SET ID_Number, name=?, last_name=?, birth_date=?, email=?, phone_number=?,password=?  WHERE id=?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, user.getNumber_ID());
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
     public void reorganizeIDs() {
         //Establishes the databases connection 
        DBConnection db = new DBConnection();
        // SQL query to get all the user IDs sorted in order
        String consultaSQL = "SELECT id FROM users ORDER BY id";
        try 
            (PreparedStatement preparedStatement = db.getConnection().prepareStatement(consultaSQL);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            int newID = 1;
            while (resultSet.next()) {
                int oldID = resultSet.getInt("id");
                if (newID != oldID) {
                    try (PreparedStatement updateStatement = db.getConnection().prepareStatement("UPDATE users SET id = ? WHERE id = ?")) {
                        updateStatement.setInt(1, newID);
                        updateStatement.setInt(2, oldID);
                        updateStatement.executeUpdate();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error al actualizar el ID: " + e.toString());
                    }
                }
                newID++;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los IDs: " + e.toString());
        } finally {
            db.disconnect();
        }
    }
}
