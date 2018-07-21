package pl.fraczek.przemyslaw.controller;

import org.apache.commons.lang.RandomStringUtils;

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

        String regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^*!:_/\\-{}\\[\\]`~<>|;&+=])(?=\\S+$).{8,}$";
        return password.matches(regex);
    }

    public boolean nameTooShort(String name) {
        return name.length() < 3;
    }

    public String generationPassword() {
        String s = "ABCDEFGHIJKLMNOPRSTUWYZ@#$%^&*!()/_:;<>`~|+={}-[]1234567890";
        String random = RandomStringUtils.random(8, s);
        if (passwordIsCorrect(random)){
            return random;
        }
        return generationPassword();
    }
}
