package io.subspacedev.alm.service.impl;

import io.subspacedev.alm.domain.model.Team;
import io.subspacedev.alm.domain.repository.TeamRepository;
import io.subspacedev.alm.dto.TeamDto;
import io.subspacedev.alm.mapper.TeamMapper;
import io.subspacedev.alm.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamMapper teamMapper;

    @Override
    public TeamDto createTeam(TeamDto teamDto) {
        Team team = teamMapper.toEntity(teamDto);
        Team savedTeam = teamRepository.save(team);
        return teamMapper.toDto(savedTeam);
    }

    @Override
    public TeamDto getTeamById(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new RuntimeException("Team not found"));
        return teamMapper.toDto(team);
    }

    @Override
    public TeamDto updateTeam(Long id, TeamDto teamDto) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new RuntimeException("Team not found"));
        team.setName(teamDto.getName());
        Team updatedTeam = teamRepository.save(team);
        return teamMapper.toDto(updatedTeam);
    }

    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}