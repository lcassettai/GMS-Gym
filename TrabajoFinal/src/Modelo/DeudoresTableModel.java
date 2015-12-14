package Modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class DeudoresTableModel extends AbstractTableModel {

    ArrayList<DeudorActivo> deudores;

    public DeudoresTableModel(ArrayList<DeudorActivo> deudores) {
        this.deudores = deudores;
    }

    @Override
    public int getRowCount() {
        return deudores.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        DeudorActivo da = deudores.get(i);
        switch (i1) {
            case 0:
                return da.getAlumno();
            case 1:
                return da.getDni();
            case 2:
                return da.getMonto();
            case 3:
                return da.getFecha();
        }
        return null;
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0: return "Alumno";
            case 1: return "DNI";
            case 2: return "Deuda";
            case 3: return "Fecha";                
        }
        return null;
    }

}
