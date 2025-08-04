package com.blogScrapper.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@AllArgsConstructor
@Component
@NoArgsConstructor
@Data
public class CommentResponseDTO {
    private String message;
    private String userName;
    private String profileImage;
    private LocalDateTime createdAt;
}
