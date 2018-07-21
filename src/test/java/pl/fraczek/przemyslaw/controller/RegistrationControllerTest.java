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
    public void shouldCreateUserWhenInputDataAreCorrect() {
        Response result = controller.add(CORRECT_NAME, CORRECT_PASSWORD, CORRECT_EMAIL, CORRECT_NUMBER);

        assertTrue(repository.exist(CORRECT_NAME));
        assertEquals(result.getMassage() , "Hello " + CORRECT_NAME);
        assertTrue(result.isSuccess());
    }

    @Test
    public void shouldThrowExceptionWhenUserNameIsTooShort() {

        String tooShortName = "EQ";
        Response result = controller.add(tooShortName, CORRECT_PASSWORD, CORRECT_EMAIL, CORRECT_NUMBER);

        assertEquals(result.getMassage(),"User name is too short.");
        assertFalse(result.isSuccess());
    }

    @Test
    public void shouldThrowExceptionWhenNameIsOccupied() {
        controller.add(CORRECT_NAME,CORRECT_PASSWORD,CORRECT_EMAIL,CORRECT_NUMBER);
        Response result = controller.add(CORRECT_NAME, CORRECT_PASSWORD, CORRECT_EMAIL, CORRECT_NUMBER);

        assertEquals(result.getMassage(),"Specified user name is occupied.");
        assertFalse(result.isSuccess());
    }

    @Test
    public void shouldThrowExceptionWhenPasswordIsInvalid() {
        String invalidPassword = "frank";
        Response result = controller.add(CORRECT_NAME, invalidPassword, CORRECT_EMAIL, CORRECT_NUMBER);

        assertEquals(result.getMassage() ,"Password is incorrect. The password should have at least 8 characters" +
                ", one digit, one special character and one capital letter.");
        assertFalse(result.isSuccess());
    }

    @Test
    public void shouldThrowExceptionWhenEmailIsInvalid() {
        String invalidEmail = "as2o2.pl";
        Response result = controller.add(CORRECT_NAME, CORRECT_PASSWORD, invalidEmail, CORRECT_NUMBER);

        assertEquals(result.getMassage() ,"Email address is invalid.");
        assertFalse(result.isSuccess());

    }

    @Test
    public void shouldThrowExceptionWhenNumberIsInvalid() {
        String numberInvalid = "1234567n";
        Response result = controller.add(CORRECT_NAME, CORRECT_PASSWORD, CORRECT_EMAIL, numberInvalid);

        assertEquals(result.getMassage(),"Phone number is invalid.");
        assertFalse(result.isSuccess());

    }
}
