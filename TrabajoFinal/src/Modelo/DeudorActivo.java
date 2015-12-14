
package Modelo;

public class DeudorActivo {
    private int idDeudor;
    private String alumno;
    private String dni;
    private float monto;
    private String fecha;
    private boolean estado;

    public DeudorActivo() {
    }

    public int getIdDeudor() {
        return idDeudor;
    }

    public void setIdDeudor(int idDeudor) {
        this.idDeudor = idDeudor;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
