package com.klu.clubconnect.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "registrations")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private String status;
    private LocalDateTime registeredAt;
    private Boolean certificateIssued;

    public Registration() {
        this.certificateIssued = false;
    }

    @PrePersist
    protected void onCreate() {
        registeredAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public User getUser() { return user; }
    public Event getEvent() { return event; }
    public String getStatus() { return status; }
    public LocalDateTime getRegisteredAt() { return registeredAt; }
    public Boolean getCertificateIssued() { return certificateIssued; }

    public void setId(Long id) { this.id = id; }
    public void setUser(User user) { this.user = user; }
    public void setEvent(Event event) { this.event = event; }
    public void setStatus(String status) { this.status = status; }
    public void setRegisteredAt(LocalDateTime registeredAt) { this.registeredAt = registeredAt; }
    public void setCertificateIssued(Boolean certificateIssued) { this.certificateIssued = certificateIssued; }
}