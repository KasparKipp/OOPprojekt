package com.projekt.Ridebuddy.registration.service;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Pattern;

@Service
public class RegistrationValidator {

    private final String emailPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";


    //Meetodid kontrollimaks registreerimispäringu valiidsuseid
    // TODO: Täiendada meetodeid
    public boolean isEmailValid(String email) {
        //TODO: check for dublicate email
        Pattern pattern = Pattern.compile(emailPattern);
        boolean isValid = pattern.matcher(email).matches();
        return isValid;
    }
    public boolean isPasswordValid(String password) {

        return true;
    }
}
