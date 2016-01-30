package Controlador;

import Modelo.Actividad;
import Modelo.Clase;
import Modelo.Dias;
import Modelo.Empleado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ControladorReservas {

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

    public ArrayList<Actividad> obtenerActividades(int codAlumno) {
        ArrayList<Actividad> listaActividades = new ArrayList<>();
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "exec obtenerActividadInscripto " + codAlumno;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Actividad a = new Actividad();
                a.setActividad(rs.getString(1));
                a.setTipoActividad(rs.getInt(2));
                listaActividades.add(a);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("No se pudo obtener la lista de actividades, motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
        return listaActividades;
    }

    public ArrayList<Empleado> obtenerEmpleado(int codActividad) {
        ArrayList<Empleado> listaEmpleado = new ArrayList<>();
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "exec obtenerProfesorDeActividad " + codActividad;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Empleado e = new Empleado();
                e.setCodEmpleado(rs.getInt(1));
                e.setApellido(rs.getString(2));
                listaEmpleado.add(e);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("No se pudo obtener la lista de actividades, motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
        return listaEmpleado;
    }

    public ArrayList<Dias> obtenerDiasDisponibles(int codActividad, int codEmpleado) {
        ArrayList<Dias> listaDias = new ArrayList<>();
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "exec obtenerDiasActividadDisponible " + codEmpleado + "," + codActividad;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Dias d = new Dias();
                d.setIdDia(rs.getInt(1));
                d.setDia(rs.getString(2));
                listaDias.add(d);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("No se pudo obtener la lista de dias, motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
        return listaDias;
    }

    public ArrayList<Clase> obtenerHorarioDisponible(int codActividad, int codEmpleado,int idDia) {
        ArrayList<Clase> listaHorarios = new ArrayList<>();
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "exec obtenerHorarioDisponible " + codEmpleado + "," + codActividad + "," + idDia;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Clase c = new Clase();
                c.setIdClase(rs.getInt(1));
                c.setHoraInicio(rs.getString(2));
                c.setHoraFin(rs.getString(3));
                listaHorarios.add(c);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("No se pudo obtener la lista de horarios, motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
        return listaHorarios;
    }
}
