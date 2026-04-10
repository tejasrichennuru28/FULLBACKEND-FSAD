package com.klu.clubconnect.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "communities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Community {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    private String category;
    
    private String description;
    
    private Integer members = 0;
    
    private String icon;
    
    private String meetingDay;
    
    private String meetingTime;
    
    private String location;
    
    private Boolean active = true;
    
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;
    
    private LocalDateTime createdAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}