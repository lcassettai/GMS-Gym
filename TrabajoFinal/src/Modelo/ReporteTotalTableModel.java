package Modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ReporteTotalTableModel extends AbstractTableModel {

    ArrayList<ReporteTotalPagos> listaPagos;

    public ReporteTotalTableModel(ArrayList<ReporteTotalPagos> listaPagos) {
        this.listaPagos = listaPagos;
    }

    @Override
    public int getRowCount() {
        return listaPagos.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        ReporteTotalPagos rtp = listaPagos.get(i);
        switch (i1) {
            case 0:
                return rtp.getNroCuota();
            case 1:
                return rtp.getAlumno();
            case 2:
                return rtp.getActividad();
            case 3:
                return rtp.getMonto();
            case 4:
                return rtp.getPromocion();
            case 5:
                return rtp.getDescuento();
            case 6:
                return rtp.getEmpleado();
            case 7:
                return rtp.getFecha();
            case 8:
                return rtp.getHora();
        }
        return null;
    }

    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "nroCuota";
            case 1:
                return "Alumno";
            case 2:
                return "Actividad";
            case 3:
                return "Monto";
            case 4:
                return "Promocion";
            case 5:
                return "Descuento";
            case 6:
                return "Empleado";
            case 7:
                return "Fecha";
            case 8:
                return "Hora";
        }
        return null;
    }

}
