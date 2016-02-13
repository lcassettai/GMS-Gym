/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Actividad;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Home
 */
public class ControladorActividades {
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
    
   
    public ArrayList<Actividad> buscarActividades(int tipoActividad){
        ArrayList<Actividad> lista= new ArrayList<>();
        String sql = "";
        try {
            conectar();
            Statement st = conexion.createStatement();
            if(tipoActividad == 0){
                  sql = "select idActividad,actividad,precio,cantDias,idTipoActividad from actividades where habilitado = 'true' ";
            }else{
                  sql = "select idActividad,actividad,precio,cantDias,idTipoActividad from actividades where habilitado = 'true'  AND idTipoActividad = "+ tipoActividad;
            }          
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Actividad a = new Actividad();
                a.setIdActividad(rs.getInt(1));
                a.setActividad(rs.getString(2));
                a.setPrecio(rs.getFloat(3));
                a.setCantDias(rs.getInt(4));
                a.setTipoActividad(rs.getInt(5));
                lista.add(a);
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
    
    public ArrayList<String> tipoActividades(){
       ArrayList<String> tipos = new ArrayList<>();
       
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "select tipoActividad from tipoActividades";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                tipos.add(rs.getString(1));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
        }
        finally{
            desconectar();
        }
        return tipos;
    }
    
    public void agregarActividad(Actividad a){
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "INSERT INTO actividades (actividad,precio,cantDias,idTipoActividad,habilitado)"
                       + "values('"+a.getActividad()+"',"+a.getPrecio()+","+a.getCantDias()+","+a.getTipoActividad()+",'true')";
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo cargar la actividad");
        }
        finally{
            desconectar();
        }
    }
    
    public void actualizarActividad(Actividad a){
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "UPDATE actividades SET actividad = '"+a.getActividad()+"',precio = "+a.getPrecio()+","
                       + "cantDias = " + a.getCantDias() + ", idTipoActividad = "+a.getTipoActividad()+" WHERE idActividad = " + a.getIdActividad();
             st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo actualizar la actividad");
        }
        finally{
            desconectar();
        }
    }
    
    public void borrar(int i){
        try {
            conectar();
            Statement st = conexion.createStatement();
            String sql = "UPDATE actividades SET habilitado = 'false' where idActividad = " +i;
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("No se pudo eliminar la actividad motivo : " + e.getMessage());
        }
        finally{
            desconectar();
        }
    }
  
    
}
