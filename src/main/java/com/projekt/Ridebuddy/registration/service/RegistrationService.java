package com.projekt.Ridebuddy.registration.service;

import com.projekt.Ridebuddy.registration.model.RegistrationRequest;
import com.projekt.Ridebuddy.user.model.Driver;
import com.projekt.Ridebuddy.user.model.UserRole;
import com.projekt.Ridebuddy.user.service.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final static String MESSSAGE_INVALID_EMAIL = "Invalid email: %s does not seem to be a valid email address";


    private final DriverService driverService;
    private final RegistrationValidator validator;

    public String register(RegistrationRequest request) {
        // TODO: Custom exceptions
        // Siin on hea ressurss: https://www.baeldung.com/exception-handling-for-rest-with-spring
        if (!(validator.isEmailValid(request.getEmail()))) {
            return (String.format(MESSSAGE_INVALID_EMAIL, request.getEmail()));

        } else if (!validator.isPasswordValid(request.getPassword())) {
            return "You should be ashamed of your password. Choose a better one";
        }

        return driverService.signUpUser(
                new Driver(
                        request.getFirstname(),
                        request.getLastname(),
                        request.getEmail(),
                        request.getCompany(),
                        request.getPassword(),
                        UserRole.USER
                )
        );
    }
}
