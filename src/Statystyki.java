
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Statystyki {



    public static int sredniaArytmetyczna(){
        List<Pracownik> lista= DodajFrame.getLista();
        double suma=0;
        for (Pracownik prac: lista) {
            suma+=prac.getPensja();
        }return (int)suma/lista.size();
    }
    public static int mediana(){
        List<Pracownik> lista= DodajFrame.getLista();
        List<Pracownik> kopia= new ArrayList<>();
        //kopia=lista;
        kopia.addAll(lista);
        kopia.sort(Comparator.comparing(Pracownik::getPensja));
        int rozmiar=kopia.size();

        return rozmiar%2==0?(int)kopia.get(rozmiar/2-1).getPensja(): (int) kopia.get(rozmiar / 2).getPensja();
    }

    public static double wariancja(List<Pracownik> lista){
        int srednia=sredniaArytmetyczna();
        double suma=0;
        for (Pracownik pracownik:lista) {
            suma+=Math.pow(pracownik.getPensja()-srednia,2);
        }
        return suma/lista.size();
    }

    public static int pierwszyKwartyl(){
        List<Pracownik> lista= DodajFrame.getLista();
        List<Pracownik> kopia= new ArrayList<>();
        //kopia=lista;
        kopia.addAll(lista);
        kopia.sort(Comparator.comparing(Pracownik::getPensja));
        int rozmiar = kopia.size();

        return rozmiar%2==0?(int)kopia.get(rozmiar/4-1).getPensja(): (int) kopia.get(rozmiar / 4).getPensja();
    }

    public static int trzeciKwartyl(){
        List<Pracownik> lista= DodajFrame.getLista();
        List<Pracownik> kopia= new ArrayList<>();
        //kopia=lista;
        kopia.addAll(lista);
        kopia.sort(Comparator.comparing(Pracownik::getPensja));
        int rozmiar=kopia.size();

        return rozmiar%2==0?(int)kopia.get(3*rozmiar/4-1).getPensja(): (int) kopia.get(3*rozmiar/4).getPensja();
    }
}
