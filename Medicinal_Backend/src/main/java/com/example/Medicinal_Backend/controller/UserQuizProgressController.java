package com.example.Medicinal_Backend.controller;

import com.example.Medicinal_Backend.model.UserQuizProgress;
import com.example.Medicinal_Backend.service.UserQuizProgressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-quiz-progress")
@CrossOrigin(origins = "*")
public class UserQuizProgressController {

    private final UserQuizProgressService service;

    public UserQuizProgressController(UserQuizProgressService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserQuizProgress> getAll() {
        return service.getAllProgress();
    }

    @PostMapping
    public UserQuizProgress add(@RequestBody UserQuizProgress progress) {
        return service.saveProgress(progress);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteProgress(id);
    }
}

