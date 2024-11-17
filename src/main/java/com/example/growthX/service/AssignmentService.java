package com.example.growthX.service;

import com.example.growthX.dto.assignmentRequestDTO;
import com.example.growthX.entity.Assignment;
import com.example.growthX.repository.AssignmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;

    public Assignment uploadAssignment(assignmentRequestDTO assignmentRequestDTO) {
        Assignment assignment = new Assignment(null, assignmentRequestDTO.getUserId(), assignmentRequestDTO.getTask(),
                assignmentRequestDTO.getAdminId(), "PENDING", LocalDateTime.now());
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> getAssignmentsForAdmin(String adminId) {
        return assignmentRepository.findByAdminId(adminId);
    }

    public Assignment updateAssignmentStatus(String id, String status) {
        Assignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Assignment not found!"));
        assignment.setStatus(status);
        return assignmentRepository.save(assignment);
    }
}
