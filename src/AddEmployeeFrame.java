import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;


public class AddEmployeeFrame extends JFrame implements ActionListener, MouseListener {

    JTextField textFieldMail;
    private JTextField textFieldName;
    JTextField textFieldSurname;
    JTextField textFieldBirthYear;
    JTextField textFieldSex;
    JTextField textFieldDepartment;
    JToggleButton textFieldMarried;
    JTextField textFieldNumberOfChildren;
    JTextField textFieldSalary;

    JButton button;

    JLabel mainLabel;
    JLabel labelName;
    JLabel labelMail;
    JLabel labelSurname;
    JLabel labelBirthYear;
    JLabel labelSex;
    JLabel labelDepartment;
    JLabel labelMarried;
    JLabel labelNumberOfChildren;
    JLabel labelSalary;

    private static List<Employee> list = new ArrayList<>();

    public static List<Employee> getList() {
        return list;
    }

    public static void setList(List<Employee> list1){
        //list.clear();
        //list.addAll(lista1);
        //list=lista1;
        list=list1;
    }



    /*int tekst;
    String tekst2;
    private static String walidacjaWiadomosc;*/

    public AddEmployeeFrame() {
        super("Add employee");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 600);
        setLocation(10, 10);
        setLayout(null);

        labelMail = new JLabel("Mail:");
        labelName = new JLabel("Name:");
        mainLabel = new JLabel("Adding new employee");
        labelSurname = new JLabel("Surname:");
        labelDepartment = new JLabel("Department:");
        labelNumberOfChildren = new JLabel("Number of childrens:");
        labelBirthYear = new JLabel("Birth year:");
        labelSex = new JLabel("Sex:");
        labelMarried = new JLabel("Married:");
        labelSalary = new JLabel("Salary:");

        textFieldMail = new JTextField();
        textFieldName = new JTextField();
        textFieldSurname = new JTextField();
        textFieldDepartment = new JTextField();
        textFieldSex = new JTextField();
        textFieldBirthYear = new JTextField();
        textFieldNumberOfChildren = new JTextField();
        textFieldMarried = new JToggleButton("Married", true);
        textFieldSalary = new JTextField();

        textFieldMarried.addActionListener(this);

        button = new JButton("Add Employee");

        labelName.setBounds(10, 90, 60, 20);
        labelMail.setBounds(10, 60, 60, 20);
        mainLabel.setBounds(10, 10, 300, 50);
        labelSurname.setBounds(10, 120, 60, 20);
        labelBirthYear.setBounds(10, 150, 100, 20);
        labelDepartment.setBounds(10, 180, 60, 20);
        labelMarried.setBounds(10, 240, 100, 20);
        labelNumberOfChildren.setBounds(10, 270, 100, 20);
        labelSalary.setBounds(10, 300, 60, 20);
        labelSex.setBounds(10, 210, 60, 20);

        textFieldMail.setBounds(100, 60, 140, 20);
        textFieldName.setBounds(100, 90, 140, 20);
        textFieldSurname.setBounds(100, 120, 140, 20);
        textFieldBirthYear.setBounds(100, 150, 140, 20);
        textFieldDepartment.setBounds(100, 180, 140, 20);
        textFieldSex.setBounds(100, 210, 140, 20);
        textFieldMarried.setBounds(100, 240, 140, 20);
        textFieldNumberOfChildren.setBounds(100, 270, 140, 20);
        textFieldSalary.setBounds(100, 300, 140, 20);

        button.setBounds(10, 350, 140, 50);


        add(textFieldMail);
        add(textFieldName);
        add(textFieldSurname);
        add(textFieldDepartment);
        add(textFieldNumberOfChildren);
        add(textFieldBirthYear);
        add(textFieldMarried);
        add(textFieldSalary);
        add(textFieldSex);

        add(labelMail);
        add(button);
        add(labelName);
        add(mainLabel);
        add(labelSurname);
        add(labelDepartment);
        add(labelSalary);
        add(labelBirthYear);
        add(labelMarried);
        add(labelSex);
        add(labelNumberOfChildren);

        button.addMouseListener(this);
        textFieldMail.addActionListener(this);
        textFieldName.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textFieldMarried.setSelected(((JToggleButton)e.getSource()).isSelected());
        if(textFieldMarried.isSelected()){
            textFieldMarried.setText("Married");
            //textFieldMarried.setSelected(false);
        }
        if(!textFieldMarried.isSelected()){
            textFieldMarried.setText("Nor married");
            //textFieldMarried.setSelected(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (isValidate()) {
            Employee employee = new Employee(textFieldName.getText(), textFieldSurname.getText(),
                    textFieldSex.getText().charAt(0),Integer.parseInt(textFieldDepartment.getText()),
                    Integer.parseInt(textFieldSalary.getText()),
                    Integer.parseInt(textFieldBirthYear.getText()),Integer.parseInt(textFieldNumberOfChildren.getText()),
                    textFieldMarried.isSelected());
            getList().add(employee);
            dispose();
        } else JOptionPane.showMessageDialog(null, Validation.getValidateMessage());
    }

    public boolean isValidate() {
        return Validation.validateMail(textFieldMail.getText())&& Validation.validateName(textFieldName.getText())
                && Validation.validateSurname(textFieldSurname.getText()) && Validation.validateBirthYear(textFieldBirthYear.getText())
                && Validation.validateDepartment(textFieldDepartment.getText()) && Validation.validateSex(textFieldSex.getText())
                && Validation.validateNumberOfChildren(textFieldNumberOfChildren.getText()) && Validation.validateSalary(textFieldSalary.getText());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}



