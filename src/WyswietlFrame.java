import javax.swing.*;


public class WyswietlFrame extends JFrame {

        WyswietlFrame(){
            setBounds(100, 100, 500, 400);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JTable table = new JTable(new ModelData());
            add(new JScrollPane(table));
            setVisible(true);
        }
}
