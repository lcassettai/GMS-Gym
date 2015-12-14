/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorAlumno;
import Controlador.ControladorAsistencias;
import Controlador.ControladorEmpleados;
import Controlador.ControladorPagos;
import Modelo.Alumno;
import Modelo.Empleado;
import Modelo.Inscripcion;
import java.awt.JobAttributes;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Home
 */
public class FormControlAsistencia extends javax.swing.JFrame {

    /**
     * Creates new form FomrControlAsistencias
     */
    Alumno alumno;
    Empleado empleado;
    ControladorAsistencias controladorAsist;

    public FormControlAsistencia() {
        initComponents();

        this.setLocationRelativeTo(null);
        controladorAsist = new ControladorAsistencias();
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
        txtDNI = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Control de Asistencias");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("Ingrese su DNI");

        txtDNI.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtDNI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setText("Bienvenido!");

        btnAceptar.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(414, 414, 414)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(396, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyTyped
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_ENTER) {
            validarAcceso();
        }
    }//GEN-LAST:event_txtDNIKeyTyped

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        validarAcceso();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void validarAcceso() {
        String dni = txtDNI.getText();

        if (buscarAlumno(dni)) {
            controladorAsist.asistenciaAlumno(alumno.getCodCliente());
            JOptionPane.showMessageDialog(this, "Bienvenido Alumno");
            alumno = null;
        } else {
            if (buscarEmpleado(dni)) {
                controladorAsist.asistenciaEmpleado(empleado.getCodEmpleado());
                JOptionPane.showMessageDialog(this, "Bienvenido Empleado");
                empleado = null;
            } else {
                JOptionPane.showMessageDialog(this, "Usted no se encuentra habilitado para ingresar");
            }
        }
        txtDNI.setText("");
    }

    private boolean buscarAlumno(String dni) {
        ControladorAlumno ca = new ControladorAlumno();
        alumno = ca.buscarAlumnoDNI(dni);
        if (verificarEstado(alumno.getCodCliente()) && alumno.getCodCliente() > 0) {
            return true;
        } else {
            return false;
        }

    }

    private boolean buscarEmpleado(String dni) {
        ControladorEmpleados ce = new ControladorEmpleados();
        empleado = ce.buscarEmpleadoDNI(dni);

        return empleado.getCodEmpleado() > 0;
    }

    public Boolean verificarEstado(int codAlumno) {
        Boolean habilitado = false;
        ControladorPagos cp = new ControladorPagos();
        ArrayList<Inscripcion> listaInscripciones = cp.buscarInscripciones(codAlumno);
        Date fechaActual = new Date();

        for (Inscripcion lstInscrip : listaInscripciones) {
            if (lstInscrip.getHabilitado() == true) {
                if (lstInscrip.getDiasVencimiento() > 0) {
                    if (fechaActual.before(lstInscrip.getFechaFin())) {
                        habilitado = true;
                        break;
                    }
                }
            }
        }

        return habilitado;
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
            java.util.logging.Logger.getLogger(FormControlAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormControlAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormControlAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormControlAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormControlAsistencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtDNI;
    // End of variables declaration//GEN-END:variables
}
