package Controlador;

import Modelo.Alumno;
import Modelo.Deudor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ControladorAlumno {

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

    public ArrayList<Alumno> traerAlumnos() {
        ArrayList<Alumno> lista = new ArrayList<>();

        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "SELECT codAlumno,nombre,apellido,fecNac,sexo,direccion,telefono,telefonoAyuda,dni,activo,comentario FROM alumnos";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Alumno a = new Alumno();
                a.setCodCliente(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setApellido(rs.getString(3));
                a.setFechaNac(rs.getTimestamp(4));
                a.setSexo(rs.getBoolean(5));
                a.setDireccion(rs.getString(6));
                a.setTelefono(rs.getString(7));
                a.setTelefonoEmergencia(rs.getString(8));
                a.setDni(rs.getString(9));
                a.setActivo(rs.getBoolean(10));
                a.setComentario(rs.getString(11));
                lista.add(a);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo traer los alumnos, motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
        return lista;
    }
    
        public ArrayList<Alumno> traerAlumnosHabilitados() {
        ArrayList<Alumno> lista = new ArrayList<>();

        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "exec obtenerAlumnosHabilitados";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Alumno a = new Alumno();
                a.setCodCliente(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setApellido(rs.getString(3));
                a.setFechaNac(rs.getTimestamp(4));
                a.setSexo(rs.getBoolean(5));
                a.setDireccion(rs.getString(6));
                a.setTelefono(rs.getString(7));
                a.setTelefonoEmergencia(rs.getString(8));
                a.setDni(rs.getString(9));
                a.setActivo(rs.getBoolean(10));
                a.setComentario(rs.getString(11));
                lista.add(a);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo traer los alumnos, motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
        return lista;
    }


    public Alumno buscarAlumno(int cod) {
        Alumno a = null;

        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "SELECT codAlumno,nombre,apellido,fecNac,sexo,direccion,telefono,"
                    + "telefonoAyuda,dni,activo,comentario FROM alumnos WHERE codAlumno = " + cod;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                a = new Alumno();
                a.setCodCliente(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setApellido(rs.getString(3));
                a.setFechaNac(rs.getTimestamp(4));
                a.setSexo(rs.getBoolean(5));
                a.setDireccion(rs.getString(6));
                a.setTelefono(rs.getString(7));
                a.setTelefonoEmergencia(rs.getString(8));
                a.setDni(rs.getString(9));
                a.setActivo(rs.getBoolean(10));
                a.setComentario(rs.getString(11));

            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo traer los alumnos, motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
        return a;
    }

    public ArrayList<Alumno> buscarAlumno(String alumno) {
        ArrayList<Alumno> lista = new ArrayList<>();

        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "exec buscarAlumno '%" + alumno + "%'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Alumno a = new Alumno();
                a.setCodCliente(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setApellido(rs.getString(3));
                a.setFechaNac(rs.getTimestamp(4));
                a.setSexo(rs.getBoolean(5));
                a.setDireccion(rs.getString(6));
                a.setTelefono(rs.getString(7));
                a.setTelefonoEmergencia(rs.getString(8));
                a.setDni(rs.getString(9));
                a.setActivo(rs.getBoolean(10));
                a.setComentario(rs.getString(11));
                lista.add(a);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo traer los alumnos, motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
        return lista;
    }

    public void cargarAlumno(Alumno a) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = df.format(a.getFechaNac());

        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "Insert into alumnos(nombre,apellido,fecNac,"
                    + "sexo,direccion,telefono,telefonoAyuda,dni,activo,"
                    + "comentario) values('" + a.getNombre() + "','" + a.getApellido() + "'"
                    + ",'" + fecha + "','" + a.getSexo() + "','" + a.getDireccion() + "','" + a.getTelefono() + "'"
                    + ",'" + a.getTelefonoEmergencia() + "','" + a.getDni() + "','" + a.getActivo() + "','" + a.getComentario() + "');";
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo cargar el alumno, motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
    }

    public void actualizarAlumno(Alumno a) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = df.format(a.getFechaNac());

        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "Update Alumnos set nombre = '" + a.getNombre() + "',"
                    + "apellido = '" + a.getApellido() + "',fecNac = '" + fecha + "',sexo = '"+a.getSexo()+"',direccion = '"+a.getDireccion()+"',"
                    + "telefono = '"+a.getTelefono()+"',telefonoAyuda = '"+a.getTelefonoEmergencia()+"',dni = '"+a.getDni()+"',activo = '"+a.getActivo()+"',"
                    + "comentario = '"+a.getComentario()+"' where codalumno = " + a.getCodCliente();
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo actualizar el alumno, motivo : " + e.getMessage());
        } finally {
            desconectar();
        }
    }
    
    
    public float verificarDeuda(int cod){
        float total = 0;
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "exec verificarDeuda " + cod;
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                total = rs.getFloat(2);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo recuprar la deuda motivo : " + e.getMessage());
        }
        finally{
            desconectar();
        }
        return total;
    }
    
    public Deudor obtenerDeuda(int codAlumno){
        Deudor d = new Deudor();
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "SELECT idDeudor,monto,pagado,codAlumno,idPagoCuota "
                       + "FROM deudores WHERE codAlumno = "+codAlumno+" AND pagado = 'false'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                d.setIdDeudor(rs.getInt(1));
                d.setMonto(rs.getFloat(2));
                d.setPagado(rs.getBoolean(3));
                d.setCodAlumno(rs.getInt(4));
                d.setIdCuota(rs.getInt(5));
            }
        } catch (Exception e) {
        }
        finally{
            desconectar();
        }
        return d;
    }
    
    public Alumno buscarAlumnoDNI(String dni){
        Alumno a = new Alumno();
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "sp_buscarAlumnoDni "+ dni;
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){              
                a.setCodCliente(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setApellido(rs.getString(3));
                a.setDni(rs.getString(4));
                a.setActivo(rs.getBoolean(5));                               
            }
            rs.close();
            st.close();
        } catch (Exception e) {
        }
        finally{
            desconectar();
        }
        return a;
    }
    public void desactivarAlumno(int codAlumno){
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "update alumnos set activo = 'false' where codAlumno = "+codAlumno+"";
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo cambiar el estado del alumno, motivo : " + e.getMessage());
        }
        finally{
            desconectar();
        }
    }
    
    

}
