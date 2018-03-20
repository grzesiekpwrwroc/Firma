import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Pracownik {

    /*public enum Plec{
        MALE, FEMALE;
    }*/

    static String wiadomosc;


    private String imie;
    private String nazwisko;
    private char plec;
    private int numerDzialu;
    private float pensja;
    private int rokUrodzenia;
    private int iloscDzieci;
    private boolean stanCywilny;


    public Pracownik(String imie, String nazwisko, char plec, int numerDzialu, float pensja, int rokUrodzenia, int iloscDzieci, boolean stanCywilny) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.numerDzialu = numerDzialu;
        this.pensja = pensja;
        this.rokUrodzenia = rokUrodzenia;
        this.iloscDzieci = iloscDzieci;
        this.stanCywilny = stanCywilny;

    }

    public Pracownik() {

    }

    public Pracownik(Pracownik pracownik) {
        this.imie = pracownik.imie;
        this.nazwisko = pracownik.nazwisko;
        this.plec = pracownik.plec;
        this.numerDzialu = pracownik.numerDzialu;
        this.pensja = pracownik.pensja;
        this.rokUrodzenia = pracownik.rokUrodzenia;
        this.iloscDzieci = pracownik.iloscDzieci;
        this.stanCywilny = pracownik.stanCywilny;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null || obj == this || !(obj instanceof Pracownik))
            return false;

        Pracownik pracownik = (Pracownik) obj;

        if (pracownik.imie != this.imie) return false;
        if (pracownik.nazwisko != this.nazwisko) return false;
        if (pracownik.plec != this.plec) return false;
        if (pracownik.numerDzialu != this.numerDzialu) return false;
        if (pracownik.pensja != this.pensja) return false;
        if (pracownik.rokUrodzenia != this.rokUrodzenia) return false;
        if (pracownik.iloscDzieci != this.iloscDzieci) return false;
        if (pracownik.stanCywilny != this.stanCywilny) return false;


        return true;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public char getPlec() {
        return plec;
    }

    public void setPlec(char plec) {
        this.plec = plec;
    }

    public int getNumerDzialu() {
        return numerDzialu;
    }

    public void setNumerDzialu(int numerDzialu) {
        this.numerDzialu = numerDzialu;
    }

    public float getPensja() {
        return pensja;
    }

    public void setPensja(float pensja) {
        this.pensja = pensja;
    }

    public int getRokUrodzenia() {
        return rokUrodzenia;
    }

    public void setRokUrodzenia(int rokUrodzenia) {
        this.rokUrodzenia = rokUrodzenia;
    }

    public int getIloscDzieci() {
        return iloscDzieci;
    }

    public void setIloscDzieci(int iloscDzieci) {
        this.iloscDzieci = iloscDzieci;
    }

    public boolean getStanCywilny() {
        return stanCywilny;
    }

    public void setStanCywilny(boolean stanCywilny) {
        this.stanCywilny = stanCywilny;
    }


    public String wyswietlPracownika() {
        return this.imie + " " + this.nazwisko + " " + this.plec + " " + this.numerDzialu + " " + this.pensja + " " + this.rokUrodzenia + " " + this.iloscDzieci + " " + this.stanCywilny;
    }

    public void wyswietlPracownikaOkrojona() {
        System.out.println("Imie:" + this.imie + " Nazwisko:" + this.nazwisko + " Pensja:" + this.pensja);
    }

    public void wyswietlSpecjalne() {
        System.out.println(this.imie.toUpperCase() + " " + this.nazwisko.toUpperCase());
    }

    public void wyswietlGetterami() {
        System.out.println(getImie() + " " + getNazwisko());
    }

    public boolean czyPensjaPowyzej(float prog) {
        return getPensja() > prog;
    }

    public void dajPodwyzke(float procent) {
        //if (Statystyki.sredniaArytmetyczna(DodajFrame.getLista()) < 7000) {

        procent += getIloscDzieci() * 2;
        if (getStanCywilny()) procent += 3;
        setPensja(getPensja() * (1 + (procent / 100)));
        //}
    }

    public static void logikaPodwyzki(List<Pracownik> lista, float procent) {
        setWiadomosc("");
        if (Statystyki.sredniaArytmetyczna() < 5000 || Statystyki.pierwszyKwartyl() < 2500 || Statystyki.mediana() < 4000) {
            if (Statystyki.trzeciKwartyl() < Statystyki.sredniaArytmetyczna() * 1.5) {
                for (Pracownik pracownik : lista) {
                    pracownik.dajPodwyzke(procent);
                }
                setWiadomosc("Każdy dostał podwyżkę!");
            } else {
                for (Pracownik pracownik : lista) {
                    if (pracownik.getPensja() < Statystyki.trzeciKwartyl())
                        pracownik.dajPodwyzke(procent);
                }
                setWiadomosc("3/4 pracowników dostało podwyżkę!");
            }
        } else {
            for (Pracownik pracownik : lista) {
                if (pracownik.getPensja() < Statystyki.pierwszyKwartyl())
                    pracownik.dajPodwyzke(procent);
            }
            setWiadomosc("1/4 pracowników dostało podwyżkę!");
            //return lista;
        }
    }

    public static void setWiadomosc(String wiadomosc1) {
        wiadomosc = wiadomosc1;
    }

    public static String getWiadomosc() {
        return wiadomosc;
    }


   /* public void dajPodwyzke1(Optional<Pracownik> pracownik, float procent, int budzet,List<Pracownik>lista){
        if(pracownik!=null){
            if(czyPodwyzkaMozliwa(pracownik,procent,budzet)){
                pracownik.dajPodwyzke(procent);
            }
        }
    }*/

    public static int sumaZarobkow(List<Pracownik> lista) {
        int zarobki = 0;
        for (Pracownik pracownik : lista) {
            zarobki += pracownik.getPensja();
        }
        return zarobki;
    }
    public static List<Pracownik> kopiujListe(List<Pracownik> lista){
        List<Pracownik> kopia= new ArrayList<>();
        for (Pracownik x : lista) {
            kopia.add(new Pracownik(x));
        }
        return kopia;
    }


    public static List<Pracownik> czyPodwyzkaMozliwa(Pracownik pracownik, float procent, long budzet) {
        List<Pracownik> kopia = new ArrayList<>();
        List<Pracownik> lista = DodajFrame.getLista();
        //lista.get(2).setPensja(Statystyki.trzeciKwartyl(lista));
        //kopia.addAll(lista);

        /*for (Pracownik x : lista) {
            kopia.add(new Pracownik(x));
        }*/
        kopia=kopiujListe(lista);

        if (pracownik != null) {
            int i = 0;
            for (Pracownik prac : kopia) {
                if (prac.equals(pracownik)) {
                    prac.dajPodwyzke(procent);
                    i = 100;
                }
                i++;
            }
            if (sumaZarobkow(kopia) <= budzet) {
                JOptionPane.showMessageDialog(null, "Pracownik: " + pracownik.wyswietlPracownika() + " dostał podwyżkę!");
                return kopia;
            } else {
                JOptionPane.showMessageDialog(null, "Nie ma pieniędzy!");
                return lista;
            }
        } else {
            logikaPodwyzki(kopia, procent);

            if (sumaZarobkow(kopia) <= budzet) {

                JOptionPane.showMessageDialog(null, getWiadomosc());
                return kopia;
            } else {
                JOptionPane.showMessageDialog(null, "Nie ma pieniędzy dla wszystkich");
                return lista;
            }
        }
        //return lista;
    }



    /*public static void main(String[] args) {
        Pracownik pracownik = new Pracownik("Grzegorz", "Jarus",'M',2,3000, 28,2,true);
        pracownik.wyswietlPracownika();
        pracownik.wyswietlPracownikaOkrojona();
        pracownik.wyswietlSpecjalne();
        System.out.println(pracownik.czyPensjaPowyzej(3000));
        pracownik.wyswietlGetterami();
        pracownik.dajPodwyzke(10);
        pracownik.wyswietlPracownikaOkrojona();
    }*/


}
