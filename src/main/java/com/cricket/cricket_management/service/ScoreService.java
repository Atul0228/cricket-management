package com.cricket.cricket_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.cricket_management.model.Score;
import com.cricket.cricket_management.repository.ScoreRepository;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public Score saveScore(Score score) {
        return scoreRepository.save(score);
    }

    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    public Score getScoreById(Long id) {
        return scoreRepository.findById(id).orElse(null);
    }

    public void deleteScore(Long id) {
        scoreRepository.deleteById(id);
    }
}