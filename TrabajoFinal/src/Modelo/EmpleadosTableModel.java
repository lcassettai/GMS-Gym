
package Modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class EmpleadosTableModel extends AbstractTableModel  {
    private ArrayList<Empleado> lista;

    public EmpleadosTableModel(ArrayList<Empleado> lista) {
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
        Empleado e = lista.get(i);
        switch(i1){
            case 0:return e.getCodEmpleado();
            case 1:return e.getNombre();
            case 2:return e.getApellido();
            case 3:return e.getApellido();
        }
        return null;
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0:return "Codigo";
            case 1:return "Nombre";
            case 2:return "Apellido";
            case 3:return "DNI";
        }
        return null;
    }
    
    
    
    
}
