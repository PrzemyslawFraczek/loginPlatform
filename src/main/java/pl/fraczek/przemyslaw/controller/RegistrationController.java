package pl.fraczek.przemyslaw.controller;

import pl.fraczek.przemyslaw.model.Response;
import pl.fraczek.przemyslaw.model.User;
import pl.fraczek.przemyslaw.model.UserRepository;

public class RegistrationController {
    private UserRepository repository ;
    private Validator validator = new Validator();

    public RegistrationController(UserRepository repository) {
        this.repository = repository;
    }


    public Response add(String name, String password, String email, String number) {

        Response response =  new Response();

        if(repository.exist(name)){
            response.setSuccess(false);
            response.setMassage("Name's user is busy");
        }else if(validator.nameTooShort(name)){
            response.setSuccess(false);
            response.setMassage("Name is too short");
        }else if(!validator.passwordIsCorrect(password)){
            response.setSuccess(false);
            response.setMassage("Password is incorrect. The password should have at least 8 characters, " +
                    "one digit, one special character and one small and large letter");
        }else if(!validator.emailIsCorrect(email)){
            response.setSuccess(false);
            response.setMassage("E-mail is invalid");
        }else if(!validator.numberIsCorrect(number)){
            response.setSuccess(false);
            response.setMassage("Number is invalid");
        }else {
            response.setSuccess(true);
            response.setMassage("Hello new user " + name);
            User user = new User(name,password,email,number);
            repository.add(user);
        }
        return response;
    }
}
