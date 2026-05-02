package com.klu.clubconnect.dto;

public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String dob;
    private String college;
    private String year;
    private String department;
    private String adminId;

    public RegisterRequest() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }
    
    public String getCollege() { return college; }
    public void setCollege(String college) { this.college = college; }
    
    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public String getAdminId() { return adminId; }
    public void setAdminId(String adminId) { this.adminId = adminId; }
}