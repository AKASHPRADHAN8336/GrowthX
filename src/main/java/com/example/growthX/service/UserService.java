package com.example.growthX.service;

import com.example.growthX.dto.UserRegistrationDTO;
import com.example.growthX.entity.Admin;
import com.example.growthX.entity.User;
import com.example.growthX.repository.AdminRepository;
import com.example.growthX.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AdminRepository adminRepository;

    public User registerUser(UserRegistrationDTO userRegistrationDTO) {
        if (userRepository.findByUsername(userRegistrationDTO.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists!");
        }
        User user = new User(null, userRegistrationDTO.getUsername(), passwordEncoder.encode(userRegistrationDTO.getPassword()));
        return userRepository.save(user);
    }

    public User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Invalid password!");
        }
        return user;
    }


    public List<Admin> getAllAdmins() {
        return adminRepository.findAll(); 
    }
}
