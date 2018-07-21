package pl.fraczek.przemyslaw.controller;


import org.junit.Test;
import pl.fraczek.przemyslaw.model.InMemoryRepository;
import pl.fraczek.przemyslaw.model.Response;
import pl.fraczek.przemyslaw.model.User;
import pl.fraczek.przemyslaw.model.UserRepository;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class UserControllerTest {
    private UserRepository repository = new InMemoryRepository();
    private UserController controller = new UserController(repository);

    private final User USER = new User("Franklin", "Frank123!", "aste2@o2.pl", "513546997");

    @Test
    public void shouldChangeEmail() {
        String newEmail = "fraczek.przemyslaw2@gmail.com";

        repository.add(USER);
        Response result = controller.changeEmail(USER, newEmail);
        User user = repository.get(USER.getName());

        assertEquals(user.getEmail(), newEmail);
        assertTrue(result.isSuccess());
        assertEquals(result.getMassage(), "Email address has been changed to " + newEmail + ".");
    }

    @Test
    public void shouldThrowExceptionWhenEmailIsInvalid() {
        String incorrectEmail = "aste2o2.pl";
        repository.add(USER);

        Response result = controller.changeEmail(USER, incorrectEmail);
        User user = repository.get(USER.getName());

        assertEquals(USER.getEmail(), user.getEmail());
        assertFalse(result.isSuccess());
        assertEquals(result.getMassage(), "New email address is invalid.");
    }

    @Test
    public void shouldChangeNumber() {
        String newNumber = "513558479";
        repository.add(USER);

        Response result = controller.changeNumber(USER, newNumber);
        User user = repository.get(USER.getName());

        assertEquals(result.getMassage(), "Phone number has been changed to " + newNumber);
        assertTrue(result.isSuccess());
        assertEquals(user.getNumber(), newNumber);

    }

    @Test
    public void shouldReturnExceptionWhenNumberIsInvalid() {
        String invalidNumber = "54asd1476";
        repository.add(USER);

        Response result = controller.changeNumber(USER, invalidNumber);
        User user = repository.get(USER.getName());

        assertEquals(user.getNumber(), USER.getNumber());
        assertFalse(result.isSuccess());
        assertEquals(result.getMassage(), "New number is invalid");
    }

    @Test
    public void shouldThrowExceptionWhenNewNumberIsSameAsPreviousOne() {
        repository.add(USER);

        Response result = controller.changeNumber(USER, USER.getNumber());

        assertFalse(result.isSuccess());
        assertEquals(result.getMassage(), "New phone number is the same as previous one.");

    }

    @Test
    public void shouldThrowExceptionWhenNewEmailIsSameAsPreviousOne() {
        repository.add(USER);

        Response result = controller.changeEmail(USER, USER.getEmail());

        assertFalse(result.isSuccess());
        assertEquals(result.getMassage(), "New email address is same as previous one.");
    }
}
