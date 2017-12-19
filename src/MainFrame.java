import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    public MainFrame(){
        super("Not Hello World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocation(10, 10);
        setVisible(true);
        setLayout(new FlowLayout());

        JButton b1 = new JButton("Dodaj pracownika");
        JButton b2 = new JButton("Wyświetl pracowników");
        b1.setBounds(60, 160, 100, 100);
        b2.setBounds(60, 360, 100, 100);
        add(b1);
        add(b2);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DodajFrame();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WyswietlFrame();
            }
        });
    }



}
