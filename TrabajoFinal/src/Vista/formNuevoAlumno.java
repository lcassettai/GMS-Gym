/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorAlumno;
import Modelo.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static javax.management.Query.gt;
import javax.swing.JOptionPane;

/**
 *
 * @author Home
 */
public class formNuevoAlumno extends javax.swing.JFrame {

    int nuevo;
    ArrayList<Alumno> lista;

    public formNuevoAlumno() {
        initComponents();
        lista = new ArrayList<>();
        grupoSexo.add(rbMasculino);
        grupoSexo.add(rbFemenino);
        setResizable(false);
        nuevo = 0;
        foco();
        txtBuscarAlumno.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoSexo = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtTelefonoEmer = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        rbMasculino = new javax.swing.JRadioButton();
        rbFemenino = new javax.swing.JRadioButton();
        cboActivo = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtComentario = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlumnos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarAlumno = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestionar Alumnos");
        setMaximumSize(new java.awt.Dimension(724, 442));
        setMinimumSize(new java.awt.Dimension(724, 442));
        setSize(new java.awt.Dimension(724, 442));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel10.setText("Codigo :");

        jLabel11.setText("Nombre :");

        jLabel12.setText("Apellido :");

        jLabel13.setText("Fecha de Nacimiento :");

        jLabel14.setText("DNI :");

        jLabel15.setText("Sexo :");

        jLabel16.setText("Direccion :");

        jLabel17.setText("Telefono :");

        jLabel18.setText("Telefono Emergencia :");

        txtNombre.setEnabled(false);

        txtApellido.setEnabled(false);

        txtDni.setEnabled(false);

        txtDireccion.setEnabled(false);

        txtTelefono.setEnabled(false);
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtTelefonoEmer.setEnabled(false);

        lblCodigo.setText("-");

        jdcFecha.setEnabled(false);

        rbMasculino.setText("Masculino");
        rbMasculino.setEnabled(false);

        rbFemenino.setText("Femenino");
        rbFemenino.setEnabled(false);

        cboActivo.setSelected(true);
        cboActivo.setText("Activo");
        cboActivo.setEnabled(false);

        jLabel19.setText("Comentario :");

        txtComentario.setColumns(20);
        txtComentario.setRows(5);
        txtComentario.setEnabled(false);
        jScrollPane2.setViewportView(txtComentario);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCodigo)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(rbMasculino)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rbFemenino))
                        .addComponent(txtNombre)
                        .addComponent(txtApellido)
                        .addComponent(jdcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                        .addComponent(txtDni)
                        .addComponent(txtDireccion)))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cboActivo)
                        .addComponent(txtTelefono)
                        .addComponent(txtTelefonoEmer, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(lblCodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefonoEmer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboActivo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel13)
                            .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(rbMasculino)
                            .addComponent(rbFemenino))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Apellido", "Nombre", "DNI"
            }
        ));
        tblAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlumnosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblAlumnosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblAlumnos);

        jLabel1.setText("Buscar Alumno :");

        txtBuscarAlumno.setToolTipText("Puede realizar la busqueda por Nombre, Apellido o DNI");
        txtBuscarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarAlumnoActionPerformed(evt);
            }
        });
        txtBuscarAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarAlumnoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarAlumno)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevoChico.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setToolTipText("Agregar un nuevo alumno");
        btnNuevo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setToolTipText("Editar alumno");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/EliminarUsuario.png"))); // NOI18N
        btnEliminar.setText("Desactivar");
        btnEliminar.setToolTipText("El alumno no podra ingresar hasta que no vuelva a estar activo");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/CancelarCambios.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.setToolTipText("Volver al menu principal");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("Guardar Cambios");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        borrar();
        nuevo = 1;
        habilitar(true);
        tblAlumnos.clearSelection();
        tblAlumnos.enable(false);
        txtBuscarAlumno.enable(false);
        txtNombre.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblAlumnos.getSelectedRow() >= 0) {
            habilitar(true);
            nuevo = 2;
            tblAlumnos.enable(false);
            txtBuscarAlumno.enable(false);
            txtNombre.requestFocus(); 
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un alumno para poder editarlo", "Ayuda", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int codigoAlumno = tblAlumnos.getSelectedRow();
        if (codigoAlumno >= 0) {
            ControladorAlumno ca = new ControladorAlumno();
            ca.desactivarAlumno(false, Integer.parseInt(lblCodigo.getText()));
            JOptionPane.showMessageDialog(this, "Se desactivo la cuenta del alumno correctamente!", "Eliminar Alumno", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar la cuenta del alumno que desea desactivar", "Eliminar Alumno", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        habilitar(false);
        tblAlumnos.clearSelection();
        borrar();
        tblAlumnos.enable(true);
        txtBuscarAlumno.enable(true);
        txtBuscarAlumno.setText("");
        actualizarLista();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (validarCampos()) {
            Alumno a = new Alumno();

            a.setNombre(txtNombre.getText());
            a.setApellido(txtApellido.getText());
            a.setComentario(txtComentario.getText());
            a.setActivo(cboActivo.isSelected());
            if (rbFemenino.isSelected()) {
                a.setSexo(false);
            } else {
                a.setSexo(true);
            }
            a.setDireccion(txtDireccion.getText());
            a.setTelefono(txtTelefono.getText());
            a.setTelefonoEmergencia(txtTelefonoEmer.getText());
            a.setDni(txtDni.getText());

            //Necesito convertir formato date a timestamp para poder almacenarlo
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            String day = df.format(jdcFecha.getDate());
            a.setFechaNac(Timestamp.valueOf(day));

            ControladorAlumno ca = new ControladorAlumno();
            if (nuevo == 1) {
                ca.cargarAlumno(a);
                JOptionPane.showMessageDialog(this, "Se cargo el alumno correctamente", "Informe", JOptionPane.INFORMATION_MESSAGE);
            } else {
                if (nuevo == 2) {
                    a.setCodCliente(Integer.parseInt(lblCodigo.getText()));
                    ca.actualizarAlumno(a);
                    JOptionPane.showMessageDialog(this, "Se actualizo el alumno correctamente", "Informe", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            borrar();
            habilitar(false);
            nuevo = 0;
            tblAlumnos.enable(true);
            txtBuscarAlumno.enable(true);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        actualizarLista();
    }//GEN-LAST:event_formWindowActivated

    private void tblAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlumnosMouseClicked

    }//GEN-LAST:event_tblAlumnosMouseClicked

    private void txtBuscarAlumnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarAlumnoKeyReleased
        if (!txtBuscarAlumno.getText().isEmpty()) {
            ControladorAlumno ca = new ControladorAlumno();
            lista = ca.buscarAlumno(txtBuscarAlumno.getText());

            AlumnosTableModel alumnoTabla = new AlumnosTableModel(lista);
            tblAlumnos.setModel(alumnoTabla);
        } else {
            actualizarLista();
        }
    }//GEN-LAST:event_txtBuscarAlumnoKeyReleased

    private void txtBuscarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarAlumnoActionPerformed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped

    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void tblAlumnosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlumnosMousePressed
        try {
            int seleccionado = tblAlumnos.getSelectedRow();
            Integer dato = (Integer) tblAlumnos.getValueAt(seleccionado, 0);
            cargarCampos(dato);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "La tabla no esta habilitada", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_tblAlumnosMousePressed

    public Boolean validarCampos() {

        try {
            if (txtNombre.getText().isEmpty()) {
                throw new Exception("Ingrese el nombre del alumno");
            }

            if (txtApellido.getText().isEmpty()) {
                throw new Exception("Ingrese el apellido del alumno");
            }

            if (jdcFecha.getDate() == null) {
                throw new Exception("Ingrese la fecha de nacimiento");
            }

            if (txtDni.getText().isEmpty()) {
                throw new Exception("Ingrese el DNI del alumno");
            }

            if (!isNumeric(txtDni.getText())) {
                throw new Exception("El DNI debe ser un campo numerico");
            }

            if (rbMasculino.isSelected() == false && rbFemenino.isSelected() == false) {
                throw new Exception("Ingrese el sexo del alumno");
            }

            if (!txtTelefono.getText().isEmpty()) {
                if (!isNumeric(txtTelefono.getText())) {
                    throw new Exception("El telefono debe ser un campo numerico");
                }
            }

            if (!txtTelefonoEmer.getText().isEmpty()) {
                if (!isNumeric(txtTelefonoEmer.getText())) {
                    throw new Exception("El telefono de emergencia debe ser un campo numerico");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public void actualizarLista() {
        ControladorAlumno ca = new ControladorAlumno();
        lista = ca.traerAlumnos();

        AlumnosTableModel alumnos = new AlumnosTableModel(lista);
        tblAlumnos.setModel(alumnos);
    }

    public void cargarCampos(int i) {
        borrar();
        ControladorAlumno ca = new ControladorAlumno();
        Alumno a = ca.buscarAlumno(i);

        if (a != null) {
            lblCodigo.setText(Integer.toString(a.getCodCliente()));
            txtNombre.setText(a.getNombre());
            txtApellido.setText(a.getApellido());
            jdcFecha.setDate(a.getFechaNac());
            if (a.getSexo()) {
                rbMasculino.setSelected(true);
            } else {
                rbFemenino.setSelected(true);
            }

            txtDireccion.setText(a.getDireccion());
            txtDni.setText(a.getDni());
            txtTelefono.setText(a.getTelefono());
            txtTelefonoEmer.setText(a.getTelefonoEmergencia());
            txtComentario.setText(a.getComentario());
            cboActivo.setSelected(a.getActivo());

        }
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
            java.util.logging.Logger.getLogger(formNuevoAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formNuevoAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formNuevoAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formNuevoAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formNuevoAlumno().setVisible(true);
            }
        });
    }

    private void habilitar(Boolean x) {
        txtNombre.setEnabled(x);
        txtApellido.setEnabled(x);
        jdcFecha.setEnabled(x);
        rbFemenino.setEnabled(x);
        rbMasculino.setEnabled(x);
        txtDireccion.setEnabled(x);
        txtDni.setEnabled(x);
        txtTelefono.setEnabled(x);
        txtTelefonoEmer.setEnabled(x);
        btnNuevo.setEnabled(!x);
        btnEditar.setEnabled(!x);
        btnEliminar.setEnabled(!x);
        btnCancelar.setEnabled(x);
        cboActivo.setEnabled(x);
        txtComentario.setEnabled(x);
        btnGuardar.setEnabled(x);
    }

    private void borrar() {
        txtNombre.setText("");
        txtApellido.setText("");
        rbFemenino.setSelected(false);
        rbMasculino.setSelected(false);
        txtDireccion.setText("");
        txtDni.setText("");
        txtTelefono.setText("");
        txtTelefonoEmer.setText("");
        cboActivo.setSelected(true);
        jdcFecha.setDate(null);
        txtComentario.setText("");
        lblCodigo.setText("-");
    }

    private static boolean isNumeric(String cadena) {
        try {
            Float.parseFloat(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    
    private void foco(){
        txtBuscarAlumno.setNextFocusableComponent(btnNuevo);
        btnNuevo.setNextFocusableComponent(btnEditar);
        btnEditar.setNextFocusableComponent(btnEliminar);       
        btnEliminar.setNextFocusableComponent(btnGuardar);
        btnGuardar.setNextFocusableComponent(btnEliminar);
        btnEliminar.setNextFocusableComponent(btnSalir);
        txtNombre.setNextFocusableComponent(txtApellido);
        txtApellido.setNextFocusableComponent(jdcFecha);
        jdcFecha.setNextFocusableComponent(txtDni);
        txtDni.setNextFocusableComponent(rbMasculino);
        rbMasculino.setNextFocusableComponent(rbFemenino);
        rbFemenino.setNextFocusableComponent(txtDireccion);
        txtDireccion.setNextFocusableComponent(txtTelefono);
        txtTelefono.setNextFocusableComponent(txtTelefonoEmer);
        txtTelefonoEmer.setNextFocusableComponent(cboActivo);
        cboActivo.setNextFocusableComponent(txtComentario);         
        txtComentario.setNextFocusableComponent(btnGuardar);
        btnGuardar.setNextFocusableComponent(btnCancelar);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox cboActivo;
    private javax.swing.ButtonGroup grupoSexo;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JRadioButton rbFemenino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JTable tblAlumnos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscarAlumno;
    private javax.swing.JTextArea txtComentario;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoEmer;
    // End of variables declaration//GEN-END:variables
}
