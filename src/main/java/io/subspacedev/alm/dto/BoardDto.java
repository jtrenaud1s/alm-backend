package io.subspacedev.alm.dto;

import lombok.Data;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class BoardDto {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Team is mandatory")
    private TeamDto team;

    private List<EpicDto> epics;

    private List<FeatureDto> features;

    private List<StoryDto> stories;

    private List<TaskDto> tasks;
}