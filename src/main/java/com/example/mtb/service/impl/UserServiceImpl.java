package com.example.mtb.service.impl;

import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.User;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.enums.UserRole;
import com.example.mtb.exception.EmailAlreadyExistException;
import com.example.mtb.repository.UserRepository;
import com.example.mtb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDetails userRegister(UserDetails userDetails) {
        if(userRepository.existsByEmail(userDetails.getEmail())){
            throw new EmailAlreadyExistException("user mail already exist "+userDetails.getEmail());
        }
        if(userDetails.getUserRole()== UserRole.USER){
            User user=new User();
            user.setUserId(userDetails.getUserId());
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setUserRole(userDetails.getUserRole());
            user.setPhoneNumber(userDetails.getPhoneNumber());
            user.setDateOfBirth(userDetails.getDateOfBirth());
            user.setCreatedAt(userDetails.getCreatedAt());
            user.setUpdatedAt(userDetails.getUpdatedAt());
            return userRepository.save(user);
        }

        else{
            TheaterOwner theaterOwner=new TheaterOwner();
            theaterOwner.setUserId(userDetails.getUserId());
            theaterOwner.setUsername(userDetails.getUsername());
            theaterOwner.setEmail(userDetails.getEmail());
            theaterOwner.setPassword(userDetails.getPassword());
            theaterOwner.setUserRole(userDetails.getUserRole());
            theaterOwner.setPhoneNumber(userDetails.getPhoneNumber());
            theaterOwner.setDateOfBirth(userDetails.getDateOfBirth());
            theaterOwner.setCreatedAt(userDetails.getCreatedAt());
            theaterOwner.setUpdatedAt(userDetails.getUpdatedAt());
            return userRepository.save(theaterOwner);
        }
    }
}

