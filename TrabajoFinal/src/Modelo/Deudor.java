
package Modelo;

public class Deudor {
    
    private int idDeudor;
    private float monto;
    private String detalle;
    private boolean pagado;
    private int codAlumno;
    private int idCuota;

    public Deudor() {
    }

    public Deudor(float monto, int codAlumno) {
        this.monto = monto;
        this.codAlumno = codAlumno;
    }

    
    public Deudor(int idDeudor, float monto, String detalle, boolean pagado, int codAlumno, int idCuota) {
        this.idDeudor = idDeudor;
        this.monto = monto;
        this.detalle = detalle;
        this.pagado = pagado;
        this.codAlumno = codAlumno;
        this.idCuota = idCuota;
    }

    public int getIdDeudor() {
        return idDeudor;
    }

    public void setIdDeudor(int idDeudor) {
        this.idDeudor = idDeudor;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public int getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(int codAlumno) {
        this.codAlumno = codAlumno;
    }

    public int getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(int idCuota) {
        this.idCuota = idCuota;
    }
    
    
    

}
