package com.weblio.userhub.service;

import com.weblio.userhub.model.User;
import com.weblio.userhub.model.Role;
import com.weblio.userhub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register a new user
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        return userRepository.save(user);
    }

    // Get all users (for admin)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Find user by id
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
