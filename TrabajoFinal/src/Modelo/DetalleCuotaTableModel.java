
package Modelo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class DetalleCuotaTableModel extends AbstractTableModel{
    
    ArrayList<DetalleCuotaPaga> lista;

    public DetalleCuotaTableModel(ArrayList<DetalleCuotaPaga> lista) {
        this.lista = lista;
    }   
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        DetalleCuotaPaga dcp = lista.get(i);
        switch(i1){
            case 0: return dcp.getActividad();
            case 1: return dcp.getPrecioActividad();
            case 2: return dcp.getPromocion();
            case 3: return dcp.getMontoDescuento();
        } 
        return null;            
    }

    @Override
    public String getColumnName(int i) {        
        switch(i){
            case 0: return "Actividad";
            case 1: return "Precio";
            case 2: return "Promocion";
            case 3: return "Descuento";
        }
        return null;
    }
    
    
    
}
