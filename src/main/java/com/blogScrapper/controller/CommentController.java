package com.blogScrapper.controller;

import com.blogScrapper.dto.CommentResponseDTO;
import com.blogScrapper.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/blog/{blogId}")
    public ResponseEntity<List<CommentResponseDTO>> getComments(@PathVariable Long blogId){
        return ResponseEntity.ok(commentService.getComments(blogId));
    }
}
