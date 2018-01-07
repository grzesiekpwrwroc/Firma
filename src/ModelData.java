import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ModelData extends AbstractTableModel {

    //new ArrayList<Pracownik>();
    List<Pracownik> data;
    //List<Pracownik> data = (Filtry.filtrujPensjaPowyzejProgu(DodajFrame.getLista(),9000));
    //List<Pracownik> data=Filtry.filtrujRokUrodzaniaPowyzejProgu(Filtry.filtrujPensjaPowyzejProgu(DodajFrame.getLista(),9000),1980);
    String colNames[] = { "Imie", "Nazwisko", "Rok urodzenia","Płeć", "Dział","Stan cywilny","Ilość dzieci", "Pensja" };
    Class<?> colClasses[] = { String.class, String.class, Integer.class, Character.class, Integer.class, Boolean.class,Integer.class, Integer.class };

    public List<Pracownik> setData(List<Pracownik>lista){
        data=lista;
        return data;
    }

    ModelData(List<Pracownik> lista) {
        data=lista;
    }

    public int getRowCount() {
        return data.size();
    }

    public int getColumnCount() {
        return colNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return data.get(rowIndex).getImie();
        }
        if (columnIndex == 1) {
            return data.get(rowIndex).getNazwisko();
        }
        if (columnIndex == 2) {
            return data.get(rowIndex).getRokUrodzenia();
        }
        if(columnIndex==3) {
            return data.get(rowIndex).getPlec();
        }
        if(columnIndex==4) {
            return data.get(rowIndex).getNumerDzialu();
        }
        if(columnIndex==5){
            return data.get(rowIndex).getStanCywilny();
        }
        if(columnIndex==6){
            return data.get(rowIndex).getIloscDzieci();
        }
        if(columnIndex==7){
            return data.get(rowIndex).getPensja();
        }
        return null;
    }

    public String getColumnName(int columnIndex) {
        return colNames[columnIndex];
    }

    public Class<?> getColumnClass(int columnIndex) {
        return colClasses[columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            data.get(rowIndex).setImie((String) aValue);
        }
        if (columnIndex == 1) {
            data.get(rowIndex).setNazwisko((String) aValue);
        }
        if (columnIndex == 2) {
            data.get(rowIndex).setRokUrodzenia((Integer) aValue);
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }
}