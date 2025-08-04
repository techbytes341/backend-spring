package com.blogScrapper.service;

import com.blogScrapper.dto.CommentResponseDTO;
import com.blogScrapper.model.Comment;
import com.blogScrapper.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    public List<CommentResponseDTO> getComments(Long blogId){
        List<Comment> comments = commentRepository.findByBlogId(blogId);
        return toDTO(comments);
    }

    private List<CommentResponseDTO> toDTO(List<Comment> comments){
        return comments.stream().map(comment -> new CommentResponseDTO(
                comment.getMessage(),comment.getUser().getUsername(),comment.getUser().getProfileImage(),comment.getCreatedAt()
        )).toList();
    }
}
