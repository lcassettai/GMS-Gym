
package Modelo;


public class DetalleCuotaPaga {
              
    
    private String promocion;
    private float montoDescuento;
    private String Actividad;
    private float precioActividad;

    public DetalleCuotaPaga( String promocion, float montoDescuento, String Actividad, float precioActividad) {        
        this.promocion = promocion;
        this.montoDescuento = montoDescuento;
        this.Actividad = Actividad;
        this.precioActividad = precioActividad;
    }

    public DetalleCuotaPaga() {
    }     

    public String getPromocion() {
        return promocion;
    }

    public void setPromocion(String promocion) {
        this.promocion = promocion;
    }

    public float getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(float montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    public String getActividad() {
        return Actividad;
    }

    public void setActividad(String Actividad) {
        this.Actividad = Actividad;
    }

    public float getPrecioActividad() {
        return precioActividad;
    }

    public void setPrecioActividad(float precioActividad) {
        this.precioActividad = precioActividad;
    }
    
    
    

}
