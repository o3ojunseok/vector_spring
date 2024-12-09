package com.milvus.vector_spring.project.dto;

import com.milvus.vector_spring.content.dto.ContentResponseDto;
import com.milvus.vector_spring.project.Project;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public class ProjectContentsResponseDto {
    private Long id;
    private String name;
    private String key;
    private String openAiKey;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<ContentResponseDto> contents;

    public static ProjectContentsResponseDto projectContentsResponseDto(Project project) {
        List<ContentResponseDto> contentList = project.getContents().stream()
                .map(ContentResponseDto::contentResponseDto)
                .toList();
        return ProjectContentsResponseDto.builder()
                .id(project.getId())
                .name(project.getName())
                .key(project.getKey())
                .openAiKey(project.getOpenAiKey())
                .createdAt(project.getCreatedAt())
                .updatedAt(project.getUpdatedAt())
                .contents(contentList)
                .build();
    }
}
