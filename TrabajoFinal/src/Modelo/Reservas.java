
package Modelo;

public class Reservas {
    private int idReserva;
    private int idInscripcion;
    private int idClase;

    public Reservas() {
    }

    public Reservas(int idInscripcion, int idClase) {
        this.idInscripcion = idInscripcion;
        this.idClase = idClase;
    }

       
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }
    
    
}
