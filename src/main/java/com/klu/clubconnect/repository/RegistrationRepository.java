package com.klu.clubconnect.repository;

import com.klu.clubconnect.model.Registration;
import com.klu.clubconnect.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findByUser(User user);
}