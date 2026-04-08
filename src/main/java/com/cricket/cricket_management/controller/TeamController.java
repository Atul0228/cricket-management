package com.cricket.cricket_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cricket.cricket_management.dto.TeamDTO;
import com.cricket.cricket_management.service.TeamService;
import com.cricket.cricket_management.response.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    // CREATE
    @PostMapping
    public ResponseEntity<ApiResponse<TeamDTO>>
            saveTeam(
            @Valid @RequestBody TeamDTO dto) {

        TeamDTO saved =
                teamService.saveTeam(dto);

        ApiResponse<TeamDTO> response =
                new ApiResponse<>(
                        true,
                        "Team created successfully",
                        saved);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<ApiResponse<List<TeamDTO>>>
            getAllTeams() {

        List<TeamDTO> teams =
                teamService.getAllTeams();

        ApiResponse<List<TeamDTO>> response =
                new ApiResponse<>(
                        true,
                        "Teams fetched successfully",
                        teams);

        return ResponseEntity.ok(response);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TeamDTO>>
            getTeamById(
            @PathVariable Long id) {

        TeamDTO team =
                teamService.getTeamById(id);

        ApiResponse<TeamDTO> response =
                new ApiResponse<>(
                        true,
                        "Team fetched successfully",
                        team);

        return ResponseEntity.ok(response);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TeamDTO>>
            updateTeam(
            @PathVariable Long id,
            @Valid @RequestBody TeamDTO dto) {

        TeamDTO updated =
                teamService.updateTeam(id, dto);

        ApiResponse<TeamDTO> response =
                new ApiResponse<>(
                        true,
                        "Team updated successfully",
                        updated);

        return ResponseEntity.ok(response);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>>
            deleteTeam(
            @PathVariable Long id) {

        teamService.deleteTeam(id);

        ApiResponse<Void> response =
                new ApiResponse<>(
                        true,
                        "Team deleted successfully",
                        null);

        return ResponseEntity.ok(response);
    }

    // PAGINATION
    @GetMapping("/pagination")
    public ResponseEntity<ApiResponse<List<TeamDTO>>>
            getTeamsWithPagination(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy) {

        List<TeamDTO> teams =
                teamService.getTeamsWithPagination(
                        page,
                        size,
                        sortBy);

        ApiResponse<List<TeamDTO>> response =
                new ApiResponse<>(
                        true,
                        "Teams fetched with pagination",
                        teams);

        return ResponseEntity.ok(response);
    }

    // SEARCH
    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<TeamDTO>>>
            searchTeams(
            @RequestParam String teamName) {

        List<TeamDTO> teams =
                teamService.searchTeamsByName(
                        teamName);

        ApiResponse<List<TeamDTO>> response =
                new ApiResponse<>(
                        true,
                        "Search completed successfully",
                        teams);

        return ResponseEntity.ok(response);
    }
}