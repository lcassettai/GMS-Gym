package Vista;

import Controlador.ControladorAlumno;
import Controlador.ControladorPagos;
import Modelo.Alumno;
import Modelo.Deudor;
import Modelo.Inscripcion;
import Modelo.InscripcionesTableModel;
import Modelo.Usuario;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FormMenuPrincipal extends javax.swing.JFrame {

    Usuario login;
    ArrayList<Alumno> listaAlumnos = new ArrayList<>();

    public FormMenuPrincipal() {
        initComponents();
        login = new Usuario();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(java.awt.SystemColor.activeCaption);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Iconos/Pesas3.png"));


        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanel1 = new javax.swing.JPanel();
        btnNuevoAlumno = new javax.swing.JButton();
        btnNuevoPago = new javax.swing.JButton();
        btnBuscarCliente = new javax.swing.JButton();
        btnVerAsistencia = new javax.swing.JButton();
        btnReservaNueva = new javax.swing.JButton();
        btnNuevaReserva = new javax.swing.JButton();
        btnSalir1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstBusquedaRapida = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblDeuda = new javax.swing.JLabel();
        lblNombreApellido = new javax.swing.JLabel();
        lblMatricula = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblInscripcion = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        lblIdSesion = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        itmIniciar = new javax.swing.JMenu();
        miIniciar = new javax.swing.JMenuItem();
        miCerrar = new javax.swing.JMenuItem();
        itmAbmAlumno = new javax.swing.JMenu();
        miAbmAlumno = new javax.swing.JMenuItem();
        miAbmReservas = new javax.swing.JMenuItem();
        miAbmEmpleados = new javax.swing.JMenuItem();
        miAbmActividades = new javax.swing.JMenuItem();
        miAbmPromociones = new javax.swing.JMenuItem();
        miAbmClases = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        miInformPago = new javax.swing.JMenuItem();
        miInformAsistencia = new javax.swing.JMenuItem();
        miInformDeudor = new javax.swing.JMenuItem();
        clasesActivas = new javax.swing.JMenuItem();
        GananciasDelAño = new javax.swing.JMenuItem();
        miAyuda = new javax.swing.JMenu();
        jmOpciones = new javax.swing.JMenu();
        cbMostrarAsistencia = new javax.swing.JCheckBoxMenuItem();
        cbLimpiarCampos = new javax.swing.JCheckBoxMenuItem();
        miSalir = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gym Management System GMS Cassettai Luciano");
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(950, 544));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);

        btnNuevoAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevoChico.png"))); // NOI18N
        btnNuevoAlumno.setText("Nuevo Alumno");
        btnNuevoAlumno.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNuevoAlumno.setEnabled(false);
        btnNuevoAlumno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNuevoAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoAlumnoActionPerformed(evt);
            }
        });

        btnNuevoPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevoPagoChico.png"))); // NOI18N
        btnNuevoPago.setText("Nuevo Pago");
        btnNuevoPago.setEnabled(false);
        btnNuevoPago.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNuevoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPagoActionPerformed(evt);
            }
        });

        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar2.png"))); // NOI18N
        btnBuscarCliente.setText("Cancelar Deuda");
        btnBuscarCliente.setEnabled(false);
        btnBuscarCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        btnVerAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/AsistenciaChico.png"))); // NOI18N
        btnVerAsistencia.setText("Ver Asistencias");
        btnVerAsistencia.setEnabled(false);
        btnVerAsistencia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVerAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerAsistenciaActionPerformed(evt);
            }
        });

        btnReservaNueva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ReservaChico.png"))); // NOI18N
        btnReservaNueva.setText("Nueva Reserva");
        btnReservaNueva.setEnabled(false);
        btnReservaNueva.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReservaNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservaNuevaActionPerformed(evt);
            }
        });

        btnNuevaReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/HistorialPAgos.png"))); // NOI18N
        btnNuevaReserva.setText("Historial Pagos");
        btnNuevaReserva.setEnabled(false);
        btnNuevaReserva.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNuevaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaReservaActionPerformed(evt);
            }
        });

        btnSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/SalirChico.png"))); // NOI18N
        btnSalir1.setText("Salir");
        btnSalir1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevoAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevoPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(btnVerAsistencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReservaNueva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevaReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNuevoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReservaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVerAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(btnSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(java.awt.SystemColor.activeCaption);

        lstBusquedaRapida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lstBusquedaRapida.setEnabled(false);
        lstBusquedaRapida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstBusquedaRapidaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lstBusquedaRapidaMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(lstBusquedaRapida);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
        );

        jPanel3.setBackground(java.awt.SystemColor.activeCaption);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Matricula Alumno :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Alumno :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Deuda :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Estado :");

        lblEstado.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblEstado.setText("-");

        lblDeuda.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDeuda.setText("-");

        lblNombreApellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombreApellido.setText("-");

        lblMatricula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMatricula.setText("-");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreApellido)
                    .addComponent(lblMatricula)
                    .addComponent(lblEstado)
                    .addComponent(lblDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblMatricula))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(lblNombreApellido))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblEstado))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblDeuda))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel5)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Sesion Actual :");

        jPanel4.setBackground(java.awt.SystemColor.activeCaption);

        tblInscripcion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Actividad", "Fecha Inicio", "Fecha Fin", "Dias Restantes"
            }
        ));
        tblInscripcion.setToolTipText("");
        tblInscripcion.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblInscripcion);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel5.setBackground(java.awt.SystemColor.activeCaption);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Buscar :");

        txtBuscar.setEnabled(false);
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(20, 20, 20))
        );

        lblIdSesion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblIdSesion.setForeground(new java.awt.Color(0, 153, 0));
        lblIdSesion.setText("-");

        itmIniciar.setText("Sesion");

        miIniciar.setText("Iniciar Sesion");
        miIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miIniciarActionPerformed(evt);
            }
        });
        itmIniciar.add(miIniciar);

        miCerrar.setText("Cerrar Sesion");
        miCerrar.setEnabled(false);
        miCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCerrarActionPerformed(evt);
            }
        });
        itmIniciar.add(miCerrar);

        jMenuBar1.add(itmIniciar);

        itmAbmAlumno.setText("Gestionar");

        miAbmAlumno.setText("Alumnos");
        miAbmAlumno.setEnabled(false);
        miAbmAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAbmAlumnoActionPerformed(evt);
            }
        });
        itmAbmAlumno.add(miAbmAlumno);

        miAbmReservas.setText("Reservas");
        miAbmReservas.setEnabled(false);
        miAbmReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAbmReservasActionPerformed(evt);
            }
        });
        itmAbmAlumno.add(miAbmReservas);

        miAbmEmpleados.setText("Empleados");
        miAbmEmpleados.setEnabled(false);
        miAbmEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAbmEmpleadosActionPerformed(evt);
            }
        });
        itmAbmAlumno.add(miAbmEmpleados);

        miAbmActividades.setText("Actividades");
        miAbmActividades.setEnabled(false);
        miAbmActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAbmActividadesActionPerformed(evt);
            }
        });
        itmAbmAlumno.add(miAbmActividades);

        miAbmPromociones.setText("Promociones");
        miAbmPromociones.setEnabled(false);
        miAbmPromociones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAbmPromocionesActionPerformed(evt);
            }
        });
        itmAbmAlumno.add(miAbmPromociones);

        miAbmClases.setText("Clases");
        miAbmClases.setEnabled(false);
        miAbmClases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAbmClasesActionPerformed(evt);
            }
        });
        itmAbmAlumno.add(miAbmClases);

        jMenuBar1.add(itmAbmAlumno);

        jMenu5.setText("Informes");

        miInformPago.setText("Pagos");
        miInformPago.setEnabled(false);
        miInformPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miInformPagoActionPerformed(evt);
            }
        });
        jMenu5.add(miInformPago);

        miInformAsistencia.setText("Asistencias");
        miInformAsistencia.setEnabled(false);
        miInformAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miInformAsistenciaActionPerformed(evt);
            }
        });
        jMenu5.add(miInformAsistencia);

        miInformDeudor.setText("Deudores");
        miInformDeudor.setEnabled(false);
        miInformDeudor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miInformDeudorActionPerformed(evt);
            }
        });
        jMenu5.add(miInformDeudor);

        clasesActivas.setText("Clases Disponibles");
        clasesActivas.setEnabled(false);
        clasesActivas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clasesActivasActionPerformed(evt);
            }
        });
        jMenu5.add(clasesActivas);

        GananciasDelAño.setText("Ganancias del año en curso");
        GananciasDelAño.setEnabled(false);
        GananciasDelAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GananciasDelAñoActionPerformed(evt);
            }
        });
        jMenu5.add(GananciasDelAño);

        jMenuBar1.add(jMenu5);

        miAyuda.setText("Control de Asistencias");
        miAyuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miAyudaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                miAyudaMousePressed(evt);
            }
        });
        miAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAyudaActionPerformed(evt);
            }
        });
        jMenuBar1.add(miAyuda);

        jmOpciones.setText("Opciones");

        cbMostrarAsistencia.setSelected(true);
        cbMostrarAsistencia.setText("Mostrar Asistencias");
        cbMostrarAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMostrarAsistenciaActionPerformed(evt);
            }
        });
        jmOpciones.add(cbMostrarAsistencia);

        cbLimpiarCampos.setSelected(true);
        cbLimpiarCampos.setText("Limpiar Campos");
        jmOpciones.add(cbLimpiarCampos);

        jMenuBar1.add(jmOpciones);

        miSalir.setText("Salir");
        miSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miSalirMouseClicked(evt);
            }
        });
        miSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalirActionPerformed(evt);
            }
        });
        jMenuBar1.add(miSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblIdSesion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblIdSesion))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSalirActionPerformed

    }//GEN-LAST:event_miSalirActionPerformed

    private void miSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miSalirMouseClicked
        salir();
    }//GEN-LAST:event_miSalirMouseClicked

    private void btnReservaNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservaNuevaActionPerformed
        int i = lstBusquedaRapida.getSelectedIndex();
        if (i > -1) {
            if (tblInscripcion.getRowCount() > 0) {
                Alumno a = listaAlumnos.get(i);
                FormNuevasReservas fnr = new FormNuevasReservas();
                fnr.setAlumno(a);
                fnr.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "El alumno tiene ninguna pago registrado!", "Nueva Reserva", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un alumno!");
        }
    }//GEN-LAST:event_btnReservaNuevaActionPerformed

    private void btnNuevoAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoAlumnoActionPerformed
        formNuevoAlumno na = new formNuevoAlumno();
        na.setLocationRelativeTo(this);
        na.activarNuevo();
        na.setVisible(true);
    }//GEN-LAST:event_btnNuevoAlumnoActionPerformed

    private void miAbmEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAbmEmpleadosActionPerformed
        formNuevoEmpleado ne = new formNuevoEmpleado();
        ne.setLocationRelativeTo(this);
        ne.setVisible(true);
    }//GEN-LAST:event_miAbmEmpleadosActionPerformed

    private void miIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miIniciarActionPerformed
        formSesion sesion = new formSesion();
        sesion.setLocationRelativeTo(this);
        sesion.setUsuario(login);
        sesion.setVisible(true);
    }//GEN-LAST:event_miIniciarActionPerformed

    private void miCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCerrarActionPerformed
        habilitarAdministrador(false);
        borrar();
        limpiarTabla();
        ArrayList vacio = new ArrayList();
        lstBusquedaRapida.setListData(vacio.toArray());
    }//GEN-LAST:event_miCerrarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if (login.getTipoEmpleado() != 0) {
            if (login.getTipoEmpleado() == 3) {
                habilitarAdministrador(true);
                lblIdSesion.setText(login.getUsuario() + "(Administrador)");
            } else {
                habilitarEmpleado(true);
                lblIdSesion.setText(login.getUsuario());
            }
            borrar();
            limpiarTabla();
            actualizarAlumnos();
        }

    }//GEN-LAST:event_formWindowActivated

    private void miAbmActividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAbmActividadesActionPerformed
        formGestionarActividades fa = new formGestionarActividades();
        fa.setVisible(true);
    }//GEN-LAST:event_miAbmActividadesActionPerformed

    private void miAbmPromocionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAbmPromocionesActionPerformed
        FormGestionarPromociones fgp = new FormGestionarPromociones();
        fgp.setVisible(true);
    }//GEN-LAST:event_miAbmPromocionesActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if (!txtBuscar.getText().isEmpty()) {
            ControladorAlumno ca = new ControladorAlumno();
            listaAlumnos = ca.buscarAlumno(txtBuscar.getText());
            lstBusquedaRapida.setListData(listaAlumnos.toArray());
        } else {
            actualizarAlumnos();
        }

    }//GEN-LAST:event_txtBuscarKeyReleased

    private void lstBusquedaRapidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstBusquedaRapidaMouseClicked
