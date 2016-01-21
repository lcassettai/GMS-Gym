package Controlador;

import Modelo.Asistencia;
import Modelo.CuotaPaga;
import Modelo.DetalleCuotaPaga;
import Modelo.Deudor;
import Modelo.DeudorActivo;
import Modelo.Inscripcion;
import Modelo.ReporteTotalPagos;
import Modelo.detallePagoCuota;
import Modelo.pagoCuota;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ControladorPagos {

    Connection conexion;

    public void conectar() {
        try {
            CadenaConexion c = new CadenaConexion();
            String[] cadena = c.obtenerCadena();
            Class.forName(cadena[0]);
            conexion = DriverManager.getConnection(cadena[1], cadena[2], cadena[3]);
        } catch (Exception e) {
            System.out.println("No se pudo conectar a la BD motivo : " + e.getMessage());
        }

    }

    public void desconectar() {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            System.out.println("No se pudo desconectar de la BD motivo : " + e);
        }
    }

    public void registrarPagoCuota(pagoCuota p) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = df.format(p.getFecha());
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "exec SP_registrarPagoCuota '" + fecha + "'," + p.getMontoEntregadp() + ","
                    + "" + p.getCodAlumno() + "," + p.getCodEmpleado();
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo registrar el pago motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
    }

    public void registrarDetallePago(ArrayList<detallePagoCuota> detalles) {
        try {
            conectar();
            for (detallePagoCuota detalle : detalles) {
                Statement st = conexion.createStatement();
                String sql = "exec SP_registrarDetalle " + detalle.getMonto() + "," + detalle.getIdPromocion() + "," + detalle.getIdActividad() + "," + detalle.getMontoDescuento();
                st.executeUpdate(sql);
                st.close();
            }
        } catch (Exception e) {
            System.out.println("No se pudieron registrar los detalles motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
    }

    public void registrarInscripcion(ArrayList<Inscripcion> inscripciones) {

        try {
            conectar();
            for (Inscripcion insc : inscripciones) {
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String fecIn = df.format(insc.getFechaIn());
                String fecFin = df.format(insc.getFechaFin());
                Statement st = conexion.createStatement();
                String sql = "exec SP_registrarInscripciones '" + fecIn + "','" + fecFin + "'," + insc.getDiasVencimiento() + ","
                        + "" + insc.getIdActividad() + "," + insc.getCodAlumno();
                st.executeUpdate(sql);
                st.close();
            }

        } catch (Exception e) {
            System.out.println("No se pudieron registrar las inscripciones por el siguiente motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
    }

    public ArrayList<Inscripcion> buscarInscripciones(int idAlumno) {
        ArrayList<Inscripcion> lista = new ArrayList<>();
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "exec SP_buscarInscripcion " + idAlumno;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Inscripcion i = new Inscripcion();
                // a.codAlumno,actividad,fechaInicio,fechaFin,i.diasVencimiento,i.habilitado
                i.setCodAlumno(rs.getInt(1));
                i.setActividad(rs.getString(2));
                i.setFechaIn(rs.getTimestamp(3));
                i.setFechaFin(rs.getTimestamp(4));
                i.setDiasVencimiento(rs.getInt(5));
                i.setHabilitado(rs.getBoolean(6));
                lista.add(i);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo recuperar la lista de inscripciones ,motivo " + e.getMessage());
        } finally {
            desconectar();
        }
        return lista;
    }

    public void registrarDeudor(Deudor deudor) {
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "exec SP_registrarDeudor " + deudor.getMonto() + ",'" + false + "'," + deudor.getCodAlumno();
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo registrar el deudor, motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
    }

    public void saldarDeuda(float monto, int deudor, int codEmpleado, String detalle) {
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "exec SP_SaldarDeuda '','" + monto + "','" + deudor + "','" + codEmpleado + "','" + detalle + "'";
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo saldar la cuenta, motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
    }

    //Falta aplicar los filtros
    public ArrayList<CuotaPaga> obtenerCuotasPagas(String aluApellido, String empApellido, String dni, Timestamp fecIn, Timestamp fecFin) {

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = df.format(fecIn);
        String fecha2 = df.format(fecFin);

        ArrayList<CuotaPaga> lista = new ArrayList<>();
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "exec SP_BUSCARPAGOS '%" + aluApellido + "%','%" + empApellido + "%','%" + dni + "%','" + fecha + "','" + fecha2 + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                CuotaPaga cp = new CuotaPaga();
                cp.setIdPagoCuota(rs.getInt(1));
                cp.setApellidoAlumno(rs.getString(2));
                cp.setNombreAlumno(rs.getString(3));
                cp.setDni(rs.getString(4));
                cp.setFecha(rs.getString(5));
                cp.setApellidoEmpleado(rs.getString(6));
                cp.setMontoTotal(rs.getFloat(7));

                lista.add(cp);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo obtener las cuotas, motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
        return lista;
    }

    public ArrayList<DetalleCuotaPaga> obtenerDetalleCuotaPaga(int cuota) {
        ArrayList<DetalleCuotaPaga> lista = new ArrayList<>();
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "exec SP_BuscarDetallePago " + cuota;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                DetalleCuotaPaga dcp = new DetalleCuotaPaga();
                dcp.setPromocion(rs.getString(1));
                dcp.setMontoDescuento(rs.getFloat(2));
                dcp.setActividad(rs.getString(3));
                dcp.setPrecioActividad(rs.getFloat(4));

                lista.add(dcp);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo obtener el detalle de las cuotas motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
        return lista;
    }

    public ArrayList<DeudorActivo> buscarDeudoresActivos(DeudorActivo da, Timestamp fechaInicio, Timestamp fechaFin) {
        ArrayList<DeudorActivo> deudores = new ArrayList<>();

        ArrayList<Asistencia> lista = new ArrayList<>();

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = df.format(fechaInicio);
        String fecha2 = df.format(fechaFin);

        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "SP_BuscarDeudores '%" + da.getAlumno() + "%','%" + da.getDni() + "%','" + fecha + "','" + fecha2 + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                DeudorActivo deudor = new DeudorActivo();
                deudor.setIdDeudor(rs.getInt(1));
                deudor.setAlumno(rs.getString(2));
                deudor.setDni(rs.getString(3));
                deudor.setMonto(rs.getFloat(4));
                deudor.setFecha(rs.getString(5));
                deudor.setEstado(rs.getBoolean(6));
                deudores.add(deudor);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudieron obtener los deudores activos, motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
        return deudores;

    }

    public ArrayList<ReporteTotalPagos> obtenerTotal(Timestamp desde, Timestamp hasta) {

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = df.format(desde);
        String fecha2 = df.format(hasta);

        ArrayList<ReporteTotalPagos> lista = new ArrayList<>();
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "SP_reportesDetalladoTotalPagos '" + fecha + "','" + fecha2 + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ReporteTotalPagos rtp = new ReporteTotalPagos();
                rtp.setTipoPago(rs.getString(1));
                rtp.setAlumno(rs.getString(2));
                rtp.setActividad(rs.getString(3));
                rtp.setMonto(rs.getFloat(4));
                rtp.setPromocion(rs.getString(5));
                rtp.setDescuento(rs.getFloat(6));
                rtp.setEmpleado(rs.getString(7));
                rtp.setFecha(rs.getString(8));
                rtp.setHora(rs.getString(9));

                lista.add(rtp);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
        } finally {
            desconectar();
        }
        return lista;
    }

    public float obtenerTotalReporte(Timestamp desde, Timestamp hasta) {
        float resultado = 0;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = df.format(desde);
        String fecha2 = df.format(hasta);

        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = " SP_totalPagos '" + fecha + "','" + fecha2 + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                resultado = rs.getFloat(1);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
        } finally {
            desconectar();
        }
        return resultado;

    }

}
