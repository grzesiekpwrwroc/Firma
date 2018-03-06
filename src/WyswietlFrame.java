import javax.swing.*;
import java.awt.*;


public class WyswietlFrame extends JFrame {

        WyswietlFrame(){
            setLayout(new BorderLayout());
            setBounds(10, 10, 1000, 800);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JTable table = new JTable(new ModelData(DodajFrame.getLista()));
            //table.setBounds(10,10,100,200);
            add(new JScrollPane(table),BorderLayout.PAGE_START);

            //JButton przyciskFiltruj=new JButton("Filtruj");
            //add(przyciskFiltruj,BorderLayout.WEST);
            //JTable table2 = new JTable(new ModelData((Filtry.filtrujPensjaPowyzejProgu(10000)).filtrujRokUrodzeniaPowyzejProgu(1980)));
           JTable table2 = new JTable(new ModelData(Filtry.filtrujRokUrodzaniaPowyzejProgu(true,Filtry.filtrujPensjaPowyzejProgu(true,DodajFrame.getLista(),9900),1980)));
           // table2.setBounds(10,600,200,200);
            //add(new JScrollPane(table));
            //add(new JScrollPane(table2));
            //add(table);
            //add(table2);
            add(new JScrollPane(table2),BorderLayout.PAGE_END);
            setVisible(true);
        }
}
