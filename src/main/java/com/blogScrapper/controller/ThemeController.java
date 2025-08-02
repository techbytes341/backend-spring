package com.blogScrapper.controller;

import com.blogScrapper.model.Theme;
import com.blogScrapper.repository.ThemeRepository;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ThemeController {

    public ThemeRepository themeRepository;

    public List<Theme> getAllThemes(){
        return themeRepository.findAll();
    }
}
