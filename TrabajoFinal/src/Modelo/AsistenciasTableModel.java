package Modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class AsistenciasTableModel extends AbstractTableModel {

    private ArrayList<Asistencia> listaAsistencia;

    public AsistenciasTableModel(ArrayList<Asistencia> listaAsistencia) {
        this.listaAsistencia = listaAsistencia;
    }

    @Override
    public int getRowCount() {
        return listaAsistencia.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Asistencia a = listaAsistencia.get(i);
        switch(i1){
            case 0:return a.getApellido();
            case 1:return a.getNombre();
            case 2:return a.getDni();
            case 3:return a.getFecha();
            case 4:return a.getHora();
        }
        return false;
    }

    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "Apellido";
            case 1:
                return "Nombre";
            case 2:
                return "Dni";
            case 3:
                return "Fecha";
            case 4:
                return "Hora";
        }
        return null;
    }

}
