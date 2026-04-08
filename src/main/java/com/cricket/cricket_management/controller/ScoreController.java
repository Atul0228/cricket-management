package com.cricket.cricket_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cricket.cricket_management.model.Score;
import com.cricket.cricket_management.service.ScoreService;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping
    public Score saveScore(@RequestBody Score score) {
        return scoreService.saveScore(score);
    }

    @GetMapping
    public List<Score> getAllScores() {
        return scoreService.getAllScores();
    }

    @GetMapping("/{id}")
    public Score getScoreById(@PathVariable Long id) {
        return scoreService.getScoreById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteScore(@PathVariable Long id) {
        scoreService.deleteScore(id);
    }
}