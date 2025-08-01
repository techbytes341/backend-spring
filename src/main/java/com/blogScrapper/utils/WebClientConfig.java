package com.blogScrapper.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("SCRAP_SERVICE_URL")
    private  String BASE_URL;

    public WebClient webClient(WebClient.Builder builder){
        return builder
                .baseUrl(BASE_URL)
                .build();
    }
}