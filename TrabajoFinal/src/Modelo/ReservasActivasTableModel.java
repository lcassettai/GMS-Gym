package Modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ReservasActivasTableModel extends AbstractTableModel {

    ArrayList<Reservas> listaReservas;

    public ReservasActivasTableModel(ArrayList<Reservas> listaReservas) {
        this.listaReservas = listaReservas;
    }

    @Override
    public int getRowCount() {
        return listaReservas.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reservas r = listaReservas.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return r.getIdReserva();
            case 1:
                return r.getAlumno();
            case 2:
                return r.getActividad();
            case 3:
                return r.getDia();
            case 4:
                return r.getHoraInicio();           
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
           switch(column){
            case 0: return "Nro Reserva";
            case 1: return "Alumno";
            case 2: return "Actividad";
            case 3: return "Dia";
            case 4: return "Horario";          
                  
         }
        return null;
    }
    
    

}
