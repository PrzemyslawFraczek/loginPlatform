package pl.fraczek.przemyslaw.controller;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Validator {

    public boolean emailIsCorrect(String email) {
        boolean result = true;
        try {
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();
        } catch (AddressException e) {
            result = false;
        }
        return result ;
    }

    public boolean numberIsCorrect(String number) {
        return number.length() == 9 && number.matches("^[0-9]*$");
    }

    public boolean passwordIsCorrect(String password) {

        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^*!:;&+=])(?=\\S+$).{8,}$";
        return password.matches(regex);
    }

    public boolean nameTooShort(String name) {
        return name.length() < 3;
    }
}
