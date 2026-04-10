package com.klu.clubconnect.dto;

public class LoginResponse {
    private String token;
    private String type;
    private Long id;
    private String name;
    private String email;
    private String role;
    private String avatar;
    private Integer totalPoints;
    
    // Constructor
    public LoginResponse(String token, String type, Long id, String name, 
                         String email, String role, String avatar, Integer totalPoints) {
        this.token = token;
        this.type = type;
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.avatar = avatar;
        this.totalPoints = totalPoints;
    }
    
    // Getters
    public String getToken() { return token; }
    public String getType() { return type; }
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
    public String getAvatar() { return avatar; }
    public Integer getTotalPoints() { return totalPoints; }
    
    // Setters
    public void setToken(String token) { this.token = token; }
    public void setType(String type) { this.type = type; }
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setRole(String role) { this.role = role; }
    public void setAvatar(String avatar) { this.avatar = avatar; }
    public void setTotalPoints(Integer totalPoints) { this.totalPoints = totalPoints; }
}