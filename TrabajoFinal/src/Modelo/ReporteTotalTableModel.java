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
        return 8;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        ReporteTotalPagos rtp = listaPagos.get(i);
        switch (i1) {
            case 0:
                return rtp.getTipoPago();
            case 1:
                return rtp.getAlumno();
            case 2:
                return rtp.getMonto();
            case 3:
                return rtp.getDescuento();
            case 4:
                return rtp.getMontoEntregado();
            case 5:
                return rtp.getEmpleado();            
            case 6:
                return rtp.getFecha();
            case 7:
                return rtp.getHora();
        }
        return null;
    }

    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "Tipo de Pago";
            case 1:
                return "Alumno";
            case 2:
                return "Monto Total";
            case 3:
                return "Descuento Total";
            case 4:
                return "Monto Entregado";
            case 5:
                return "Empleado";
            case 6:
                return "Fecha";
            case 7:
                return "Hora";        
        }
        return null;
    }

}
