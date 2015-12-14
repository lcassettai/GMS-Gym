
package Modelo;


public class Actividad {
    private int idActividad;
    private String actividad;
    private float precio;
    private int cantDias;
    private int tipoActividad;

    public Actividad() {
    }

    public Actividad(int idActividad, String actividad, float precio, int cantDias, int tipoActividad) {
        this.idActividad = idActividad;
        this.actividad = actividad;
        this.precio = precio;
        this.cantDias = cantDias;
        this.tipoActividad = tipoActividad;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }

    public int getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(int tipoActividad) {
        this.tipoActividad = tipoActividad;
    }
    
    @Override
    public String toString(){
        return this.actividad;
    }
}
