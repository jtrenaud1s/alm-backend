package io.subspacedev.alm.dto;

import lombok.Data;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

@Data
public class TeamDto {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private List<BoardDto> teamBoards;

    private List<UserDto> members;
}