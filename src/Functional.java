import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Functional {

    public static void main(String[] args) {

    Function<String,Integer> findWordCount = t -> t.split(" ").length;

    Function<Integer,String> numberToString = integer -> {
        switch(integer){
            case 0: return "Zero";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            default: return "unknown";
        }
    };

    Function<String, String> funkcja = s -> {
        switch(s){
            case "three": return "dupa";
            case "two" : return "dwa";
            default: return "puste";
        }
    };

    Function<String,Integer> dlugosc = s -> s.length();

    Function<Integer,Boolean> pred = integer -> integer==4;
         //Integer count=findWordCount.apply("Czołem wielkiej Polsce!");
        Boolean wynik =
                 findWordCount
                .andThen(numberToString)
                .andThen(funkcja)
                .andThen(dlugosc)
                .andThen(pred)
                .apply("Czołem wielkiej Polsce!");
        System.out.println(wynik);

        Pracownik pracownik= new Pracownik();
        Pracownik pracownik1;
        pracownik1=pracownik;
        System.out.println(pracownik.hashCode());
        System.out.println(pracownik1.hashCode());
        int i=3;
        float j =4;
        int wynik2 = i;
        wynik2+=j;
        System.out.println("");

        List<Integer> lista = new ArrayList<>();
        lista.add(2);
        lista.add(3);
        lista.add(7);

        List<Integer> lista2 = new ArrayList<>();
        lista2.add(4);
        lista2.add(5);
        lista2.add(6);

        lista.clear();
        lista.addAll(lista2);



        List<Pracownik> lista1 = new ArrayList<>();
        lista1.add(new Pracownik("Grzegorz","Jarus",'m',3,3000,1989,2,true));
        lista1.add(new Pracownik("Paweł","Nowak",'m',2,10000,1979,1,false));
        lista1.add(new Pracownik("Monika","Nowak",'k',4,6000,1992,3,true));
        List<Pracownik> kopia = new ArrayList<>();
        //kopia.addAll(lista1);

        for (Pracownik x: lista1) {
            kopia.add(new Pracownik(x));
            x.dajPodwyzke(2);
        }

        for(int z=0; z<lista1.size(); z++){
            System.out.print(lista1.get(z).wyswietlPracownika()+ " ");
            System.out.println(lista1.get(z).hashCode());

            System.out.print(kopia.get(z).wyswietlPracownika()+ " ");
            System.out.println(kopia.get(z).hashCode());

        }

    }

}

