


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;


public class FiltrujFrame {

    JTable table;
    List<Pracownik> lista;
    List<Pracownik> listaFiltrowana;
    //List<Pracownik> listaFiltrowana2;

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
            table.setEnabled(false);

            add(new JScrollPane(table),BorderLayout.PAGE_START);
        }
    }

    class ParametryPanel extends JPanel {

        JTextField textFieldPensja = new JTextField(String.valueOf(Statystyki.sredniaArytmetyczna()));
        JTextField textFieldRokUrodzenia = new JTextField(String.valueOf(Statystyki.pierwszyKwartyl()));
        JTextField textFieldPlec = new JTextField(String.valueOf(Statystyki.trzeciKwartyl()));
        //JTextField textFieldPensja = new JTextField("Podaj kwotę");
        //JTextField textFieldRokUrodzenia = new JTextField("Podaj rok urodzenia");
        //JTextField textFieldPlec = new JTextField("Podaj płeć");
        JTextField textFieldDzial = new JTextField("Podaj dział");

        public boolean isValidateFiltry(){
            return Validation.validatePensja(textFieldPensja.getText())&&Validation.validateRokUrodzenia(textFieldRokUrodzenia.getText())&&
                    Validation.validatePlec(textFieldPlec.getText())&&Validation.validateDzialy(textFieldDzial.getText());
        }
        ParametryPanel() {
            //setLayout(null);
            JToggleButton b1 = new JToggleButton("Filtruj pensja");
            JToggleButton b2 = new JToggleButton("Filtruj rok urodzenia");
            JToggleButton b3 = new JToggleButton("Filtruj płeć");
            JToggleButton b4 = new JToggleButton("Filtruj dział");


            add(b1);
            add(textFieldPensja);
            add(b2);
            add(textFieldRokUrodzenia);
            add(b3);
            add(textFieldPlec);
            add(b4);
            add(textFieldDzial);


            b1.addActionListener(e -> {
                if (isValidateFiltry()) {
                    listaFiltrowana = lista;
                    listaFiltrowana = Filtry.filtrujPensjaPowyzejProgu(b1.isSelected(), listaFiltrowana, Integer.parseInt(textFieldPensja.getText()));
                    listaFiltrowana = Filtry.filtrujRokUrodzaniaPowyzejProgu(b2.isSelected(), listaFiltrowana, Integer.parseInt(textFieldRokUrodzenia.getText()));
                    listaFiltrowana = Filtry.filtrujPlec(b3.isSelected(), listaFiltrowana, (textFieldPlec.getText().charAt(0)));
                    listaFiltrowana = Filtry.filtrujDzial(b4.isSelected(), listaFiltrowana, textFieldDzial.getText());

                    ModelData model = new ModelData(listaFiltrowana);
                    table.setModel(model);
                } else {
                    b1.setSelected(false);
                    JOptionPane.showMessageDialog(null, Validation.getWalidacjaWiadomosc());
                }
            });

            b2.addActionListener(e -> {
                //List<Pracownik> listaFiltrowana=lista;
                if (isValidateFiltry()) {
                    listaFiltrowana = lista;
                    listaFiltrowana = Filtry.filtrujPensjaPowyzejProgu(b1.isSelected(), listaFiltrowana, Integer.parseInt(textFieldPensja.getText()));
                    listaFiltrowana = Filtry.filtrujRokUrodzaniaPowyzejProgu(b2.isSelected(), listaFiltrowana, Integer.parseInt(textFieldRokUrodzenia.getText()));
                    listaFiltrowana = Filtry.filtrujPlec(b3.isSelected(), listaFiltrowana, (textFieldPlec.getText().charAt(0)));
                    listaFiltrowana = Filtry.filtrujDzial(b4.isSelected(), listaFiltrowana, textFieldDzial.getText());

                    ModelData model = new ModelData(listaFiltrowana);

                    table.setModel(model);
                }//= new JTable(new ModelData(listaFiltrowana));
                else {
                    b2.setSelected(false);
                    JOptionPane.showMessageDialog(null, Validation.getWalidacjaWiadomosc());
                }
            });

            b3.addActionListener(e -> {
                //List<Pracownik> listaFiltrowana=lista;
                if (isValidateFiltry()) {
                    listaFiltrowana = lista;
                    listaFiltrowana = Filtry.filtrujPensjaPowyzejProgu(b1.isSelected(), listaFiltrowana, Integer.parseInt(textFieldPensja.getText()));
                    listaFiltrowana = Filtry.filtrujRokUrodzaniaPowyzejProgu(b2.isSelected(), listaFiltrowana, Integer.parseInt(textFieldRokUrodzenia.getText()));
                    listaFiltrowana = Filtry.filtrujPlec(b3.isSelected(), listaFiltrowana, (textFieldPlec.getText().charAt(0)));
                    listaFiltrowana = Filtry.filtrujDzial(b4.isSelected(), listaFiltrowana, textFieldDzial.getText());

                    ModelData model = new ModelData(listaFiltrowana);
                    table.setModel(model);
                }//= new JTable(new ModelData(listaFiltrowana));
                else {
                    b3.setSelected(false);
                    JOptionPane.showMessageDialog(null, Validation.getWalidacjaWiadomosc());
                }
            });

            b4.addActionListener(e -> {
                if (isValidateFiltry()) {
                    listaFiltrowana = lista;
                    listaFiltrowana = Filtry.filtrujPensjaPowyzejProgu(b1.isSelected(), listaFiltrowana, Integer.parseInt(textFieldPensja.getText()));
                    listaFiltrowana = Filtry.filtrujRokUrodzaniaPowyzejProgu(b2.isSelected(), listaFiltrowana, Integer.parseInt(textFieldRokUrodzenia.getText()));
                    listaFiltrowana = Filtry.filtrujPlec(b3.isSelected(), listaFiltrowana, (textFieldPlec.getText().charAt(0)));
                    listaFiltrowana = Filtry.filtrujDzial(b4.isSelected(), listaFiltrowana, textFieldDzial.getText());

                    ModelData model = new ModelData(listaFiltrowana);
                    table.setModel(model);
                } else {
                    b4.setSelected(false);
                    JOptionPane.showMessageDialog(null, Validation.getWalidacjaWiadomosc());
                }
            });

            textFieldPensja.addMouseListener(new MouseListener() {
                boolean stann;
                @Override
                public void mouseClicked(MouseEvent e) {

                    if(!stann){
                    textFieldPensja.setText("");
                    stann=true;}
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
            });
            textFieldRokUrodzenia.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    textFieldRokUrodzenia.setText("");
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
            });
            textFieldPlec.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    textFieldPlec.setText("");
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
            });
            textFieldDzial.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    textFieldDzial.setText("");
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
            });

        }

    }
}
