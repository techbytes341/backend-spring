package com.blogScrapper.controller;

import com.blogScrapper.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    private Util utils;

    @Value("ENVIRONMENT")
    private String environment;

    @GetMapping("/")
    public ResponseEntity<?> healthCheck(){
        Map<String,Object> map = new HashMap<>();
        map.put("status","UP");
        map.put("timestamp", Instant.now().toString());
        map.put("version", "v1.0.0");
        map.put("uptime", utils.getUptime());
        map.put("environment", environment);
        return ResponseEntity.ok(map);
    }

}
