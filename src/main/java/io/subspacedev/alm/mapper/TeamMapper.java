package io.subspacedev.alm.mapper;

import io.subspacedev.alm.dto.TeamDto;
import io.subspacedev.alm.domain.model.Team;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    TeamDto toDto(Team team);

    Team toEntity(TeamDto teamDto);
}