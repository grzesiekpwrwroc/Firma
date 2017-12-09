public class Pracownik {


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


    public void wyswietlPracownika(){
        System.out.println("Imie:"+this.imie +" Nazwisko:" +this.nazwisko+ " Płeć:"+this.plec +" Numer dzialu:"+ this.numerDzialu+ " Pensja:"+this.pensja+" Rok urodzenia"+ this.rokUrodzenia+" Ilość dzieci:"+this.iloscDzieci+" Stan cywilny:"+this.stanCywilny);
    }

    public void wyswietlPracownikaOkrojona(){
        System.out.println("Imie:"+this.imie +" Nazwisko:" +this.nazwisko+  " Pensja:"+this.pensja);
    }

    public void wyswietlSpecjalne(){
        System.out.println(this.imie.toUpperCase()+ " " +this.nazwisko.toUpperCase());
    }

    public void wyswietlGetterami(){
        System.out.println(getImie()+ " "+ getNazwisko());
    }

    public boolean czyPensjaPowyzej(float prog){
        return getPensja()>prog*2;
    }

    public void dajPodwyzke(float procent){

        procent+=getIloscDzieci()*2;
        if(getStanCywilny()) procent+=3;
        setPensja(getPensja()*(1+(procent/100)));


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
