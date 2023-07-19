package io.subspacedev.alm.service.impl;

import io.subspacedev.alm.dto.BoardDto;
import io.subspacedev.alm.domain.model.Board;
import io.subspacedev.alm.mapper.BoardMapper;
import io.subspacedev.alm.domain.repository.BoardRepository;
import io.subspacedev.alm.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public BoardDto createBoard(BoardDto boardDto) {
        Board board = boardMapper.toEntity(boardDto);
        Board savedBoard = boardRepository.save(board);
        return boardMapper.toDto(savedBoard);
    }

    @Override
    public BoardDto getBoardById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("Board not found"));
        return boardMapper.toDto(board);
    }

    @Override
    public BoardDto updateBoard(Long id, BoardDto boardDto) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("Board not found"));
        board.setName(boardDto.getName());
        Board updatedBoard = boardRepository.save(board);
        return boardMapper.toDto(updatedBoard);
    }

    @Override
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}