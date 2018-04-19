import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    int counter =0;
    public MainFrame(){
        super("Not Hello World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocation(10, 10);
        setVisible(true);
        setLayout(new FlowLayout());

        JButton b1 = new JButton("Add employee");
        JButton b2 = new JButton("Display employees");
        JButton b3 = new JButton("Filter employees");
        //b1.setBounds(60, 160, 100, 100);
       // b2.setBounds(60, 360, 100, 100);
       // b3.setBounds(60,560,100,100);
        add(b1);
        add(b2);
        add(b3);
        b1.addActionListener(e -> new AddEmployeeFrame());

        b2.addActionListener(e -> new DisplayFrame());
        b3.addActionListener(e -> {


            new FilterFrame(counter);
            counter++;
        });
    }



}
