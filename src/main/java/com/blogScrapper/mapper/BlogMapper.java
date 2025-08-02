package com.blogScrapper.mapper;

import com.blogScrapper.dto.BlogResponseDTO;
import com.blogScrapper.model.Blog;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlogMapper {

    public BlogResponseDTO toDTO(Blog b){
        return  new BlogResponseDTO(b.getId(),
                b.getHeadline(),
                b.getSummary(),b.getTheme() != null ? b.getTheme().getName() : null,b.getAudioUrl(),b.getCoverImage(),
                b.getCompany(),b.getCreatedAt(),b.getViews());
    }

    public List<BlogResponseDTO> toDTOList(List<Blog> blogs){
        return blogs.stream().map(this::toDTO).toList();
    }
}
