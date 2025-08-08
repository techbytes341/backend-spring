package com.blogScrapper.scheduler;

import com.blogScrapper.dto.PostResponseDTO;
import com.blogScrapper.model.Blog;
import com.blogScrapper.model.Theme;
import com.blogScrapper.repository.BlogRepository;
import com.blogScrapper.service.PostService;
import com.blogScrapper.utils.AppLogger;
import com.blogScrapper.utils.BlogConfig;
import com.blogScrapper.utils.BlogSourceConfig;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;

@Component
public class PostScrapJob {

    @Autowired
    private PostService postService;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private BlogSourceConfig blogSourceConfig;
//    @Autowired
//    private ExecutorService scrapExecutor;

    private static final Logger logger = AppLogger.getLogger(PostScrapJob.class);

    @Scheduled(fixedRate = 20000,initialDelay = 5000)
    public void getPostAndSaveBlogs(){

        logger.info("\uD83D\uDD52 Scheduled scraping triggered on thread {}",Thread.currentThread().getName());

        List<BlogConfig> urlConfigList = blogSourceConfig.getConfigs();

//        urlConfigList.forEach(config -> {
//            scrapExecutor.submit(()->scrapAndSave(config));
//        });
                urlConfigList.forEach(this::scrapAndSave);

        logger.info("<---- All scraping tasks submitted ---->");
    }
    private  void scrapAndSave(BlogConfig config){

        String url = config.getHomepageUrl();
        String ran = "ABCDEFGHIJKLMNOPQRSTUV";
        try {
            logger.info("Scraping {} started on thread {}",url,Thread.currentThread().getName());

            PostResponseDTO responseDTO = postService.getPost(url,config.getBlogLinkSelector());

            String summary = null; //get summarized blog content through ai
            Theme theme = new Theme(ran.substring((int) (Math.random() * 10))); //get from AI;

            Blog blog = new Blog(
                    responseDTO.getTitle(),
                    summary,
                    responseDTO.getAuthor(),
                    theme,
                    responseDTO.getCompany(),
                    responseDTO.getPublishedAt(),
                    responseDTO.getCoverImage()
            );

            Blog savedBlog = blogRepository.save(blog);
            logger.info("Blog saved details : {}",blog);
            logger.info("✅ Scraping {} completed",url);

        } catch (Exception e) {
            logger.error("❌ Error scraping {}: {}",url,e.getMessage());
        }
    }
}
