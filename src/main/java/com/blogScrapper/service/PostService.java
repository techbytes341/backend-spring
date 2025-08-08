package com.blogScrapper.service;

import com.blogScrapper.dto.PostRequestDTO;
import com.blogScrapper.dto.PostResponseDTO;
import com.blogScrapper.utils.AppLogger;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class PostService {

    private final Logger logger = AppLogger.getLogger(PostService.class);

    @Autowired
    private WebClient webClient;

    public PostResponseDTO getPost(String url,String selector){

        PostRequestDTO requestDTO = new PostRequestDTO(url,selector);

        PostResponseDTO responseDTO =  webClient.post()
                .uri("/extract")
                .bodyValue(requestDTO)
                .retrieve()
                .bodyToMono(PostResponseDTO.class)
                .block(Duration.ofSeconds(10));

        logger.info("ResponseDTO for {} : {}",url,responseDTO);

        if (responseDTO == null || responseDTO.getTitle() == null) {
            logger.error("Invalid scraping response for URL: {}", url);
            throw new RuntimeException("Invalid scraping response for URL: "+ url);

        }else
            return responseDTO;

    }
}