package pl.fraczek.przemyslaw.view.registration;

import pl.fraczek.przemyslaw.controller.RegistrationController;
import pl.fraczek.przemyslaw.controller.Validator;
import pl.fraczek.przemyslaw.model.Response;
import pl.fraczek.przemyslaw.view.Reader;

public class RegistrationPanel {
    private Reader reader;
    private RegistrationController controller;
    private Validator validator;

    public RegistrationPanel(Reader reader, RegistrationController controller, Validator validator) {
        this.reader = reader;
        this.controller = controller;
        this.validator = validator;
    }

    public Response register() {
        reader.display("Type your name");
        String name = reader.readInformation();

        reader.display("Do you wish to automatically generate a new password?");
        reader.display("Yes - 1");
        reader.display("No - 2");
        int answer = reader.readInt();
        String password;
        if (answer == 1) {
            password = validator.generationPassword();
            reader.display(password + " this is your generated password");
        } else {
            reader.display("Type a new password:");
            password = reader.readInformation();
        }

        reader.display("Type your email address:");
        String email = reader.readInformation();

        reader.display("Type your phone number:");
        String number = reader.readInformation();

        return controller.add(name, password, email, number);
    }



}
