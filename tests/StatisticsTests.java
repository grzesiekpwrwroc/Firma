import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticsTests {

    @Test
    public void arithmeticAverage_returns6000(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Grzeogorz","Jarus",'m',3,3000,1989,2,false ));
        list.add(new Employee("Paweł","Nowak",'m',2,7000,1985,1,false ));
        list.add(new Employee("Jan","Zielinski",'m',1,9000,1960,0,true ));
        list.add(new Employee("Zuzanna","Abacka",'k',4,5000,1975,4,true ));
        AddEmployeeFrame.setList(list);
        int result = Statistics.arithmeticAverage();
        assertEquals(6000,result);
    }

    @Test
    public void firstQuartile_returns3000(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Grzeogorz","Jarus",'m',3,3000,1989,2,false ));
        list.add(new Employee("Paweł","Nowak",'m',2,7000,1985,1,false ));
        list.add(new Employee("Jan","Zielinski",'m',1,9000,1960,0,true ));
        list.add(new Employee("Zuzanna","Abacka",'k',4,5000,1975,4,true ));
        AddEmployeeFrame.setList(list);
        int result = Statistics.firstQuartile();
        assertEquals(3000,result);
    }

    @Test
    public void thirdQuartile_returns7000(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Grzeogorz","Jarus",'m',3,3000,1989,2,false ));
        list.add(new Employee("Paweł","Nowak",'m',2,7000,1985,1,false ));
        list.add(new Employee("Jan","Zielinski",'m',1,9000,1960,0,true ));
        list.add(new Employee("Zuzanna","Abacka",'k',4,5000,1975,4,true ));
        AddEmployeeFrame.setList(list);
        int result = Statistics.thirdQuartile();
        assertEquals(7000,result);
    }

    @Test
    public void median_returns5000(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Grzeogorz","Jarus",'m',3,3000,1989,2,false ));
        list.add(new Employee("Paweł","Nowak",'m',2,7000,1985,1,false ));
        list.add(new Employee("Jan","Zielinski",'m',1,9000,1960,0,true ));
        list.add(new Employee("Zuzanna","Abacka",'k',4,5000,1975,4,true ));
        AddEmployeeFrame.setList(list);
        int result = Statistics.median();
        assertEquals(5000,result);
    }
}
