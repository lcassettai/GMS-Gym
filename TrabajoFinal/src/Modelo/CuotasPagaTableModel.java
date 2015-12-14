
package Modelo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class CuotasPagaTableModel extends AbstractTableModel{
    
    private ArrayList<CuotaPaga> lista;

    public CuotasPagaTableModel(ArrayList<CuotaPaga> lista) {
        this.lista = lista;
    }
    
        
    @Override
    public int getRowCount() {
        return lista.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
       return 6; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int i, int i1) {
        CuotaPaga cp = lista.get(i);
        switch(i1){
            case 0: return cp.getIdPagoCuota();
            case 1: return cp.getApellidoAlumno() + " " + cp.getNombreAlumno();            
            case 2: return cp.getDni();
            case 3: return cp.getFecha();
            case 4: return cp.getApellidoEmpleado();
            case 5: return cp.getMontoTotal();        
         }
        return null;
    }

    @Override
    public String getColumnName(int i) {
       switch(i){
            case 0: return "ID";
            case 1: return "Alumno";
            case 2: return "DNI";
            case 3: return "Fecha";
            case 4: return "Empleado";
            case 5: return "Monto total";
                  
         }
        return null;
    }
    
    
    
    
    
}
