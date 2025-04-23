package com.example.mtb.mapper;

import com.example.mtb.dto.UserRegistrationDTO;
import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.User;
import org.springframework.stereotype.Component;


@Component
public class UserRegistrationMapper {
        public User registrationUser(UserRegistrationDTO userRegistrationDTO ) {
            User user = new User();
            user.setUsername(userRegistrationDTO.username());
            user.setEmail(userRegistrationDTO.email());
            user.setPassword(userRegistrationDTO.password());
            user.setUserRole(userRegistrationDTO.userRole());
            user.setPhoneNumber(userRegistrationDTO.phoneNumber());
            user.setDateOfBirth(userRegistrationDTO.dateOfBirth());
            return user;
        }

        public TheaterOwner registrationTheaterOwner (UserRegistrationDTO userRegistrationDTO){
            TheaterOwner theaterOwner =new TheaterOwner();
            theaterOwner.setUsername(userRegistrationDTO.username());
            theaterOwner.setEmail(userRegistrationDTO.email());
            theaterOwner.setPhoneNumber(userRegistrationDTO.phoneNumber());
            theaterOwner.setPassword(userRegistrationDTO.password());
            theaterOwner.setDateOfBirth(userRegistrationDTO.dateOfBirth());
            return theaterOwner;

        }
}

