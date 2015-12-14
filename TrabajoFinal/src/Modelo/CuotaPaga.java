
package Modelo;

public class CuotaPaga {
    private int idPagoCuota;
    private String apellidoAlumno;
    private String nombreAlumno;
    private String dni;
    private String fecha;
    private String apellidoEmpleado;
    private float montoTotal;

    public CuotaPaga(int idPagoCuota, String apellidoAlumno, String nombreAlumno, String dni, String fecha, String apellidoEmpleado, float montoTotal) {
        this.idPagoCuota = idPagoCuota;
        this.apellidoAlumno = apellidoAlumno;
        this.nombreAlumno = nombreAlumno;
        this.dni = dni;
        this.fecha = fecha;
        this.apellidoEmpleado = apellidoEmpleado;
        this.montoTotal = montoTotal;
    }

    public CuotaPaga() {
    }
    
    

    public int getIdPagoCuota() {
        return idPagoCuota;
    }

    public void setIdPagoCuota(int idPagoCuota) {
        this.idPagoCuota = idPagoCuota;
    }

    public String getApellidoAlumno() {
        return apellidoAlumno;
    }

    public void setApellidoAlumno(String apellidoAlumno) {
        this.apellidoAlumno = apellidoAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }
    
    
    
}
