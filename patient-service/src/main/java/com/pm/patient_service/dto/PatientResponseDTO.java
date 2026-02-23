package com.pm.patient_service.dto;


import java.time.LocalDate;
import java.util.UUID;

public class PatientResponseDTO
{
    private UUID id;
    private String name;
    private String email;
    private String address;
    private LocalDate dateOfBirth;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress(String string) {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
