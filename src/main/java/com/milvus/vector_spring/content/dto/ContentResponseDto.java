package com.milvus.vector_spring.content.dto;

import com.milvus.vector_spring.content.Content;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ContentResponseDto {
    private final Long id;
    private final String title;
    private final String answer;
    private final Long createdUser;
    private final Long updatedUser;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public static ContentResponseDto of (Content content) {
        return new ContentResponseDto(
                content.getId(),
                content.getTitle(),
                content.getAnswer(),
                content.getCreatedBy().getId(),
                content.getUpdatedBy().getId(),
                content.getCreatedAt(),
                content.getUpdatedAt()
        );
    }
}
