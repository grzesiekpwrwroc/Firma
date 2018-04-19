import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

public class ValidationTests {
    @Test
    public void validateBirthYear_yearBelow1900_returnsFalse(){
        boolean result = Validation.validateBirthYear("1800");
        assertEquals(false, result);
    }
    @Test
    public void validateBirthYear_yearAbove9999_returnsFalse(){
        boolean result = Validation.validateBirthYear("10000");
        assertEquals(false, result);
        result = Validation.validateBirthYear("11900");
        assertEquals(false, result);
        result = Validation.validateBirthYear("11111900");
        assertEquals(false, result);
    }

    @Test
    public void validateBirthYear_yearNotOnlyDigits_returnsFalse(){
        boolean result = Validation.validateBirthYear("19.91");
        assertEquals(false, result);
        result = Validation.validateBirthYear("1945m");
        assertEquals(false, result);
        result = Validation.validateBirthYear("200!9");
        assertEquals(false, result);
    }

    @Test
    public void validateBirthYear_emptyBirthYear_returnsFalse(){
        boolean result = Validation.validateBirthYear("");
        assertEquals(false, result);
    }

    @Test
    public void validateName_nameNotOnlyLetters_returnsFalse(){
        boolean result = Validation.validateName("Grze2gorz");
        assertEquals(false, result);
        result = Validation.validateName("Grze!gorz");
        assertEquals(false, result);
        result = Validation.validateName("Grze.gorz");
        assertEquals(false, result);
    }

    @Test
    public void validateSurname_nameNotOnlyLetters_returnsFalse(){
        boolean result = Validation.validateSurname("Grze2gorz");
        assertEquals(false, result);
        result = Validation.validateSurname("Grze!gorz");
        assertEquals(false, result);
        result = Validation.validateSurname("Grze.gorz");
        assertEquals(false, result);
    }

    @Test
    public void validateSurname_emptySurname_returnsFalse(){
        boolean result = Validation.validateSurname("");
        assertEquals(false, result);
    }
    @Test
    public void validateName_emptySurname_returnsFalse(){
        boolean result = Validation.validateName("");
        assertEquals(false, result);
    }


   /* @Test
    public void checkListSize_removedTwoEmployees_returnsSizeMinusTwo(){
        Files.readFile();
        int result = AddEmployeeFrame.getList().size();
        AddEmployeeFrame.getList().remove(result-1);
        AddEmployeeFrame.getList().remove(result-3);
        assertEquals(result-2,AddEmployeeFrame.getList().size());
    }*/

}
