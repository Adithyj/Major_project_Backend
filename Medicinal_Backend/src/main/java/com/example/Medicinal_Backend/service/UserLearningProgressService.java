package com.example.Medicinal_Backend.service;

import com.example.Medicinal_Backend.model.UserLearningProgress;
import com.example.Medicinal_Backend.repository.UserLearningProgressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLearningProgressService {

    private final UserLearningProgressRepository repository;

    public UserLearningProgressService(UserLearningProgressRepository repository) {
        this.repository = repository;
    }

    public List<UserLearningProgress> getAllProgress() {
        return repository.findAll();
    }

    public UserLearningProgress saveProgress(UserLearningProgress progress) {
        return repository.save(progress);
    }

    public void deleteProgress(Long id) {
        repository.deleteById(id);
    }
}

