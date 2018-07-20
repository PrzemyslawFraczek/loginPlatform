package pl.fraczek.przemyslaw.view;

import pl.fraczek.przemyslaw.controller.LoginController;
import pl.fraczek.przemyslaw.controller.RegistrationController;
import pl.fraczek.przemyslaw.controller.UserController;
import pl.fraczek.przemyslaw.model.Response;
import pl.fraczek.przemyslaw.model.UserRepository;
import pl.fraczek.przemyslaw.view.login.LoginPanel;
import pl.fraczek.przemyslaw.view.profilUser.UserPanel;
import pl.fraczek.przemyslaw.view.registration.RegistrationPanel;

public class StartPanel {
    private Reader reader;
    private RegistrationPanel registrationPanel;
    private LoginPanel loginPanel;
    private UserPanel userPanel;

    public StartPanel(Reader reader, UserRepository repository) {
        this.reader = reader;
        RegistrationController registrationController = new RegistrationController(repository);
        registrationPanel = new RegistrationPanel(this.reader, registrationController);
        UserController userController =  new UserController(repository);
        userPanel = new UserPanel(this.reader , userController);
        LoginController loginController = new LoginController(repository);
        loginPanel = new LoginPanel(this.reader, loginController);
    }

    public void start() {
        int answer;
        do {
            reader.display("What you want to do");
            reader.display("1 - Sing in");
            reader.display("2 - Login");
            reader.display("3 - Exit");
            answer = reader.readInt();

            if (answer == 1) {
                reader.display(registrationPanel.register().getMassage());
            }
            if (answer == 2) {
                Response login = loginPanel.login();
                reader.display(login.getMassage());
                if(login.isSuccess()){
                    userPanel.userPanel(login.getUser());
                }
            }
            if (answer != 2 && answer != 1 && answer != 3) {
                reader.display(answer + "This option is not available");
            }

        } while (answer != 3);
    }
}
