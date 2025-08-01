package com.blogScrapper.scheduler;

import com.blogScrapper.dto.PostResponseDTO;
import com.blogScrapper.model.Blog;
import com.blogScrapper.repository.BlogRepository;
import com.blogScrapper.service.PostService;
import com.blogScrapper.utils.BlogSourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostScrapJob {

    @Autowired
    private PostService postService;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private BlogSourceConfig blogSourceConfig;


    @Scheduled(cron = "0 0 * * * *")
    public void getPostAndSaveBlogs(){
        List<String> urlList = blogSourceConfig.getSources();
        for(String url:urlList){
            try{
                PostResponseDTO responseDTO = postService.getPost(url);
                String summary = null;//get summarized blog content through ai
                String theme = null;//get from AI;
                Blog blog = new Blog(
                        responseDTO.getTitle(),
                        summary,
                        responseDTO.getAuthor(),
                        theme, responseDTO.getCompany(), responseDTO.getPublishedAt(), responseDTO.getCoverImage()
                );
                blogRepository.save(blog);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
