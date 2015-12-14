package Controlador;

import Modelo.Asistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ControladorAsistencias {

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

    public void asistenciaAlumno(int idAlumno) {
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "SP_presenteAlumno " + idAlumno;
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo cargar la asistencia motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
    }

    public void asistenciaEmpleado(int idEmpleado) {
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "SP_presenteEmpleado " + idEmpleado;
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo cargar la asistencia motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
    }

    public ArrayList<Asistencia> obtenerAsistenciaAlumno(Asistencia a, Timestamp fechaInicio, Timestamp fechaFin) {
        ArrayList<Asistencia> lista = new ArrayList<>();

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = df.format(fechaInicio);
        String fecha2 = df.format(fechaFin);

        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "SP_obtenerAsistenciaAlumnos '%" + a.getApellido() + "%','%" + a.getNombre() + "%','%" + a.getDni() + "%','" + fecha + "','" + fecha2 + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Asistencia asistencia = new Asistencia();
                asistencia.setCodigo(rs.getInt(1));
                asistencia.setNombre(rs.getString(2));
                asistencia.setApellido(rs.getString(3));
                asistencia.setDni(rs.getString(4));
                asistencia.setFecha(rs.getString(5));
                asistencia.setHora(rs.getString(6));

                lista.add(asistencia);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo cargar la asistencia motivo : " + e.getMessage());
        } finally {
            desconectar();
        }

        return lista;
    }

    public ArrayList<Asistencia> obtenerAsistenciaEmpleado(Asistencia a, Timestamp fechaInicio, Timestamp fechaFin) {
        ArrayList<Asistencia> lista = new ArrayList<>();

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = df.format(fechaInicio);
        String fecha2 = df.format(fechaFin);

        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "SP_obtenerAsistenciaEmpleados '%" + a.getApellido() + "%','%" + a.getNombre() + "%','%" + a.getDni() + "%','" + fecha + "','" + fecha2 + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Asistencia asistencia = new Asistencia();
                asistencia.setCodigo(rs.getInt(1));
                asistencia.setNombre(rs.getString(2));
                asistencia.setApellido(rs.getString(3));
                asistencia.setDni(rs.getString(4));
                asistencia.setFecha(rs.getString(5));
                asistencia.setHora(rs.getString(6));

                lista.add(asistencia);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo cargar la asistencia motivo : " + e.getMessage());
        } finally {
            desconectar();
        }

        return lista;
    }

}
