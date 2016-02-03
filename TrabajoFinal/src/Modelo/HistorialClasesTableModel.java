package Modelo;

import Controlador.ControladorReservas;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class HistorialClasesTableModel extends AbstractTableModel {

    private ArrayList<Clase> listaClases;

    public HistorialClasesTableModel(ArrayList<Clase> listaClases) {
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
                return c.getActividad();
            case 1:
                return c.getDia();
            case 2:
                return c.getEmpleado();
            case 3:
                return c.getHoraInicio();
            case 4:
                return c.getCupo();
            case 5:
                return obtenerInscriptos(c.getIdClase());
        }

        return null;
    }

    private int obtenerInscriptos(int codClase) {
        ControladorReservas cr = new ControladorReservas();
        return cr.obtenerNumeroInscriptos(codClase);
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Actividad";
            case 1:
                return "Dia";
            case 2:
                return "Profesor";
            case 3:
                return "Horario";
            case 4:
                return "Cupo";
            case 5:
                return "Inscriptos";
        }
        return null;
    }
}
