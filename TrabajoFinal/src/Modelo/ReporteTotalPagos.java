
package Modelo;

public class ReporteTotalPagos {
    private int nroCuota;
    private String tipoPago;
    private float montoEntregado;
    private String alumno;   
    private float monto;
    private float descuento;
    private String empleado;
    private String fecha;
    private String hora;

    public ReporteTotalPagos() {
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }
       

    public int getNroCuota() {
        return nroCuota;
    }

    public void setNroCuota(int nroCuota) {
        this.nroCuota = nroCuota;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }  

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public float getMontoEntregado() {
        return montoEntregado;
    }

    public void setMontoEntregado(float montoEntregado) {
        this.montoEntregado = montoEntregado;
    }   
    
    
    
}
