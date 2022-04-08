package com.projekt.Ridebuddy.user.dao;


import com.projekt.Ridebuddy.user.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface DriverRepo extends JpaRepository<Driver, Long> {

    Optional<Driver> findByEmail(String email);
}
