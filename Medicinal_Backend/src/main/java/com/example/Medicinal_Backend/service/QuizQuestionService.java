package com.example.Medicinal_Backend.service;

import com.example.Medicinal_Backend.model.QuizQuestion;
import com.example.Medicinal_Backend.repository.QuizQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizQuestionService {

    private final QuizQuestionRepository repository;

    public QuizQuestionService(QuizQuestionRepository repository) {
        this.repository = repository;
    }

    public List<QuizQuestion> getAllQuestions() {
        return repository.findAll();
    }

    public Optional<QuizQuestion> getQuestionById(Long id) {
        return repository.findById(id);
    }

    public QuizQuestion saveQuestion(QuizQuestion question) {
        return repository.save(question);
    }

    public void deleteQuestion(Long id) {
        repository.deleteById(id);
    }
}
