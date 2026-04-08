package com.cricket.cricket_management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.cricket.cricket_management.dto.TeamDTO;
import com.cricket.cricket_management.model.Team;
import com.cricket.cricket_management.repository.TeamRepository;
import com.cricket.cricket_management.exception.ResourceNotFoundException;

@Service
public class TeamService {

    private static final Logger logger =
            LoggerFactory.getLogger(TeamService.class);

    @Autowired
    private TeamRepository teamRepository;

    // Convert Entity → DTO
    private TeamDTO convertToDTO(Team team) {

        TeamDTO dto = new TeamDTO();

        dto.setTeamId(team.getTeamId());
        dto.setTeamName(team.getTeamName());
        dto.setCoach(team.getCoach());

        return dto;
    }

    // Convert DTO → Entity
    private Team convertToEntity(TeamDTO dto) {

        Team team = new Team();

        team.setTeamId(dto.getTeamId());
        team.setTeamName(dto.getTeamName());
        team.setCoach(dto.getCoach());

        return team;
    }

    // CREATE
    public TeamDTO saveTeam(TeamDTO dto) {

        logger.info("Saving new team: {}", dto.getTeamName());

        Team team = convertToEntity(dto);

        Team saved = teamRepository.save(team);

        logger.info("Team created successfully with ID: {}",
                saved.getTeamId());

        return convertToDTO(saved);
    }

    // READ ALL
    public List<TeamDTO> getAllTeams() {

        logger.info("Fetching all teams");

        return teamRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // READ BY ID
    public TeamDTO getTeamById(Long id) {

        logger.info("Fetching team with ID: {}", id);

        Team team = teamRepository.findById(id)
                .orElseThrow(() -> {

                    logger.error(
                            "Team not found with ID: {}", id);

                    return new ResourceNotFoundException(
                            "Team not found with id: " + id);
                });

        return convertToDTO(team);
    }

    // UPDATE
    public TeamDTO updateTeam(Long id, TeamDTO dto) {

        logger.info("Updating team with ID: {}", id);

        Team existing = teamRepository.findById(id)
                .orElseThrow(() -> {

                    logger.error(
                            "Team not found for update: {}", id);

                    return new ResourceNotFoundException(
                            "Team not found with id: " + id);
                });

        existing.setTeamName(dto.getTeamName());
        existing.setCoach(dto.getCoach());

        Team updated = teamRepository.save(existing);

        logger.info("Team updated successfully: {}", id);

        return convertToDTO(updated);
    }

    // DELETE
    public void deleteTeam(Long id) {

        logger.info("Deleting team with ID: {}", id);

        Team existing = teamRepository.findById(id)
                .orElseThrow(() -> {

                    logger.error(
                            "Team not found for delete: {}", id);

                    return new ResourceNotFoundException(
                            "Team not found with id: " + id);
                });

        teamRepository.delete(existing);

        logger.info("Team deleted successfully: {}", id);
    }

    // PAGINATION
    public List<TeamDTO> getTeamsWithPagination(
            int page,
            int size,
            String sortBy) {

        logger.info(
                "Fetching teams with pagination: page={}, size={}, sortBy={}",
                page, size, sortBy);

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sortBy).ascending());

        Page<Team> teamPage =
                teamRepository.findAll(pageable);

        return teamPage.getContent()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    // SEARCH
    public List<TeamDTO> searchTeamsByName(
            String teamName) {

        logger.info("Searching teams by name: {}",
                teamName);

        return teamRepository
                .findByTeamNameContainingIgnoreCase(
                        teamName)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }
}