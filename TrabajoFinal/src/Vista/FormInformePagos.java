/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorPagos;
import Modelo.CuotaPaga;
import Modelo.CuotasPagaTableModel;
import Modelo.DetalleCuotaPaga;
import Modelo.DetalleCuotaTableModel;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;

public class FormInformePagos extends javax.swing.JFrame {

    private Date fechaActual;
    ArrayList<CuotaPaga> listaCuotaPaga;
    ArrayList<DetalleCuotaPaga> listaDetalle;

    public FormInformePagos() {
        initComponents();
        fechaActual = new Date();
        dtpFecIn.setDate(fechaActual);
        dtpFecFin.setDate(fechaActual);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        listaCuotaPaga = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCuotas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetalleCuota = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAlumno = new javax.swing.JTextField();
        txtEmpleado = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dtpFecIn = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        dtpFecFin = new com.toedter.calendar.JDateChooser();
        btnImprimir = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informe de pago de cuotas");

        tblCuotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Alumno", "DNI", "Fecha", "Empleado", "Monto Total"
            }
        ));
        tblCuotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCuotasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblCuotasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblCuotas);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cuotas ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tblDetalleCuota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Actividad", "Precio", "Promocion", "Descuento"
            }
        ));
        jScrollPane2.setViewportView(tblDetalleCuota);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Detalle Cuota");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(329, 329, 329)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setText("DNI Alumno :");

        jLabel4.setText("Apellido Alumno :");

        jLabel5.setText("Apellido Empleado :");

        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        jLabel6.setText("Fecha Inicio :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Filtrar Cuotas");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Search.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel8.setText("Fecha Fin :");

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Imprimir2.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/clear.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(dtpFecFin, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(txtAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(95, 95, 95)
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(dtpFecIn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(228, 228, 228)
                                .addComponent(btnBuscar)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar)
                                .addGap(18, 18, 18)
                                .addComponent(btnImprimir))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(339, 339, 339)
                                .addComponent(jLabel7)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addComponent(dtpFecIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8)
                    .addComponent(dtpFecFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnImprimir)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (validarCampos()) {
            String aluApellido = txtAlumno.getText();
            String empApellido = txtEmpleado.getText();
            String dni = txtDni.getText();

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            String day = df.format(dtpFecIn.getDate());
            Timestamp fechaIn = Timestamp.valueOf(day);

            String day2 = df.format(dtpFecFin.getDate());
            Timestamp fechaFin = Timestamp.valueOf(day2);

            ControladorPagos cp = new ControladorPagos();
            listaCuotaPaga = cp.obtenerCuotasPagas(aluApellido, empApellido, dni, fechaIn, fechaFin);

            if (listaCuotaPaga.size() > 0) {
                CuotasPagaTableModel tableModelCuota = new CuotasPagaTableModel(listaCuotaPaga);
                tblCuotas.setModel(tableModelCuota);
            } else {
                LimpiarJTable();
                JOptionPane.showMessageDialog(this, "No se encontraron resultados");
            }
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private Boolean validarCampos() {
        Boolean resultado = true;
        try {
            if (!txtDni.getText().isEmpty()) {
                if (!isNumber(txtDni.getText())) {
                    throw new Exception("El dni debe ser de tipo numerico");
                }
            }

            if (dtpFecIn.getDate() == null) {
                throw new Exception("Ingrese una fecha de inicio correcta");
            }

            if (dtpFecFin.getDate() == null) {
                throw new Exception("Ingrese una fecha de fin correcta");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return resultado;
    }

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        if (tblCuotas.getSelectedRow() > -1) {
            try {
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                String day = df.format(fechaActual);
                CuotaPaga cp = listaCuotaPaga.get(tblCuotas.getSelectedRow());

                PdfReader pdfTemplate = new PdfReader("template.pdf");
                FileOutputStream fileOutputStream = new FileOutputStream("PDF/PagoNro-" + cp.getIdPagoCuota() + "-Fec-" + day + ".pdf");
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                PdfStamper stamper = new PdfStamper(pdfTemplate, fileOutputStream);
                stamper.setFormFlattening(true);

                stamper.getAcroFields().setField("txtAlumno", cp.getApellidoAlumno() + " " + cp.getNombreAlumno());
                stamper.getAcroFields().setField("txtEmpleado", cp.getApellidoEmpleado());
                stamper.getAcroFields().setField("txtNroCuota", String.valueOf(cp.getIdPagoCuota()));
                stamper.getAcroFields().setField("txtDni", cp.getDni());
                stamper.getAcroFields().setField("txtFecha", cp.getFecha());
                stamper.getAcroFields().setField("txtTotal", String.valueOf(cp.getMontoTotal()));

                String ac = "";
                String precio = "";
                String prom = "";
                String desc = "";
                String impor = "";
                float imptTot;
                float descTot = 0;
                float subtotal = 0;

                for (DetalleCuotaPaga listDet : listaDetalle) {
                    ac += listDet.getActividad() + "\n";
                    precio += listDet.getPrecioActividad() + "\n";
                    desc += listDet.getMontoDescuento() + "\n";
                    imptTot = listDet.getPrecioActividad() - listDet.getMontoDescuento();
                    impor += imptTot + "\n";
                    descTot += listDet.getMontoDescuento();
                    subtotal += listDet.getPrecioActividad();
                }
                stamper.getAcroFields().setField("txtActividad", ac);
                stamper.getAcroFields().setField("txtPrecio", precio);
                stamper.getAcroFields().setField("txtDescuento", desc);
                stamper.getAcroFields().setField("txtImporte", impor);
                stamper.getAcroFields().setField("txtSubtotal", String.valueOf(subtotal));
                stamper.getAcroFields().setField("txtDescuentoTotal", String.valueOf(descTot));

                stamper.close();
                pdfTemplate.close();

                JOptionPane.showMessageDialog(this, "Se creo un nuevo comprobante \nNombre : PagoNro-" + cp.getIdPagoCuota() + "-Fec-" + day + ".pdf");

                int resp = JOptionPane.showConfirmDialog(null, "Desea abrir el archivo ? ", "Abrir Comprobante", JOptionPane.YES_NO_OPTION);
                if (resp == JOptionPane.YES_OPTION) {
                    try {
                        File path = new File("PDF/PagoNro-" + cp.getIdPagoCuota() + "-Fec-" + day + ".pdf");
                        Desktop.getDesktop().open(path);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un elemento de la lista!");
        }
    }//GEN-LAST:event_btnImprimirActionPerformed


    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtAlumno.setText("");
        txtDni.setText("");
        txtEmpleado.setText("");
        fechaActual = new Date();
        dtpFecIn.setDate(fechaActual);
        dtpFecFin.setDate(fechaActual);
        LimpiarJTable();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void LimpiarJTable() {
        listaCuotaPaga = new ArrayList<>();
        listaDetalle = new ArrayList<>();
        CuotasPagaTableModel tableModelCuota = new CuotasPagaTableModel(listaCuotaPaga);
        tblCuotas.setModel(tableModelCuota);

        DetalleCuotaTableModel tableDetalle = new DetalleCuotaTableModel(listaDetalle);
        tblDetalleCuota.setModel(tableDetalle);

    }
    private void tblCuotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCuotasMouseClicked

    }//GEN-LAST:event_tblCuotasMouseClicked

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped

    }//GEN-LAST:event_txtDniKeyTyped

    private void tblCuotasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCuotasMousePressed
        int i = tblCuotas.getSelectedRow();
        int seleccionado = tblCuotas.getSelectedRow();
        Integer dato = (Integer) tblCuotas.getValueAt(seleccionado, 0);
        cargarDetalle(dato);
    }//GEN-LAST:event_tblCuotasMousePressed

    private static boolean isNumber(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private void cargarDetalle(int i) {
        ControladorPagos cp = new ControladorPagos();
        listaDetalle = cp.obtenerDetalleCuotaPaga(i);

        DetalleCuotaTableModel tableDetalle = new DetalleCuotaTableModel(listaDetalle);
        tblDetalleCuota.setModel(tableDetalle);
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
            java.util.logging.Logger.getLogger(FormInformePagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormInformePagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormInformePagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormInformePagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormInformePagos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnLimpiar;
    private com.toedter.calendar.JDateChooser dtpFecFin;
    private com.toedter.calendar.JDateChooser dtpFecIn;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblCuotas;
    private javax.swing.JTable tblDetalleCuota;
    private javax.swing.JTextField txtAlumno;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEmpleado;
    // End of variables declaration//GEN-END:variables
}
