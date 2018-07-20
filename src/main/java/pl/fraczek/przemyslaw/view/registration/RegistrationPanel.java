package pl.fraczek.przemyslaw.view.registration;

import pl.fraczek.przemyslaw.controller.RegistrationController;
import pl.fraczek.przemyslaw.model.Response;
import pl.fraczek.przemyslaw.view.Reader;

public class RegistrationPanel {
    private Reader reader;
    private RegistrationController controller;

    public RegistrationPanel(Reader reader, RegistrationController controller) {
        this.reader = reader;
        this.controller = controller;
    }

    public Response register(){
        reader.display("Give me your name");
        String name = reader.readInforamtion();


        reader.display("Give me your password");
        String password = reader.readInforamtion();

        reader.display("Give me your E-mail");
        String email = reader.readInforamtion();

        reader.display("Give me your number");
        String number = reader.readInforamtion();

        return controller.add(name,password,email,number);
    }

}
