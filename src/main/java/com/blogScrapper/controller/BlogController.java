package com.blogScrapper.controller;

import com.blogScrapper.dto.BlogPageResponseDTO;
import com.blogScrapper.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blog")
@AllArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping
    public ResponseEntity<BlogPageResponseDTO> getBlogs(@RequestParam(required = false) String company,
                                                        @RequestParam(required = false) String theme,
                                                        @RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "5") int limit){
        return ResponseEntity.ok(blogService.getFilteredBlogs(company,theme,page,limit));
    }
}
