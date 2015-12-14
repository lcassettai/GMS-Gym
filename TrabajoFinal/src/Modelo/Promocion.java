
package Modelo;


public class Promocion {
    private int codigo;
    private String promocion;
    private String descripcion;
    private float monto;

    public Promocion() {
    }

    public Promocion(int codigo, String promocion, String descripcion, float monton) {
        this.codigo = codigo;
        this.promocion = promocion;
        this.descripcion = descripcion;
        this.monto = monton;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

        public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPromocion() {
        return promocion;
    }

    public void setPromocion(String promocion) {
        this.promocion = promocion;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monton) {
        this.monto = monton;
    }

    @Override
    public String toString() {
        return this.promocion;
    }
    
    
    
}
