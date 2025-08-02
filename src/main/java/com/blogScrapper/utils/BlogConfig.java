package com.blogScrapper.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogConfig {
    private String name;
    private String homepageUrl;
    private String blogLinkSelector;
}
