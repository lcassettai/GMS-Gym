package Modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ClasesTableModel extends AbstractTableModel {

    private ArrayList<Clase> listaClases;

    public ClasesTableModel(ArrayList<Clase> listaClases) {
        this.listaClases = listaClases;
    }

    @Override
    public int getRowCount() {
        return listaClases.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clase c = listaClases.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return c.getEmpleado();
            case 1:
                return c.getActividad();
            case 2:
                return c.getCupo();
            case 3:
                return c.getHoraInicio();
            case 4:
                return c.getHoraFin();
        }
        
        return null;
    }

    @Override
    public String getColumnName(int column) {
       switch(column){
           case 0:return "Profesor";
           case 1:return "Actividad";
           case 2:return "Cupo";
           case 3:return "Hora Inicio";
           case 4:return "Hora Fin";
       }
       return null;
    }
    
    

}
