/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanmanager.proyectos;
import beanmanager.controles.Bdd;
import beanmanager.menuInicio;
import beanmanager.proyectos.*;
import java.awt.Color;
import java.sql.*;
import javax.swing.table.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ascencio
 */
public class IndexProyecto extends javax.swing.JFrame {
    Statement st;
    ResultSet rs;
    int numeroProyectos,numeroActual=1;
    int[] idProyecto,avanceProyecto,idActividad,idProgramador;
    String[] nombreProyecto,fechaCreacion,fechaInicio;
    DefaultTableModel modelTblProgramadores,modelTblActividades;
    /**
     * Creates new form IndexProyecto
     */
    public IndexProyecto() {
        initComponents();
        setResizable(false); //Quitar Resize
        setLocationRelativeTo(null);//Centra pantalla
        setLayout(null); // Libre seleccion de tamaño
        getContentPane().setBackground(Color.decode("#FFFFFF"));//Colocamos fondo blanco
        modelTblProgramadores=(DefaultTableModel)tblProgramadores.getModel();
        modelTblActividades=(DefaultTableModel)tblActividades.getModel();
        try
        {
            Bdd baseDatos= new Bdd();
            st = baseDatos.con.createStatement();
            rs=st.executeQuery("SELECT count(*) FROM Proyecto WHERE aceptado=1 AND eliminado=0");
            rs.next();
            numeroProyectos=rs.getInt("count(*)");
            
            idProyecto=new int[numeroProyectos];
            avanceProyecto=new int[numeroProyectos];
            nombreProyecto=new String[numeroProyectos];
            fechaCreacion=new String[numeroProyectos];
            fechaInicio=new String[numeroProyectos];
            
            if(numeroProyectos>0)
            {
                rs=st.executeQuery("SELECT idProyecto,titulo,fechaInicio,fechaCreacion FROM Proyecto WHERE aceptado=1 AND eliminado=0");
                for(int i =0; i<numeroProyectos;i++)
                {
                    rs.next();
                    idProyecto[i]=rs.getInt("idProyecto");
                    nombreProyecto[i]=rs.getString("titulo");
                    fechaCreacion[i]=rs.getString("fechaCreacion");
                    fechaInicio[i]=rs.getString("fechaInicio");
                }
                lblNumero.setText("/"+String.valueOf(numeroProyectos));
                
                //Actividades
                for(int i =0;i<numeroProyectos;i++)
                {
                    rs=st.executeQuery("SELECT count(*) FROM Actividades WHERE idProyecto="+idProyecto[i]+" AND eliminado=0");
                    rs.next();
                    int numeroActividadesTotales=rs.getInt("count(*)");
                    if(numeroActividadesTotales>0)
                    {
                        rs=st.executeQuery("SELECT count(*) FROM Actividades WHERE idProyecto="+idProyecto[i]+" AND eliminado=0 AND estado=1");
                        rs.next();
                        int numeroActividadesTerminadas=rs.getInt("count(*)");
                        avanceProyecto[i]=(int)(numeroActividadesTerminadas*100/numeroActividadesTotales);
                    }
                    else
                        avanceProyecto[i]=0;  
                }           
                //Fin Actividades
                 mostrarDatos();
            }
            else
             JOptionPane.showMessageDialog(null, "No hay ningun proyecto que gestionar");   
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error en BDD: "+e.toString());
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

        lblNumero = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        txtNumero = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNombreProyecto = new javax.swing.JLabel();
        lblNombreProyecto1 = new javax.swing.JLabel();
        lblFechaCreacion = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pbAvance = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProgramadores = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblActividades = new javax.swing.JTable();
        btnEliminarProgramador = new javax.swing.JButton();
        btnNuevoProgramador = new javax.swing.JButton();
        btnNuevaActividad = new javax.swing.JButton();
        btnEditarActividad = new javax.swing.JButton();
        btnEliminarActividad = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);

        lblNumero.setText("/Total");

        btnSiguiente.setText("Siguiente >");
        btnSiguiente.setToolTipText("Siguiente Proyecto");
        btnSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSiguienteMouseClicked(evt);
            }
        });

        btnAnterior.setText("< Anterior");
        btnAnterior.setToolTipText("Anterior Proyecto");
        btnAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnteriorMouseClicked(evt);
            }
        });

        txtNumero.setText("1");
        txtNumero.setToolTipText("Colocar Numero");
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumeroKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Nombre de Proyecto:");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("Fecha de Inicio:");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("Fecha de Creación:");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Avance del Proyecto:");

        pbAvance.setValue(50);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setText("Actividades Asignadas:");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setText("Programadores Asignados:");

        tblProgramadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Rol Proyecto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProgramadores);

        tblActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Tipo", "Fecha Inicio", "Fecha Fin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblActividades);

        btnEliminarProgramador.setText("Eliminar");
        btnEliminarProgramador.setToolTipText("Eliminar Programador");
        btnEliminarProgramador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarProgramadorMouseClicked(evt);
            }
        });

        btnNuevoProgramador.setText("Editar");
        btnNuevoProgramador.setToolTipText("Nuevo Editar Programadores");
        btnNuevoProgramador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoProgramadorMouseClicked(evt);
            }
        });

        btnNuevaActividad.setText("Nuevo");
        btnNuevaActividad.setToolTipText("Nueva Actividad");
        btnNuevaActividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevaActividadMouseClicked(evt);
            }
        });

        btnEditarActividad.setText("Editar");
        btnEditarActividad.setToolTipText("Editar Actividad");
        btnEditarActividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarActividadMouseClicked(evt);
            }
        });
        btnEditarActividad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEditarActividadKeyPressed(evt);
            }
        });

        btnEliminarActividad.setText("Eliminar");
        btnEliminarActividad.setToolTipText("Eliminar Actividad");
        btnEliminarActividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarActividadMouseClicked(evt);
            }
        });
        btnEliminarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActividadActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beanmanager/recursos/imagenes/home.png"))); // NOI18N
        jButton1.setToolTipText("");
        jButton1.setBorderPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pbAvance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFechaCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnEliminarProgramador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNuevoProgramador)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnEliminarActividad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditarActividad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNuevaActividad)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(btnAnterior)
                        .addGap(28, 28, 28)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(lblNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSiguiente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(262, Short.MAX_VALUE)
                    .addComponent(lblNombreProyecto1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(78, 78, 78)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAnterior)
                            .addComponent(btnSiguiente)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblNombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lblFechaCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lblFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(pbAvance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoProgramador)
                    .addComponent(btnEliminarProgramador)
                    .addComponent(btnNuevaActividad)
                    .addComponent(btnEditarActividad)
                    .addComponent(btnEliminarActividad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(98, 98, 98)
                    .addComponent(lblNombreProyecto1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(338, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSiguienteMouseClicked
        if(numeroActual<numeroProyectos)
        {
            numeroActual++;
            txtNumero.setText(String.valueOf(numeroActual));
            mostrarDatos();
        }
    }//GEN-LAST:event_btnSiguienteMouseClicked

    private void btnAnteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnteriorMouseClicked
      if(numeroActual>1)
        {
            numeroActual--;
            txtNumero.setText(String.valueOf(numeroActual));
            mostrarDatos();
        }
    }//GEN-LAST:event_btnAnteriorMouseClicked

    private void txtNumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyPressed

        if(evt.getExtendedKeyCode()==10||evt.getExtendedKeyCode()==13)
            try
            {
                int n=Integer.parseInt(txtNumero.getText());
                if(n>0 && n<=numeroProyectos)
                {
                    numeroActual =n;
                    mostrarDatos();
                }
                else
                    txtNumero.setText(Integer.toString(numeroActual));
                
            }
            catch(Exception e)
            {
                txtNumero.setText(Integer.toString(numeroActual));
            }
    }//GEN-LAST:event_txtNumeroKeyPressed

    private void btnEliminarActividadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarActividadMouseClicked
        try{
            if(tblActividades.getSelectedRow()>=0)
            {
                int reply = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar la Actividad Seleccionada?", "Eliminar Actividad", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                  st.executeUpdate("UPDATE Actividades SET eliminado=1 WHERE idActividad="+String.valueOf(idActividad[tblActividades.getSelectedRow()]));
                  mostrarDatos();
                }   
            }
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "Error en BDD: "+e.toString());
        }
    }//GEN-LAST:event_btnEliminarActividadMouseClicked

    private void btnEliminarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActividadActionPerformed
        
    }//GEN-LAST:event_btnEliminarActividadActionPerformed

    private void btnEliminarProgramadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarProgramadorMouseClicked
        try{
            if( tblProgramadores.getSelectedRow()>=0)
            {
                int reply = JOptionPane.showConfirmDialog(null, "¿Desea Sacar al Programador Seleccionado?", "Sacar Programador", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                  st.executeUpdate("UPDATE Integrantes SET eliminado=1 WHERE idIntegrante="+String.valueOf(idProgramador[tblProgramadores.getSelectedRow()]));
                  mostrarDatos();
                }   
            }      
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "Error en BDD: "+e.toString());
        }
    }//GEN-LAST:event_btnEliminarProgramadorMouseClicked

    private void btnEditarActividadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEditarActividadKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActividadKeyPressed

    private void btnEditarActividadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarActividadMouseClicked

        if( tblActividades.getSelectedRow()>=0)
        {
            Actividades Act = new Actividades(idProyecto[numeroActual-1],idActividad[tblActividades.getSelectedRow()]);
            Act.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnEditarActividadMouseClicked

    private void btnNuevaActividadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevaActividadMouseClicked

            Actividades Act = new Actividades(idProyecto[numeroActual-1]);
            Act.setVisible(true);
            this.setVisible(false);
        
    }//GEN-LAST:event_btnNuevaActividadMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        menuInicio Ini = new menuInicio();
        Ini.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1MouseClicked

    private void btnNuevoProgramadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoProgramadorMouseClicked
        Programadores Pro=new Programadores(idProyecto[numeroActual-1]);
        Pro.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnNuevoProgramadorMouseClicked

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
            java.util.logging.Logger.getLogger(IndexProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IndexProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IndexProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IndexProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IndexProyecto().setVisible(true);
            }
        });
    }

    
    //Metodos
    
    private void mostrarDatos()
    {
       lblNombreProyecto.setText(nombreProyecto[numeroActual-1]);
       lblFechaInicio.setText(fechaInicio[numeroActual-1]);
       lblFechaCreacion.setText(fechaCreacion[numeroActual-1]);
       pbAvance.setValue(avanceProyecto[numeroActual-1]);
       
       mostrarProgramadores();
       mostrarActividades();
       
    }
    
    private void mostrarProgramadores()
    {
        try{
            while(modelTblProgramadores.getRowCount()>0)
                modelTblProgramadores.removeRow(modelTblProgramadores.getRowCount()-1);
            
            rs=st.executeQuery("SELECT count(*) FROM Integrantes WHERE eliminado=0 AND idProyecto="+idProyecto[numeroActual-1]);
            rs.next();
            idProgramador=new int[rs.getInt("count(*)")];
            
            rs=st.executeQuery("SELECT A.idIntegrante,B.nombre,B.Apellido,C.rol FROM Integrantes A INNER JOIN Usuarios B on(A.idUsuario=B.idUsuario) INNER JOIN rolesProyecto C on(A.idrol=C.idrol) WHERE A.eliminado=0 AND A.idProyecto="+idProyecto[numeroActual-1]);
            int p=0;
            while(rs.next())
            {
                modelTblProgramadores.insertRow(modelTblProgramadores.getRowCount(), new Object[]{rs.getString("B.nombre"),rs.getString("B.apellido"),rs.getString("C.rol")});
                idProgramador[p]=rs.getInt("A.idIntegrante");
                p++;
            }
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "Error Mostrando Programadores: "+e.toString());
        }
    }
    private void mostrarActividades()
    {
        try{
            while(modelTblActividades.getRowCount()>0)
                modelTblActividades.removeRow(modelTblActividades.getRowCount()-1);
            
            rs=st.executeQuery("SELECT count(*) FROM Actividades WHERE eliminado=0 AND idProyecto="+idProyecto[numeroActual-1]);
            rs.next();
            idActividad=new int[rs.getInt("count(*)")];
            
            rs=st.executeQuery("SELECT A.idActividad,A.titulo,A.fechaInicio,A.fechaFinal,B.tipo FROM Actividades A INNER JOIN TiposActividad B on(A.idTipo=B.idTipo) WHERE A.eliminado=0 AND A.idProyecto="+idProyecto[numeroActual-1]);
            int p=0;
            while(rs.next())
            {
                modelTblActividades.insertRow(modelTblActividades.getRowCount(), new Object[]{rs.getString("A.titulo"),rs.getString("B.tipo"),rs.getString("A.fechaInicio"),rs.getString("A.fechaFinal")});
                idActividad[p]=rs.getInt("A.idActividad");
                p++;
            }
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "Error Mostrando Actividades: "+e.toString());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnEditarActividad;
    private javax.swing.JButton btnEliminarActividad;
    private javax.swing.JButton btnEliminarProgramador;
    private javax.swing.JButton btnNuevaActividad;
    private javax.swing.JButton btnNuevoProgramador;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaCreacion;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblNombreProyecto;
    private javax.swing.JLabel lblNombreProyecto1;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JProgressBar pbAvance;
    private javax.swing.JTable tblActividades;
    private javax.swing.JTable tblProgramadores;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
