package com.cricket.cricket_management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TeamDTO {

    private Long teamId;

    @NotBlank(message = "Team name is required")
    @Size(min = 2, max = 50,
          message = "Team name must be between 2 and 50 characters")
    private String teamName;

    @NotBlank(message = "Coach name is required")
    @Size(min = 2, max = 50,
          message = "Coach name must be between 2 and 50 characters")
    private String coach;

    public TeamDTO() {
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }
}