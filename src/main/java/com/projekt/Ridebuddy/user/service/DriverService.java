package com.projekt.Ridebuddy.user.service;

import com.projekt.Ridebuddy.user.dao.DriverRepo;
import com.projekt.Ridebuddy.user.model.Driver;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DriverService implements UserDetailsService {

    private final static String MESSAGE_USER_NOT_FOUND = "No registered users with this email: %s";
    private final DriverRepo driverRepo;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return driverRepo.findByEmail(username).orElseThrow(() ->
                new UsernameNotFoundException(
                        String.format(MESSAGE_USER_NOT_FOUND, username)
                ));
    }

    public String signUpUser(Driver driver) {
        boolean emailExists = driverRepo.findByEmail(driver.getEmail())
                .isPresent();
        if (emailExists) {
            return String.format(
                    "%s is already associated with another user.",
                    driver.getEmail()
            );
        }
        String encodedPassword = bCryptPasswordEncoder
                .encode(driver.getPassword());
        driver.setPassword(encodedPassword);

        // TODO: confirmation token kui tahaks possibly email verificationiga registreerimist teha.
        // TODO: Kui email verif on tehtud siis peaks panema driveri enabled default väärtuseks false.

        driverRepo.save(driver);

        return "Registration was a success";
    }
}
