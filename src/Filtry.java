



import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.sort;
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

    public static List<Pracownik> filtrujPensjaPowyzejProgu(boolean stan,List<Pracownik> lista, int prog) {

        List<Pracownik> wynik = lista
                .stream()
                .filter(t -> t.getPensja() >= prog)
                .collect(toList());
        if(stan)
        return wynik;
        else return lista;
    }

    /*public static List<Pracownik> filtrujRokUrodzaniaPowyzejProgu1( int prog) {

        List<Pracownik> wynik = getLista()
                .stream()
                .filter(t -> t.getRokUrodzenia() > prog)
                .collect(toList());
        return wynik;
    }*/

    public static List<Pracownik> filtrujRokUrodzaniaPowyzejProgu(boolean stan,List<Pracownik> lista, int prog) {

        List<Pracownik> wynik = lista
                .stream()
                .filter(t -> t.getRokUrodzenia() >= prog)
                .collect(toList());
        if(stan)
        return wynik;
        else return lista;
    }


   /* public static List<Pracownik> filtrujPlec1(List<Pracownik> lista, char znak) {

        List<Pracownik> wynik = new ArrayList<>();
        for (Pracownik t : lista) {
            if (Objects.equals(znak,t.getPlec())) {
                wynik.add(t);
            }
        }
        return wynik;
    }*/

    public static List<Pracownik> filtrujPlec(boolean stan,List<Pracownik> lista, char znak) {

        Map<Character,Boolean> mapa = new HashMap<>();
        mapa.put('1',true);
        mapa.put('2',false);
        mapa.put('3',false);
        mapa.put('4',true);
        List<Pracownik> wynik = lista
                .stream()
                .filter(t -> t.getPlec()==znak)
                //.filter(t ->t.getNumerDzialu()==(mapa.get((Object)'1'))||(mapa.get((Object)'2')==true)||(mapa.get((Object)'3')==true)||(mapa.get((Object)'4')==true)
                //.filter(t -> t.getRokUrodzenia()=='K')
                .collect(toList());
        if(stan)
        return wynik;
        else return lista;
    }

    public static List<Pracownik> filtrujDzial(boolean stan,List<Pracownik> lista, String dzialy) {


        Predicate<Pracownik> predicate = new Predicate<Pracownik>() {
            @Override
            public boolean test(Pracownik pracownik) {
                Map<Integer, Boolean> mapa = new HashMap<>();
                mapa=czytajDzialy(dzialy);
                return (pracownik.getNumerDzialu() == 1 && mapa.get(1)) || (pracownik.getNumerDzialu() == 2 && mapa.get(2))
                        || (pracownik.getNumerDzialu() == 3 && mapa.get(3)) || (pracownik.getNumerDzialu() == 4 && mapa.get(4)) ? true : false;
            }
        };

       List<Pracownik> wynik = lista
                .stream()
                .filter(predicate)
                .collect(toList());
        if(stan)
        return wynik;
        else return lista;
    }


    public static Map<Integer,Boolean> czytajDzialy(String dzialy){
        Map<Integer, Boolean> mapa = new HashMap<>();
        mapa.put(1, false);
        mapa.put(2, false);
        mapa.put(3, false);
        mapa.put(4, false);
        String dzial;
        if(Validation.validateDzialy(dzialy)) {
            for (int i = 0; i < dzialy.length(); i = i + 2) {
                dzial = String.valueOf(dzialy.charAt(i));
                mapa.put(Integer.parseInt(dzial), true);
            }
        }

        return mapa;
    }

   public Optional<List<Pracownik>> metoda(Optional<List<Pracownik>> lista){return lista;}
}
