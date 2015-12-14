
package Controlador;

import Modelo.Empleado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ControladorEmpleados {
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
    
    public void desconectar(){
        try {
            if(conexion!=null)
                conexion.close();
        } catch (Exception e) {
            System.out.println("No se pudo desconectar de la BD motivo : " + e);
        }
    }
    
    public ArrayList<Empleado> buscarEmpleados(){
        ArrayList<Empleado> lista = new ArrayList<>();
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "Select codEmpleado,nombre,apellido,fecNac,sexo,direccion,"
                         +"telefono,dni,activo,suplencias,comentario,telefonoAyuda,usuario,contraseña,idTipoEmpleado"
                         + " from empleados order by activo desc";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Empleado e = new Empleado();
                e.setCodEmpleado(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setApellido(rs.getString(3));
                e.setFechaNac(rs.getTimestamp(4));
                e.setSexo(rs.getBoolean(5));
                e.setDireccion(rs.getString(6));
                e.setTelefono(rs.getString(7));                
                e.setDni(rs.getString(8));
                e.setActivo(rs.getBoolean(9));
                e.setSuplencia(rs.getBoolean(10));
                e.setComentario(rs.getString(11));
                e.setTelefonoAyuda(rs.getString(12));
                e.setUsuario(rs.getString(13));
                e.setContraseña(rs.getString(14));
                e.setTipoEmpleado(rs.getInt(15));
                lista.add(e);
            }
            
            rs.close();
            st.close();
            
        } catch (Exception e) {
            System.out.println("No se pudo traer los datos del empleado  motivo : " + e.getMessage());
        }
        finally{
            desconectar();
        }
        return lista;
        
    }
    
    public Empleado buscarEmpleado(int i){
        Empleado e = null;
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "Select codEmpleado,nombre,apellido,fecNac,sexo,direccion,"
                         +"telefono,dni,activo,suplencias,comentario,telefonoAyuda,usuario,contraseña,idTipoEmpleado"
                         + " from empleados where codEmpleado = " + i;
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                e = new Empleado();
                e.setCodEmpleado(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setApellido(rs.getString(3));
                e.setFechaNac(rs.getTimestamp(4));
                e.setSexo(rs.getBoolean(5));
                e.setDireccion(rs.getString(6));
                e.setTelefono(rs.getString(7));                
                e.setDni(rs.getString(8));
                e.setActivo(rs.getBoolean(9));
                e.setSuplencia(rs.getBoolean(10));
                e.setComentario(rs.getString(11));
                e.setTelefonoAyuda(rs.getString(12));  
                e.setUsuario(rs.getString(13));
                e.setContraseña(rs.getString(14));
                e.setTipoEmpleado(rs.getInt(15));
            }
            
            rs.close();
            st.close();
            
        } catch (Exception em) {
            System.out.println("No se encontro el empleado : " + em.getMessage());
        }
        finally{
            desconectar();
        }
        return e;
        
    }
    
   
    
    public void actualizarEmpleado(Empleado em){
        //cambio e formato para insertar en el sql server
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");         
        String fecha = df.format(em.getFechaNac());    
        
        
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql ="Update empleados set	nombre = '"+em.getNombre()+"',"
                      + " apellido = '"+em.getApellido()+"', fecNac = '"+fecha+"',"
                      + "sexo = '"+em.getSexo()+"',direccion = '"+em.getDireccion()+"',"
                      + "telefono = '"+em.getTelefono()+"',telefonoAyuda = '"+em.getTelefonoAyuda()+"'"
                      + ",dni = '"+em.getDni()+"',activo = '"+em.getActivo()+"',suplencias = '"+em.getSuplencia()
                      + "',comentario = '"+em.getComentario()+"', usuario = '"+em.getUsuario()+"',"
                      + "contraseña = '"+em.getContraseña()+"', idTipoEmpleado = "+em.getTipoEmpleado()
                      + " where codEmpleado = "+em.getCodEmpleado();
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo insertar el empleado, motivo : " +e.getMessage());
        }
        finally{
            desconectar();
        }
    }
    
    public void cargarNuevoEmpleado(Empleado em){
         SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");         
         String fecha = df.format(em.getFechaNac());  
         
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "insert into empleados (nombre,apellido,fecNac,sexo,direccion,"
                    + "telefono,telefonoAyuda,dni,activo,suplencias,comentario,usuario,"
                    + "contraseña,idTipoEmpleado) values ('"+em.getNombre()+"',"
                    + "'"+em.getApellido()+"','"+fecha+"','"+em.getSexo()+"','"+em.getDireccion()+"',"
                    + "'"+em.getTelefono()+"','"+em.getTelefonoAyuda()+"','"+em.getDni()+"',"
                    + "'"+em.getActivo() + "','"+em.getSuplencia()+"','"+em.getComentario()+"',"
                    + "'"+em.getUsuario()+"','"+em.getContraseña()+"',"+em.getTipoEmpleado()+")";
            st.executeQuery(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo cargar el empleado motivo : " + e.getMessage());
        }
        finally{
            desconectar();
        }
    }
    
    public Empleado buscarEmpleadoDNI(String dni){
        Empleado em = new Empleado();
        try {
            conectar();
            Statement st =  conexion.createStatement();
            String sql = "SP_buscarEmpleado " + dni;
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                em.setCodEmpleado(rs.getInt(1));
                em.setNombre(rs.getString(2));
                em.setApellido(rs.getString(3));
                em.setDni(rs.getString(4));
                em.setActivo(rs.getBoolean(5));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo buscar el empleado motivo : " + e.getMessage());
        }
        finally{
            desconectar();
        }
        return em;
    }
    
    
    
    
}
