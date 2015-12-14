
package Modelo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class AlumnosTableModel extends AbstractTableModel{

    ArrayList<Alumno> lista;

    public AlumnosTableModel(ArrayList<Alumno> lista) {
        this.lista = lista;
    }

    public AlumnosTableModel() {
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
        Alumno a = lista.get(i);
        
        switch(i1){
            case 0: return a.getCodCliente();
            case 1: return a.getApellido();
            case 2: return a.getNombre();
            case 3: return a.getDni();
        }
        
        return null;
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0:return "Codigo";
            case 1:return "Apellido";
            case 2:return "Nombre";
            case 3:return "DNI";            
        }
        return null;
    }
    
    
}
