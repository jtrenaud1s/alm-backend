package io.subspacedev.alm.service;

import io.subspacedev.alm.dto.TeamDto;

public interface TeamService {
    TeamDto createTeam(TeamDto teamDto);

    TeamDto getTeamById(Long id);

    TeamDto updateTeam(Long id, TeamDto teamDto);

    void deleteTeam(Long id);
}