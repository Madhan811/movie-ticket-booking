package com.example.mtb.service;

import com.example.mtb.dto.UserRegistrationDTO;
import com.example.mtb.entity.UserDetails;

public interface UserService {
    UserDetails userRegister(UserRegistrationDTO userRegistrationDTO);
}
