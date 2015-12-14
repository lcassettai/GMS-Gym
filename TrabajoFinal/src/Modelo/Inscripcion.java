
package Modelo;

import java.sql.Timestamp;


public class Inscripcion {
    private int idInscripcion;
    private Timestamp fechaIn;
    private Timestamp fechaFin;
    private int diasVencimiento;
    private int idActividad;
    private int codAlumno;
    private String actividad;
    private Boolean habilitado;

    public Inscripcion(int idInscripcion, Timestamp fechaIn, Timestamp fechaFin, int diasVencimiento, int idActividad, int codAlumno, String actividad, Boolean habilitado) {
        this.idInscripcion = idInscripcion;
        this.fechaIn = fechaIn;
        this.fechaFin = fechaFin;
        this.diasVencimiento = diasVencimiento;
        this.idActividad = idActividad;
        this.codAlumno = codAlumno;
        this.actividad = actividad;
        this.habilitado = habilitado;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }
    

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }       

    public Inscripcion() {
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Timestamp getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(Timestamp fechaIn) {
        this.fechaIn = fechaIn;
    }

    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getDiasVencimiento() {
        return diasVencimiento;
    }

    public void setDiasVencimiento(int diasVencimiento) {
        this.diasVencimiento = diasVencimiento;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public int getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(int codAlumno) {
        this.codAlumno = codAlumno;
    }
    
    
    
}
