
package Modelo;

import java.sql.Timestamp;


public class Empleado {
    private int codEmpleado;
    private String nombre;
    private String apellido;  
    private Timestamp fechaNac;
    private Boolean sexo;      //true Masculuno - false femenino
    private String telefono;    
    private String telefonoAyuda;
    private String direccion;
    private String dni;
    private Boolean activo; //true esta trabajando - falso no esta trabajando
    private Boolean suplencia;  //true acepta suplencias - false no acepta
    private String comentario;
    private String usuario;
    private String contraseña;
    private int tipoEmpleado;

    public Empleado() {
    }

    public Empleado(int codEmpleado, String nombre, String apellido, Timestamp fechaNac, Boolean sexo, String telefono, String telefonoAyuda, String direccion, String dni, Boolean activo, Boolean suplencia, String comentario, String usuario, String contraseña, int tipoEmpleado) {
        this.codEmpleado = codEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.telefono = telefono;
        this.telefonoAyuda = telefonoAyuda;
        this.direccion = direccion;
        this.dni = dni;
        this.activo = activo;
        this.suplencia = suplencia;
        this.comentario = comentario;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.tipoEmpleado = tipoEmpleado;
    }

    public int getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(int codEmpleado) {
        this.codEmpleado = codEmpleado;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefonoAyuda() {
        return telefonoAyuda;
    }

    public void setTelefonoAyuda(String telefonoAyuda) {
        this.telefonoAyuda = telefonoAyuda;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public Boolean getSuplencia() {
        return suplencia;
    }

    public void setSuplencia(Boolean suplencia) {
        this.suplencia = suplencia;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(int tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    
    
    
}
