/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.util.Date;
import Controlador.ControladorActividades;
import Controlador.ControladorPagos;
import Controlador.ControladorPromociones;
import Modelo.Actividad;
import Modelo.Alumno;
import Modelo.Deudor;
import Modelo.Inscripcion;
import Modelo.Promocion;
import Modelo.detallePagoCuota;
import Modelo.pagoCuota;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Home
 */
public class formNuevoPago extends javax.swing.JFrame {

    /**
     * Creates new form formNuevoPago
     */
    private ArrayList<Actividad> listaActividades;
    private ArrayList<Promocion> listaPromociones;
    private ArrayList listaPago;
    private DefaultTableModel modelo;
    private float totalAPagar;
    private float montoEntregado;
    private Date fechaActual;
    private Alumno alumno;
    private int codigoEmpleado;
    private float montoTotalSinDescuento;
    private ArrayList<detallePagoCuota> listaDetalle;
    private ArrayList<Inscripcion> listaInscripcion;

    public formNuevoPago() {
        initComponents();
        fechaActual = new Date();
        jdcFechaInicio.setDate(fechaActual);
        jdcFechaFin.setDate(sumarFechasDias(fechaActual));
        this.setLocationRelativeTo(null);
        listaPago = new ArrayList();
        modelo = (DefaultTableModel) tblDetallePago.getModel();
        listaActividades = new ArrayList<>();
        listaPromociones = new ArrayList<>();
        cargarActividades();
        cargarPromociones();
        totalAPagar = 0;
        montoEntregado = 0;
        montoTotalSinDescuento = 0;
        listaDetalle = new ArrayList<>();
        listaInscripcion = new ArrayList<>();
        this.setResizable(false);
    }

    public void setAlumno(Alumno a) {
        alumno = a;
        lblApellido.setText(alumno.getApellido());
        lblCodigoAlumno.setText(String.valueOf(alumno.getCodCliente()));
        lblNombre.setText(alumno.getNombre());
    }

