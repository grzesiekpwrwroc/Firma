import javax.swing.*;
import java.util.regex.Pattern;

public class Validation {

    private static String walidacjaWiadomosc;

    public static boolean validateMail(String mail) {
        if (mail.length() == 0) {
            setWalidacjaWiadomosc("Proszę podać E-mail");
            return false;
        }
        if (Pattern.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$", mail))
            return true;
        else {
            setWalidacjaWiadomosc("Nieprawidłowy format maila");
            return false;
        }

    }


    public static boolean validateImie(String imie) {
        if (imie.length() == 0) {
            setWalidacjaWiadomosc("Proszę podać imię");
            return false;
        }
        if (Pattern.matches("[AaĄąBbCcĆćDdEeĘęFfGgHhIiJjKkLlŁłMmNnŃńOoÓóPpRrSsŚśTtUuWwYyZzŹźŻż]+", imie))
            return true;
        else {
            setWalidacjaWiadomosc("Imię powinno składać się tylko z liter");
            return false;
        }

    }

    public static boolean validateNazwisko(String nazwisko) {
        if (nazwisko.length() == 0) {
            setWalidacjaWiadomosc("Proszę podać nazwisko");
            return false;
        }
        if (Pattern.matches("[AaĄąBbCcĆćDdEeĘęFfGgHhIiJjKkLlŁłMmNnŃńOoÓóPpRrSsŚśTtUuWwYyZzŹźŻż]+", nazwisko))
            return true;
        else {
            setWalidacjaWiadomosc("Nazwisko powinno składać się tylko z liter");
            return false;
        }

    }

    public static boolean validatePlec(String plec) {
        if (plec.length() == 0) {
            setWalidacjaWiadomosc("Proszę podać płeć");
            return false;
        }
        if (plec.length() != 1) {
            setWalidacjaWiadomosc("Płeć powinna składać się z jednej litery");
            return false;
        } else if (plec.equalsIgnoreCase("K") || plec.equalsIgnoreCase("M"))
            return true;
        else {
            setWalidacjaWiadomosc("Płeć powinna składać się z jednej litery M lub K");
            return false;
        }
    }

    public static boolean validatePensja1(JTextField tekstFieldPensja) {
        if (tekstFieldPensja.getText().length() == 0) {
            setWalidacjaWiadomosc("Proszę podać pensję");
            return false;
        } else if (Pattern.matches("\\d+", tekstFieldPensja.getText()))
            return true;
        else {
            setWalidacjaWiadomosc("Pensja powinna składać się z samych cyfr");
            return false;
        }
    }

    public static boolean validateDzial(String dzial) {
        if (dzial.length() == 0) {
            setWalidacjaWiadomosc("Proszę podać numer działu");
            return false;
        } else if (Pattern.matches("1|2|3|4",dzial))
            return true;
        else {
            setWalidacjaWiadomosc("Dział to liczba 1,2,3 lub 4 ");
            return false;
        }
    }

    @SuppressWarnings("Annotator")
    public static boolean validateDzialy(String dzialy) {
       if (dzialy.length() != 0 && dzialy.length() != 1 && dzialy.length() != 3 && dzialy.length() != 5 && dzialy.length() != 7) {
            setWalidacjaWiadomosc("Format wejścia to NR,NR,NR,NR");
            return false;
        }
       else{
        if (dzialy.length() == 0) {
            setWalidacjaWiadomosc("Proszę podać numer działu");
            return false;
        }
        if (dzialy.length() == 1) {
            if (Pattern.matches("1|2|3|4", dzialy))
                return true;
            else {
                setWalidacjaWiadomosc("Dział to liczba 1,2,3 lub 4 ");
                return false;
            }
        }
        if (dzialy.length() == 3) {
            if (Pattern.matches("\\d{1},\\d{1}", dzialy))
                return true;
            else {
                setWalidacjaWiadomosc("Format wejścia to NR,NR,NR,NR");
                return false;
            }
        }
        if (dzialy.length() == 5) {
            if (Pattern.matches("\\d{1},\\d{1},\\d{1}", dzialy))
                return true;
            else {
                setWalidacjaWiadomosc("Format wejścia to NR,NR,NR,NR");
                return false;
            }
        }
        if (dzialy.length() == 7) {
            if (Pattern.matches("\\d{1},\\d{1},\\d{1},\\d{1}}", dzialy))
                return true;
            else {
                setWalidacjaWiadomosc("Format wejścia to NR,NR,NR,NR");
                return false;
            }
        }}
        return true;
    }

    public static boolean validateRokUrodzenia(String rokUrodzenia) {
        if (rokUrodzenia.length() == 0) {
            setWalidacjaWiadomosc("Proszę podać rok urodzenia");
            return false;
        } else if (Pattern.matches("\\d+", rokUrodzenia)) {
            if (Integer.parseInt(rokUrodzenia) < 1900 || Integer.parseInt(rokUrodzenia) > 9999) {
                setWalidacjaWiadomosc("Rok urodzenia powinna być z przedziału <1900,9999>");
                return false;
            }
            return true;
        } else {
            setWalidacjaWiadomosc("Rok urodzenia powinien składać się z samych cyfr");
            return false;
        }
    }

    public static boolean validateIloscDzieci(String iloscDzieci) {
        if (iloscDzieci.length() == 0) {
            setWalidacjaWiadomosc("Proszę podać ilość dzieci");
            return false;
        } else if (Pattern.matches("\\d+", iloscDzieci))
            return true;

        else {
            setWalidacjaWiadomosc("Ilość dzieci powinna składać się z samych cyfr");
            return false;
        }
    }




    public static boolean validatePensja(String pensja) {
        if (pensja.length()==0) {
            setWalidacjaWiadomosc("Proszę podać pensję");
            return false;
        } else if (Pattern.matches("\\d+", pensja))
            return true;
        else {
            setWalidacjaWiadomosc("Pensja powinna składać się z samych cyfr");
            //walidacjaWiadomosc="Pensja powinna składać się z samych cyfr";
            return false;
        }
    }


    public static void setWalidacjaWiadomosc(String wiadomosc) {
        walidacjaWiadomosc = wiadomosc;
    }
    public static String getWalidacjaWiadomosc(){
        return walidacjaWiadomosc;
    }



}
