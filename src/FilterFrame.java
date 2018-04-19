


import javax.swing.*;
import java.awt.*;
import java.util.List;


public class FilterFrame {

    JTable table;
    List<Employee> list;
    List<Employee> filterList;
    //List<Pracownik> listaFiltrowana2;

    FilterFrame(int counter) {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setBounds(10, 10, 1030, 800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        list = AddEmployeeFrame.getList();
        filterList = list;
        Container c = frame.getContentPane();
        //List<Pracownik> list=DodajFrame.getList();
        TablePanel t = new TablePanel();
        ParameterPanel p = new ParameterPanel();
        t.setBounds(10, 10, 1000, 600);
        p.setBounds(10, 620, 1000, 150);
        t.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        p.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        c.add(t);
        c.add(p);

        frame.setVisible(true);
        frame.setResizable(false);
    }

    class TablePanel extends JPanel {
        TablePanel() {
            setLayout(new BorderLayout());
            //super();
            table = new JTable(new ModelData(list));
            table.setSize(800, 500);
            table.setEnabled(false);

            add(new JScrollPane(table),BorderLayout.PAGE_START);
        }
    }

    class ParameterPanel extends JPanel {

        JTextField textFieldSalary = new JTextField(String.valueOf(Statistics.arithmeticAverage()));
        JTextField textFieldBirthYear = new JTextField(String.valueOf(Statistics.firstQuartile()));
        JTextField textFieldSex = new JTextField(String.valueOf(Statistics.thirdQuartile()));
        //JTextField textFieldSalary = new JTextField("Podaj kwotę");
        //JTextField textFieldBirthYear = new JTextField("Podaj rok urodzenia");
        //JTextField textFieldSex = new JTextField("Podaj płeć");
        JTextField textFieldDepartment = new JTextField("Enter the department");

        public boolean isValidateFilters(){
            return Validation.validateSalary(textFieldSalary.getText())&&Validation.validateBirthYear(textFieldBirthYear.getText())&&
                    Validation.validateSex(textFieldSex.getText())&&Validation.validateDepartments(textFieldDepartment.getText());
        }
        ParameterPanel() {
            //setLayout(null);
            JToggleButton b1 = new JToggleButton("Filter salary");
            JToggleButton b2 = new JToggleButton("Filter birthyear");
            JToggleButton b3 = new JToggleButton("Filter sex");
            JToggleButton b4 = new JToggleButton("Filter department");


            add(b1);
            add(textFieldSalary);
            add(b2);
            add(textFieldBirthYear);
            add(b3);
            add(textFieldSex);
            add(b4);
            add(textFieldDepartment);


            b1.addActionListener(e -> {
                if (isValidateFilters()) {
                    filterList = list;
                    filterList = Filters.filterSalaryAboveThreshold(b1.isSelected(), filterList, Integer.parseInt(textFieldSalary.getText()));
                    filterList = Filters.filterBirthyearAboveThreshold(b2.isSelected(), filterList, Integer.parseInt(textFieldBirthYear.getText()));
                    filterList = Filters.filterSex(b3.isSelected(), filterList, (textFieldSex.getText().charAt(0)));
                    filterList = Filters.filterDepartments(b4.isSelected(), filterList, textFieldDepartment.getText());

                    ModelData model = new ModelData(filterList);
                    table.setModel(model);
                } else {
                    b1.setSelected(false);
                    JOptionPane.showMessageDialog(null, Validation.getValidateMessage());
                }
            });

            b2.addActionListener(e -> {
                //List<Pracownik> filterList=list;
                if (isValidateFilters()) {
                    filterList = list;
                    filterList = Filters.filterSalaryAboveThreshold(b1.isSelected(), filterList, Integer.parseInt(textFieldSalary.getText()));
                    filterList = Filters.filterBirthyearAboveThreshold(b2.isSelected(), filterList, Integer.parseInt(textFieldBirthYear.getText()));
                    filterList = Filters.filterSex(b3.isSelected(), filterList, (textFieldSex.getText().charAt(0)));
                    filterList = Filters.filterDepartments(b4.isSelected(), filterList, textFieldDepartment.getText());

                    ModelData model = new ModelData(filterList);

                    table.setModel(model);
                }//= new JTable(new ModelData(filterList));
                else {
                    b2.setSelected(false);
                    JOptionPane.showMessageDialog(null, Validation.getValidateMessage());
                }
            });

            b3.addActionListener(e -> {
                //List<Pracownik> filterList=list;
                if (isValidateFilters()) {
                    filterList = list;
                    filterList = Filters.filterSalaryAboveThreshold(b1.isSelected(), filterList, Integer.parseInt(textFieldSalary.getText()));
                    filterList = Filters.filterBirthyearAboveThreshold(b2.isSelected(), filterList, Integer.parseInt(textFieldBirthYear.getText()));
                    filterList = Filters.filterSex(b3.isSelected(), filterList, (textFieldSex.getText().charAt(0)));
                    filterList = Filters.filterDepartments(b4.isSelected(), filterList, textFieldDepartment.getText());

                    ModelData model = new ModelData(filterList);
                    table.setModel(model);
                }//= new JTable(new ModelData(filterList));
                else {
                    b3.setSelected(false);
                    JOptionPane.showMessageDialog(null, Validation.getValidateMessage());
                }
            });

            b4.addActionListener(e -> {
                if (isValidateFilters()) {
                    filterList = list;
                    filterList = Filters.filterSalaryAboveThreshold(b1.isSelected(), filterList, Integer.parseInt(textFieldSalary.getText()));
                    filterList = Filters.filterBirthyearAboveThreshold(b2.isSelected(), filterList, Integer.parseInt(textFieldBirthYear.getText()));
                    filterList = Filters.filterSex(b3.isSelected(), filterList, (textFieldSex.getText().charAt(0)));
                    filterList = Filters.filterDepartments(b4.isSelected(), filterList, textFieldDepartment.getText());

                    ModelData model = new ModelData(filterList);
                    table.setModel(model);
                } else {
                    b4.setSelected(false);
                    JOptionPane.showMessageDialog(null, Validation.getValidateMessage());
                }
            });

            textFieldSalary.addMouseListener(new ClickListener(mouseEvent -> {
                textFieldSalary.setText("");}));
            textFieldBirthYear.addMouseListener(new ClickListener(mouseEvent -> {
                textFieldBirthYear.setText("");}));
            textFieldSex.addMouseListener(new ClickListener(mouseEvent -> {
                textFieldSex.setText("");}));
            textFieldDepartment.addMouseListener(new ClickListener(mouseEvent -> {
                textFieldDepartment.setText("");}));



        }

    }
}
