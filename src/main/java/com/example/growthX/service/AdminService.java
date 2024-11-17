package com.example.growthX.service;

import com.example.growthX.dto.AdminRegistrationDTO;
import com.example.growthX.entity.Admin;
import com.example.growthX.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public Admin registerAdmin(AdminRegistrationDTO adminRegistrationDTO) {
        if (adminRepository.findByUsername(adminRegistrationDTO.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists!");
        }
        Admin admin = new Admin(null, adminRegistrationDTO.getUsername(), passwordEncoder.encode(adminRegistrationDTO.getPassword()));
        return adminRepository.save(admin);
    }

    public Admin authenticate(String username, String password) {
        Admin admin = adminRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Admin not found!"));
        if (!passwordEncoder.matches(password, admin.getPassword())) {
            throw new BadCredentialsException("Invalid password!");
        }
        return admin;
    }
}
