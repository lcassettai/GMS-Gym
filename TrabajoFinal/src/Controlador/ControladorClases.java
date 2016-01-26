
package Controlador;

import Modelo.Clase;
import Modelo.Empleado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class ControladorClases {
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
    
    public ArrayList obtenerProfesores(){
        ArrayList<Empleado> listaProfesores = new ArrayList<>();
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "exec obtenerProfesores";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Empleado e = new Empleado();
                e.setCodEmpleado(rs.getInt(1));
                e.setApellido(rs.getString(2));
                e.setNombre(rs.getString(3));
                
                listaProfesores.add(e);
            }
            rs.close();
            st.close();            
        } catch (Exception e) {
            System.out.println("No se pudo obtener la lista de profesores motivo : " + e.getMessage());
        }
        finally{
            desconectar();
        }
        return listaProfesores;
    }
    
    public void agregarNuevaClase(Clase c){
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "exec nuevaClase "+c.getCupo()+","+c.getIdACtividad()+","+c.getIdEmpleado()+",'"+c.getHoraInicio()+"','"+c.getHoraFin()+"'";
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo agregar la clase, motivo : " + e.getMessage());
        }
        finally{
            desconectar();
        }
    }
    
    public ArrayList<Clase> obtenerClases(){
        ArrayList<Clase> listaClases = new ArrayList<>();
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "exec obtenerClases";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Clase c = new Clase();
                c.setEmpleado(rs.getString(1));
                c.setActividad(rs.getString(2));
                c.setCupo(rs.getInt(3));
                c.setHoraInicio(rs.getString(4));
                c.setHoraFin(rs.getString(5));
                c.setIdACtividad(rs.getInt(6));
                c.setIdEmpleado(rs.getInt(7));
                c.setIdClase(rs.getInt(8));
                listaClases.add(c);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo obtener las clases, motvo : " + e.getMessage());
        }
        finally{
            desconectar();
        }
        return listaClases;
    }
    
    public void eliminarClase(int codClase){
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql  = "exec eliminarClase " + codClase;
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo eliminar la clase, motivo : " + e.getMessage());
        }
        finally{
            desconectar();
        }
    }
}
