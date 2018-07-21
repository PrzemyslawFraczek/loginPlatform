package pl.fraczek.przemyslaw.controller;

import pl.fraczek.przemyslaw.model.Response;
import pl.fraczek.przemyslaw.model.User;
import pl.fraczek.przemyslaw.model.UserRepository;


public class LoginController {
    private UserRepository repository;


    public LoginController(UserRepository repository) {
        this.repository = repository;
    }

    public Response login(String name, String password) {
        Response response = new Response();

        if (!repository.exist(name)) {
            response.setSuccess(false);
            response.setMassage("Specified user does not exist: " + name);
        } else {
            User user = repository.get(name);
            if (!user.getPassword().equals(password)) {
                response.setSuccess(false);
                response.setMassage("Password is incorrect");
            } else {
                response.setMassage(name + " welcome !!");
                response.setSuccess(true);
                response.setUser(repository.get(name));
            }
        }
        return response;
    }
}
