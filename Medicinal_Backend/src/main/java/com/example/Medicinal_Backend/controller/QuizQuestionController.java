package com.example.Medicinal_Backend.controller;

import com.example.Medicinal_Backend.model.QuizQuestion;
import com.example.Medicinal_Backend.service.QuizQuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz-questions")
@CrossOrigin(origins = "*")
public class QuizQuestionController {

    private final QuizQuestionService service;

    public QuizQuestionController(QuizQuestionService service) {
        this.service = service;
    }

    @GetMapping
    public List<QuizQuestion> getAll() {
        return service.getAllQuestions();
    }

    @GetMapping("/{id}")
    public QuizQuestion getById(@PathVariable Long id) {
        return service.getQuestionById(id).orElse(null);
    }

    @PostMapping
    public QuizQuestion add(@RequestBody QuizQuestion question) {
        return service.saveQuestion(question);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteQuestion(id);
    }
}
