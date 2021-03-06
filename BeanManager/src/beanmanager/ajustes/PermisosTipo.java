/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanmanager.ajustes;

import beanmanager.controles.Bdd;
import java.awt.Color;
import java.util.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author jacky
 */
public class PermisosTipo extends javax.swing.JFrame {
    DefaultTableModel ModelPermisos;
    List<String> idTipo;
    String[] columnas = new String[]{"id","Modulo","Ingresar","Agregar","Modificar","Borrar"};
    /**
     * Creates new form PermisosTipo
     */
    public PermisosTipo() {
        ModelPermisos = new DefaultTableModel(null,columnas) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
              @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }
            @Override
            public boolean isCellEditable (int fila, int columna) {
                return false;
            }
        };
        initComponents();
        CargarTipos();
        setLocationRelativeTo(null);
        setLayout(null);
        this.getContentPane().setBackground(Color.decode("#FFFFFF"));
        this.jtbPermisos.getColumnModel().getColumn(0).setMaxWidth(0);
        this.jtbPermisos.getColumnModel().getColumn(0).setMinWidth(0);
        this.jtbPermisos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        this.jtbPermisos.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
    }
    public void CargarTipos(){
        try{
            Bdd conexion = new Bdd();
            String consulta="SELECT * FROM `TiposUsuario` WHERE `eliminado`=0";
            Statement stmt = conexion.con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);
            idTipo = new ArrayList<String>();
            while(resultado.next())
            {
                idTipo.add(resultado.getString("idTipo"));
                jcmbTipo.addItem(resultado.getString("tipo"));
            }
            conexion.close();

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void CargarPermisos(){
        Boolean[] prueba = new Boolean[]{true,false,true,false,false,true};
       try{
            int rows = ModelPermisos.getRowCount();
            for(int j = 0; j<rows;j++)
            {
                ModelPermisos.removeRow(0);
            }
            Bdd conexion = new Bdd();
            String consulta="SELECT `idPermiso`, `Modulos`.`modulo` as 'modulo',`ingresar`,`agregar`,`modificar`,`borrar` "
                    + "FROM `Permisos` inner join `Modulos` on `Modulos`.`idModulo` = `Permisos`.`idModulo`"
                    + " WHERE `Permisos`.`eliminado`=0 and `idTipo`="+idTipo.get(jcmbTipo.getSelectedIndex());
            Statement stmt = conexion.con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);
            Object[] datos = new Object[6];
            while(resultado.next())
            {
                datos[0]=resultado.getObject(1);
                datos[1]=resultado.getObject(2);
                for(int i=2;i<6;i++)
                {
                     datos[i] = (resultado.getObject(i+1).toString().equals("1"))?true:false;
                      //JOptionPane.showMessageDialog(null, datos[i]);
                }
               this.ModelPermisos.addRow(datos);
               
            }
            conexion.close();

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
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
        jcmbTipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbPermisos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jlbHome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Permisos por Tipo de Usuario");

        jLabel2.setText("Tipo: ");

        jcmbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbTipoItemStateChanged(evt);
            }
        });

        jtbPermisos.setModel(ModelPermisos);
        jtbPermisos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbPermisosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbPermisos);

        jLabel3.setText("Para modificar los permisos del rol, de click en la fila del modulo que desea cambiar.");

        jlbHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beanmanager/recursos/imagenes/home.png"))); // NOI18N
        jlbHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbHomeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 343, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbHome)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jlbHome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtbPermisosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbPermisosMouseClicked
        // TODO add your handling code here:
        int i= this.jtbPermisos.getSelectedRow();
        String idPermiso = this.jtbPermisos.getValueAt(i, 0).toString();
//        JOptionPane.showMessageDialog(null, idPermiso);
        ModificarPermisoTipo jfmModificar = new ModificarPermisoTipo(idPermiso);
        jfmModificar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jtbPermisosMouseClicked

    private void jcmbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbTipoItemStateChanged
        // TODO add your handling code here:
        CargarPermisos();
    }//GEN-LAST:event_jcmbTipoItemStateChanged

    private void jlbHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbHomeMouseClicked
        // TODO add your handling code here:
        InicioAjustes jfmAjustes = new InicioAjustes();
        jfmAjustes.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jlbHomeMouseClicked

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
            java.util.logging.Logger.getLogger(PermisosTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PermisosTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PermisosTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PermisosTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PermisosTipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcmbTipo;
    private javax.swing.JLabel jlbHome;
    private javax.swing.JTable jtbPermisos;
    // End of variables declaration//GEN-END:variables
}
