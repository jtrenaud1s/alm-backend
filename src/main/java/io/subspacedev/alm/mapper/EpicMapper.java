package io.subspacedev.alm.mapper;

import io.subspacedev.alm.dto.EpicDto;
import io.subspacedev.alm.domain.model.Epic;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EpicMapper {
    EpicDto toDto(Epic epic);

    Epic toEntity(EpicDto epicDto);
}