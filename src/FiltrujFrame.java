import com.sun.media.sound.ModelAbstractChannelMixer;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class FiltrujFrame extends JFrame {

    JTable table;
    List<Pracownik> lista;
    List<Pracownik> listaFiltrowana;


    FiltrujFrame(int licznik){
    setLayout(new FlowLayout());
    setBounds(10, 10, 1000, 800);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     lista=DodajFrame.getLista();
        listaFiltrowana=lista;
    //List<Pracownik> lista=DodajFrame.getLista();
        table = new JTable(new ModelData(lista));
        table.setSize(1000,400);
        //table.setAutoCreateRowSorter(true);

    add(new JScrollPane(table));

        JButton b1 = new JButton("Filtruj pensja");
        JButton b2 = new JButton("Filtruj rok urodzenia");
        JButton b3 = new JButton("Filtruj płeć");
        JButton b4 = new JButton("Filtruj dział");
        JButton b5 = new JButton("Filtruj singli");
        JTextField textFieldPensja = new JTextField();
        JTextField textFieldRokUrodzenia = new JTextField();
        JTextField textFieldPlec = new JTextField();
        JTextField textFieldDzial = new JTextField();

        textFieldPensja.setSize(50,20);

        add(b1);
        add(textFieldPensja);
        add(b2);
        //add(b3);
       // add(b4);
       // add(b5);
        //add(textFieldPensja);
        add(textFieldRokUrodzenia);
        //add(textFieldPlec);
        //add(textFieldDzial);


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaFiltrowana=Filtry.filtrujPensjaPowyzejProgu(listaFiltrowana,9900);
                ModelData model = new ModelData(listaFiltrowana);
                table.setModel(model);
                //table.setRowSorter(new TableRowSorter(model));
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //List<Pracownik> listaFiltrowana=lista;
                listaFiltrowana=Filtry.filtrujRokUrodzaniaPowyzejProgu(listaFiltrowana,1980);
                ModelData model = new ModelData(listaFiltrowana);
                table.setModel(model);  //= new JTable(new ModelData(listaFiltrowana));

            }
        });

    setVisible(true);
}
}
