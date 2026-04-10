package com.klu.clubconnect.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventDTO {
    private Long id;
    private String title;
    private String description;
    private String category;
    private LocalDate date;
    private LocalTime time;
    private String venue;
    private Integer maxParticipants;
    private Integer registeredCount;
    private Integer points;
    private String status;
    private String icon;
    private String color;
    private String imageUrl;
    private String rules;
    
    // Constructors
    public EventDTO() {}
    
    public EventDTO(Long id, String title, String description, String category, 
                    LocalDate date, LocalTime time, String venue, Integer maxParticipants,
                    Integer registeredCount, Integer points, String status, 
                    String icon, String color, String imageUrl, String rules) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.date = date;
        this.time = time;
        this.venue = venue;
        this.maxParticipants = maxParticipants;
        this.registeredCount = registeredCount;
        this.points = points;
        this.status = status;
        this.icon = icon;
        this.color = color;
        this.imageUrl = imageUrl;
        this.rules = rules;
    }
    
    // Getters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public LocalDate getDate() { return date; }
    public LocalTime getTime() { return time; }
    public String getVenue() { return venue; }
    public Integer getMaxParticipants() { return maxParticipants; }
    public Integer getRegisteredCount() { return registeredCount; }
    public Integer getPoints() { return points; }
    public String getStatus() { return status; }
    public String getIcon() { return icon; }
    public String getColor() { return color; }
    public String getImageUrl() { return imageUrl; }
    public String getRules() { return rules; }
    
    // Setters
    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setCategory(String category) { this.category = category; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setTime(LocalTime time) { this.time = time; }
    public void setVenue(String venue) { this.venue = venue; }
    public void setMaxParticipants(Integer maxParticipants) { this.maxParticipants = maxParticipants; }
    public void setRegisteredCount(Integer registeredCount) { this.registeredCount = registeredCount; }
    public void setPoints(Integer points) { this.points = points; }
    public void setStatus(String status) { this.status = status; }
    public void setIcon(String icon) { this.icon = icon; }
    public void setColor(String color) { this.color = color; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setRules(String rules) { this.rules = rules; }
}