package io.subspacedev.alm.mapper;

import io.subspacedev.alm.dto.StoryDto;
import io.subspacedev.alm.domain.model.Story;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StoryMapper {
    StoryDto toDto(Story story);

    Story toEntity(StoryDto storyDto);
}