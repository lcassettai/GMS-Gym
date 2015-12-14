
package Controlador;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ControladorSesion {
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
    
    public Usuario buscarUsuario(String usuario){
        Usuario usr = null;
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "select codEmpleado,usuario,contraseña, activo,idtipoEmpleado from empleados where usuario = '" + usuario +"'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                usr = new Usuario();                
                usr.setIdUsuario(rs.getInt(1));
                usr.setUsuario(rs.getString(2));
                usr.setContraseña(rs.getString(3));
                usr.setEstado(rs.getBoolean(4));
                usr.setTipoEmpleado(rs.getInt(5));
            }
            rs.close();
            st.close();
          
        } catch (Exception e) {
            System.out.println("No se encontro ningun usuario motivo : " + e);             
        }
        finally{
            desconectar();
        }
         return usr;
    }
    

    
    
    
}
