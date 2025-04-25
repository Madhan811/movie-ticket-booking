package com.example.mtb.dto;

import com.example.mtb.enums.UserRole;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
public record UserResponseDTO(
//        @NotNull
//        String userId,
        @NotNull
        String userName,
        @NotNull
        String email,
        String userDetailsEmail, @NotNull
        UserRole userRole,
        @NotNull
        String phoneNumber,
        LocalDate dateOfBirth
) {
}

