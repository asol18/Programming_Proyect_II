package view;

import Controller.CtrlUser;
import controller.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.DAORol;

/**
 *
 * @author lpper
 */
public class frmAdmin extends javax.swing.JFrame {

    CtrlPlace cp = new CtrlPlace();
    CtrlEvents ce = new CtrlEvents();
    CtrlReservations cr = new CtrlReservations();
    CtrlRol cro = new CtrlRol();
    CtrlUser cu = new CtrlUser();
    DAORol rol= new DAORol();
    String value;

    public frmAdmin() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.loadData();
        this.loadCBX();
        this.clearFields();
    }
    private void loadCBX() {
        this.ce.loadcbxEvent(cbxrolesUser);
    }
//Method to load all Places, Reservations and User 
    private void loadData() {
        this.cp.loadDataPlace(tblPlaces);
        this.ce.loadDataReservations(tblReservations);
        this.cr.loadDataReservations(tblReservations);
        this.cu.loadDataUser(tblUser);
    }
    private void clearFields(){
        this.ce.clearFields(txtnameEvent, txtdescriptionEvent, txtdateEvent, txtaddressEvent, txtcityEvent, txtpostalcodeEvent, txtpriceEvent, txtplace_idEvent);
        this.cp.clearFields(txtnamePlace, txtaddressPlace, txtcityPlace, txtpostalcodePlace, txtlatitudePlace, txtlongitudePlace);
        this.cr.clearFields(txtUserReservation, txtdateReservation, txtquantityReservation);
        this.cu.clearFields(txtnameRol, txtnameRol, txtlastnameUser, txtcityPlace, txtemailUser, txtphoneUser, txtpasswordUser, txtnameRol);
    }
    private boolean validateNonEmptyFields(JTextField... fields) {
        for (JTextField field : fields) {
            if (field.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnameEvent = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtdescriptionEvent = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtdateEvent = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtaddressEvent = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtcityEvent = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtpostalcodeEvent = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtpriceEvent = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtplace_idEvent = new javax.swing.JTextField();
        btncreateEvent = new javax.swing.JButton();
        btnepgradeEvent = new javax.swing.JButton();
        btndeleteEvent = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEvents = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtnamePlace = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtaddressPlace = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtcityPlace = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtpostalcodePlace = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtlatitudePlace = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtlongitudePlace = new javax.swing.JTextField();
        btncreatePlace = new javax.swing.JButton();
        btnupdatePlace = new javax.swing.JButton();
        btndeletePlace = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPlaces = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtUserReservation = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtdateReservation = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtquantityReservation = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cbxeventsReservation = new javax.swing.JComboBox<>();
        btncreateReservation = new javax.swing.JButton();
        btnupdateReservation = new javax.swing.JButton();
        btndeleteReservation = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReservations = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtnameRol = new javax.swing.JTextField();
        btncreateRol = new javax.swing.JButton();
        btnupdateRol = new javax.swing.JButton();
        btndeleteRol = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        txtidnumberUser = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtnameUser = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtlastnameUser = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtdirthdateUser = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtemailUser = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtphoneUser = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtpasswordUser = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        cbxrolesUser = new javax.swing.JComboBox<>();
        addUser = new javax.swing.JButton();
        editUser = new javax.swing.JButton();
        deleteUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Nombre:");

        txtnameEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameEventActionPerformed(evt);
            }
        });

        jLabel2.setText("Descripcion:");

        txtdescriptionEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescriptionEventActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha:");

        jLabel4.setText("Dirrecion:");

        txtaddressEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaddressEventActionPerformed(evt);
            }
        });

        jLabel5.setText("Ciudad:");

        txtcityEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcityEventActionPerformed(evt);
            }
        });

        jLabel6.setText("Codigo Postal:");

        jLabel7.setText("Precio:");

        jLabel8.setText("Lugar:");

        txtplace_idEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtplace_idEventActionPerformed(evt);
            }
        });

        btncreateEvent.setText("Agregar");
        btncreateEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncreateEventActionPerformed(evt);
            }
        });

        btnepgradeEvent.setText("Modificar");
        btnepgradeEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnepgradeEventActionPerformed(evt);
            }
        });

        btndeleteEvent.setText("Eliminar");
        btndeleteEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteEventActionPerformed(evt);
            }
        });

        tblEvents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Descripcion", "Fecha", "Dirrecion", "Ciudad", "Codigo Postal", "Precio", "Lugar id"
            }
        ));
        tblEvents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEventsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEvents);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btncreateEvent)
                        .addGap(14, 14, 14)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnameEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdescriptionEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdateEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtaddressEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcityEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpostalcodeEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpriceEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtplace_idEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnepgradeEvent)
                        .addGap(18, 18, 18)
                        .addComponent(btndeleteEvent)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtnameEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtdescriptionEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtdateEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtaddressEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtcityEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtpostalcodeEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtpriceEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtplace_idEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btncreateEvent)
                            .addComponent(btnepgradeEvent)
                            .addComponent(btndeleteEvent))))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Eventos", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("Nombre:");

        txtnamePlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamePlaceActionPerformed(evt);
            }
        });

        jLabel10.setText("Dirrecion:");

        txtaddressPlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaddressPlaceActionPerformed(evt);
            }
        });

        jLabel11.setText("Ciudad:");

        txtcityPlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcityPlaceActionPerformed(evt);
            }
        });

        jLabel12.setText("Codigo Postal:");

        jLabel13.setText("Latitud:");

        jLabel14.setText("Longitud:");

        btncreatePlace.setText("Agregar");
        btncreatePlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncreatePlaceActionPerformed(evt);
            }
        });

        btnupdatePlace.setText("Modificar");
        btnupdatePlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdatePlaceActionPerformed(evt);
            }
        });

        btndeletePlace.setText("Eliminar");
        btndeletePlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletePlaceActionPerformed(evt);
            }
        });

        tblPlaces.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Dirrecion", "Ciudad", "Codigo Postal", "Latitud", "Longitud"
            }
        ));
        tblPlaces.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPlacesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPlaces);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtcityPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtlatitudePlace, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtpostalcodePlace, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(txtlongitudePlace, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtaddressPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnamePlace, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btncreatePlace)
                        .addGap(18, 18, 18)
                        .addComponent(btnupdatePlace)
                        .addGap(18, 18, 18)
                        .addComponent(btndeletePlace)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnamePlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtaddressPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcityPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtpostalcodePlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtlatitudePlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtlongitudePlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btncreatePlace)
                            .addComponent(btnupdatePlace)
                            .addComponent(btndeletePlace)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lugares", jPanel4);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setText("Usuario:");

        txtUserReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserReservationActionPerformed(evt);
            }
        });

        jLabel16.setText("Fecha:");

        jLabel17.setText("Cantidad:");

        jLabel18.setText("Evento:");

        cbxeventsReservation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxeventsReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxeventsReservationActionPerformed(evt);
            }
        });

        btncreateReservation.setText("Agregar");
        btncreateReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncreateReservationActionPerformed(evt);
            }
        });

        btnupdateReservation.setText("Modificar");
        btnupdateReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateReservationActionPerformed(evt);
            }
        });

        btndeleteReservation.setText("Eliminar");
        btndeleteReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteReservationActionPerformed(evt);
            }
        });

        tblReservations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Usuario", "Fecha", "Cantidad", "Evento"
            }
        ));
        tblReservations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReservationsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblReservations);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel17))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btncreateReservation)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUserReservation, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(txtdateReservation, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(txtquantityReservation, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(cbxeventsReservation, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnupdateReservation)
                        .addGap(18, 18, 18)
                        .addComponent(btndeleteReservation)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtUserReservation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtdateReservation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtquantityReservation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(cbxeventsReservation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btncreateReservation)
                            .addComponent(btnupdateReservation)
                            .addComponent(btndeleteReservation)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Reservaciones", jPanel5);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setText("Nombre:");

        txtnameRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameRolActionPerformed(evt);
            }
        });

        btncreateRol.setText("Agregar");
        btncreateRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncreateRolActionPerformed(evt);
            }
        });

        btnupdateRol.setText("Modificar");
        btnupdateRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateRolActionPerformed(evt);
            }
        });

        btndeleteRol.setText("Eliminar");
        btndeleteRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteRolActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Nombre"
            }
        ));
        jScrollPane4.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btncreateRol)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtnameRol, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnupdateRol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btndeleteRol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtnameRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btncreateRol)
                            .addComponent(btnupdateRol)
                            .addComponent(btndeleteRol)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Roles", jPanel7);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Cedula", "Nombre", "Apellido", "Fecha nacimiento", "Email", "Telefono", "Contraseña", "Rol"
            }
        ));
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblUser);

        jLabel20.setText("Cedula:");

        txtidnumberUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidnumberUserActionPerformed(evt);
            }
        });

        jLabel21.setText("Nombre:");

        jLabel22.setText("Apellido:");

        jLabel23.setText("Fecha Nacimiento:");

        jLabel24.setText("Email:");

        jLabel25.setText("Telefono:");

        jLabel26.setText("Contraseña:");

        jLabel27.setText("Rol:");

        cbxrolesUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxrolesUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxrolesUserActionPerformed(evt);
            }
        });

        addUser.setText("Agregar");
        addUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserActionPerformed(evt);
            }
        });

        editUser.setText("Modificar");
        editUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserActionPerformed(evt);
            }
        });

        deleteUser.setText("Eliminar");
        deleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addUser)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21)
                                .addComponent(jLabel22)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel25)))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel23))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtidnumberUser)
                            .addComponent(txtnameUser)
                            .addComponent(txtlastnameUser)
                            .addComponent(txtdirthdateUser, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(txtemailUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(txtphoneUser, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(txtpasswordUser, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(cbxrolesUser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteUser)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtidnumberUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtnameUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(txtlastnameUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdirthdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(15, 15, 15)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtemailUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtphoneUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtpasswordUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(cbxrolesUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addUser)
                    .addComponent(editUser)
                    .addComponent(deleteUser))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Usuarios", jPanel9);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPlacesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPlacesMouseClicked
        this.cp.selectedRowPlace(tblPlaces, txtnamePlace, txtaddressPlace, txtcityPlace, txtpostalcodePlace, txtlatitudePlace, txtlongitudePlace);
    }//GEN-LAST:event_tblPlacesMouseClicked

    private void btndeletePlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletePlaceActionPerformed
        this.cp.deletePlace();
        this.cp.clearFields(txtnamePlace, txtaddressPlace, txtcityPlace, txtpostalcodePlace, txtlatitudePlace, txtlongitudePlace);
        this.cp.updatePlace(txtnamePlace, txtaddressPlace, txtcityPlace, txtpostalcodePlace, txtlatitudePlace, txtlongitudePlace);
    }//GEN-LAST:event_btndeletePlaceActionPerformed

    private void btncreatePlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncreatePlaceActionPerformed
        this.cp.addPlace(tblPlaces, txtnamePlace, txtaddressPlace, txtcityPlace, txtpostalcodePlace, txtlatitudePlace, txtlongitudePlace);
        this.cp.clearFields(txtnamePlace, txtaddressPlace, txtcityPlace, txtpostalcodePlace, txtlatitudePlace, txtlongitudePlace);
        this.cp.updatePlace(txtnamePlace, txtaddressPlace, txtcityPlace, txtpostalcodePlace, txtlatitudePlace, txtlongitudePlace);
        if (txtnamePlace.getText().isEmpty() || txtaddressPlace.getText().isEmpty() || txtcityPlace.getText().isEmpty()
                || txtpostalcodePlace.getText().isEmpty() || txtlatitudePlace.getText().isEmpty() || txtlongitudePlace.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btncreatePlaceActionPerformed

    private void btnupdatePlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdatePlaceActionPerformed
        this.cp.updatePlace(txtnamePlace, txtaddressPlace, txtcityPlace, txtpostalcodePlace, txtlatitudePlace, txtlongitudePlace);
        this.cp.clearFields(txtnamePlace, txtaddressPlace, txtcityPlace, txtpostalcodePlace, txtlatitudePlace, txtlongitudePlace);
    }//GEN-LAST:event_btnupdatePlaceActionPerformed

    private void btncreateEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncreateEventActionPerformed
        this.ce.addEvent(tblEvents, txtnameEvent, txtdescriptionEvent, txtdateEvent, txtaddressEvent, txtcityEvent, txtpostalcodeEvent, txtpriceEvent, txtplace_idEvent);
        this.ce.clearFields(txtnameEvent, txtdescriptionEvent, txtdateEvent, txtaddressEvent, txtcityEvent, txtpostalcodeEvent, txtpriceEvent, txtplace_idEvent);
        this.ce.updateEvent(tblEvents, txtnameEvent, txtdescriptionEvent, txtdateEvent, txtaddressEvent, txtcityEvent, txtpostalcodeEvent, txtpriceEvent, txtplace_idEvent);
        if (!validateNonEmptyFields(txtnameEvent, txtdescriptionEvent, txtdateEvent,
                txtaddressEvent, txtcityEvent, txtpostalcodeEvent, txtpriceEvent,
                txtplace_idEvent)) {
            return;
        }
    }//GEN-LAST:event_btncreateEventActionPerformed

    private void btnepgradeEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnepgradeEventActionPerformed
        this.ce.updateEvent(tblEvents, txtnameEvent, txtdescriptionEvent, txtdateEvent, txtaddressEvent, txtcityEvent, txtpostalcodeEvent, txtpriceEvent, txtplace_idEvent);
        this.ce.clearFields(txtnameEvent, txtdescriptionEvent, txtdateEvent, txtaddressEvent, txtcityEvent, txtpostalcodeEvent, txtpriceEvent, txtplace_idEvent);
    }//GEN-LAST:event_btnepgradeEventActionPerformed

    private void btndeleteEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteEventActionPerformed
        this.ce.deleteEvent();
        this.ce.clearFields(txtnameEvent, txtdescriptionEvent, txtdateEvent, txtaddressEvent, txtcityEvent, txtpostalcodeEvent, txtpriceEvent, txtplace_idEvent);
        this.ce.updateEvent(tblEvents, txtnameEvent, txtdescriptionEvent, txtdateEvent, txtaddressEvent, txtcityEvent, txtpostalcodeEvent, txtpriceEvent, txtplace_idEvent);
    }//GEN-LAST:event_btndeleteEventActionPerformed

    private void tblEventsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEventsMouseClicked
        this.ce.selectedRowEvent(tblEvents, txtnameEvent, txtdescriptionEvent, txtdateEvent, txtaddressEvent, txtcityEvent, txtpostalcodeEvent, txtpriceEvent, txtplace_idEvent);
    }//GEN-LAST:event_tblEventsMouseClicked

    private void btncreateReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncreateReservationActionPerformed
        this.cr.addReservation(tblReservations, txtUserReservation, txtdateReservation, txtquantityReservation, cbxeventsReservation);
        this.cr.clearFields(txtUserReservation, txtdateReservation, txtquantityReservation);
        this.cr.updateReservation(tblReservations, txtnameRol, txtdateReservation, txtquantityReservation, cbxeventsReservation);
        if (txtUserReservation.getText().isEmpty() || txtdateReservation.getText().isEmpty() || txtquantityReservation.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btncreateReservationActionPerformed

    private void btnupdateReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateReservationActionPerformed
        this.cr.updateReservation(tblReservations, txtnameRol, txtdateReservation, txtquantityReservation, cbxeventsReservation);
        this.cr.clearFields(txtUserReservation, txtdateReservation, txtquantityReservation);
    }//GEN-LAST:event_btnupdateReservationActionPerformed

    private void btndeleteReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteReservationActionPerformed
        this.cr.deleteReservationPlace();
        this.cr.clearFields(txtUserReservation, txtdateReservation, txtquantityReservation);
        this.cr.updateReservation(tblReservations, txtnameRol, txtdateReservation, txtquantityReservation, cbxeventsReservation);
    }//GEN-LAST:event_btndeleteReservationActionPerformed

    private void tblReservationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReservationsMouseClicked
        this.cr.selectedRowReservationPlace(tblReservations, txtUserReservation, txtdateReservation, txtquantityReservation, cbxeventsReservation);
    }//GEN-LAST:event_tblReservationsMouseClicked

    private void addUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserActionPerformed
        this.cu.addUser(tblUser,   txtidnumberUser, txtnameRol, txtlastnameUser, txtcityPlace, txtemailUser, txtphoneUser, txtpasswordUser, cbxrolesUser);
        this.cu.clearFields(txtnameRol, txtnameRol, txtlastnameUser, txtcityPlace, txtemailUser, txtphoneUser, txtpasswordUser, txtnameRol);
        this.cu.updateUser(tblUser, txtnameRol, txtnameRol, txtlastnameUser, txtcityPlace, txtemailUser, txtphoneUser, txtpasswordUser, cbxrolesUser);
        if (txtidnumberUser.getText().isEmpty() || txtnameRol.getText().isEmpty() || txtlastnameUser.getText().isEmpty()|| txtcityPlace.getText().isEmpty()|| txtemailUser.getText().isEmpty()|| txtphoneUser.getText().isEmpty()|| txtpasswordUser.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_addUserActionPerformed

    private void editUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserActionPerformed
        this.cu.updateUser(tblUser, txtnameRol, txtnameRol, txtlastnameUser, txtcityPlace, txtemailUser, txtphoneUser, txtpasswordUser, cbxrolesUser);
        this.cu.clearFields(txtnameRol, txtnameRol, txtlastnameUser, txtcityPlace, txtemailUser, txtphoneUser, txtpasswordUser, txtnameRol);
    }//GEN-LAST:event_editUserActionPerformed

    private void deleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserActionPerformed
        this.cu.deleteUser();
        this.cu.clearFields(txtnameRol, txtnameRol, txtlastnameUser, txtcityPlace, txtemailUser, txtphoneUser, txtpasswordUser, txtnameRol);
        this.cu.updateUser(tblUser, txtnameRol, txtnameRol, txtlastnameUser, txtcityPlace, txtemailUser, txtphoneUser, txtpasswordUser, cbxrolesUser);
    }//GEN-LAST:event_deleteUserActionPerformed

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        this.cu.selectedRowUsers(tblUser, txtidnumberUser, txtnameUser, txtlastnameUser, txtdirthdateUser, txtemailUser, txtphoneUser, txtpasswordUser, cbxrolesUser);
    }//GEN-LAST:event_tblUserMouseClicked

    private void cbxeventsReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxeventsReservationActionPerformed
    this.ce.loadcbxEvent(cbxrolesUser);
    }//GEN-LAST:event_cbxeventsReservationActionPerformed

    private void btnupdateRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnupdateRolActionPerformed

    private void btncreateRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncreateRolActionPerformed
    
    }//GEN-LAST:event_btncreateRolActionPerformed

    private void btndeleteRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btndeleteRolActionPerformed

    private void cbxrolesUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxrolesUserActionPerformed
    this.cu.getIdRole(cbxrolesUser);
    }//GEN-LAST:event_cbxrolesUserActionPerformed

    private void txtnameRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameRolActionPerformed

    }//GEN-LAST:event_txtnameRolActionPerformed

    private void txtnameEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameEventActionPerformed
    
    }//GEN-LAST:event_txtnameEventActionPerformed

    private void txtdescriptionEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescriptionEventActionPerformed

    }//GEN-LAST:event_txtdescriptionEventActionPerformed

    private void txtaddressEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaddressEventActionPerformed

    }//GEN-LAST:event_txtaddressEventActionPerformed

    private void txtcityEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcityEventActionPerformed

    }//GEN-LAST:event_txtcityEventActionPerformed

    private void txtplace_idEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtplace_idEventActionPerformed

    }//GEN-LAST:event_txtplace_idEventActionPerformed

    private void txtnamePlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamePlaceActionPerformed
 
    }//GEN-LAST:event_txtnamePlaceActionPerformed

    private void txtaddressPlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaddressPlaceActionPerformed
  
    }//GEN-LAST:event_txtaddressPlaceActionPerformed

    private void txtcityPlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcityPlaceActionPerformed
 
    }//GEN-LAST:event_txtcityPlaceActionPerformed

    private void txtUserReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserReservationActionPerformed

    }//GEN-LAST:event_txtUserReservationActionPerformed

    private void txtidnumberUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidnumberUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidnumberUserActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUser;
    private javax.swing.JButton btncreateEvent;
    private javax.swing.JButton btncreatePlace;
    private javax.swing.JButton btncreateReservation;
    private javax.swing.JButton btncreateRol;
    private javax.swing.JButton btndeleteEvent;
    private javax.swing.JButton btndeletePlace;
    private javax.swing.JButton btndeleteReservation;
    private javax.swing.JButton btndeleteRol;
    private javax.swing.JButton btnepgradeEvent;
    private javax.swing.JButton btnupdatePlace;
    private javax.swing.JButton btnupdateReservation;
    private javax.swing.JButton btnupdateRol;
    private javax.swing.JComboBox<String> cbxeventsReservation;
    private javax.swing.JComboBox<String> cbxrolesUser;
    private javax.swing.JButton deleteUser;
    private javax.swing.JButton editUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblEvents;
    private javax.swing.JTable tblPlaces;
    private javax.swing.JTable tblReservations;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField txtUserReservation;
    private javax.swing.JTextField txtaddressEvent;
    private javax.swing.JTextField txtaddressPlace;
    private javax.swing.JTextField txtcityEvent;
    private javax.swing.JTextField txtcityPlace;
    private javax.swing.JTextField txtdateEvent;
    private javax.swing.JTextField txtdateReservation;
    private javax.swing.JTextField txtdescriptionEvent;
    private javax.swing.JTextField txtdirthdateUser;
    private javax.swing.JTextField txtemailUser;
    private javax.swing.JTextField txtidnumberUser;
    private javax.swing.JTextField txtlastnameUser;
    private javax.swing.JTextField txtlatitudePlace;
    private javax.swing.JTextField txtlongitudePlace;
    private javax.swing.JTextField txtnameEvent;
    private javax.swing.JTextField txtnamePlace;
    private javax.swing.JTextField txtnameRol;
    private javax.swing.JTextField txtnameUser;
    private javax.swing.JTextField txtpasswordUser;
    private javax.swing.JTextField txtphoneUser;
    private javax.swing.JTextField txtplace_idEvent;
    private javax.swing.JTextField txtpostalcodeEvent;
    private javax.swing.JTextField txtpostalcodePlace;
    private javax.swing.JTextField txtpriceEvent;
    private javax.swing.JTextField txtquantityReservation;
    // End of variables declaration//GEN-END:variables


}
