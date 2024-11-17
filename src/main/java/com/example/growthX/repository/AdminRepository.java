package com.example.growthX.repository;

import com.example.growthX.entity.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {
    Optional<Admin> findByUsername(String username);

    List<Admin> findAll();
}
