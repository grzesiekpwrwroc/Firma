



import java.util.*;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;


public class Filters {


    private static List<Employee>list=AddEmployeeFrame.getList();

    public static List<Employee> getList(){return list;}

    public static long countNumberOfEmployeesAbove(List<Employee> list, int threshold) {

        return list
                //Stream.of(list)
                .stream()
                .filter(t -> t.getSalary() > threshold)
                .count();
    }

    public static long countNumberOfEmployeesInDepertments(List<Employee> list,int department) {

        return list
                //Stream.of(list)
                .stream()
                .filter(p->p.getDepartment()==department)
                .count();
    }

    public static List<Employee> filterSalaryAboveThreshold(boolean state, List<Employee> list, int threshold) {

        List<Employee> result = list
                .stream()
                .filter(t -> t.getSalary() >= threshold)
                .collect(toList());
        if(state)
        return result;
        else return list;
    }


    public static List<Employee> filterBirthyearAboveThreshold(boolean state, List<Employee> list, int threshold) {

        List<Employee> result = list
                .stream()
                .filter(t -> t.getBirthYear() >= threshold)
                .collect(toList());
        if(state)
        return result;
        else return list;
    }


    public static List<Employee> filterSex(boolean state, List<Employee> list, char word) {

        List<Employee> result = list
                .stream()
                .filter(t -> t.getSex()==word)
                .collect(toList());
        if(state)
        return result;
        else return list;
    }

    public static List<Employee> filterDepartments(boolean state, List<Employee> list, String departments) {

        Predicate<Employee> predicate = employee -> {
            Map<Integer, Boolean> map;// = new HashMap<>();
            map = readDepartments(departments);
            return (employee.getDepartment() == 1 && map.get(1)) || (employee.getDepartment() == 2 && map.get(2))
                    || (employee.getDepartment() == 3 && map.get(3)) || (employee.getDepartment() == 4 && map.get(4));
        };

       List<Employee> result = list
                .stream()
                .filter(predicate)
                .collect(toList());
        if(state)
        return result;
        else return list;
    }

    public static Map<Integer,Boolean> readDepartments(String departments){
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(1, false);
        map.put(2, false);
        map.put(3, false);
        map.put(4, false);
        String dzial;
        if(Validation.validateDepartments(departments)) {
            for (int i = 0; i < departments.length(); i = i + 2) {
                dzial = String.valueOf(departments.charAt(i));
                map.put(Integer.parseInt(dzial), true);
            }
        }
        return map;
    }

   public Optional<List<Employee>> metoda(Optional<List<Employee>> list){return list;}
}
