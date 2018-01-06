import com.sun.xml.internal.ws.api.FeatureListValidatorAnnotation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Filtry {


    private static List<Pracownik>lista=DodajFrame.getLista();

    public static List<Pracownik> getLista(){return lista;}

    public static long zliczPensjaPowyzejProgu(List<Pracownik> lista, int prog) {

        long wynik = lista
                //Stream.of(lista)
                .stream()
                .filter(t -> t.getPensja() > prog)
                .count();

        return wynik;
    }

    public static List<Pracownik> filtrujPensjaPowyzejProgu(List<Pracownik> lista, int prog) {

        List<Pracownik> wynik = lista
                .stream()
                .filter(t -> t.getPensja() > prog)
                .collect(toList());
        return wynik;
    }

    public static List<Pracownik> filtrujRokUrodzaniaPowyzejProgu1( int prog) {

        List<Pracownik> wynik = getLista()
                .stream()
                .filter(t -> t.getRokUrodzenia() > prog)
                .collect(toList());
        return wynik;
    }

    public static List<Pracownik> filtrujRokUrodzaniaPowyzejProgu(List<Pracownik> lista, int prog) {

        List<Pracownik> wynik = lista
                .stream()
                .filter(t -> t.getRokUrodzenia() > prog)
                .collect(toList());
        return wynik;
    }

   /* public static List<Pracownik> combo(List<Pracownik>lista){
        lista=filtrujPensjaPowyzejProgu(lista,5000);//.filtrujRokUrodzaniaPowyzejProgu(lista,1980);
        lista=filtrujRokUrodzaniaPowyzejProgu(lista,1980);
        lista.filtrujPensjaP
    }*/
}
