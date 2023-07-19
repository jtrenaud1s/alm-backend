package io.subspacedev.alm.dto;

import lombok.Data;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class FeatureDto {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String description;

    @NotNull(message = "Epic is mandatory")
    private EpicDto epic;

    private List<StoryDto> stories;
}