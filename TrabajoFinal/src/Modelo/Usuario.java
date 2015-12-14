
package Modelo;


public class Usuario {
    private int idUsuario;
    private String usuario;
    private String contraseña;
    private Boolean estado;
    private int tipoEmpleado;

    public Usuario() {
    }

    public Usuario(int idUsuario, String usuario, String contraseña, Boolean estado, int tipoEmpleado) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.estado = estado;
        this.tipoEmpleado = tipoEmpleado;
    }

    public int getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(int tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

 
    

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    public void borrar(){
        this.usuario = "";
        this.contraseña = "";
        this.idUsuario = 0;
        this.tipoEmpleado = 0;
        this.estado = false;
    }
     
    
}
