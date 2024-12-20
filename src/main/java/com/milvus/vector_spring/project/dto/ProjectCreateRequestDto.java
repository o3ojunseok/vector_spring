package com.milvus.vector_spring.project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProjectCreateRequestDto {
    @NotNull(message = "필수 입력")
    @NotBlank
    private String name;

    private String openAiKey;

    @NotNull
    private Long createdUserId;
}
