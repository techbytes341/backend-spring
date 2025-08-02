package com.blogScrapper.repository;

import com.blogScrapper.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<Theme,Long> {
}
