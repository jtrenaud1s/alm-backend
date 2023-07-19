package io.subspacedev.alm.dto;

import lombok.Data;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class EpicDto {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String description;

    @NotNull(message = "Team board is mandatory")
    private BoardDto teamBoard;

    private List<FeatureDto> features;
}