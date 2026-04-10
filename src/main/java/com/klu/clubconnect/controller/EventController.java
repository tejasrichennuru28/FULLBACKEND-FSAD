package com.klu.clubconnect.controller;

import com.klu.clubconnect.dto.EventDTO;
import com.klu.clubconnect.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "http://localhost:3000")
public class EventController {
    
    @Autowired
    private EventService eventService;
    
    @GetMapping("/public/all")
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }
    
    @GetMapping("/public/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getEventById(id));
    }
    
    @PostMapping("/admin/create")
    public ResponseEntity<EventDTO> createEvent(@RequestBody EventDTO eventDTO) {
        return ResponseEntity.ok(eventService.createEvent(eventDTO));
    }
    
    @PutMapping("/admin/update/{id}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDTO) {
        return ResponseEntity.ok(eventService.updateEvent(id, eventDTO));
    }
    
    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.ok("Event deleted successfully");
    }
    
    // NEW METHOD - Delete all events
    @DeleteMapping("/admin/delete-all")
    public ResponseEntity<String> deleteAllEvents() {
        eventService.deleteAllEvents();
        return ResponseEntity.ok("All events deleted successfully");
    }
}