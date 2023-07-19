package io.subspacedev.alm.service;

import io.subspacedev.alm.dto.BoardDto;

public interface BoardService {
    BoardDto createBoard(BoardDto boardDto);

    BoardDto getBoardById(Long id);

    BoardDto updateBoard(Long id, BoardDto boardDto);

    void deleteBoard(Long id);
}