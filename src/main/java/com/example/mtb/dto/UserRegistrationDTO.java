package com.example.mtb.dto;

import com.example.mtb.enums.UserRole;

import java.time.LocalDate;

public record UserRegistrationDTO(
        String username,
        String email,
        String password,
        UserRole userRole,
        String phoneNumber,
        LocalDate dateOfBirth
) {
}
