package com.example.growthX.controller;

import com.example.growthX.dto.LoginRequestDTO;
import com.example.growthX.dto.UserRegistrationDTO;
import com.example.growthX.dto.assignmentRequestDTO;
import com.example.growthX.entity.Admin;
import com.example.growthX.entity.Assignment;
import com.example.growthX.entity.User;
import com.example.growthX.service.AssignmentService;
import com.example.growthX.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final AssignmentService assignmentService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        return new ResponseEntity<>(userService.registerUser(userRegistrationDTO), HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody LoginRequestDTO loginRequestDTO) {
        return new ResponseEntity<>(userService.authenticate(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()), HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<Assignment> uploadAssignment(@RequestBody assignmentRequestDTO assignmentRequestDTO) {
        return new ResponseEntity<>(assignmentService.uploadAssignment(assignmentRequestDTO), HttpStatus.OK);
    }

    @GetMapping("/admins")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        return new ResponseEntity<>(userService.getAllAdmins(), HttpStatus.OK);

    }
}
