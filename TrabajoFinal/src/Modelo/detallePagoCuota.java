
package Modelo;


public class detallePagoCuota {
    private int idDetalle;
    private float monto;
    private int idPromocion;
    private int idActividad;
    private int idPagoCuota;
    private float montoDescuento;

    public detallePagoCuota(int idDetalle, float monto, int idPromocion, int idActividad, int idPagoCuota, float montoDescuento) {
        this.idDetalle = idDetalle;
        this.monto = monto;
        this.idPromocion = idPromocion;
        this.idActividad = idActividad;
        this.idPagoCuota = idPagoCuota;
        this.montoDescuento = montoDescuento;
    }

    public float getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(float montoDescuento) {
        this.montoDescuento = montoDescuento;
    }
    
    
    
    public detallePagoCuota() {
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public int getIdPagoCuota() {
        return idPagoCuota;
    }

    public void setIdPagoCuota(int idPagoCuota) {
        this.idPagoCuota = idPagoCuota;
    }

    @Override
    public String toString() {
        return "detallePagoCuota{" + "monto=" + monto + '}';
    }
    
     
}
