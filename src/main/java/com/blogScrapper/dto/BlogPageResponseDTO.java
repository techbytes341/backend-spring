package com.blogScrapper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class BlogPageResponseDTO {
    private List<BlogResponseDTO> blogs;
    private Long totalCount;
}
