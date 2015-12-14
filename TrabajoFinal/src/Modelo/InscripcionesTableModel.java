
package Modelo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class InscripcionesTableModel extends AbstractTableModel{

    private ArrayList<Inscripcion> lista;

    public InscripcionesTableModel(ArrayList<Inscripcion> lista) {
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
       Inscripcion insc = lista.get(i);
       switch(i1){
           case 0:return insc.getActividad();
           case 1:{SimpleDateFormat df = new SimpleDateFormat("dd-MM-YYYY"); return df.format(insc.getFechaIn());}
           case 2:{SimpleDateFormat df = new SimpleDateFormat("dd-MM-YYYY"); return df.format(insc.getFechaFin());}
           case 3:return insc.getDiasVencimiento();
       }
       return null;
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0:return "Actividad";
            case 1:return "Fecha de Inicio";
            case 2:return "Fecha de Fin";
            case 3:return "Dias restantes";            
        }
        return null;
    }
    
    
    
}