    public void setCodigoEmpleado(int codigo) {
        codigoEmpleado = codigo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblCodigoAlumno = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jdcFechaInicio = new com.toedter.calendar.JDateChooser();
        jdcFechaFin = new com.toedter.calendar.JDateChooser();
        cboActividades = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cboPromocion = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetallePago = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMontoEntregado = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lblMontoTotal = new javax.swing.JLabel();
        lblDescuentoTotal = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnPagar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo pago de cuota");

        jLabel1.setText("Codigo del Alumno :");

        jLabel2.setText("Apellido :");

        jLabel3.setText("Nombre :");

        jLabel5.setText("Actividad :");

        jLabel6.setText("Fecha Inicio :");

        jLabel7.setText("Fecha Finalizacion :");

        lblCodigoAlumno.setText("-");

        lblApellido.setText("-");

        lblNombre.setText("-");

        jLabel8.setText("Promocion :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jdcFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jdcFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboActividades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboPromocion, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodigoAlumno)
                            .addComponent(lblApellido)
                            .addComponent(lblNombre))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblCodigoAlumno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboActividades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jdcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jdcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboPromocion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        tblDetallePago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Actividad", "Fecha de Inicio", "Fecha de Fin", "Promocion", "Monto", "Descuento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetallePago.getTableHeader().setReorderingAllowed(false);
        tblDetallePago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDetallePagoMousePressed(evt);
            }
        });
        tblDetallePago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblDetallePagoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDetallePago);

        jLabel9.setText("Total a pagar :");

        lblTotal.setText("-");

        jLabel10.setText("Monto Entregado : ");

        txtMontoEntregado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMontoEntregadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoEntregadoKeyTyped(evt);
            }
        });

        jLabel11.setText("Monto total :");

        lblMontoTotal.setText("-");

        lblDescuentoTotal.setText("-");

        jLabel12.setText("Descuento total :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(463, 463, 463)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDescuentoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(483, 483, 483)
                        .addComponent(lblMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMontoEntregado, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblMontoTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblDescuentoTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtMontoEntregado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Pagar.png"))); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.setToolTipText("Pagar el total");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/SalirChico.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Remover.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Eliminar Actividad de la lista");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/agregarDetalle.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Agregar Nueva actividad a la lista");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btnPagar)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPagar)
                    .addComponent(btnSalir)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        //Obtengo la actividad y la promocion seleccionada
        
        if (validarFecha()) {
            Actividad a = listaActividades.get(cboActividades.getSelectedIndex());
            Promocion p = listaPromociones.get(cboPromocion.getSelectedIndex());
            float ValidacionDescuento = a.getPrecio() - p.getMonto();

            if (ValidacionDescuento > 0) {
                if (verificarActividadEnTabla(a.getActividad())) {
                    //obtengo el monto de la actividad
                    float precioActividad = a.getPrecio();

                    montoTotalSinDescuento += precioActividad;

                    float descuento = p.getMonto();

                    //el total a pagar es el precio de la actividad menos el descuento de la promocion
                    totalAPagar += precioActividad - descuento;

                    montoEntregado = totalAPagar;

                    lblMontoTotal.setText("$ " + String.valueOf(montoTotalSinDescuento));
                    txtMontoEntregado.setText(String.valueOf(montoEntregado));

                    actualizarTotal(totalAPagar);

                    String promo = p.getPromocion();
                    String act = a.getActividad();

                    float montoDescuento = p.getMonto();
                    SimpleDateFormat df = new SimpleDateFormat("dd-mm-YYYY");
                    String fecIn = df.format(jdcFechaInicio.getDate());
                    String fecFin = df.format(jdcFechaFin.getDate());

                    //Armo un arreglo con los datos del detalle
                    detallePagoCuota dpc = new detallePagoCuota();
                    dpc.setMonto(a.getPrecio());
                    dpc.setIdPromocion(p.getCodigo());
                    dpc.setIdActividad(a.getIdActividad());
                    dpc.setMontoDescuento(p.getMonto());

                    //Armo un arreglo con los datos para la inscripcion
                    Inscripcion insc = new Inscripcion();
                    insc.setCodAlumno(alumno.getCodCliente());
                    insc.setDiasVencimiento(a.getCantDias());
                    insc.setIdActividad(a.getIdActividad());

                    SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
                    String diaFin = df2.format(jdcFechaFin.getDate());

                    String diaIni = df2.format(jdcFechaInicio.getDate());

                    insc.setFechaFin(Timestamp.valueOf(diaFin));
                    insc.setFechaIn(Timestamp.valueOf(diaIni));

                    //Los agrego a la lista
                    listaInscripcion.add(insc);
                    listaDetalle.add(dpc);

                    modelo.addRow(new Object[]{act, fecIn, fecFin, promo, precioActividad, montoDescuento});
                    lblDescuentoTotal.setText("$ " + String.valueOf(montoTotalSinDescuento - totalAPagar));
                } else {
                    JOptionPane.showMessageDialog(this, "La actividad ya se encuentra en la lista", "Agregar Actividad", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "El monto del descuento no puede ser mayor al precio de la actividad", "Agregar Actividad", JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private boolean verificarActividadEnTabla(String actividad) {
        for (int i = 0; i < tblDetallePago.getRowCount(); i++) {
            if (actividad.equals((String) tblDetallePago.getValueAt(i, 0))) {
                return false;
            }
        }
        return true;
    }

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Esta seguro que desea salir?", "Salir", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int i = tblDetallePago.getSelectedRow();
        if (i > -1) {
            totalAPagar -= (float) modelo.getValueAt(i, 4) - (float) modelo.getValueAt(i, 5);
            montoEntregado = totalAPagar;

            montoTotalSinDescuento -= (float) modelo.getValueAt(i, 4);

            lblMontoTotal.setText("$ " + String.valueOf(montoTotalSinDescuento));
            txtMontoEntregado.setText(String.valueOf(montoEntregado));

            modelo.removeRow(i);
            listaInscripcion.remove(i);
            listaDetalle.remove(i);
            actualizarTotal(totalAPagar);
            lblDescuentoTotal.setText("$ " + String.valueOf(montoTotalSinDescuento - totalAPagar));
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un elemento para eliminar","Eliminar",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    private void tblDetallePagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDetallePagoKeyPressed

    }//GEN-LAST:event_tblDetallePagoKeyPressed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        //cargo un nuevo pago
        if (validarCampos()) {
            if (alumno.verificarDeudas() == 0) {
                if (montoEntregado < totalAPagar) {
                    float deuda = totalAPagar - montoEntregado;
                    if (JOptionPane.showConfirmDialog(this, "Se va a registrar un pago por : $ " + montoEntregado + "\nDesea continuar?", "Registrar pago", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        if (JOptionPane.showConfirmDialog(this, "Si continua se va a registrar a " + alumno.getApellido() + ",  " + alumno.getNombre()
                                + "\ncomo deudor/a por un monto de : $ " + deuda + "\nEsta seguro que desea continuar?", "Deudor", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            Deudor d = new Deudor(deuda, alumno.getCodCliente());
                            registrarTodo();
                            ControladorPagos cp = new ControladorPagos();
                            cp.registrarDeudor(d);
                        }
                    }
                } else {
                    if (JOptionPane.showConfirmDialog(this, "Se va a realizar un pago por : $ " + totalAPagar +"\nDesea continuar?", "Registrar pago", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        registrarTodo();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "El alumno no puede registrar un nuevo pago \n hasta cancelar su deuda de : $ " + alumno.verificarDeudas(),"Deuda",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void registrarTodo() {
        ControladorPagos cp = new ControladorPagos();

        pagoCuota pago = new pagoCuota();
        pago.setCodAlumno(alumno.getCodCliente());
        pago.setCodEmpleado(codigoEmpleado);
        pago.setMontoEntregadp(Float.parseFloat(txtMontoEntregado.getText()));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        String day = df.format(fechaActual);
        pago.setFecha(Timestamp.valueOf(day));

        //registro todos los datos en la base de datos
        cp.registrarPagoCuota(pago);
        cp.registrarDetallePago(listaDetalle);
        cp.registrarInscripcion(listaInscripcion);

        JOptionPane.showMessageDialog(this, "Se registro el pago con exito!","Pago Registrado",JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }

    private void txtMontoEntregadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoEntregadoKeyReleased
        if (txtMontoEntregado.getText().isEmpty()) {
            montoEntregado = totalAPagar;
        } else {
            montoEntregado = Float.parseFloat(txtMontoEntregado.getText());
        }
    }//GEN-LAST:event_txtMontoEntregadoKeyReleased

    private void tblDetallePagoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetallePagoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDetallePagoMousePressed

    private void txtMontoEntregadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoEntregadoKeyTyped
          char c=evt.getKeyChar();             
         
          if(Character.isLetter(c)) { 
              getToolkit().beep(); 
               
              evt.consume(); 
               
             
               
          } 
    }//GEN-LAST:event_txtMontoEntregadoKeyTyped

    private boolean validarCampos() {
        boolean bandera = true;
        float txtMonEntregado = -1;
        try {
            if (tblDetallePago.getRowCount() <= 0) {
                throw new Exception("Debe agregar almenos un elemento a la lista para pagar");
            }
            
            if(!isFloat(txtMontoEntregado.getText())){
                throw new Exception("El monto entregado debe ser de tipo numerico");
            }     
            
            if (txtMontoEntregado.getText().isEmpty()) {
                throw new Exception("Ingrese el monto entregado");
            } else {
                txtMonEntregado = Float.parseFloat(txtMontoEntregado.getText());
            }
            if (txtMonEntregado > totalAPagar) {
                throw new Exception("El monto entregado no puede ser mayor que el total a pagar ");
            }
            if (txtMonEntregado < 0) {
                throw new Exception("El monto entregado no puede ser menor a cero ");
            }
            
                       
               
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
            bandera = false;
        }
        return bandera;
    }

    private boolean validarFecha() {
        try {
            if (jdcFechaInicio.getDate() == null) {
                throw new Exception("Ingrese la fecha de inicio");
            }
            if (jdcFechaFin.getDate() == null) {
                throw new Exception("Ingrese la fecha de Fin");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
      private static boolean isFloat(String cadena) {
        try {
            Float.parseFloat(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static java.sql.Date sumarFechasDias(java.util.Date fch) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, 30);
        return new java.sql.Date(cal.getTimeInMillis());
    }

    private void actualizarTotal(float tot) {
        lblTotal.setText("$" + String.valueOf(tot));
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
            java.util.logging.Logger.getLogger(formNuevoPago.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formNuevoPago.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formNuevoPago.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formNuevoPago.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formNuevoPago().setVisible(true);
            }
        });
    }

    private void cargarPromociones() {
        ControladorPromociones cp = new ControladorPromociones();
        listaPromociones = cp.consultarPromociones();
        for (Promocion lstP : listaPromociones) {
            cboPromocion.addItem(lstP.getPromocion());
        }

    }

    private void cargarActividades() {
        ControladorActividades ca = new ControladorActividades();
        listaActividades = ca.buscarActividades();
        for (Actividad lstA : listaActividades) {
            cboActividades.addItem(lstA.getActividad());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboActividades;
    private javax.swing.JComboBox cboPromocion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFechaFin;
    private com.toedter.calendar.JDateChooser jdcFechaInicio;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCodigoAlumno;
    private javax.swing.JLabel lblDescuentoTotal;
    private javax.swing.JLabel lblMontoTotal;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblDetallePago;
    private javax.swing.JTextField txtMontoEntregado;
    // End of variables declaration//GEN-END:variables
}
