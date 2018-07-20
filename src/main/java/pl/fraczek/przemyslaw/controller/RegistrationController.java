package pl.fraczek.przemyslaw.controller;

import pl.fraczek.przemyslaw.model.InMemoryRepository;
import pl.fraczek.przemyslaw.model.Response;
import pl.fraczek.przemyslaw.model.User;
import pl.fraczek.przemyslaw.model.UserRepository;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class RegistrationController {
    private UserRepository repository = new InMemoryRepository();


    public Response add(String name, String password, String email, String number) {
        Response response =  new Response();
        if(repository.exist(name)){
            response.setSuccess(false);
            response.setMassage("Name's user is busy");
        }else if(name.length() < 3){
            response.setSuccess(false);
            response.setMassage("Name is too short");
        }else if(!passwordIsCorrect(password)){
            response.setSuccess(false);
            response.setMassage("Password is incorrect");
        }else if(!emailIsCorrect(email)){
            response.setSuccess(false);
            response.setMassage("E-mail is invalid");
        }else if(!numberIsCorrect(number)){
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

    private boolean numberIsCorrect(String number) {
        return number.length() == 9 && number.matches("(.*[0-9])");
    }

    private boolean emailIsCorrect(String email) {
        boolean result = true;
        try {
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();
        } catch (AddressException e) {
            result = false;
        }
        return result;
    }

    private boolean passwordIsCorrect(String password) {

        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^!&+=])(?=\\S+$).{8,}$";
        return password.matches(regex);
    }


}
