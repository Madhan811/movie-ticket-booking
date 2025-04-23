package com.example.mtb.controller;;

import com.example.mtb.dto.UserRegistrationDTO;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.service.UserService;
import com.example.mtb.utility.ResponseStructure;
import com.example.mtb.utility.StructureResponseBuilder;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/register")
public class UserController {
        private final UserService userService;
        @Autowired
        private StructureResponseBuilder structureResponseBuilder;
        @PostMapping
        public ResponseEntity<ResponseStructure<UserDetails>> registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {
                return structureResponseBuilder.success(HttpStatus.CREATED,"user registration successfully done",userService.userRegister(userRegistrationDTO));
        }
}
