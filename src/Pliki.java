import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Pliki {

    public static void odcztajPlik() {

        Pracownik pracownik = new Pracownik();

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("plik.txt");
        } catch (FileNotFoundException e) {
            System.out.println("BŁĄD!!! Nie znaleziono pliku...");
            System.exit(1);
        }

        int bajt = 0;
        StringBuffer slowo = new StringBuffer();
        int licznik = 0;

        // ODCZYT KOLEJNYCH BAJTÓW Z PLIKU:
        try {
            bajt = fis.read();
            while (bajt != -1) { // wartość -1 zwracana gdy koniec pliku...
                System.out.print((char) bajt);
                if (bajt != ',')
                    slowo.append((char) bajt);
                else {
                    licznik++;
                    if (licznik < 8) {
                        String slowo1 = slowo.toString();
                        dodajParametr(pracownik, licznik, slowo1);
                        slowo = new StringBuffer();
                    }
                    if (licznik == 8) {
                        String slowo1 = slowo.toString();
                        dodajParametr(pracownik, licznik, slowo1);
                        DodajFrame.getLista().add(pracownik);
                        pracownik = null;
                        pracownik=new Pracownik();
                        licznik = 0;
                        slowo = new StringBuffer();
                    }
                }
                bajt = fis.read();
            }
        } catch (IOException e) {
            System.out.println("BŁĄD ODCZYTU!!!");
            System.exit(2);
        }

        // ZAMYKANIE PLIKU:
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dodajParametr(Pracownik pracownik, int licznik, String slowo) {
        //pracownik = new Pracownik();
        if (licznik == 1)
            pracownik.setImie(slowo);//String.valueOf(slowo));
        if (licznik == 2)
            pracownik.setNazwisko(slowo);//String.valueOf(slowo));
        if (licznik == 3)
            pracownik.setPlec(slowo.charAt(0));
        if (licznik == 4)
            pracownik.setNumerDzialu(Integer.parseInt(slowo));//Integer.parseInt(String.valueOf(slowo)));
        if (licznik == 5)
            pracownik.setPensja(Float.parseFloat(slowo));//Float.valueOf(String.valueOf(slowo)));
        if (licznik == 6)
            pracownik.setRokUrodzenia(Integer.parseInt(slowo));
        if (licznik == 7)
            pracownik.setIloscDzieci(Integer.parseInt(slowo));
        if (licznik == 8)
            pracownik.setStanCywilny(Boolean.valueOf(slowo));

    }
}



