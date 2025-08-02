package com.blogScrapper.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "blog")
@Data
public class BlogSourceConfig {
    private List<BlogConfig> configs;

    public List<BlogConfig> getConfigs() {
        return configs;
    }

    public void setConfigs(List<BlogConfig> configs) {
        this.configs = configs;
    }
}