import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;


public class DodajFrame extends JFrame implements ActionListener, MouseListener {

    JTextField tekstFieldMail;
    private JTextField tekstFieldImie;
    JTextField tekstFieldNazwisko;
    JTextField tekstFieldRokUrodzenia;
    JTextField tekstFieldPlec;
    JTextField tekstFieldDzial;
    JToggleButton tekstFieldStanCywilny;
    JTextField tekstFieldIloscDzieci;
    JTextField tekstFieldPensja;

    JButton przycisk;

    JLabel labelGlowne;
    JLabel labelImie;
    JLabel labelMail;
    JLabel labelNazwisko;
    JLabel labelRokUrodzenia;
    JLabel labelPlec;
    JLabel labelDzial;
    JLabel labelStanCywilny;
    JLabel labelIloscDzieci;
    JLabel labelPensja;

    private static List<Pracownik> lista = new ArrayList<>();

    public static List<Pracownik> getLista() {
        return lista;
    }



    int tekst;
    String tekst2;
    private static String walidacjaWiadomosc;

    public static void setWalidacjaWiadomosc(String walidacjaWiadomosc) {
        DodajFrame.walidacjaWiadomosc = walidacjaWiadomosc;
    }
    public static String getWalidacjaWiadomosc(){
        return walidacjaWiadomosc;
    }



    public DodajFrame() {
        super("Dodaj pracownika");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 600);
        setLocation(10, 10);
        setLayout(null);

        labelMail = new JLabel("Mail:");
        labelImie = new JLabel("Imie:");
        labelGlowne = new JLabel("Dodawanie nowego pracownika");
        labelNazwisko = new JLabel("Nazwisko:");
        labelDzial = new JLabel("Dział:");
        labelIloscDzieci = new JLabel("Ilość dzieci:");
        labelRokUrodzenia = new JLabel("Rok urodzenia:");
        labelPlec = new JLabel("Płeć:");
        labelStanCywilny = new JLabel("Stan cywilny:");
        labelPensja = new JLabel("Pensja:");

        tekstFieldMail = new JTextField();
        tekstFieldImie = new JTextField();
        tekstFieldNazwisko = new JTextField();
        tekstFieldDzial= new JTextField();
        tekstFieldPlec= new JTextField();
        tekstFieldRokUrodzenia= new JTextField();
        tekstFieldIloscDzieci= new JTextField();
        tekstFieldStanCywilny= new JToggleButton("Singiel", true);
        tekstFieldPensja= new JTextField();

        tekstFieldStanCywilny.addActionListener(this);

        przycisk = new JButton("Dodaj pracownika");

        labelImie.setBounds(10, 90, 60, 20);
        labelMail.setBounds(10, 60, 60, 20);
        labelGlowne.setBounds(10, 10, 300, 50);
        labelNazwisko.setBounds(10, 120, 60, 20);
        labelRokUrodzenia.setBounds(10, 150, 100, 20);
        labelDzial.setBounds(10, 180, 60, 20);
        labelStanCywilny.setBounds(10, 240, 100, 20);
        labelIloscDzieci.setBounds(10, 270, 100, 20);
        labelPensja.setBounds(10, 300, 60, 20);
        labelPlec.setBounds(10, 210, 60, 20);

        tekstFieldMail.setBounds(100, 60, 140, 20);
        tekstFieldImie.setBounds(100, 90, 140, 20);
        tekstFieldNazwisko.setBounds(100, 120, 140, 20);
        tekstFieldRokUrodzenia.setBounds(100, 150, 140, 20);
        tekstFieldDzial.setBounds(100, 180, 140, 20);
        tekstFieldPlec.setBounds(100, 210, 140, 20);
        tekstFieldStanCywilny.setBounds(100, 240, 140, 20);
        tekstFieldIloscDzieci.setBounds(100, 270, 140, 20);
        tekstFieldPensja.setBounds(100, 300, 140, 20);

        przycisk.setBounds(10, 350, 140, 50);


        add(tekstFieldMail);
        add(tekstFieldImie);
        add(tekstFieldNazwisko);
        add(tekstFieldDzial);
        add(tekstFieldIloscDzieci);
        add(tekstFieldRokUrodzenia);
        add(tekstFieldStanCywilny);
        add(tekstFieldPensja);
        add(tekstFieldPlec);

        add(labelMail);
        add(przycisk);
        add(labelImie);
        add(labelGlowne);
        add(labelNazwisko);
        add(labelDzial);
        add(labelPensja);
        add(labelRokUrodzenia);
        add(labelStanCywilny);
        add(labelPlec);
        add(labelIloscDzieci);

        przycisk.addMouseListener(this);
        tekstFieldMail.addActionListener(this);
        tekstFieldImie.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tekstFieldStanCywilny.setSelected(((JToggleButton)e.getSource()).isSelected());
        if(tekstFieldStanCywilny.isSelected()){
            tekstFieldStanCywilny.setText("Singiel");
            //tekstFieldStanCywilny.setSelected(false);
        }
        if(!tekstFieldStanCywilny.isSelected()){
            tekstFieldStanCywilny.setText("Po ślubie");
            //tekstFieldStanCywilny.setSelected(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (isValidate()) {
            Pracownik pracownik = new Pracownik(tekstFieldImie.getText(),tekstFieldNazwisko.getText(),
                    tekstFieldPlec.getText().charAt(0),Integer.parseInt(tekstFieldDzial.getText()),
                    Integer.parseInt(tekstFieldPensja.getText()),
                    Integer.parseInt(tekstFieldRokUrodzenia.getText()),Integer.parseInt(tekstFieldIloscDzieci.getText()),
                    tekstFieldStanCywilny.isSelected());
            getLista().add(pracownik);
            dispose();
        } else JOptionPane.showMessageDialog(null, getWalidacjaWiadomosc());
    }

    public boolean isValidate() {
        return Validation.validateMail(tekstFieldMail)&& Validation.validateImie(tekstFieldImie)
                && Validation.validateNazwisko(tekstFieldNazwisko) && Validation.validateRokUrodzenia(tekstFieldRokUrodzenia)
                && Validation.validateDzial(tekstFieldDzial) && Validation.validatePlec(tekstFieldPlec)
                && Validation.validateIloscDzieci(tekstFieldIloscDzieci) && Validation.validatePensja(tekstFieldPensja);
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
}



