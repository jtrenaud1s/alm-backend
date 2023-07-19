package io.subspacedev.alm.dto;

import lombok.Data;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class StoryDto {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String description;

    @NotNull(message = "Feature is mandatory")
    private FeatureDto feature;

    private List<TaskDto> tasks;
}