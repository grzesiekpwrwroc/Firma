
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Files {

    public static void readFile() {

        Employee employee = new Employee();

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("plik.txt");
        } catch (FileNotFoundException e) {
            System.out.println("BŁĄD!!! Nie znaleziono pliku...");
            System.exit(1);
        }

        int byyte = 0;
        StringBuffer word = new StringBuffer();
        int counter = 0;

        // ODCZYT KOLEJNYCH BAJTÓW Z PLIKU:
        try {
            byyte = fis.read();
            while (byyte != -1) { // wartość -1 zwracana gdy koniec pliku...
                System.out.print((char) byyte);
                if (byyte != ',')
                    word.append((char) byyte);
                else {
                    counter++;
                    if (counter < 8) {
                        String word2 = word.toString();
                        addParameter(employee, counter, word2);
                        word = new StringBuffer();
                    }
                    if (counter == 8) {
                        String word2 = word.toString();
                        addParameter(employee, counter, word2);
                        AddEmployeeFrame.getList().add(employee);
                        employee = null;
                        employee=new Employee();
                        counter = 0;
                        word = new StringBuffer();
                    }
                }
                byyte = fis.read();
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

    private static void addParameter(Employee employee, int counter, String word) {
        //pracownik.dajPodwyzke(3);
        try {
            //pracownik = new Pracownik();
            if (counter == 1)
                employee.setName(word);//String.valueOf(slowo));
            if (counter == 2)
                employee.setSurname(word);//String.valueOf(slowo));
            if (counter == 3)
                employee.setSex(word.charAt(0));
            if (counter == 4)
                employee.setDepartment(Integer.parseInt(word));//Integer.parseInt(String.valueOf(slowo)));
            if (counter == 5)
                employee.setSalary(Float.parseFloat(word));//Float.valueOf(String.valueOf(slowo)));
            if (counter == 6)
                employee.setBirthYear(Integer.parseInt(word));
            if (counter == 7)
                employee.setNumberOfChlidrens(Integer.parseInt(word));
            if (counter == 8)
                employee.setMarried(Boolean.valueOf(word));
        }
        catch(NumberFormatException e){
            System.out.println("Zły format" + e.getMessage());
        }

    }
}



