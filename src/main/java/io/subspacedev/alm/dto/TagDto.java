package io.subspacedev.alm.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TagDto {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;
}