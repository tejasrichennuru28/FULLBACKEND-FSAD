package com.klu.clubconnect.service;

import com.klu.clubconnect.dto.EventDTO;
import com.klu.clubconnect.model.Event;
import com.klu.clubconnect.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    
    @Autowired
    private EventRepository eventRepository;
    
    public List<EventDTO> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        List<EventDTO> eventDTOs = new ArrayList<>();
        
        for (Event event : events) {
            EventDTO dto = new EventDTO();
            dto.setId(event.getId());
            dto.setTitle(event.getTitle());
            dto.setDescription(event.getDescription());
            dto.setCategory(event.getCategory());
            dto.setDate(event.getDate());
            dto.setTime(event.getTime());
            dto.setVenue(event.getVenue());
            dto.setMaxParticipants(event.getMaxParticipants());
            dto.setRegisteredCount(event.getRegisteredCount());
            dto.setPoints(event.getPoints());
            dto.setStatus(event.getStatus());
            dto.setIcon(event.getIcon());
            dto.setColor(event.getColor());
            dto.setImageUrl(event.getImageUrl());
            dto.setRules(event.getRules());
            eventDTOs.add(dto);
        }
        return eventDTOs;
    }
    
    public EventDTO getEventById(Long id) {
        Optional<Event> eventOpt = eventRepository.findById(id);
        if (eventOpt.isPresent()) {
            Event event = eventOpt.get();
            EventDTO dto = new EventDTO();
            dto.setId(event.getId());
            dto.setTitle(event.getTitle());
            dto.setDescription(event.getDescription());
            dto.setCategory(event.getCategory());
            dto.setDate(event.getDate());
            dto.setTime(event.getTime());
            dto.setVenue(event.getVenue());
            dto.setMaxParticipants(event.getMaxParticipants());
            dto.setRegisteredCount(event.getRegisteredCount());
            dto.setPoints(event.getPoints());
            dto.setStatus(event.getStatus());
            dto.setIcon(event.getIcon());
            dto.setColor(event.getColor());
            dto.setImageUrl(event.getImageUrl());
            dto.setRules(event.getRules());
            return dto;
        }
        return null;
    }
    
    public EventDTO createEvent(EventDTO eventDTO) {
        Event event = new Event();
        event.setTitle(eventDTO.getTitle());
        event.setDescription(eventDTO.getDescription());
        event.setCategory(eventDTO.getCategory());
        event.setDate(eventDTO.getDate());
        event.setTime(eventDTO.getTime());
        event.setVenue(eventDTO.getVenue());
        event.setMaxParticipants(eventDTO.getMaxParticipants());
        event.setPoints(eventDTO.getPoints());
        event.setStatus(eventDTO.getStatus());
        event.setIcon(eventDTO.getIcon());
        event.setColor(eventDTO.getColor());
        event.setImageUrl(eventDTO.getImageUrl());
        event.setRules(eventDTO.getRules());
        
        Event savedEvent = eventRepository.save(event);
        
        EventDTO dto = new EventDTO();
        dto.setId(savedEvent.getId());
        dto.setTitle(savedEvent.getTitle());
        dto.setDescription(savedEvent.getDescription());
        dto.setCategory(savedEvent.getCategory());
        dto.setDate(savedEvent.getDate());
        dto.setTime(savedEvent.getTime());
        dto.setVenue(savedEvent.getVenue());
        dto.setMaxParticipants(savedEvent.getMaxParticipants());
        dto.setRegisteredCount(savedEvent.getRegisteredCount());
        dto.setPoints(savedEvent.getPoints());
        dto.setStatus(savedEvent.getStatus());
        dto.setIcon(savedEvent.getIcon());
        dto.setColor(savedEvent.getColor());
        dto.setImageUrl(savedEvent.getImageUrl());
        dto.setRules(savedEvent.getRules());
        
        return dto;
    }
    
    public EventDTO updateEvent(Long id, EventDTO eventDTO) {
        Optional<Event> eventOpt = eventRepository.findById(id);
        if (eventOpt.isPresent()) {
            Event event = eventOpt.get();
            event.setTitle(eventDTO.getTitle());
            event.setDescription(eventDTO.getDescription());
            event.setCategory(eventDTO.getCategory());
            event.setDate(eventDTO.getDate());
            event.setTime(eventDTO.getTime());
            event.setVenue(eventDTO.getVenue());
            event.setMaxParticipants(eventDTO.getMaxParticipants());
            event.setPoints(eventDTO.getPoints());
            event.setStatus(eventDTO.getStatus());
            event.setIcon(eventDTO.getIcon());
            event.setColor(eventDTO.getColor());
            event.setImageUrl(eventDTO.getImageUrl());
            event.setRules(eventDTO.getRules());
            
            Event updatedEvent = eventRepository.save(event);
            
            EventDTO dto = new EventDTO();
            dto.setId(updatedEvent.getId());
            dto.setTitle(updatedEvent.getTitle());
            dto.setDescription(updatedEvent.getDescription());
            dto.setCategory(updatedEvent.getCategory());
            dto.setDate(updatedEvent.getDate());
            dto.setTime(updatedEvent.getTime());
            dto.setVenue(updatedEvent.getVenue());
            dto.setMaxParticipants(updatedEvent.getMaxParticipants());
            dto.setRegisteredCount(updatedEvent.getRegisteredCount());
            dto.setPoints(updatedEvent.getPoints());
            dto.setStatus(updatedEvent.getStatus());
            dto.setIcon(updatedEvent.getIcon());
            dto.setColor(updatedEvent.getColor());
            dto.setImageUrl(updatedEvent.getImageUrl());
            dto.setRules(updatedEvent.getRules());
            
            return dto;
        }
        return null;
    }
    
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
    
    // NEW METHOD - Delete all events
    public void deleteAllEvents() {
        eventRepository.deleteAll();
    }
}