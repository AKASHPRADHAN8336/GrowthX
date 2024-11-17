package com.example.growthX.repository;

import com.example.growthX.entity.Assignment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AssignmentRepository extends MongoRepository<Assignment , String> {
    List<Assignment> findByAdminId(String adminId);
}
