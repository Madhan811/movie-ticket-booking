package com.example.mtb.service.impl;

import com.example.mtb.dto.UserRegistrationDTO;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.enums.UserRole;
import com.example.mtb.exception.EmailAlreadyExistException;
import com.example.mtb.mapper.UserRegistrationMapper;
import com.example.mtb.repository.UserRepository;
import com.example.mtb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final UserRegistrationMapper userRegistrationMapper;

    @Override
    public UserDetails userRegister(UserRegistrationDTO userRegistrationDTO) {
        {
            if (userRepository.existsByEmail(userRegistrationDTO.email())) {
                throw new EmailAlreadyExistException("user mail already exist" + userRegistrationDTO.email());
            }
            if (userRegistrationDTO.role() == UserRole.USER) {
                return userRepository.save( userRegistrationMapper.registrationUser(userRegistrationDTO));
            } else {
                return userRepository.save(userRegistrationMapper.registrationTheaterOwner(userRegistrationDTO));
            }
        }
    }
}

