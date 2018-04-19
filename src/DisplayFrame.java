
import javax.swing.*;
import java.awt.*;


public class DisplayFrame extends JFrame {

        DisplayFrame(){
            setLayout(new BorderLayout());
            setBounds(10, 10, 1000, 800);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            //ModelData model = new ModelData(DodajFrame.getList());
            JTable table = new JTable(new ModelData(AddEmployeeFrame.getList()));
            //table.setBounds(10,10,100,200);
            add(new JScrollPane(table),BorderLayout.PAGE_START);
            JTextField textFieldPercent = new JTextField("Percent of raise");
            JTextField textFieldBudget = new JTextField("Budget");

            JButton giveARaise = new JButton("Give a raise");

            add(new JScrollPane(textFieldPercent),BorderLayout.WEST);
            add(new JScrollPane(textFieldBudget),BorderLayout.CENTER);
            add(new JScrollPane(giveARaise),BorderLayout.EAST);

            giveARaise.addActionListener(e -> {

                ModelData model = (ModelData) table.getModel();
                Employee selected = null;
                try{
                    int row = table.getSelectedRow();
                    selected = model.data.get(row);
                    if(Validation.validatePercentOfRaise(textFieldPercent.getText())&&Validation.validateBudgetOfRaise(textFieldBudget.getText()))
                    AddEmployeeFrame.setList(Employee.isRaisePossible(selected,Float.parseFloat(textFieldPercent.getText()),Long.parseLong(textFieldBudget.getText())));
                    //new ModelData(Pracownik.czyPodwyzkaMozliwa(wybrany,Float.parseFloat(tekstFieldProcent.getText()),Long.parseLong(tekstFieldBudzet.getText())));
                   // model.setData(DodajFrame.getList());//=new ModelData(DodajFrame.getList());
                    else
                        JOptionPane.showMessageDialog(null, Validation.getValidateMessage());
                    model = new ModelData(AddEmployeeFrame.getList());
                    table.setModel(model);
                }catch(Exception e1){
                    if(Validation.validatePercentOfRaise(textFieldPercent.getText())&&Validation.validateBudgetOfRaise(textFieldBudget.getText()))
                    AddEmployeeFrame.setList(Employee.isRaisePossible(null,Float.parseFloat(textFieldPercent.getText()),Long.parseLong(textFieldBudget.getText())));
                    //JOptionPane.showMessageDialog(null,"Błąd");
                    else
                        JOptionPane.showMessageDialog(null, Validation.getValidateMessage());
                    model = new ModelData(AddEmployeeFrame.getList());
                    table.setModel(model);
                }table.updateUI();
                //Wykresy.main();
            });


            JButton delete = new JButton("Delete employee");
            delete.addActionListener(e -> {
                ModelData model = (ModelData) table.getModel();
                Employee deleted = null;
                try {
                    int row = table.getSelectedRow();
                    deleted = model.data.get(row);
                    model.removeRow(row);
                    //usuniety.wyswietlPracownikaOkrojona();
                    JOptionPane.showMessageDialog(null, "Deleted empoloyee:" + deleted.displayEmployee());
                }
                catch(NullPointerException e1){
                        JOptionPane.showMessageDialog(null, e1.getMessage());
                        }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, " Select an employee for delete");
                    }
                table.updateUI();

            });
            add(new JScrollPane(delete),BorderLayout.PAGE_END);
            setVisible(true);
        }
}
