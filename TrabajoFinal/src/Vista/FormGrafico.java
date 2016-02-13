package Vista;

import Controlador.ControladorPagos;
import javax.swing.ButtonGroup;
import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class FormGrafico extends javax.swing.JFrame {
    
    String[] mes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    
    public FormGrafico() {
        initComponents();
        ButtonGroup grupo1 = new ButtonGroup();
        grupo1.add(rbBarras);
        grupo1.add(rbArea);
        grupo1.add(rbLineas);        
        
        rbBarras.setSelected(true);
        setLocationRelativeTo(null);
        this.setResizable(false);
        setVisible(true);
        graficar();
    }
    
    public void graficar() {
        
        ControladorPagos cp = new ControladorPagos();
        Float[][] pagos = cp.obtenerArregloPagos();
        Float[][] deudores = cp.obtenerArregloDeudores();
        
        ChartPanel panel;
        JFreeChart chart = null;
        
        DefaultCategoryDataset data = new DefaultCategoryDataset();

        //Se recorre 12 veces por que son 12 meses
        for (int i = 0; i < 12; i++) {

            //Si el monto total de deudas de ese mes es mayor a cero lo agrega 
            //Caso contrario lo agrega con 0
            if (deudores[i][1] != null) {
                data.addValue(deudores[1][i], "Acreedores", mes[i]);
            } else {
                data.addValue(0, "Acreedores", mes[i]);
            }

            //Si el monto total de ganacia del mes es mayor a cero lo agrega
            //Caso contrario el monto de ganancia es cero
            if (pagos[i][1] != null) {
                data.addValue(pagos[1][i], "Ganancias", mes[i]);
            } else {
                data.addValue(0, "Ganancias", mes[i]);
            }            
        }

       
        
        if (rbBarras.isSelected()) {
            chart = ChartFactory.createBarChart("Total del ganancias del año en curso",
                    "Mes",
                    "Monto",
                    data,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    true);
            CategoryPlot plot = (CategoryPlot) chart.getPlot();
            plot.setDomainGridlinesVisible(true);
            
            panel = new ChartPanel(chart);
            panel.setBounds(20, 20, 1000, 400);
            barras.removeAll();
            barras.add(panel);
            barras.repaint();
        } else if (rbArea.isSelected()) {
            chart = ChartFactory.createAreaChart("Total del ganancias del año en curso",
                    "Mes",
                    "Monto",
                    data,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    true);
            CategoryPlot plot = (CategoryPlot) chart.getPlot();
            plot.setDomainGridlinesVisible(true);
            
            panel = new ChartPanel(chart);
            panel.setBounds(20, 20, 1000, 400);
            barras.removeAll();
            barras.add(panel);
            barras.repaint();
        } else {
            chart = ChartFactory.createLineChart("Total del ganancias del año en curso",
                    "Mes",
                    "Monto",
                    data,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    true);
            CategoryPlot plot = (CategoryPlot) chart.getPlot();
            plot.setDomainGridlinesVisible(true);
            
            panel = new ChartPanel(chart);
            panel.setBounds(20, 20, 1000, 400);
            barras.removeAll();
            barras.add(panel);
            barras.repaint();
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barras = new javax.swing.JPanel();
        rbBarras = new javax.swing.JRadioButton();
        rbLineas = new javax.swing.JRadioButton();
        rbArea = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grafico de Ganancias");
        setBackground(new java.awt.Color(255, 255, 255));

        barras.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout barrasLayout = new javax.swing.GroupLayout(barras);
        barras.setLayout(barrasLayout);
        barrasLayout.setHorizontalGroup(
            barrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        barrasLayout.setVerticalGroup(
            barrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );

        rbBarras.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbBarras.setText("Barras");
        rbBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbBarrasActionPerformed(evt);
            }
        });

        rbLineas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbLineas.setText("Linea");
        rbLineas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbLineasItemStateChanged(evt);
            }
        });
        rbLineas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbLineasStateChanged(evt);
            }
        });
        rbLineas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbLineasActionPerformed(evt);
            }
        });

        rbArea.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbArea.setText("Area");
        rbArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAreaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Seleccione el tipo de grafico :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbBarras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbLineas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbArea)
                .addContainerGap(652, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(barras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbBarras)
                    .addComponent(rbLineas)
                    .addComponent(rbArea)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBarrasActionPerformed
        graficar();
    }//GEN-LAST:event_rbBarrasActionPerformed

    private void rbLineasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbLineasActionPerformed
        graficar();
    }//GEN-LAST:event_rbLineasActionPerformed

    private void rbAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAreaActionPerformed
        graficar();
    }//GEN-LAST:event_rbAreaActionPerformed

    private void rbLineasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbLineasItemStateChanged

    }//GEN-LAST:event_rbLineasItemStateChanged

    private void rbLineasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbLineasStateChanged

    }//GEN-LAST:event_rbLineasStateChanged

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
            java.util.logging.Logger.getLogger(FormGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormGrafico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton rbArea;
    private javax.swing.JRadioButton rbBarras;
    private javax.swing.JRadioButton rbLineas;
    // End of variables declaration//GEN-END:variables
}
