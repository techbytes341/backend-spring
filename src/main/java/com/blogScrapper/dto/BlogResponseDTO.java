package com.blogScrapper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class BlogResponseDTO {
    private Long id;
    private Long post;
    private String headline;
    private String summary;
    private String theme;
    private String audioUrl;
    private String coverImage;
    private String company;
    private LocalDateTime createdAt;
    private Long views;
}
