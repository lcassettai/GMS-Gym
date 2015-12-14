package Modelo;

import Controlador.ControladorAlumno;
import Controlador.ControladorPagos;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Alumno {

    private int codCliente;
    private String nombre;
    private String apellido;
    private Timestamp fechaNac;
    private Boolean sexo;  //true masculino false femenino
    private String direccion;
    private String telefono;
    private String telefonoEmergencia;
    private String dni;
    private Boolean activo;
    private String comentario;

    public Alumno() {
    }

    public Alumno(int codCliente, String nombre, String apellido, Timestamp fechaNac, Boolean sexo, String direccion, String telefono, String telefonoEmergencia, String dni, Boolean activo, String comentario) {
        this.codCliente = codCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.telefonoEmergencia = telefonoEmergencia;
        this.dni = dni;
        this.activo = activo;
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Timestamp getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Timestamp fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Boolean getSexo() {
        return sexo;
    }

    public void setSexo(Boolean sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefonoEmergencia() {
        return telefonoEmergencia;
    }

    public void setTelefonoEmergencia(String telefonoEmergencia) {
        this.telefonoEmergencia = telefonoEmergencia;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public float verificarDeudas() {
        ControladorAlumno ca = new ControladorAlumno();
        float total = ca.verificarDeuda(this.codCliente);
        if (total < 0) {
            total = 0;
        }
        return total;
    }

    public Boolean verificarEstado(Alumno alumno) {
        Boolean habilitado = false;
        ControladorPagos cp = new ControladorPagos();        
        ArrayList<Inscripcion> listaInscripciones = cp.buscarInscripciones(alumno.getCodCliente());
        Date fechaActual = new Date();
        
        if (alumno.getActivo() == true) {
            for (Inscripcion lstInscrip : listaInscripciones) {
                if (lstInscrip.getHabilitado() == true) {                   
                    if(lstInscrip.getDiasVencimiento() > 0){
                        if(fechaActual.before(lstInscrip.getFechaFin())) {
                            habilitado = true;
                            break;
                        }
                    }
                } 
            }       
        }
        return habilitado;
    }

    @Override
    public String toString() {
        return this.apellido + ", " + this.nombre;
    }

}
