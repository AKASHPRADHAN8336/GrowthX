package com.example.growthX.controller;

import com.example.growthX.dto.AdminRegistrationDTO;
import com.example.growthX.dto.LoginRequestDTO;
import com.example.growthX.entity.Admin;
import com.example.growthX.entity.Assignment;
import com.example.growthX.service.AdminService;
import com.example.growthX.service.AssignmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
@AllArgsConstructor
public class AdminController {
    private final AdminService adminService;
    private final AssignmentService assignmentService;

    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@RequestBody AdminRegistrationDTO adminRegistrationDTO) {
        return new ResponseEntity<>(adminService.registerAdmin(adminRegistrationDTO), HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<Admin> loginAdmin(@RequestBody LoginRequestDTO loginRequestDTO) {
        return new ResponseEntity<>(adminService.authenticate(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()), HttpStatus.OK);
    }

    @GetMapping("/assignments")
    public ResponseEntity<List<Assignment>> getAssignments(@RequestParam String adminId) {
        return new ResponseEntity<>(assignmentService.getAssignmentsForAdmin(adminId), HttpStatus.OK);
    }

    @PostMapping("/assignments/{id}/accept")
    public ResponseEntity<Assignment> acceptAssignment(@PathVariable String id) {
        return new ResponseEntity<>(assignmentService.updateAssignmentStatus(id, "ACCEPTED"), HttpStatus.OK);
    }

    @PostMapping("/assignments/{id}/reject")
    public ResponseEntity<Assignment> rejectAssignment(@PathVariable String id) {
        return new ResponseEntity<>(assignmentService.updateAssignmentStatus(id, "REJECTED"), HttpStatus.OK);
    }
}
