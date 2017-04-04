/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanmanager.ajustes;

import beanmanager.menuInicio;
import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author jacky
 */
public class InicioAjustes extends javax.swing.JFrame {

    /**
     * Creates new form InicioAjustes
     */
    public InicioAjustes() {
        initComponents();
        setTitle("Bean Manager - Ajustes");//titulo
        setResizable(false); //Quitar Resize
        setLocationRelativeTo(null);//Centra pantalla
        setLayout(null); // Libre seleccion de tamaño
        this.getContentPane().setBackground(Color.decode("#FFFFFF"));
        jlbEtiqueta.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlbRoles = new javax.swing.JLabel();
        jlbEtiqueta = new javax.swing.JLabel();
        jlbTipo = new javax.swing.JLabel();
        jlbRol = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlbHome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlbRoles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beanmanager/recursos/imagenes/roles.png"))); // NOI18N
        jlbRoles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbRolesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbRolesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbRolesMouseExited(evt);
            }
        });

        jlbEtiqueta.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jlbEtiqueta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbEtiqueta.setText("jLabel2");
        jlbEtiqueta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jlbTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beanmanager/recursos/imagenes/PermisosRoles.png"))); // NOI18N
        jlbTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbTipoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbTipoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbTipoMouseExited(evt);
            }
        });

        jlbRol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beanmanager/recursos/imagenes/PermisosTipo.png"))); // NOI18N
        jlbRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbRolMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbRolMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbRolMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Menú de Ajustes");

        jlbHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beanmanager/recursos/imagenes/home.png"))); // NOI18N
        jlbHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbHomeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jlbRoles)
                .addGap(57, 57, 57)
                .addComponent(jlbTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jlbRol)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbEtiqueta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbHome)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jlbHome))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbTipo)
                    .addComponent(jlbRol)
                    .addComponent(jlbRoles))
                .addGap(18, 18, 18)
                .addComponent(jlbEtiqueta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlbRolesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbRolesMouseEntered
        // TODO add your handling code here:
        jlbEtiqueta.setText("Roles");
    }//GEN-LAST:event_jlbRolesMouseEntered

    private void jlbRolesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbRolesMouseExited
        // TODO add your handling code here:
        jlbEtiqueta.setText("");
    }//GEN-LAST:event_jlbRolesMouseExited

    private void jlbTipoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbTipoMouseEntered
        // TODO add your handling code here:
         jlbEtiqueta.setText("Permisos Por Tipo de usuario");
    }//GEN-LAST:event_jlbTipoMouseEntered

    private void jlbTipoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbTipoMouseExited
        // TODO add your handling code here:
         jlbEtiqueta.setText("");
    }//GEN-LAST:event_jlbTipoMouseExited

    private void jlbRolMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbRolMouseEntered
        // TODO add your handling code here:
         jlbEtiqueta.setText("Permisos por Rol");
    }//GEN-LAST:event_jlbRolMouseEntered

    private void jlbRolMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbRolMouseExited
        // TODO add your handling code here:
         jlbEtiqueta.setText("");
    }//GEN-LAST:event_jlbRolMouseExited

    private void jlbRolesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbRolesMouseClicked
        // TODO add your handling code here:
        Roles jfmRoles = new Roles();
        jfmRoles.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jlbRolesMouseClicked

    private void jlbHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbHomeMouseClicked
        // TODO add your handling code here:
        menuInicio jfmMenu = new menuInicio();
        jfmMenu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jlbHomeMouseClicked

    private void jlbTipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbTipoMouseClicked
        // TODO add your handling code here:
//        PermisosTipo jfmTipo = new PermisosTipo();
//        jfmTipo.setVisible(true);
//        this.setVisible(false);
    }//GEN-LAST:event_jlbTipoMouseClicked

    private void jlbRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbRolMouseClicked
        // TODO add your handling code here:
//        permisos jfmPermisos = new permisos();
//        jfmPermisos.setVisible(true);
//        this.setVisible(false);
        
    }//GEN-LAST:event_jlbRolMouseClicked

    private void jlbHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbHomeMouseEntered
        // TODO add your handling code here:
        jlbEtiqueta.setText("Menú de inicio");
    }//GEN-LAST:event_jlbHomeMouseEntered

    private void jlbHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbHomeMouseExited
        // TODO add your handling code here:
        jlbEtiqueta.setText("");
    }//GEN-LAST:event_jlbHomeMouseExited

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
            java.util.logging.Logger.getLogger(InicioAjustes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioAjustes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioAjustes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioAjustes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioAjustes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jlbEtiqueta;
    private javax.swing.JLabel jlbHome;
    private javax.swing.JLabel jlbRol;
    private javax.swing.JLabel jlbRoles;
    private javax.swing.JLabel jlbTipo;
    // End of variables declaration//GEN-END:variables
}
