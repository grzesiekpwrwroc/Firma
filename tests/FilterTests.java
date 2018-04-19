import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterTests {
    @Test
    public void filterSalary_salaryAbove5000_returnsSizeEqualsOne(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Grzeogorz","Jarus",'m',3,3000,1989,2,false ));
        list.add(new Employee("Paweł","Nowak",'m',2,6000,1985,1,false ));
        list=Filters.filterSalaryAboveThreshold(true,list,5000);
        assertEquals(1,list.size());
    }
    @Test
    public void filterSalary_salaryAbove3000_returnsSizeEqualsTwo(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Grzeogorz","Jarus",'m',3,3000,1989,2,false ));
        list.add(new Employee("Paweł","Nowak",'m',2,6000,1985,1,false ));
        list=Filters.filterSalaryAboveThreshold(true,list,3000);
        assertEquals(2,list.size());
    }

    @Test
    public void filterDepartments_departmentTwoAndThree_returnsSizeEqualsTwo(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Grzeogorz","Jarus",'m',3,3000,1989,2,false ));
        list.add(new Employee("Paweł","Nowak",'m',2,6000,1985,1,false ));
        list.add(new Employee("Jan","Zielinski",'m',1,3500,1960,0,true ));
        list.add(new Employee("Zuzanna","Abacka",'k',4,1000,1975,4,true ));
        list=Filters.filterDepartments(true,list,"2,3");
        assertEquals(2,list.size());
    }

    @Test
    public void filterDepartments_departmentOneAndTwoAndThreeAndFour_returnsSizeEqualsFour(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Grzeogorz","Jarus",'m',3,3000,1989,2,false ));
        list.add(new Employee("Paweł","Nowak",'m',2,6000,1985,1,false ));
        list.add(new Employee("Jan","Zielinski",'m',1,3500,1960,0,true ));
        list.add(new Employee("Zuzanna","Abacka",'k',4,1000,1975,4,true ));
        list=Filters.filterDepartments(true,list,"1,2,3,4");
        assertEquals(4,list.size());
    }
    @Test
    public void filterSex_sexIsK_returnsSizeEqualsOne(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Grzeogorz","Jarus",'m',3,3000,1989,2,false ));
        list.add(new Employee("Paweł","Nowak",'m',2,6000,1985,1,false ));
        list.add(new Employee("Jan","Zielinski",'m',1,3500,1960,0,true ));
        list.add(new Employee("Zuzanna","Abacka",'k',4,1000,1975,4,true ));
        list=Filters.filterSex(true,list,'k');
        assertEquals(1,list.size());
    }

    @Test
    public void filterSex_sexIsM_returnsSizeEqualsFour(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Grzeogorz","Jarus",'m',3,3000,1989,2,false ));
        list.add(new Employee("Paweł","Nowak",'m',2,6000,1985,1,false ));
        list.add(new Employee("Jan","Zielinski",'m',1,3500,1960,0,true ));
        list.add(new Employee("Zuzanna","Abacka",'m',4,1000,1975,4,true ));
        list=Filters.filterSex(true,list,'m');
        assertEquals(4,list.size());
    }
    @Test
    public void filterBirthYear_yearAbove1980_returnsSizeEqualsTwo(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Grzeogorz","Jarus",'m',3,3000,1989,2,false ));
        list.add(new Employee("Paweł","Nowak",'m',2,6000,1985,1,false ));
        list.add(new Employee("Jan","Zielinski",'m',1,3500,1960,0,true ));
        list.add(new Employee("Zuzanna","Abacka",'k',4,1000,1975,4,true ));
        list=Filters.filterBirthyearAboveThreshold(true,list,1980);
        assertEquals(2,list.size());
    }

    @Test
    public void filterBirthYear_yearAbove1960_returnsSizeEqualsFour(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Grzeogorz","Jarus",'m',3,3000,1989,2,false ));
        list.add(new Employee("Paweł","Nowak",'m',2,6000,1985,1,false ));
        list.add(new Employee("Jan","Zielinski",'m',1,3500,1960,0,true ));
        list.add(new Employee("Zuzanna","Abacka",'k',4,1000,1975,4,true ));
        list=Filters.filterBirthyearAboveThreshold(true,list,1960);
        assertEquals(4,list.size());
    }
}
