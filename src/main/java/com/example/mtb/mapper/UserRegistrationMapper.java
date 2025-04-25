package com.example.mtb.mapper;

import com.example.mtb.dto.UserRegistrationDTO;
import com.example.mtb.dto.UserResponseDTO;
import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.User;
import com.example.mtb.entity.UserDetails;
import org.springframework.stereotype.Component;


@Component
public class UserRegistrationMapper {
        public User registrationUser(UserRegistrationDTO userRegistrationDTO ) {
            User user = new User();
            user.setUsername(userRegistrationDTO.userName());
            user.setEmail(userRegistrationDTO.email());
            user.setPassword(userRegistrationDTO.password());
            user.setUserRole(userRegistrationDTO.role());
            user.setPhoneNumber(userRegistrationDTO.phoneNumber());
            user.setDateOfBirth(userRegistrationDTO.dateOfBirth());
            return user;
        }

        public TheaterOwner registrationTheaterOwner (UserRegistrationDTO userRegistrationDTO){
            TheaterOwner theaterOwner =new TheaterOwner();
            theaterOwner.setUsername(userRegistrationDTO.userName());
            theaterOwner.setEmail(userRegistrationDTO.email());
            theaterOwner.setPhoneNumber(userRegistrationDTO.phoneNumber());
            theaterOwner.setPassword(userRegistrationDTO.password());
            theaterOwner.setDateOfBirth(userRegistrationDTO.dateOfBirth());
            return theaterOwner;

        }

    public UserResponseDTO responseDTO(UserDetails userDetails) {
        return new UserResponseDTO(
                userDetails.getUserId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getUserRole(),
                userDetails.getPhoneNumber(),
                userDetails.getDateOfBirth()
        );
    }
}

