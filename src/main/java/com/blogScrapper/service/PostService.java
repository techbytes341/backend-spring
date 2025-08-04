package com.blogScrapper.service;

import com.blogScrapper.dto.PostRequestDTO;
import com.blogScrapper.dto.PostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class PostService {

    @Autowired
    private WebClient webClient;

    public PostResponseDTO getPost(String url,String selector){
        PostRequestDTO requestDTO = new PostRequestDTO(url,selector);

        return webClient.post()
                .uri("/extract")
                .bodyValue(requestDTO)
                .retrieve()
                .bodyToMono(PostResponseDTO.class)
                .block(Duration.ofSeconds(10));
    }
}