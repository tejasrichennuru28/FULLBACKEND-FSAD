package com.klu.clubconnect.service;

import com.klu.clubconnect.model.Event;
import com.klu.clubconnect.model.Registration;
import com.klu.clubconnect.model.User;
import com.klu.clubconnect.repository.EventRepository;
import com.klu.clubconnect.repository.RegistrationRepository;
import com.klu.clubconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    public String registerForEvent(Long userId, Long eventId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Event> eventOpt = eventRepository.findById(eventId);
        
        if (!userOpt.isPresent()) {
            return "User not found";
        }
        if (!eventOpt.isPresent()) {
            return "Event not found";
        }
        
        User user = userOpt.get();
        Event event = eventOpt.get();
        
        // Check already registered
        List<Registration> existingRegs = registrationRepository.findByUser(user);
        for (Registration reg : existingRegs) {
            if (reg.getEvent().getId().equals(eventId)) {
                return "Already registered";
            }
        }
        
        Registration registration = new Registration();
        registration.setUser(user);
        registration.setEvent(event);
        registration.setStatus("REGISTERED");
        registration.setRegisteredAt(LocalDateTime.now());
        registrationRepository.save(registration);
        
        return "Successfully registered for " + event.getTitle();
    }

    public String unregisterFromEvent(Long userId, Long eventId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Event> eventOpt = eventRepository.findById(eventId);
        
        if (!userOpt.isPresent() || !eventOpt.isPresent()) {
            return "User or Event not found";
        }
        
        User user = userOpt.get();
        Event event = eventOpt.get();
        
        List<Registration> registrations = registrationRepository.findByUser(user);
        Registration toDelete = null;
        
        for (Registration reg : registrations) {
            if (reg.getEvent().getId().equals(eventId)) {
                toDelete = reg;
                break;
            }
        }
        
        if (toDelete == null) {
            return "Not registered";
        }
        
        registrationRepository.delete(toDelete);
        return "Successfully unregistered from " + event.getTitle();
    }

    public List<Registration> getUserRegistrations(Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (!userOpt.isPresent()) {
            return List.of();
        }
        return registrationRepository.findByUser(userOpt.get());
    }
}