import javax.swing.*;
import java.util.regex.Pattern;

public class Validation {

    private static String validateMessage;

    public static boolean validateMail(String mail) {
        if (mail.length() == 0) {
            setValidateMessage("Please enter the E-mail");
            return false;
        }
        if (Pattern.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$", mail))
            return true;
        else {
            setValidateMessage("Incorrect email format ");
            return false;
        }

    }


    public static boolean validateName(String name) {
        if (name.length() == 0) {
            setValidateMessage("Please enter the name");
            return false;
        }
        if (Pattern.matches("[AaĄąBbCcĆćDdEeĘęFfGgHhIiJjKkLlŁłMmNnŃńOoÓóPpRrSsŚśTtUuWwYyZzŹźŻż]+", name))
            return true;
        else {
            setValidateMessage("Name should consist of only letters");
            return false;
        }

    }

    public static boolean validateSurname(String surname) {
        if (surname.length() == 0) {
            setValidateMessage("Please enter the surname");
            return false;
        }
        if (Pattern.matches("[AaĄąBbCcĆćDdEeĘęFfGgHhIiJjKkLlŁłMmNnŃńOoÓóPpRrSsŚśTtUuWwYyZzŹźŻż]+", surname))
            return true;
        else {
            setValidateMessage("Surname should consist of only letters");
            return false;
        }

    }

    public static boolean validateSex(String sex) {
        if (sex.length() == 0) {
            setValidateMessage("Please enter the sex");
            return false;
        }
        if (sex.length() != 1) {
            setValidateMessage("Sex should consist of only ONE letter");
            return false;
        } else if (sex.equalsIgnoreCase("K") || sex.equalsIgnoreCase("M"))
            return true;
        else {
            setValidateMessage("Sex should consist of only ONE letter M or K");
            return false;
        }
    }

    public static boolean validateSalary1(JTextField tekstFieldPensja) {
        if (tekstFieldPensja.getText().length() == 0) {
            setValidateMessage("Please enter the salary");
            return false;
        } else if (Pattern.matches("\\d+", tekstFieldPensja.getText()))
            return true;
        else {
            setValidateMessage("Salary should consist of only digits");
            return false;
        }
    }

    public static boolean validateDepartment(String department) {
        if (department.length() == 0) {
            setValidateMessage("Please enter the department");
            return false;
        } else if (Pattern.matches("1|2|3|4",department))
            return true;
        else {
            setValidateMessage("Department is a digit 1,2,3 or 4 ");
            return false;
        }
    }



    public static boolean validateDepartments(String departments) {
        return Pattern.matches("^[1-4](,[1-4])*$", departments);
    }

    @SuppressWarnings("Annotator")
    public static boolean validateDepartments1(String departments) {
       if (departments.length() != 0 && departments.length() != 1 && departments.length() != 3 && departments.length() != 5 && departments.length() != 7) {
            setValidateMessage("Input format is NR,NR,NR,NR");
            return false;
        }
       else{
        if (departments.length() == 0) {
            setValidateMessage("Please enter the department");
            return false;
        }
        if (departments.length() == 1) {
            if (Pattern.matches("1|2|3|4", departments))
                return true;
            else {
                setValidateMessage("Department is a digit 1,2,3 or 4 ");
                return false;
            }
        }
        if (departments.length() == 3) {
            if (Pattern.matches("\\d{1},\\d{1}", departments))
                return true;
            else {
                setValidateMessage("Input format is NR,NR,NR,NR");
                return false;
            }
        }
        if (departments.length() == 5) {
            if (Pattern.matches("\\d{1},\\d{1},\\d{1}", departments))
                return true;
            else {
                setValidateMessage("Input format is NR,NR,NR,NR");
                return false;
            }
        }
        if (departments.length() == 7) {
            if (Pattern.matches("\\d{1},\\d{1},\\d{1},\\d{1}}", departments))
                return true;
            else {
                setValidateMessage("Input format is NR,NR,NR,NR");
                return false;
            }
        }}
        return true;
    }

    public static boolean validateBirthYear(String birthYear) {
        if (birthYear.length() == 0) {
            setValidateMessage("Please enter the birthyear");
            return false;
        } else if (Pattern.matches("\\d+", birthYear)) {
            if (Integer.parseInt(birthYear) < 1900 || Integer.parseInt(birthYear) > 9999) {
                setValidateMessage("Birthyear is a number between <1900,9999>");
                return false;
            }
            return true;
        } else {
            setValidateMessage("Birthyear should consist of only digits");
            return false;
        }
    }

    public static boolean validateNumberOfChildren(String numberOfChildren) {
        if (numberOfChildren.length() == 0) {
            setValidateMessage("Please enther the number of childrens");
            return false;
        } else if (Pattern.matches("\\d+", numberOfChildren))
            return true;

        else {
            setValidateMessage("Number of childrens should consist of only digits");
            return false;
        }
    }




    public static boolean validateSalary(String salary) {
        if (salary.length()==0) {
            setValidateMessage("Please enter the salary");
            return false;
        } else if (Pattern.matches("\\d+", salary))
            return true;
        else {
            setValidateMessage("Salary should consist of only digits");
            //validateMessage="Pensja powinna składać się z samych cyfr";
            return false;
        }
    }

    public static boolean validatePercentOfRaise(String percent){
        if(percent.length()==0){
            setValidateMessage("Please enter the percent of raise");
            return false;
        }
        else if(Pattern.matches("\\d+", percent)){
            if(Float.parseFloat(percent)>=1 && Float.parseFloat(percent)<100)
                return true;
        }
        setValidateMessage("Percent of raise is a number between 1,100");
        return false;
    }
    public static boolean validateBudgetOfRaise(String budget){
        if(budget.length()==0){
            setValidateMessage("Please enter the budget of raise");
            return false;
        }
        else if(Pattern.matches("\\d+", budget)){
            return true;
        }
        setValidateMessage("Budget is a positive number");
        return false;
    }


    public static void setValidateMessage(String message) {
        validateMessage = message;
    }
    public static String getValidateMessage(){
        return validateMessage;
    }



}
