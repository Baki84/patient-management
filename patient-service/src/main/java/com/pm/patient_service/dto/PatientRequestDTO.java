package com.pm.patient_service.dto;

import com.pm.patient_service.dto.validators.CreatePatientValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class PatientRequestDTO
{
    @NotBlank(message = "Name is required")
    @Size(max=100,message = "Name cannot exceed 100 characters")
    private String  name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Address is Required")
    private String address;

    @NotNull(message = "Date of birth is required")
    private LocalDate dateOfBirth;

    @NotNull( groups= CreatePatientValidationGroup.class ,message = "Registered date is required")
    private LocalDate registerDate;

    public @NotBlank(message = "Name is required") @Size(max = 100, message = "Name cannot exceed 100 characters") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is required") @Size(max = 100, message = "Name cannot exceed 100 characters") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Email is required") @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is required") @Email(message = "Email should be valid") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Address is Required") String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank(message = "Address is Required") String address) {
        this.address = address;
    }

    public @NotNull(message = "Date of birth is required") LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotNull(message = "Date of birth is required") LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public  LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate (LocalDate registerDate) {
        this.registerDate = registerDate;
    }

}
