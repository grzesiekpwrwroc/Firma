import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    int licznik=0;
    public MainFrame(){
        super("Not Hello World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocation(10, 10);
        setVisible(true);
        setLayout(new FlowLayout());

        JButton b1 = new JButton("Dodaj pracownika");
        JButton b2 = new JButton("Wyświetl pracowników");
        JButton b3 = new JButton("Filtruj pracowników");
        //b1.setBounds(60, 160, 100, 100);
       // b2.setBounds(60, 360, 100, 100);
       // b3.setBounds(60,560,100,100);
        add(b1);
        add(b2);
        add(b3);
        b1.addActionListener(e -> new DodajFrame());

        b2.addActionListener(e -> new WyswietlFrame());
        b3.addActionListener(e -> {


            new FiltrujFrame(licznik);
            licznik++;
        });
    }



}
