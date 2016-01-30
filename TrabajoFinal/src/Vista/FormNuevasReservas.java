/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorReservas;
import Modelo.Actividad;
import Modelo.Alumno;
import Modelo.Clase;
import Modelo.Dias;
import Modelo.Empleado;
import java.util.ArrayList;

/**
 *
 * @author Noelia
 */
public class FormNuevasReservas extends javax.swing.JFrame {

    Alumno alumno;
    ArrayList<Actividad> listaActividades;
    ArrayList<Empleado> listaEmpleado;
    ArrayList<Dias> listaDias;
    ArrayList<Clase> listaHorario;

    public FormNuevasReservas() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public void setAlumno(Alumno a) {
        alumno = a;
        lblApellido.setText(alumno.getApellido() + ", " + alumno.getNombre());
        lblMatricula.setText(String.valueOf(alumno.getCodCliente()));
        obtenerActividad();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblMatricula = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        cboActividad = new javax.swing.JComboBox();
        cboDia = new javax.swing.JComboBox();
        cboHorario = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReservas = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnReservar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        cboProfesor = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reservas");

        jLabel1.setText("Matricula : ");

        jLabel2.setText("Alumno :");

        jLabel3.setText("Actividad :");

        jLabel4.setText("Dia :");

        jLabel5.setText("Horario :");

        lblMatricula.setText("-");

        lblApellido.setText("-");

        cboActividad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboActividadItemStateChanged(evt);
            }
        });
        cboActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboActividadActionPerformed(evt);
            }
        });

        cboDia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboDiaItemStateChanged(evt);
            }
        });

        tblReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Profesor", "Actividad", "Dia", "Horario"
            }
        ));
        jScrollPane1.setViewportView(tblReservas);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/agregarDetalle.png"))); // NOI18N
        btnAgregar.setText("Agregar");

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Remover.png"))); // NOI18N
        btnEliminar.setText("Eliminar");

        btnReservar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ReservaChico.png"))); // NOI18N
        btnReservar.setText("Reservar");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/SalirChico.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        cboProfesor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboProfesorItemStateChanged(evt);
            }
        });

        jLabel6.setText("Profesor :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(84, 84, 84)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboHorario, 0, 167, Short.MAX_VALUE)
                            .addComponent(cboDia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 120, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReservar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblMatricula))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblApellido))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cboActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cboProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar)
                    .addComponent(btnReservar)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboActividadActionPerformed

    }//GEN-LAST:event_cboActividadActionPerformed

    //Carga el combo box actividad con las actividades del alumno a las que esta inscripta
    private void obtenerActividad() {
        ControladorReservas cr = new ControladorReservas();
        listaActividades = cr.obtenerActividades(alumno.getCodCliente());
        for (int i = 0; i < listaActividades.size(); i++) {
            cboActividad.addItem(listaActividades.get(i).getActividad());
        }
    }

    //Al momento de cargar las actividades tambien cargar los profesores que estan 
    //Inscriptos en esas actividades

    private void cboActividadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboActividadItemStateChanged
        ControladorReservas cr = new ControladorReservas();

        cboProfesor.removeAllItems();

        int idActividad = obtenerActividadSeleccionada();

        if (idActividad > -1) {
            listaEmpleado = cr.obtenerEmpleado(idActividad);
            for (int i = 0; i < listaEmpleado.size(); i++) {
                cboProfesor.addItem(listaEmpleado.get(i).getApellido());
            }
        }
    }//GEN-LAST:event_cboActividadItemStateChanged

    private void cboDiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboDiaItemStateChanged
        int idActividad = obtenerActividadSeleccionada();
        int idEmpleado = obtenerProfesorSeleccionado();
        int idDia = obtenerDiaSeleccionado();

        cboHorario.removeAllItems();

        ControladorReservas cr = new ControladorReservas();
        listaHorario = cr.obtenerHorarioDisponible(idActividad, idEmpleado, idDia);

        for (int i = 0; i < listaHorario.size(); i++) {
            cboHorario.addItem(listaHorario.get(i).getHoraInicio() + " - " + listaHorario.get(i).getHoraFin());
        }
    }//GEN-LAST:event_cboDiaItemStateChanged

    private void cboProfesorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboProfesorItemStateChanged
        int idActividad = obtenerActividadSeleccionada();
        int idEmpleado = obtenerProfesorSeleccionado();
        cboDia.removeAllItems();

        ControladorReservas cr = new ControladorReservas();
        listaDias = cr.obtenerDiasDisponibles(idActividad, idEmpleado);

        for (int i = 0; i < listaDias.size(); i++) {
            cboDia.addItem(listaDias.get(i).getDia());
        }
    }//GEN-LAST:event_cboProfesorItemStateChanged

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReservarActionPerformed

    private int obtenerProfesorSeleccionado() {
        for (Empleado listaEmpleados : listaEmpleado) {
            if (listaEmpleados.getApellido().equals(cboProfesor.getSelectedItem())) {
                return listaEmpleados.getCodEmpleado();
            }
        }
        return -1;
    }

    private int obtenerActividadSeleccionada() {
        for (Actividad listaActividade : listaActividades) {
            if (listaActividade.getActividad().equals(cboActividad.getSelectedItem())) {
                return listaActividade.getTipoActividad();
            }
        }
        return -1;
    }

    private int obtenerDiaSeleccionado() {
        for (Dias listaDia : listaDias) {
            if (listaDia.getDia().equals(cboDia.getSelectedItem())) {
                return listaDia.getIdDia();
            }
        }
        return -1;
    }

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
            java.util.logging.Logger.getLogger(FormNuevasReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormNuevasReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormNuevasReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormNuevasReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormNuevasReservas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnReservar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboActividad;
    private javax.swing.JComboBox cboDia;
    private javax.swing.JComboBox cboHorario;
    private javax.swing.JComboBox cboProfesor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JTable tblReservas;
    // End of variables declaration//GEN-END:variables
}
