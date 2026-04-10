package com.klu.clubconnect.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "notifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    
    private String message;
    
    private String type; // ANNOUNCEMENT, UPDATE
    
    private String sentTo; // ALL, REGISTERED
    
    private LocalDate sentDate;
    
    @PrePersist
    protected void onCreate() {
        sentDate = LocalDate.now();
    }
}