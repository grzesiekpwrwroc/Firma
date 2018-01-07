


import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;


public class FiltrujFrame {

    JTable table;
    List<Pracownik> lista;
    List<Pracownik> listaFiltrowana;

    FiltrujFrame(int licznik) {
        JFrame ramka = new JFrame();
        ramka.setLayout(null);
        ramka.setBounds(10, 10, 1030, 800);
        ramka.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        lista = DodajFrame.getLista();
        listaFiltrowana = lista;
        Container c = ramka.getContentPane();
        //List<Pracownik> lista=DodajFrame.getLista();
        TabelkaPanel t = new TabelkaPanel();
        ParametryPanel p = new ParametryPanel();
        t.setBounds(10, 10, 1000, 600);
        p.setBounds(10, 620, 1000, 150);
        t.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        p.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        c.add(t);
        c.add(p);

        ramka.setVisible(true);
        ramka.setResizable(false);
    }

    class TabelkaPanel extends JPanel {
        TabelkaPanel() {
            setLayout(new BorderLayout());
            //super();
            table = new JTable(new ModelData(lista));
            table.setSize(800, 500);
            add(new JScrollPane(table),BorderLayout.PAGE_START);
        }
    }

    class ParametryPanel extends JPanel {
        ParametryPanel() {
            //setLayout(null);
            JButton b1 = new JButton("Filtruj pensja");
            JButton b2 = new JButton("Filtruj rok urodzenia");
            JButton b3 = new JButton("Filtruj płeć");
            JButton b4 = new JButton("Filtruj dział");
            //JButton b5 = new JButton("Filtruj singli");
            JTextField textFieldPensja = new JTextField("Podaj kwotę");
            JTextField textFieldRokUrodzenia = new JTextField("Podaj rok urodzenia");
            JTextField textFieldPlec = new JTextField("Podaj płeć");
            JTextField textFieldDzial = new JTextField("Podaj dział");

            /*b1.setBounds(20,640,200,20);
            textFieldPensja.setBounds(20,670,100,20);
            b2.setBounds(240,640,200,20);
            textFieldRokUrodzenia.setBounds(240,670,100,20);*/

            add(b1);
            add(textFieldPensja);
            add(b2);
            add(textFieldRokUrodzenia);
            add(b3);
            add(textFieldPlec);
            add(b4);
            add(textFieldDzial);


            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Validation.validatePensja(textFieldPensja)){
                    listaFiltrowana = Filtry.filtrujPensjaPowyzejProgu(listaFiltrowana,Integer.parseInt(textFieldPensja.getText()));
                    ModelData model = new ModelData(listaFiltrowana);
                    table.setModel(model);}
                    else JOptionPane.showMessageDialog(null, DodajFrame.getWalidacjaWiadomosc());
                    //table.setRowSorter(new TableRowSorter(model));
                }
            });

            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //List<Pracownik> listaFiltrowana=lista;
                    if(Validation.validateRokUrodzenia(textFieldRokUrodzenia)){
                    listaFiltrowana = Filtry.filtrujRokUrodzaniaPowyzejProgu(listaFiltrowana, Integer.parseInt(textFieldRokUrodzenia.getText()));
                    ModelData model = new ModelData(listaFiltrowana);
                    table.setModel(model); }//= new JTable(new ModelData(listaFiltrowana));
                    else JOptionPane.showMessageDialog(null, DodajFrame.getWalidacjaWiadomosc());
                }
            });

            b3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //List<Pracownik> listaFiltrowana=lista;
                    if(Validation.validatePlec(textFieldPlec)){
                        listaFiltrowana = Filtry.filtrujPlec(listaFiltrowana, (textFieldPlec.getText().charAt(0)));
                        ModelData model = new ModelData(listaFiltrowana);
                        table.setModel(model); }//= new JTable(new ModelData(listaFiltrowana));
                    else JOptionPane.showMessageDialog(null, DodajFrame.getWalidacjaWiadomosc());
                }
            });

            b4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //List<Pracownik> listaFiltrowana=lista;
                    //b4.setSelected(true);
                    if(b4.isSelected()==false){
                        if(Validation.validateDzial(textFieldDzial)){
                            listaFiltrowana = Filtry.filtrujDzial(listaFiltrowana, Integer.parseInt(textFieldDzial.getText()));
                            ModelData model = new ModelData(listaFiltrowana);
                            table.setModel(model); //= new JTable(new ModelData(listaFiltrowana));
                            b4.setSelected(true);
                            b4.setBackground(Color.BLUE);}
                        else JOptionPane.showMessageDialog(null, DodajFrame.getWalidacjaWiadomosc());}
                    else {
                        b4.setSelected(false);
                        b4.setBackground(Color.BLACK);
                    }

                }
            });
            textFieldPensja.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    textFieldPensja.setText("");
                }
                @Override
                public void mousePressed(MouseEvent e) { }
                @Override
                public void mouseReleased(MouseEvent e) { }
                @Override
                public void mouseEntered(MouseEvent e) { }
                @Override
                public void mouseExited(MouseEvent e) { }
            });
            textFieldRokUrodzenia.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    textFieldRokUrodzenia.setText("");
                }
                @Override
                public void mousePressed(MouseEvent e) { }
                @Override
                public void mouseReleased(MouseEvent e) { }
                @Override
                public void mouseEntered(MouseEvent e) { }
                @Override
                public void mouseExited(MouseEvent e) { }
            });
            textFieldPlec.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    textFieldPlec.setText("");
                }
                @Override
                public void mousePressed(MouseEvent e) { }
                @Override
                public void mouseReleased(MouseEvent e) { }
                @Override
                public void mouseEntered(MouseEvent e) { }
                @Override
                public void mouseExited(MouseEvent e) { }
            });
            textFieldDzial.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    textFieldDzial.setText("");
                }
                @Override
                public void mousePressed(MouseEvent e) {}
                @Override
                public void mouseReleased(MouseEvent e) {}
                @Override
                public void mouseEntered(MouseEvent e) {}
                @Override
                public void mouseExited(MouseEvent e) {}
            });
        }


    }
}
