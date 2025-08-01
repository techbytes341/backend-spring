package com.blogScrapper.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Table(name = "blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String headline;
    private String summary;
    private String author;
    private String theme;
    private String audioUrl;
    private String coverImage;
    private String company;
    private LocalDateTime publishedAt;
    private LocalDateTime createdAt = LocalDateTime.now();
    private Long views =0L;

    public Blog() {
    }

    public Blog(String headline, String summary, String author, String theme, String company, LocalDateTime publishedAt, String coverImage) {
        this.headline = headline;
        this.summary = summary;
        this.author = author;
        this.theme = theme;
        this.company = company;
        this.publishedAt = publishedAt;
        this.coverImage = coverImage;
    }
}
