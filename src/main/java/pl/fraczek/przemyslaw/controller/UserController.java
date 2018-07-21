package pl.fraczek.przemyslaw.controller;

import pl.fraczek.przemyslaw.model.Response;
import pl.fraczek.przemyslaw.model.User;
import pl.fraczek.przemyslaw.model.UserRepository;

public class UserController {

    private UserRepository repository;
    private Validator validator = new Validator();

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    public Response changeEmail(User user, String newEmail) {

        Response response = new Response();

        if (!validator.emailIsCorrect(newEmail)) {
            response.setSuccess(false);
            response.setMassage("New email address is invalid.");
        } else if (user.getEmail().equals(newEmail)) {
            response.setSuccess(false);
            response.setMassage("New email address is same as previous one.");
        } else {
            response.setSuccess(true);
            response.setMassage("Email address has been changed to " + newEmail + ".");
            user.setEmail(newEmail);
            repository.update(user);
        }
        return response;
    }

    public Response changeNumber(User user, String newNumber) {

        Response response = new Response();

        if (!validator.numberIsCorrect(newNumber)) {
            response.setSuccess(false);
            response.setMassage("New number is invalid");
        } else if (user.getNumber().equals(newNumber)) {
            response.setSuccess(false);
            response.setMassage("New phone number is the same as previous one.");
        } else {
            response.setSuccess(true);
            response.setMassage("Phone number has been changed to " + newNumber);
            user.setNumber(newNumber);
            repository.update(user);
        }
        return response;
    }
}
