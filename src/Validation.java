import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static boolean validateMail(JTextField tekstFieldMail) {
        if (tekstFieldMail.getText().length() == 0) {
            MyFrame.setWalidacjaWiadomosc("Proszę podać E-mail");
            return false;
        }
        if (Pattern.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$", tekstFieldMail.getText()))
            return true;
        else {
            MyFrame.setWalidacjaWiadomosc("Nieprawidłowy format maila");
            return false;
        }

    }


    public static boolean validateImie(JTextField tekstFieldImie) {
        if (tekstFieldImie.getText().length() == 0) {
            MyFrame.setWalidacjaWiadomosc("Proszę podać imię");
            return false;
        }
        if (Pattern.matches("\\D+", tekstFieldImie.getText()))
            return true;
        else {
            MyFrame.setWalidacjaWiadomosc("Imię powinno składać się tylko z liter");
            return false;
        }

    }

    public static boolean validateNazwisko(JTextField tekstFieldNazwisko) {
        if (tekstFieldNazwisko.getText().length() == 0) {
            MyFrame.setWalidacjaWiadomosc("Proszę podać nazwisko");
            return false;
        }
        if (Pattern.matches("\\D+", tekstFieldNazwisko.getText()))
            return true;
        else {
            MyFrame.setWalidacjaWiadomosc("Nazwisko powinno składać się tylko z liter");
            return false;
        }

    }

    public static boolean validatePlec(JTextField tekstFieldPlec) {
        if (tekstFieldPlec.getText().length() == 0) {
            MyFrame.setWalidacjaWiadomosc("Proszę podać płeć");
            return false;
        }
        if (tekstFieldPlec.getText().length() != 1) {
            MyFrame.setWalidacjaWiadomosc("Płeć powinna składać się z jednej litery");
            return false;
        } else if (tekstFieldPlec.getText().equalsIgnoreCase("K") || tekstFieldPlec.getText().equalsIgnoreCase("M"))
            return true;
        else {
            MyFrame.setWalidacjaWiadomosc("Płeć powinna składać się z jednej litery M lub K");
            return false;
        }
    }

    public static boolean validatePensja(JTextField tekstFieldPensja) {
        if (tekstFieldPensja.getText().length() == 0) {
            MyFrame.setWalidacjaWiadomosc("Proszę podać pensję");
            return false;
        } else if (Pattern.matches("\\d+", tekstFieldPensja.getText()))
            return true;
        else {
            MyFrame.setWalidacjaWiadomosc("Pensja powinna składać się z samych cyfr");
            return false;
        }
    }

    public static boolean validateDzial(JTextField tekstFieldDzial) {
        if (tekstFieldDzial.getText().length() == 0) {
            MyFrame.setWalidacjaWiadomosc("Proszę podać numer działu");
            return false;
        } else if (Pattern.matches("1|2|3|4", tekstFieldDzial.getText()))
            return true;
        else {
            MyFrame.setWalidacjaWiadomosc("Dział to liczba 1,2,3 lub 4 ");
            return false;
        }
    }

    public static boolean validateRokUrodzenia(JTextField tekstFieldRokUrodzenia) {
        if (tekstFieldRokUrodzenia.getText().length() == 0) {
            MyFrame.setWalidacjaWiadomosc("Proszę podać rok urodzenia");
            return false;
        } else if (Pattern.matches("\\d+", tekstFieldRokUrodzenia.getText())) {
            if (Integer.parseInt(tekstFieldRokUrodzenia.getText()) < 1900 || Integer.parseInt(tekstFieldRokUrodzenia.getText()) > 9999) {
                MyFrame.setWalidacjaWiadomosc("Rok urodzenia powinna być z przedziału <1900,9999>");
                return false;
            }
            return true;
        } else {
            MyFrame.setWalidacjaWiadomosc("Rok urodzenia powinien składać się z samych cyfr");
            return false;
        }
    }

    public static boolean validateIloscDzieci(JTextField tekstFieldIloscDzieci) {
        if (tekstFieldIloscDzieci.getText().length() == 0) {
            MyFrame.setWalidacjaWiadomosc("Proszę podać ilość dzieci");
            return false;
        } else if (Pattern.matches("\\d+", tekstFieldIloscDzieci.getText()))
            return true;
        else {
            MyFrame.setWalidacjaWiadomosc("Ilość dzieci powinna składać się z samych cyfr");
            return false;
        }
    }
}
