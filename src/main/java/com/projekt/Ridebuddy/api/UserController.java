package com.projekt.Ridebuddy.api;

import com.projekt.Ridebuddy.registration.model.RegistrationRequest;
import com.projekt.Ridebuddy.registration.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "User")
@AllArgsConstructor
public class UserController {
    private RegistrationService registrationService;

    @PostMapping(path = "{register}")
    public String register(@RequestBody RegistrationRequest request) {

        return registrationService.register(request);
    }
}
