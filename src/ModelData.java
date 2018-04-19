import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ModelData extends AbstractTableModel {

    //new ArrayList<Pracownik>();
    List<Employee> data;
    //List<Pracownik> data = (Filtry.filterSalaryAboveThreshold(DodajFrame.getList(),9000));
    //List<Pracownik> data=Filtry.filterBirthyearAboveThreshold(Filtry.filterSalaryAboveThreshold(DodajFrame.getList(),9000),1980);
    String colNames[] = { "Name", "Surname", "Birth year","Sex", "Department","Married","Number of childrens", "Salary" };
    Class<?> colClasses[] = { String.class, String.class, Integer.class, Character.class, Integer.class, Boolean.class,Integer.class, Float.class };

    public void setData(List<Employee>list){
        data=list;

    }

    ModelData(List<Employee> list) {
        data=list;

    }

    public int getRowCount() {
        return data.size();
    }

    public int getColumnCount() {
        return colNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return data.get(rowIndex).getName();
        }
        if (columnIndex == 1) {
            return data.get(rowIndex).getSurname();
        }
        if (columnIndex == 2) {
            return data.get(rowIndex).getBirthYear();
        }
        if(columnIndex==3) {
            return data.get(rowIndex).getSex();
        }
        if(columnIndex==4) {
            return data.get(rowIndex).getDepartment();
        }
        if(columnIndex==5){
            return data.get(rowIndex).getMarried();
        }
        if(columnIndex==6){
            return data.get(rowIndex).getNumberOfChlidrens();
        }
        if(columnIndex==7){
            return data.get(rowIndex).getSalary();
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
            if(Validation.validateName(aValue.toString()))
            data.get(rowIndex).setName((String) aValue);
            else JOptionPane.showMessageDialog(null, Validation.getValidateMessage());
        }
        if (columnIndex == 1) {
            if(Validation.validateSurname(aValue.toString()))
            data.get(rowIndex).setSurname(aValue.toString());
            else JOptionPane.showMessageDialog(null, Validation.getValidateMessage());
        }
        if (columnIndex == 2) {
            if(Validation.validateBirthYear(aValue.toString()))
            data.get(rowIndex).setBirthYear((Integer) aValue);
            else JOptionPane.showMessageDialog(null, Validation.getValidateMessage());
        }

        if (columnIndex == 3) {
            if(Validation.validateSex(aValue.toString())){
                data.get(rowIndex).setSex(Character.valueOf(aValue.toString().charAt(0)));}
            else JOptionPane.showMessageDialog(null, Validation.getValidateMessage());
        }
        if (columnIndex == 4) {
            if(Validation.validateDepartment(aValue.toString()))
            data.get(rowIndex).setDepartment((Integer) aValue);
            else JOptionPane.showMessageDialog(null, Validation.getValidateMessage());
        }
        if (columnIndex == 5) {
            data.get(rowIndex).setMarried((Boolean) aValue);
        }
        if (columnIndex == 6) {
            if(Validation.validateNumberOfChildren(aValue.toString()))
            data.get(rowIndex).setNumberOfChlidrens((Integer) aValue);
            else JOptionPane.showMessageDialog(null, Validation.getValidateMessage());
        }
        if (columnIndex == 7) {
            if(Validation.validateSalary(aValue.toString()))
            data.get(rowIndex).setSalary(Float.parseFloat( aValue.toString()));
            else JOptionPane.showMessageDialog(null, Validation.getValidateMessage());
        }



        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public void removeRow(int row) {
        data.remove(row);
    }
}
