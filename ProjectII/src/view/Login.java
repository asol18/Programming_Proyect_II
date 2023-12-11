package view;

import controller.CtrlRol;
import javax.swing.JOptionPane;
import model.DAOUser;
import model.User;

/**
 *
 * @author fabri
 */
public class Login extends javax.swing.JFrame {

    frmAdmin adm = new frmAdmin();
    frmUser frmUser = new frmUser();
    CtrlRol cr = new CtrlRol();

    frmRegistration rg = new frmRegistration();
    DAOUser dao = new DAOUser();

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtemail = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel6.setText("Si no tienes un Usuario,Crealo AQUI");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 560, -1, -1));

        jButton1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 100, -1));
        getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 180, -1));
        getContentPane().add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 180, 30));

        jLabel5.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jLabel5.setText("Contraseña");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jLabel4.setText("Correo");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setText("  Ingrese sus datos");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 220, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setText("EncuentraEventos CR");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OIG (1).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        loginUser();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        rg.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void loginUser() {
        String email = txtemail.getText();
        String password = new String(txtpassword.getPassword());

        // Llamar al método para obtener el usuario por email y contraseña
        User loggedInUser = this.dao.getUserByEmailAndPassword(email, password);

        if (loggedInUser != null) {
            // Abrir el formulario frmUser y pasar el nombre de usuario
            frmUser userForm = new frmUser(loggedInUser.getName());
             // Mostrar un mensaje de bienvenida y el nombre del usuario
            JOptionPane.showMessageDialog(this, "¡Bienvenido, " + loggedInUser.getName() + "!");
            this.cr.Enter(txtemail.getText(), txtpassword.getText(), frmUser, adm);
            this.dispose();
            userForm.setVisible(true);

           
        } else {
            // Manejar el caso en el que la autenticación falla
            // Por ejemplo, mostrar un mensaje de error
            JOptionPane.showMessageDialog(this, "Error: Usuario no encontrado");
        }
    }

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtemail;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
