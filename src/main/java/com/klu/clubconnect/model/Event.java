package com.klu.clubconnect.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class Event {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String description;
    private String category;
    private LocalDate date;
    private LocalTime time;
    private String venue;
    private Integer maxParticipants;
    private Integer registeredCount = 0;
    private Integer points = 100;
    private String status = "OPEN";
    private String icon;
    private String color;
    private String imageUrl;
    private String rules;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    
    public LocalTime getTime() { return time; }
    public void setTime(LocalTime time) { this.time = time; }
    
    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }
    
    public Integer getMaxParticipants() { return maxParticipants; }
    public void setMaxParticipants(Integer maxParticipants) { this.maxParticipants = maxParticipants; }
    
    public Integer getRegisteredCount() { return registeredCount; }
    public void setRegisteredCount(Integer registeredCount) { this.registeredCount = registeredCount; }
    
    public Integer getPoints() { return points; }
    public void setPoints(Integer points) { this.points = points; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }
    
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    
    public String getRules() { return rules; }
    public void setRules(String rules) { this.rules = rules; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}