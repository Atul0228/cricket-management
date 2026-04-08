package com.cricket.cricket_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.cricket_management.model.Match;
import com.cricket.cricket_management.repository.MatchRepository;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match getMatchById(Long id) {
        return matchRepository.findById(id).orElse(null);
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}