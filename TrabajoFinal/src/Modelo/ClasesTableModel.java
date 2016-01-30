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
        return 6;
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
                return obtenerDia(c.getIdDia());
            case 3:
                return c.getCupo();
            case 4:
                return c.getHoraInicio();
            case 5:
                return c.getHoraFin();
        }

        return null;
    }

    public String obtenerDia(int id) {
        switch (id) {
            case 1:
                return "Lunes";
            case 2:
                return "Martes";
            case 3:
                return "Miercoles";
            case 4:
                return "Jueves";
            case 5:
                return "Viernes";
            case 6:
                return "Sabado";
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Profesor";
            case 1:
                return "Actividad";
            case 2:
                return "Dia";
            case 3: 
                return "Cupo";
            case 4:
                return "Hora Inicio";
            case 5:
                return "Hora Fin";
        }
        return null;
    }

}
