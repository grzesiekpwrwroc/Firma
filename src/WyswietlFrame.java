
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WyswietlFrame extends JFrame {

        WyswietlFrame(){
            setLayout(new BorderLayout());
            setBounds(10, 10, 1000, 800);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            //ModelData model = new ModelData(DodajFrame.getLista());
            JTable table = new JTable(new ModelData(DodajFrame.getLista()));
            //table.setBounds(10,10,100,200);
            add(new JScrollPane(table),BorderLayout.PAGE_START);

            //JButton przyciskFiltruj=new JButton("Filtruj");
            //add(przyciskFiltruj,BorderLayout.WEST);
            //JTable table2 = new JTable(new ModelData((Filtry.filtrujPensjaPowyzejProgu(10000)).filtrujRokUrodzeniaPowyzejProgu(1980)));
           //JTable table2 = new JTable(new ModelData(Filtry.filtrujRokUrodzaniaPowyzejProgu(true,Filtry.filtrujPensjaPowyzejProgu(true,DodajFrame.getLista(),9900),1980)));
           // table2.setBounds(10,600,200,200);
            //add(new JScrollPane(table));
            //add(new JScrollPane(table2));
            //add(table);
            //add(table2);
            JButton usun = new JButton("Usuń");
            usun.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ModelData model = (ModelData) table.getModel();
                    Pracownik usuniety = null;
                    try {
                        int wiersz = table.getSelectedRow();
                        usuniety = model.data.get(wiersz);
                        model.removeRow(wiersz);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                    table.updateUI();
                    try{
                        JOptionPane.showMessageDialog(null, "Usunięto pracownika"+usuniety.wyswietlPracownika());
                    } catch(NullPointerException e1){
                        JOptionPane.showMessageDialog(null, e1.getMessage());
                    }
                }
            });
            add(new JScrollPane(usun),BorderLayout.PAGE_END);
            setVisible(true);
        }
}
