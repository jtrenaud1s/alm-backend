package io.subspacedev.alm.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class TaskDto {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String description;

    @NotNull(message = "Story is mandatory")
    private StoryDto story;

    private int estimatedHours;

    private int toDoHours;

    private int actualHours;
}