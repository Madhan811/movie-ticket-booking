package com.example.mtb.controller;;

import com.example.mtb.dto.UserRegistrationRequest;
import com.example.mtb.dto.UserResponse;
import com.example.mtb.service.UserService;
import com.example.mtb.utility.ResponseStructure;
import com.example.mtb.utility.StructureResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
//@RequestMapping("/booking-shows")
public class UserController {

        private UserService userService;
        private StructureResponseBuilder structureResponseBuilder;

        @PostMapping("/register")
        public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@Valid @RequestBody UserRegistrationRequest request) {
                UserResponse userResponse = userService.userRegister(request);
                return structureResponseBuilder.success(HttpStatus.CREATED,"user Registeration succssefully done",userResponse);
        }

        @DeleteMapping("/users")
        public ResponseEntity<ResponseStructure<UserResponse>> deleteUser(@RequestParam String email){
                UserResponse userResponse = userService.deleteUser(email);
                return structureResponseBuilder.success(HttpStatus.OK, "User Deleted Successfully", userResponse);
        }


        @PutMapping("/users")
        public ResponseEntity<ResponseStructure<UserResponse>> updateUser(@Valid @RequestBody UserRegistrationRequest request, @RequestParam String email){
                UserResponse userResponse = userService.updateUser(request, email);
                return structureResponseBuilder.success(HttpStatus.OK,"User Updated Successfully",userResponse);
        }
}
