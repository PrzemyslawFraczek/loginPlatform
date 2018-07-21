package pl.fraczek.przemyslaw.view.login;

import pl.fraczek.przemyslaw.controller.LoginController;
import pl.fraczek.przemyslaw.model.Response;
import pl.fraczek.przemyslaw.view.Reader;

public class LoginPanel {
    private Reader reader;
    private LoginController controller;

    public LoginPanel(Reader reader, LoginController controller) {
        this.reader = reader;
        this.controller = controller;
    }

    public Response login(){

        reader.display("Please, type your Name:");
        String name = reader.readInformation();

        reader.display("Please, type your password:");
        String password = reader.readInformation();

        return controller.login(name,password);

    }



}
