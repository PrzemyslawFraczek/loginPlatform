package pl.fraczek.przemyslaw.controller;

import org.junit.Test;
import pl.fraczek.przemyslaw.model.InMemoryRepository;
import pl.fraczek.przemyslaw.model.Response;
import pl.fraczek.przemyslaw.model.User;
import pl.fraczek.przemyslaw.model.UserRepository;
import pl.fraczek.przemyslaw.view.Reader;
import pl.fraczek.przemyslaw.view.profilUser.UserPanel;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class LoginControllerTest {

    private UserRepository repository = new InMemoryRepository();
    private final LoginController controller = new LoginController(repository);

    private final String NAME = "Frankil";
    private final String PASSWORD = "Fraczek1!";


    @Test
    public void shouldLoginWhenDataAreCorrect() {


        User user = repository.add(new User(NAME, PASSWORD, "aste2@o2.pl", "513546997"));
        Response result = controller.login(NAME, PASSWORD);


        assertTrue(result.isSuccess());
        assertEquals(result.getMassage(), user.getName() + " welcome !!");

    }

    @Test
    public void shouldThrowExceptionWhenUserDoesNotExist() {
        Response result = controller.login(NAME, PASSWORD);

        assertFalse(result.isSuccess());
        assertEquals(result.getMassage() ,"Specified user does not exist: " + NAME );
    }

    @Test
    public void shouldThrowExceptionWhenUserExistButPasswordIsIncorrect() {
        String incorrectPassword = "franklin";
        repository.add(new User(NAME, PASSWORD, "aste2@o2.pl", "513546997"));
        Response result = controller.login(NAME, incorrectPassword);

        assertFalse(result.isSuccess());
        assertEquals(result.getMassage() , "Password is incorrect");
    }
}
