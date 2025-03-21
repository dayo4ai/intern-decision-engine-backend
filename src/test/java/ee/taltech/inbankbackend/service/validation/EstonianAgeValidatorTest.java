import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EstonianAgeValidatorTest {
    private final EstonianAgeValidator validator = new EstonianAgeValidator();

    @Test
    void validAge_ShouldReturnTrue() {
        // Test personal code for a 25-year-old person
        assertTrue(validator.isValidAge("39703130245"));
    }

    @Test
    void underagePersonalCode_ShouldReturnFalse() {
        // Test personal code for a 15-year-old person
        assertFalse(validator.isValidAge("60804130245"));
    }

    @Test
    void invalidPersonalCode_ShouldReturnFalse() {
        assertFalse(validator.isValidAge("12345678901"));
    }
}