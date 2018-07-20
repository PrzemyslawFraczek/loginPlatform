package pl.fraczek.przemyslaw.controller;

import org.junit.Test;
import pl.fraczek.przemyslaw.model.InMemoryRepository;
import pl.fraczek.przemyslaw.model.UserRepository;

import static junit.framework.Assert.assertTrue;

public class RegistrationControllerTest {
    private final RegistrationController controller = new RegistrationController();
    private UserRepository repository =  new InMemoryRepository();

    private final String CORRECT_NAME = "Przemek";
    private final String CORRECT_PASSWORD = "Fraczek1!";
    private final String CORRECT_EMAIL = "fraczek.przemysalw2@gamil.com";
    private final String CORRECT_NUMBER = "513546977";

    @Test

    public void shouldCreateUserWhenEverythingIsCorrect() {
        controller.add(CORRECT_NAME,CORRECT_PASSWORD,CORRECT_EMAIL,CORRECT_NUMBER);


    }
}
