package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.*;

/**
 *
 * @author deivis
 */
public class CtrlRol {

    DAOUser du = new DAOUser();
    DAORol dr = new DAORol();

    public void Enter(String email, String password, JFrame frmUser, JFrame frmAdmin) {
        // Retrieve user information based on the provided identification number
        this.du.getUserNameByEmailAndPassword(email, password);
        // Determine the user role using the DAO
        String role = this.dr.determineRol(email, password);

        // Show the corresponding interface based on the determined role
        if ("Usuario".equals(role)) {
            frmUser.setVisible(false);
        } else if ("Administrador".equals(role)) {
            frmAdmin.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Contrasena o correo electronico incorrectos");
        }
    }

}
