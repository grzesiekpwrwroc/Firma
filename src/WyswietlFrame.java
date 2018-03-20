
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
            JTextField tekstFieldProcent = new JTextField("Procent podwyżki");
            JTextField tekstFieldBudzet = new JTextField("Budżet");

            JButton dajPodwyzke = new JButton("Daj podwyżkę");

            add(new JScrollPane(tekstFieldProcent),BorderLayout.WEST);
            add(new JScrollPane(tekstFieldBudzet),BorderLayout.CENTER);
            add(new JScrollPane(dajPodwyzke),BorderLayout.EAST);

            dajPodwyzke.addActionListener(e -> {
                ModelData model = (ModelData) table.getModel();
                Pracownik wybrany = null;
                try{
                    int wiersz = table.getSelectedRow();
                    wybrany = model.data.get(wiersz);

                    DodajFrame.setLista(Pracownik.czyPodwyzkaMozliwa(wybrany,Float.parseFloat(tekstFieldProcent.getText()),Long.parseLong(tekstFieldBudzet.getText())));
                    //new ModelData(Pracownik.czyPodwyzkaMozliwa(wybrany,Float.parseFloat(tekstFieldProcent.getText()),Long.parseLong(tekstFieldBudzet.getText())));
                   // model.setData(DodajFrame.getLista());//=new ModelData(DodajFrame.getLista());
                    model = new ModelData(DodajFrame.getLista());
                    table.setModel(model);
                }catch(Exception e1){
                    DodajFrame.setLista(Pracownik.czyPodwyzkaMozliwa(null,Float.parseFloat(tekstFieldProcent.getText()),Long.parseLong(tekstFieldBudzet.getText())));
                    //JOptionPane.showMessageDialog(null,"Błąd");
                    model = new ModelData(DodajFrame.getLista());
                    table.setModel(model);
                }table.updateUI();
            });


            JButton usun = new JButton("Usuń pracownika");
            usun.addActionListener(e -> {
                ModelData model = (ModelData) table.getModel();
                Pracownik usuniety = null;
                try {
                    int wiersz = table.getSelectedRow();
                    usuniety = model.data.get(wiersz);
                    model.removeRow(wiersz);
                    //usuniety.wyswietlPracownikaOkrojona();
                    JOptionPane.showMessageDialog(null, "Usunięto pracownika:" + usuniety.wyswietlPracownika());
                }
                catch(NullPointerException e1){
                        JOptionPane.showMessageDialog(null, e1.getMessage());
                        }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, " Zaznacz pracownika do usunięcia");
                    }
                table.updateUI();

            });
            add(new JScrollPane(usun),BorderLayout.PAGE_END);
            setVisible(true);
        }
}
