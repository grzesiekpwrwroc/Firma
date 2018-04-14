import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    @Test
    public void validateRokUrodzenia_yearBelow1900_returnsFalse(){
        Boolean result = Validation.validateRokUrodzenia("1800");
        assertEquals(false, result);
    }
    @Test
    public void validateRokUrodzenia_yearAbove9999_returnsFalse(){
        Boolean result = Validation.validateRokUrodzenia("10000");
        assertEquals(false, result);
    }
}
