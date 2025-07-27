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

    @OneToOne
    @JoinColumn(name = "post_id")
    private Post post;

    private String headline;
    private String summary;
    private String theme;
    private String audioUrl;
    private String coverImage;
    private String company;

    private LocalDateTime createdAt = LocalDateTime.now();

    private Long views =0L;
}
