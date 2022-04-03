package com.projekt.Ridebuddy.api;

import com.projekt.Ridebuddy.registration.model.RegistrationRequest;
import com.projekt.Ridebuddy.registration.service.RegistrationService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("User")
@RestController
public class UserController {
    private RegistrationService registrationService;

    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }
}
