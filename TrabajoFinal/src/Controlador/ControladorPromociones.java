
package Controlador;

import Modelo.Promocion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class ControladorPromociones {
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
    
    public void cargarPromocion(Promocion p){
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "exec SP_cargarPromocion @promocion='"+p.getPromocion()+"',@descrip='"+p.getDescripcion()+"',@monto="+p.getMonto();            
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo cargar la promocion");
        }
        finally{
            desconectar();
        }
    }
    
    public void actualizarPromocion(Promocion p){
         try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "exec SP_actualizarPromocion '"+p.getCodigo()+"','"+p.getPromocion()+"','"+p.getDescripcion()+"','"+p.getMonto()+"'";            
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo cargar la promocion");
        }
        finally{
            desconectar();
        }
    }
    
    public void eliminarPromocion(int i){
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "exec SP_eliminarPromocion "+i;        
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo cargar la promocion");
        }
        finally{
            desconectar();
        }
    }
    
    public ArrayList<Promocion> consultarPromociones(){
        ArrayList<Promocion>lista = new ArrayList<>();
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "SP_traerPromociones";          
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Promocion p = new Promocion();
                p.setCodigo(rs.getInt(1));
                p.setPromocion(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setMonto(rs.getFloat(4));
                lista.add(p);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
        }
        finally{
            desconectar();
        }
        return lista;
    }
}