//        int i = lstBusquedaRapida.getSelectedIndex();
//       
//        if (i >= 0) {
//            llenarCampos(i);
//        }
    }//GEN-LAST:event_lstBusquedaRapidaMouseClicked

    private void btnNuevoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPagoActionPerformed
        int i = lstBusquedaRapida.getSelectedIndex();
        if (i > -1) {
            Alumno a = listaAlumnos.get(i);
            formNuevoPago nvp = new formNuevoPago();
            nvp.setAlumno(a);
            nvp.setCodigoEmpleado(login.getIdUsuario());
            nvp.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un alumno!");
        }
    }//GEN-LAST:event_btnNuevoPagoActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed

        if (lstBusquedaRapida.getSelectedIndex() > -1) {
            Alumno a = listaAlumnos.get(lstBusquedaRapida.getSelectedIndex());
            if (a.verificarDeudas() > 0) {
                ControladorAlumno ca = new ControladorAlumno();
                Deudor d = ca.obtenerDeuda(a.getCodCliente());
                FormPagarDeuda fpd = new FormPagarDeuda();
                fpd.setearDeudorEmpleado(d.getIdDeudor(), login.getIdUsuario(), a.verificarDeudas(), a.getApellido());
                fpd.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "El Alumno no tiene deudas", "Cancelar deuda", JOptionPane.INFORMATION_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un alumno", "Cancelar deuda", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void miInformPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miInformPagoActionPerformed
        FormInformePagos fip = new FormInformePagos();
        fip.setVisible(true);
    }//GEN-LAST:event_miInformPagoActionPerformed

    private void btnVerAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerAsistenciaActionPerformed
        FormReportesAsistencias fra = new FormReportesAsistencias();
        fra.setVisible(true);
    }//GEN-LAST:event_btnVerAsistenciaActionPerformed

    private void miInformAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miInformAsistenciaActionPerformed
        FormReportesAsistencias fra = new FormReportesAsistencias();
        fra.setVisible(true);
    }//GEN-LAST:event_miInformAsistenciaActionPerformed

    private void miInformDeudorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miInformDeudorActionPerformed
        FormDeudores fd = new FormDeudores();
        fd.setVisible(true);
    }//GEN-LAST:event_miInformDeudorActionPerformed

    private void btnNuevaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaReservaActionPerformed
        FormReportePagos frp = new FormReportePagos();
        frp.setVisible(true);
    }//GEN-LAST:event_btnNuevaReservaActionPerformed

    private void lstBusquedaRapidaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstBusquedaRapidaMousePressed
        int i = lstBusquedaRapida.getSelectedIndex();
        if (i >= 0) {
            llenarCampos(i);
        }
    }//GEN-LAST:event_lstBusquedaRapidaMousePressed

    private void miAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAyudaActionPerformed

    }//GEN-LAST:event_miAyudaActionPerformed

    private void miAyudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miAyudaMouseClicked

    }//GEN-LAST:event_miAyudaMouseClicked

    public void test() {

    }

    private void miAyudaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miAyudaMousePressed
        FormControlAsistencia fca = new FormControlAsistencia();
        fca.setExtendedState(FormControlAsistencia.MAXIMIZED_BOTH);
        fca.setMenuPrincipal(this);
        fca.setVisible(true);
    }//GEN-LAST:event_miAyudaMousePressed

    private void miAbmClasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAbmClasesActionPerformed
        FormGestionarClases fgi = new FormGestionarClases();
        fgi.setVisible(true);
    }//GEN-LAST:event_miAbmClasesActionPerformed

    private void miAbmAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAbmAlumnoActionPerformed
        formNuevoAlumno na = new formNuevoAlumno();
        na.setLocationRelativeTo(this);
        na.setVisible(true);
    }//GEN-LAST:event_miAbmAlumnoActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed

    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void clasesActivasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clasesActivasActionPerformed
        FormClasesActivas fca = new FormClasesActivas();
        fca.setVisible(true);
    }//GEN-LAST:event_clasesActivasActionPerformed

    private void miAbmReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAbmReservasActionPerformed
        FormGestionarReservas fgr = new FormGestionarReservas();
        fgr.setVisible(true);
    }//GEN-LAST:event_miAbmReservasActionPerformed

    private void GananciasDelAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GananciasDelAñoActionPerformed
        FormGrafico fg = new FormGrafico();
        fg.setVisible(true);
    }//GEN-LAST:event_GananciasDelAñoActionPerformed

    private void cbMostrarAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMostrarAsistenciaActionPerformed

    }//GEN-LAST:event_cbMostrarAsistenciaActionPerformed

    private void salir() {
        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro que quiere salir?", "Salir", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }

    private void actualizarAlumnos() {
        ControladorAlumno ca = new ControladorAlumno();
        listaAlumnos = ca.traerAlumnosHabilitados();
        lstBusquedaRapida.setListData(listaAlumnos.toArray());
    }

    private void borrar() {
        if (cbLimpiarCampos.isSelected()) {
            lblDeuda.setText("-");
            lblEstado.setText("-");
            lblMatricula.setText("-");
            lblNombreApellido.setText("-");
            lstBusquedaRapida.clearSelection();
            lblEstado.setForeground(Color.black);
            lblDeuda.setForeground(Color.black);
            txtBuscar.setText("");
        }
    }

    private void limpiarTabla() {
        ArrayList<Inscripcion> listaVacia = new ArrayList<>();
        InscripcionesTableModel itm = new InscripcionesTableModel(listaVacia);
        tblInscripcion.setModel(itm);
    }

    //Metodo para habilitar las opciones a las cuales pueden acceder los empleados
    public void habilitarEmpleado(Boolean x) {
        miAbmAlumno.setEnabled(x);

        miAbmReservas.setEnabled(x);
        miIniciar.setEnabled(!x);
        miCerrar.setEnabled(x);
        btnBuscarCliente.setEnabled(x);
        btnNuevaReserva.setEnabled(x);
        btnNuevoAlumno.setEnabled(x);
        btnNuevoPago.setEnabled(x);
        btnVerAsistencia.setEnabled(x);
        tblInscripcion.setEnabled(x);
        lstBusquedaRapida.setEnabled(x);

        miInformAsistencia.setEnabled(x);
        miInformDeudor.setEnabled(x);
        miInformPago.setEnabled(x);
        txtBuscar.setEnabled(x);
        btnReservaNueva.setEnabled(x);
        clasesActivas.setEnabled(x);
        GananciasDelAño.setEnabled(x);
        jmOpciones.setEnabled(x);
        if (!x) {
            login.borrar();
            lblIdSesion.setText("-");
        }
    }

    //Metodo para habilitar opciones a las cuales pueden accceder los administradores
    public void habilitarAdministrador(Boolean x) {
        miAbmAlumno.setEnabled(x);
        miAbmClases.setEnabled(x);

        miAbmActividades.setEnabled(x);
        miAbmReservas.setEnabled(x);
        miIniciar.setEnabled(!x);
        miCerrar.setEnabled(x);
        btnBuscarCliente.setEnabled(x);
        btnNuevaReserva.setEnabled(x);
        btnNuevoAlumno.setEnabled(x);
        btnNuevoPago.setEnabled(x);
        btnVerAsistencia.setEnabled(x);
        tblInscripcion.setEnabled(x);
        lstBusquedaRapida.setEnabled(x);

        miInformAsistencia.setEnabled(x);
        miInformDeudor.setEnabled(x);
        miInformPago.setEnabled(x);
        miAbmEmpleados.setEnabled(x);
        miAbmPromociones.setEnabled(x);
        txtBuscar.setEnabled(x);
        btnReservaNueva.setEnabled(x);
        clasesActivas.setEnabled(x);
        GananciasDelAño.setEnabled(x);
        jmOpciones.setEnabled(x);
        if (!x) {
            login.borrar();
            lblIdSesion.setText("-");
        }
    }

    private void llenarCampos(int i) {
        Alumno a = listaAlumnos.get(i);
        lblMatricula.setText(String.valueOf(a.getCodCliente()));
        String nombreApellido = a.getApellido() + " " + a.getNombre();
        lblNombreApellido.setText(nombreApellido);
        lblDeuda.setText("$ " + String.valueOf(a.verificarDeudas()));
        if (a.verificarDeudas() == 0) {
            lblDeuda.setForeground(Color.decode("#009900"));
        } else {
            lblDeuda.setForeground(Color.RED);
        }

        if (a.verificarEstado(a)) {
            lblEstado.setText("Habilitado");
            lblEstado.setForeground(Color.decode("#009900"));
        } else {
            lblEstado.setText("Inhabilitado");
            lblEstado.setForeground(Color.RED);
        }
        ControladorPagos ca = new ControladorPagos();
        ArrayList<Inscripcion> listaInscripciones = ca.buscarInscripciones(a.getCodCliente());
        InscripcionesTableModel itm = new InscripcionesTableModel(listaInscripciones);
        tblInscripcion.setModel(itm);
    }

    public void llenarCampos(String dni) {

        if (cbMostrarAsistencia.isSelected()) {

            Alumno a = null;
            for (int i = 0; i < listaAlumnos.size(); i++) {
                if (listaAlumnos.get(i).getDni().equals(dni)) {
                    a = listaAlumnos.get(i);
                }
            }

            if (a != null) {
                lblMatricula.setText(String.valueOf(a.getCodCliente()));
                String nombreApellido = a.getApellido() + " " + a.getNombre();
                lblNombreApellido.setText(nombreApellido);
                lblDeuda.setText("$ " + String.valueOf(a.verificarDeudas()));
                if (a.verificarDeudas() == 0) {
                    lblDeuda.setForeground(Color.decode("#009900"));
                } else {
                    lblDeuda.setForeground(Color.RED);
                }

                if (a.verificarEstado(a)) {
                    lblEstado.setText("Habilitado");
                    lblEstado.setForeground(Color.decode("#009900"));
                } else {
                    lblEstado.setText("Inhabilitado");
                    lblEstado.setForeground(Color.RED);
                }
                ControladorPagos ca = new ControladorPagos();
                ArrayList<Inscripcion> listaInscripciones = ca.buscarInscripciones(a.getCodCliente());
                InscripcionesTableModel itm = new InscripcionesTableModel(listaInscripciones);
                tblInscripcion.setModel(itm);
            }
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
            java.util.logging.Logger.getLogger(FormMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem GananciasDelAño;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnNuevaReserva;
    private javax.swing.JButton btnNuevoAlumno;
    private javax.swing.JButton btnNuevoPago;
    private javax.swing.JButton btnReservaNueva;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JButton btnVerAsistencia;
    private javax.swing.JCheckBoxMenuItem cbLimpiarCampos;
    private javax.swing.JCheckBoxMenuItem cbMostrarAsistencia;
    private javax.swing.JMenuItem clasesActivas;
    private javax.swing.JMenu itmAbmAlumno;
    private javax.swing.JMenu itmIniciar;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenu jmOpciones;
    private javax.swing.JLabel lblDeuda;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblIdSesion;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblNombreApellido;
    private javax.swing.JList lstBusquedaRapida;
    private javax.swing.JMenuItem miAbmActividades;
    private javax.swing.JMenuItem miAbmAlumno;
    private javax.swing.JMenuItem miAbmClases;
    private javax.swing.JMenuItem miAbmEmpleados;
    private javax.swing.JMenuItem miAbmPromociones;
    private javax.swing.JMenuItem miAbmReservas;
    private javax.swing.JMenu miAyuda;
    private javax.swing.JMenuItem miCerrar;
    private javax.swing.JMenuItem miInformAsistencia;
    private javax.swing.JMenuItem miInformDeudor;
    private javax.swing.JMenuItem miInformPago;
    private javax.swing.JMenuItem miIniciar;
    private javax.swing.JMenu miSalir;
    private javax.swing.JTable tblInscripcion;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
