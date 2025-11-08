package com.example.Medicinal_Backend.controller;

import com.example.Medicinal_Backend.model.User;
import com.example.Medicinal_Backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAll() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return service.getUserById(id).orElse(null);
    }

    @PostMapping
    public User register(@RequestBody User user) {
        return service.saveUser(user);
    }

    @GetMapping("/email/{email}")
    public User getByEmail(@PathVariable String email) {
        return service.findByEmail(email).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteUser(id);
    }
}

