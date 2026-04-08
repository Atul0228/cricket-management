package com.cricket.cricket_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.cricket_management.model.Team;
import com.cricket.cricket_management.repository.TeamRepository;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}