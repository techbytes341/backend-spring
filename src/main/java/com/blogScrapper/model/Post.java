package com.blogScrapper.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;

    private String headline;

    private String content;

    @ElementCollection
    private List<String> images;

    private String author;

    private String coverImage;

    private LocalDateTime publishedAt;

    private LocalDateTime createdAt =LocalDateTime.now();

}
