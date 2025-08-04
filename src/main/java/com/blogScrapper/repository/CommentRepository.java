package com.blogScrapper.repository;

import com.blogScrapper.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByBlogId(Long BlogId);
}
