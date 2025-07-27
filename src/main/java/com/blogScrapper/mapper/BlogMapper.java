package com.blogScrapper.mapper;

import com.blogScrapper.dto.BlogResponseDTO;
import com.blogScrapper.model.Blog;

import java.util.List;

public class BlogMapper {

    public BlogResponseDTO toDTO(Blog b){
        return  new BlogResponseDTO(b.getId(),
                b.getPost()!=null?b.getPost().getId():null,b.getHeadline(),
                b.getSummary(),b.getTheme(),b.getAudioUrl(),b.getCoverImage(),
                b.getCompany(),b.getCreatedAt(),b.getViews());
    }

    public List<BlogResponseDTO> toDTOList(List<Blog> blogs){
        return blogs.stream().map(this::toDTO).toList();
    }
}
