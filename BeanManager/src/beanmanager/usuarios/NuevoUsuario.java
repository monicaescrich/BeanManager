/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanmanager.usuarios;

import beanmanager.controles.Bdd;
import java.awt.Color;

import java.math.BigInteger;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Monica Escrich
 */
public class NuevoUsuario extends javax.swing.JFrame {

    Bdd bdd = new Bdd(); 
    boolean flagModificar=false, flagColorModificado=false;
    int id_Usr;
    String colorHexa; 
    
    /**
     * Creates new form NuevoUsuario
     */
    public NuevoUsuario() {
        
        initComponents();
        setLocationRelativeTo(null);//Centra pantalla
        setResizable(false); //Quitar Resize
        getContentPane().setBackground(Color.decode("#FFFFFF"));
        llenarComboBox(); 
    }
    
    public NuevoUsuario(int idUsuario) {
        
        initComponents();
        setLocationRelativeTo(null);//Centra pantalla
        setResizable(false); //Quitar Resize
        getContentPane().setBackground(Color.decode("#FFFFFF"));
        flagModificar=true; 
        id_Usr=idUsuario; 
        modificaUsuario(idUsuario); 
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldApellidos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNombres = new javax.swing.JTextField();
        jTextFieldCorreo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonColorGUI = new javax.swing.JButton();
        jPasswordFieldContra = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxRol = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButtonGuardar = new javax.swing.JButton();
        jButtonBackMenuUsr = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setText("Datos Usuario");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beanmanager/recursos/imagenes/usuarios.png"))); // NOI18N

        jTextFieldApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldApellidosActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombres:");

        jLabel4.setText("Apellidos: ");

        jTextFieldNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombresActionPerformed(evt);
            }
        });

        jTextFieldCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCorreoActionPerformed(evt);
            }
        });

        jLabel5.setText("Correo:");

        jLabel6.setText("Fecha Nacimiento:");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel7.setText("Configuraciones de Usuario");

        jLabel8.setText("Contraseña: ");

        jButtonColorGUI.setBackground(new java.awt.Color(255, 255, 255));
        jButtonColorGUI.setForeground(new java.awt.Color(255, 255, 255));
        jButtonColorGUI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beanmanager/recursos/imagenes/colorGUI.png"))); // NOI18N
        jButtonColorGUI.setToolTipText("Color Interfaz de Usuario");
        jButtonColorGUI.setBorder(null);
        jButtonColorGUI.setBorderPainted(false);
        jButtonColorGUI.setFocusable(false);
        jButtonColorGUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonColorGUIActionPerformed(evt);
            }
        });

        jLabel9.setText("Rol:");

        jComboBoxRol.setModel(llenarComboBox());

        jCheckBox1.setText("Usuario Activo");

        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beanmanager/recursos/imagenes/guardar.png"))); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.setToolTipText("Guardar");
        jButtonGuardar.setBorderPainted(false);
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonBackMenuUsr.setBackground(new java.awt.Color(255, 255, 255));
        jButtonBackMenuUsr.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBackMenuUsr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beanmanager/recursos/imagenes/backtousers.png"))); // NOI18N
        jButtonBackMenuUsr.setToolTipText("Menu Usuarios");
        jButtonBackMenuUsr.setBorder(null);
        jButtonBackMenuUsr.setFocusable(false);
        jButtonBackMenuUsr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackMenuUsrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButtonColorGUI)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPasswordFieldContra, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))))
                        .addGap(3, 3, 3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(222, 222, 222))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonBackMenuUsr))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel6)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addGap(10, 10, 10)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextFieldCorreo)
                                                        .addComponent(jTextFieldNombres)
                                                        .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jComboBoxRol, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonBackMenuUsr, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 29, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(14, 14, 14)
                        .addComponent(jButtonColorGUI))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPasswordFieldContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jButtonGuardar))
                            .addComponent(jCheckBox1))))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldApellidosActionPerformed

    private void jTextFieldNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombresActionPerformed

    private void jTextFieldCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCorreoActionPerformed

    private void jButtonBackMenuUsrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackMenuUsrActionPerformed
        // TODO add your handling code here:
        menuUsuario(); 
    }//GEN-LAST:event_jButtonBackMenuUsrActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // TODO add your handling code here:
       if( InsertUsers()){
            JOptionPane.showMessageDialog(null, "Usuario registrado con Exito!");
            limpiar(); 
            menuUsuario(); 
            
       } 
        
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonColorGUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonColorGUIActionPerformed
        // TODO add your handling code here:
        flagColorModificado=true;
        JColorChooser ventanaDeColores=new JColorChooser();
        Color color=ventanaDeColores.showDialog(null, "Seleccione un Color", Color.gray);
        color.getRGB(); 
        colorHexa= String.format("%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());  
    }//GEN-LAST:event_jButtonColorGUIActionPerformed
    
    public DefaultComboBoxModel llenarComboBox(){
        String cmd="SELECT `idRol`,`rol` FROM `rolesProyecto` where eliminado=0";
       DefaultComboBoxModel descripcionRoles = new DefaultComboBoxModel();
         try {
            CargarRoles rol=null;
            bdd.setPreparedQuery(cmd);
            ResultSet rs = bdd.executeReader(null);
            while(rs.next())
            {
                descripcionRoles.addElement(new CargarRoles(rs.getInt("idRol"),rs.getString("rol")));
            }
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error CargarRoles()");
        }
        
         return descripcionRoles;
    }
    

    
    public String encriptarMD5(String cadena){
      MessageDigest m;
      String encoded="";
        try {
            m = MessageDigest.getInstance("MD5");
            m.update(cadena.getBytes(),0,cadena.length());
             encoded= new BigInteger(1,m.digest()).toString(16);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(NuevoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
      
     return encoded ;
    }
    

    public void menuUsuario(){
        MenuUsuarios frmMenuUsr = new MenuUsuarios(); 
        frmMenuUsr.setVisible(true); 
        this.setVisible(false); 
    }
    
    public void modificaUsuario(int idUser)
    {
        
        String cmd="SELECT Usuarios.idUsuario, Usuarios.nombre, Usuarios.contrasena, Usuarios.apellido, Usuarios.correo,"
                +" Usuarios.fechaNacimiento, Usuarios.idTipo, Usuarios.eliminado " 
                +" FROM Usuarios where Usuarios.idUsuario="+idUser;
        
         try {
            bdd.setPreparedQuery(cmd);
            ResultSet rs = bdd.executeReader(null);
            while(rs.next())
            {
                CargarRoles.id =rs.getInt("idTipo");
                jComboBoxRol.setSelectedIndex(CargarRoles.id-1);
                jTextFieldNombres.setText(rs.getString("nombre")); 
                jTextFieldApellidos.setText(rs.getString("apellido")); 

                jTextFieldCorreo.setText(rs.getString("correo")); 

                jTextFieldCorreo.setText(rs.getString("fechaNacimiento")); 

                jPasswordFieldContra.setText(rs.getString("contrasena"));
                jFormattedTextField1.setText(rs.getString("fechaNacimiento")); 
                int x= rs.getInt("eliminado");
                if (x==0)
                    jCheckBox1.setSelected(false); 
                else 
                    jCheckBox1.setSelected(true); 
                    
               
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error modificar()");
        }
    
    }
    
    public void limpiar(){
        jTextFieldNombres.setText(""); 
        jTextFieldApellidos.setText(""); 
        jTextFieldCorreo.setText(""); 
        jPasswordFieldContra.setText("");
        jFormattedTextField1.setText(""); 
        jCheckBox1.setSelected(false); 
    }
    
    public boolean InsertUsers() {
        
        String cmd;
        SimpleDateFormat sdf;
        
        if(!flagModificar){
             cmd="INSERT INTO `Usuarios`( `idTipo`, `nombre`, `apellido`, `correo`, `contrasena`,"
                 +"`fechaNacimiento`, `colorGUI`, `eliminado`) VALUES (?,?,?,?,?,?,?,?)";
             
             sdf = new SimpleDateFormat("dd/MM/yyyy");
        }
        else {
            if (flagColorModificado)
                cmd="UPDATE `Usuarios` SET `idTipo`=?,`nombre`=?,`apellido`=?,`correo`=?,`contrasena`=?,"
                    +"`fechaNacimiento`=?,`colorGUI`=?,`eliminado`=? WHERE idUsuario="+id_Usr;
            else
                cmd="UPDATE `Usuarios` SET `idTipo`=?,`nombre`=?,`apellido`=?,`correo`=?,`contrasena`=?,"
                    +"`fechaNacimiento`=?,`eliminado`=? WHERE idUsuario="+id_Usr;
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        }
            
        
         List<Object> parametros = new ArrayList<Object>();
         
        
         
         try{
             // Convertir java.Date to SQL.Date
                
            Date parsed = null;
            parsed = sdf.parse(jFormattedTextField1.getText());
            java.sql.Date data = new java.sql.Date(parsed.getTime());
                
            CargarRoles rol= (CargarRoles) jComboBoxRol.getSelectedItem();
                
             //Parametros enviados a la consulta
             parametros.add(rol.getId());
             parametros.add(jTextFieldNombres.getText());
             parametros.add(jTextFieldApellidos.getText());
             parametros.add(jTextFieldCorreo.getText());

             parametros.add(encriptarMD5(String.valueOf(jPasswordFieldContra.getPassword())));

             parametros.add(data);
             if(flagColorModificado)
                parametros.add(colorHexa);
             if(jCheckBox1.isSelected())
                parametros.add(1);
             else
                 parametros.add(0);
             
             bdd.setPreparedQuery(cmd);
           
             bdd.executeQuery(parametros);
             
             return true; 
            
             
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error InsertUser()");
            return false;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBackMenuUsr;
    private javax.swing.JButton jButtonColorGUI;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBoxRol;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordFieldContra;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldCorreo;
    private javax.swing.JTextField jTextFieldNombres;
    // End of variables declaration//GEN-END:variables
}
