package com.example.mtb.mapper;

import com.example.mtb.dto.UserRegistrationRequest;
import com.example.mtb.dto.UserResponse;
import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.User;
import com.example.mtb.entity.UserDetails;
import org.springframework.stereotype.Component;


@Component
public class UserMapper<UserRequest> {

    long now = System.currentTimeMillis();

    public UserResponse toResponse(UserDetails user){
        return new UserResponse(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getUserRole(),
                user.getPhoneNumber(),
                user.getDateOfBirth()
        );
    }

    public User toUser(UserRegistrationRequest request){
        User user = new User();
//        user.setUserId(user.getUserId());
        user.setUsername(request.userName());
        user.setEmail(request.email());
        user.setPassword(request.password());
        user.setUserRole(request.role());
        user.setPhoneNumber(request.phoneNumber());
        user.setDateOfBirth(request.dateOfBirth());
        user.setCreatedAt(now);
        user.setUpdatedAt(now);
        return user;
    }

    public TheaterOwner toTheaterOwner(UserRegistrationRequest request){
        TheaterOwner theaterOwner = new TheaterOwner();
//        theaterOwner.setUserId(theaterOwner.getUserId());
        theaterOwner.setUsername(request.userName());
        theaterOwner.setEmail(request.email());
        theaterOwner.setPassword(request.password());
        theaterOwner.setUserRole(request.role());
        theaterOwner.setPhoneNumber(request.phoneNumber());
        theaterOwner.setDateOfBirth(request.dateOfBirth());
        theaterOwner.setCreatedAt(now);
        theaterOwner.setUpdatedAt(now);
        return theaterOwner;
    }

    public UserDetails toUpdateUserDetails(UserRegistrationRequest request, UserDetails userDetails){

        userDetails.setUsername(request.userName());
        userDetails.setPhoneNumber(request.phoneNumber());
        userDetails.setDateOfBirth(request.dateOfBirth());
        userDetails.setUpdatedAt(now);
        return userDetails;
    }


    public UserDetails toDeleteUserDetails(UserDetails userDetails){
        userDetails.setDeleteAt(now);
        userDetails.setDelete(true);
        return userDetails;
    }

}

