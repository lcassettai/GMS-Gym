package Controlador;

import Modelo.Actividad;
import Modelo.Clase;
import Modelo.Dias;
import Modelo.Empleado;
import Modelo.Inscripcion;
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

    public ArrayList<Clase> obtenerHorarioDisponible(int codActividad, int codEmpleado, int idDia) {
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
                i.setIdInscripcion(rs.getInt(7));
                i.setTipoActividad(rs.getString(8));
                i.setCantDias(i.getDiasVencimiento() / 4);
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

    public int obtenerClaseSeleccionada(int codActividad, int codEmpleado, int idDia, String horario) {
        int idClaseSeleccionada = 0;
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "exec obtenerClaseSeleccionada " + codActividad + "," + codEmpleado + "," + idDia + ",'" + horario + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idClaseSeleccionada = rs.getInt(1);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("No se pudo obtener la clase seleccionada, motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
        return idClaseSeleccionada;
    }

    public void agregarNuevaReserva(int idInscripcion, int codClase, int codCliente) {
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "exec nuevaReserva " + idInscripcion + "," + codClase + "," + codCliente;
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo insertar la inscripcion motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
    }

    public boolean verificarReservaAlumno(int idInscripcion, int codClase, int codCliente) {
        boolean existe = true;
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "exec verificarReservaAlumno " + idInscripcion + "," + codClase + "," + codCliente;
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                existe = false;
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("No se puede verificar las reservas, motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
        return existe;
    }

    public boolean verificarCupoReservas(int codClase) {
        boolean existe = false;
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "exec verificarCupoClases " + codClase;
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                if (rs.getInt(1) > 0) {
                    existe = true;
                }
            } else {
                existe = true;
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("No se puede verificar el cupo,motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
        return existe;
    }

    public int obtenerNumeroInscriptos(int codClase) {
        int inscriptos = 0;
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "   select count(*) from reservas where habilitado = 'true' AND codClase = " + codClase;
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                inscriptos = rs.getInt(1);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("No se puede verificar el numero de inscriptos,motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
        return inscriptos;
    }

}
