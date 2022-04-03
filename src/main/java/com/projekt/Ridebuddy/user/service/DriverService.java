package com.projekt.Ridebuddy.user.service;

import com.projekt.Ridebuddy.user.dao.DriverRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DriverService implements UserDetailsService {

    private final static String MESSAGE_USER_NOT_FOUND = "No registered users with this email: %s";
    private final DriverRepo driverRepo;

    public DriverService(DriverRepo driverRepo) {
        this.driverRepo = driverRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return driverRepo.findByEmail(username).orElseThrow(() ->
                new UsernameNotFoundException(
                        String.format(MESSAGE_USER_NOT_FOUND, username)
                ));
    }
}
