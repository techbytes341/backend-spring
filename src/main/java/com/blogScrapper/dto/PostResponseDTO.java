package com.blogScrapper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDTO {
    private String title;
    private String author;
    private String content;
    private String company;
    private String coverImage;
    private LocalDateTime publishedAt;
}