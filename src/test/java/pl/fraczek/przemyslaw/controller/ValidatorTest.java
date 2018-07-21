package pl.fraczek.przemyslaw.controller;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ValidatorTest {
    private Validator validator = new Validator();

    @Test
    public void shouldReturnTrueWhenEmailIsCorrect() {
        String correctEmail = "fraczek.przemyslaw2@gamil.com";
        boolean result = validator.emailIsCorrect(correctEmail);

        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseWhenEmailIsInvalid() {
        String invalidEmail = "fraczek.przemyslaw2gamil.com";
        boolean result = validator.emailIsCorrect(invalidEmail);

        assertFalse(result);
    }

    @Test
    public void shouldReturnTrueWhenPasswordIsCorrect() {
        String correctPassword = "Franklin1!";
        boolean result = validator.passwordIsCorrect(correctPassword);

        assertTrue(result);

    }

    @Test
    public void shouldReturnFalseWhenPasswordIsInvalid() {
        String invalidPassword = "asdf1";
        boolean result = validator.passwordIsCorrect(invalidPassword);

        assertFalse(result);

    }

    @Test
    public void shouldReturnTrueWhenNumberIsCorrect() {
        String correctNumber = "513546997";
        boolean result = validator.numberIsCorrect(correctNumber);

        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseWhenNumberIsInvalid() {
        String invalidNumber = "asasd1";
        boolean result = validator.numberIsCorrect(invalidNumber);

        assertFalse(result);

    }

    @Test
    public void shouldReturnFalseWhenNameDoesNotHasACorrectLength() {

        String tooShortName = "as";
        boolean result = validator.nameTooShort(tooShortName);
        
        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenNameHasACorrectLength() {
        String correctName = "Franklin";
        boolean result = validator.nameTooShort(correctName);

        assertFalse(result);
    }
}
