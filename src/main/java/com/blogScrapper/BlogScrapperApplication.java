package com.blogScrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BlogScrapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogScrapperApplication.class, args);
	}

}
