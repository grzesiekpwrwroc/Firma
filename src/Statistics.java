
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Statistics {



    public static int arithmeticAverage(){
        List<Employee> list= AddEmployeeFrame.getList();
        double sum=0;
        for (Employee employee: list) {
            sum+=employee.getSalary();
        }return (int)sum/list.size();
    }
    public static int median(){
        List<Employee> list= AddEmployeeFrame.getList();
        List<Employee> copy= new ArrayList<>();
        //kopia=list;
        copy.addAll(list);
        copy.sort(Comparator.comparing(Employee::getSalary));
        int size=copy.size();

        return size%2==0?(int)copy.get(size/2-1).getSalary(): (int) copy.get(size / 2).getSalary();
    }

    public static double variance(List<Employee> list){
        int average= arithmeticAverage();
        double sum=0;
        for (Employee pracownik:list) {
            sum+=Math.pow(pracownik.getSalary()-average,2);
        }
        return sum/list.size();
    }

    public static int firstQuartile(){
        List<Employee> list= AddEmployeeFrame.getList();
        List<Employee> copy= new ArrayList<>();
        //kopia=list;
        copy.addAll(list);
        copy.sort(Comparator.comparing(Employee::getSalary));
        int size = copy.size();

        return size%2==0?(int)copy.get(size/4-1).getSalary(): (int) copy.get(size / 4).getSalary();
    }

    public static int thirdQuartile(){
        List<Employee> list= AddEmployeeFrame.getList();
        List<Employee> copy= new ArrayList<>();
        //kopia=list;
        copy.addAll(list);
        copy.sort(Comparator.comparing(Employee::getSalary));
        int size=copy.size();

        return size%2==0?(int)copy.get(3*size/4-1).getSalary(): (int) copy.get(3*size/4).getSalary();
    }
}
