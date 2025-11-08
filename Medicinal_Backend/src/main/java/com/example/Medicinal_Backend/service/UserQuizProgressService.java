package com.example.Medicinal_Backend.service;

import com.example.Medicinal_Backend.model.UserQuizProgress;
import com.example.Medicinal_Backend.repository.UserQuizProgressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQuizProgressService {

    private final UserQuizProgressRepository repository;

    public UserQuizProgressService(UserQuizProgressRepository repository) {
        this.repository = repository;
    }

    public List<UserQuizProgress> getAllProgress() {
        return repository.findAll();
    }

    public UserQuizProgress saveProgress(UserQuizProgress progress) {
        return repository.save(progress);
    }

    public void deleteProgress(Long id) {
        repository.deleteById(id);
    }
}
