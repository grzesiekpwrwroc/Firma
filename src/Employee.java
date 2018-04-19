import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Employee {

    /*public enum Plec{
        MALE, FEMALE;
    }*/

    private static String message;


    private String name;
    private String surname;
    private char sex;
    private int department;
    private float salary;
    private int birthYear;
    private int numberOfChlidrens;
    private boolean married;


    public Employee(String name, String surname, char sex, int department, float salary, int birthYear, int numberOfChlidrens, boolean married) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.department = department;
        this.salary = salary;
        this.birthYear = birthYear;
        this.numberOfChlidrens = numberOfChlidrens;
        this.married = married;

    }

    public Employee() {

    }

    public Employee(Employee employee) {
        this.name = employee.name;
        this.surname = employee.surname;
        this.sex = employee.sex;
        this.department = employee.department;
        this.salary = employee.salary;
        this.birthYear = employee.birthYear;
        this.numberOfChlidrens = employee.numberOfChlidrens;
        this.married = employee.married;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null || obj == this || !(obj instanceof Employee))
            return false;

        Employee employee = (Employee) obj;

        if (employee.name != this.name) return false;
        if (employee.surname != this.surname) return false;
        if (employee.sex != this.sex) return false;
        if (employee.department != this.department) return false;
        if (employee.salary != this.salary) return false;
        if (employee.birthYear != this.birthYear) return false;
        if (employee.numberOfChlidrens != this.numberOfChlidrens) return false;
        if (employee.married != this.married) return false;


        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getNumberOfChlidrens() {
        return numberOfChlidrens;
    }

    public void setNumberOfChlidrens(int numberOfChlidrens) {
        this.numberOfChlidrens = numberOfChlidrens;
    }

    public boolean getMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }


    public String displayEmployee() {
        return this.name + " " + this.surname + " " + this.sex + " " + this.department + " " + this.salary + " " + this.birthYear + " " + this.numberOfChlidrens + " " + this.married;
    }

    public void shortDisplayEmployee() {
        System.out.println("Name:" + this.name + " Surname:" + this.surname + " Salary:" + this.salary);
    }

    public void specjalDisplay() {
        System.out.println(this.name.toUpperCase() + " " + this.surname.toUpperCase());
    }

    public void getterDisplay() {
        System.out.println(getName() + " " + getSurname());
    }

    public boolean isSalaryAbove(float threshold) {
        return getSalary() > threshold;
    }

    public void giveARaise(float percent) {
        //if (Statystyki.arithmeticAverage(DodajFrame.getList()) < 7000) {

        percent += getNumberOfChlidrens() * 2;
        if (getMarried()) percent += 3;
        setSalary(getSalary() * (1 + (percent / 100)));
        //}
    }

    public static void raiseLogic(List<Employee> list, float percent) {
        setMessage("");
        if (Statistics.arithmeticAverage() < 5000 || Statistics.firstQuartile() < 2500 || Statistics.median() < 4000) {
            if (Statistics.thirdQuartile() < Statistics.arithmeticAverage() * 1.5) {
                for (Employee employee : list) {
                    employee.giveARaise(percent);
                }
                setMessage("Every man take a raise!");
            } else {
                for (Employee employee : list) {
                    if (employee.getSalary() < Statistics.thirdQuartile())
                        employee.giveARaise(percent);
                }
                setMessage("3/4 employees has taken a raise!");
            }
        } else {
            for (Employee employee : list) {
                if (employee.getSalary() < Statistics.firstQuartile())
                    employee.giveARaise(percent);
            }
            setMessage("1/4 employees has taken a raise!");
            //return list;
        }
    }

    public static void setMessage(String message1) {
        message = message1;
    }

    public static String getMessage() {
        return message;
    }


   /* public void dajPodwyzke1(Optional<Pracownik> pracownik, float procent, int budzet,List<Pracownik>list){
        if(pracownik!=null){
            if(czyPodwyzkaMozliwa(pracownik,procent,budzet)){
                pracownik.dajPodwyzke(procent);
            }
        }
    }*/

    public static int sumOfSalaries(List<Employee> list) {
        int totalSalaries = 0;
        for (Employee employee : list) {
            totalSalaries += employee.getSalary();
        }
        return totalSalaries;
    }
    public static List<Employee> copyList(List<Employee> list){
        List<Employee> copy= new ArrayList<>();
        for (Employee x : list) {
            copy.add(new Employee(x));
        }
        return copy;
    }


    public static List<Employee> isRaisePossible(Employee employee, float procent, long budget) {
        List<Employee> copy = new ArrayList<>();
        List<Employee> list = AddEmployeeFrame.getList();
        //list.get(2).setSalary(Statystyki.trzeciKwartyl(list));
        //kopia.addAll(list);

        /*for (Pracownik x : list) {
            kopia.add(new Pracownik(x));
        }*/
        copy=copyList(list);

        if (employee != null) {
            int i = 0;
            for (Employee empl : copy) {
                if (empl.equals(employee)) {
                    empl.giveARaise(procent);
                    i = 100;
                }
                i++;
            }
            if (sumOfSalaries(copy) <= budget) {
                JOptionPane.showMessageDialog(null, "Employee: " + employee.displayEmployee() + " has taken a raise");
                return copy;
            } else {
                JOptionPane.showMessageDialog(null, "There are no money!");
                return list;
            }
        } else {
            raiseLogic(copy, procent);

            if (sumOfSalaries(copy) <= budget) {

                JOptionPane.showMessageDialog(null, getMessage());
                return copy;
            } else {
                JOptionPane.showMessageDialog(null, "There are no money for everything!");
                return list;
            }
        }
        //return list;
    }



    /*public static void main(String[] args) {
        Pracownik pracownik = new Pracownik("Grzegorz", "Jarus",'M',2,3000, 28,2,true);
        pracownik.wyswietlPracownika();
        pracownik.wyswietlPracownikaOkrojona();
        pracownik.wyswietlSpecjalne();
        System.out.println(pracownik.czyPensjaPowyzej(3000));
        pracownik.wyswietlGetterami();
        pracownik.dajPodwyzke(10);
        pracownik.wyswietlPracownikaOkrojona();
    }*/


}
