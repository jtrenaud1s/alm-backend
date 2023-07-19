package io.subspacedev.alm.mapper;

import io.subspacedev.alm.dto.BoardDto;
import io.subspacedev.alm.domain.model.Board;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardMapper {
    BoardDto toDto(Board board);

    Board toEntity(BoardDto boardDto);
}