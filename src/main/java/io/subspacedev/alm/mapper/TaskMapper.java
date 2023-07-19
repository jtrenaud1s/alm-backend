package io.subspacedev.alm.mapper;

import io.subspacedev.alm.dto.TaskDto;
import io.subspacedev.alm.domain.model.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDto toDto(Task task);

    Task toEntity(TaskDto taskDto);
}