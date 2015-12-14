
package Modelo;

import java.sql.Timestamp;

public class pagoCuota {
    private int idPagoCuota;
    private Timestamp fecha;
    private float montoEntregadp;
    private int codAlumno;
    private int codEmpleado;

    public pagoCuota(int idPagoCuota, Timestamp fecha, float montoEntregadp, int codAlumno, int codEmpleado) {
        this.idPagoCuota = idPagoCuota;
        this.fecha = fecha;
        this.montoEntregadp = montoEntregadp;
        this.codAlumno = codAlumno;
        this.codEmpleado = codEmpleado;
    }

    public pagoCuota() {
    }

    public int getIdPagoCuota() {
        return idPagoCuota;
    }

    public void setIdPagoCuota(int idPagoCuota) {
        this.idPagoCuota = idPagoCuota;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public float getMontoEntregadp() {
        return montoEntregadp;
    }

    public void setMontoEntregadp(float montoEntregadp) {
        this.montoEntregadp = montoEntregadp;
    }

    public int getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(int codAlumno) {
        this.codAlumno = codAlumno;
    }

    public int getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(int codEmpleado) {
        this.codEmpleado = codEmpleado;
    }
    
    
}
