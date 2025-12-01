package com.example.library.controller;

import com.example.library.entity.User;
import com.example.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    // ✅ Register a new user (Member/Librarian/Admin)
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    // ✅ Get all users (Admin only in real setup)
    @GetMapping
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    // ✅ Get user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // ✅ Update user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User existing = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existing.setUsername(updatedUser.getUsername());
        existing.setPassword(updatedUser.getPassword());
        existing.setRole(updatedUser.getRole());
        return userRepo.save(existing);
    }

    // ✅ Delete user
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
    }
}
