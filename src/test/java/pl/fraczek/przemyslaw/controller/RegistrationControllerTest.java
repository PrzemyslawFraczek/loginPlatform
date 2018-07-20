package pl.fraczek.przemyslaw.controller;

import org.junit.Test;
import pl.fraczek.przemyslaw.model.InMemoryRepository;
import pl.fraczek.przemyslaw.model.Response;
import pl.fraczek.przemyslaw.model.UserRepository;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class RegistrationControllerTest {
    private UserRepository repository =  new InMemoryRepository();
    private final RegistrationController controller = new RegistrationController(repository);

    private final String CORRECT_NAME = "Przemek";
    private final String CORRECT_PASSWORD = "Fraczek1!";
    private final String CORRECT_EMAIL = "fraczek.przemysalw2@gamil.com";
    private final String CORRECT_NUMBER = "513546977";


    @Test
    public void shouldCreateUserWhenEverythingIsCorrect() {
        Response result = controller.add(CORRECT_NAME, CORRECT_PASSWORD, CORRECT_EMAIL, CORRECT_NUMBER);

        assertTrue(repository.exist(CORRECT_NAME));
        assertEquals(result.getMassage() , "Hello new user " + CORRECT_NAME);
        assertTrue(result.isSuccess());
    }

    @Test
    public void shouldThrowExceptionWhenNameIsTooShort() {

        String tooShortName = "EQ";
        Response result = controller.add(tooShortName, CORRECT_PASSWORD, CORRECT_EMAIL, CORRECT_NUMBER);

        assertEquals(result.getMassage(),"Name is too short");
        assertFalse(result.isSuccess());
    }

    @Test
    public void shouldThrowExceptionWhenNameIsBusy() {
        controller.add(CORRECT_NAME,CORRECT_PASSWORD,CORRECT_EMAIL,CORRECT_NUMBER);
        Response result = controller.add(CORRECT_NAME, CORRECT_PASSWORD, CORRECT_EMAIL, CORRECT_NUMBER);

        assertEquals(result.getMassage(),"Name's user is busy");
        assertFalse(result.isSuccess());
    }

    @Test
    public void shouldThrowExceptionWhenPasswordInvalid() {
        String invalidPassword = "frank";
        Response result = controller.add(CORRECT_NAME, invalidPassword, CORRECT_EMAIL, CORRECT_NUMBER);

        assertEquals(result.getMassage() ,"Password is incorrect. The password should have at least 8 characters, " +
                "one digit, one special character and one small and large letter");
        assertFalse(result.isSuccess());
    }

    @Test
    public void shouldThrowExceptionWhenEmailInvalid() {
        String invalidEmail = "as2o2.pl";
        Response result = controller.add(CORRECT_NAME, CORRECT_PASSWORD, invalidEmail, CORRECT_NUMBER);

        assertEquals(result.getMassage() ,"E-mail is invalid");
        assertFalse(result.isSuccess());

    }

    @Test
    public void shouldThrowExceptionWhenNumberIsInvalid() {
        String numberInvalid = "1234567n";
        Response result = controller.add(CORRECT_NAME, CORRECT_PASSWORD, CORRECT_EMAIL, numberInvalid);

        assertEquals(result.getMassage(),"Number is invalid");
        assertFalse(result.isSuccess());

    }
}
