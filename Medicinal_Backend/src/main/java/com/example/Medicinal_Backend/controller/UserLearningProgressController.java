package com.example.Medicinal_Backend.controller;


import com.example.Medicinal_Backend.model.UserLearningProgress;
import com.example.Medicinal_Backend.service.UserLearningProgressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-learning-progress")
@CrossOrigin(origins = "*")
public class UserLearningProgressController {

    private final UserLearningProgressService service;

    public UserLearningProgressController(UserLearningProgressService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserLearningProgress> getAll() {
        return service.getAllProgress();
    }

    @PostMapping
    public UserLearningProgress add(@RequestBody UserLearningProgress progress) {
        return service.saveProgress(progress);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteProgress(id);
    }
}
