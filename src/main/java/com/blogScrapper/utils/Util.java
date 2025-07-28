package com.blogScrapper.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;


@Component
public class Util {
    public String getUptime() {
        long uptimeMillis = ManagementFactory.getRuntimeMXBean().getUptime();
        long seconds = uptimeMillis / 1000 % 60;
        long minutes = uptimeMillis / (1000 * 60) % 60;
        long hours = uptimeMillis / (1000 * 60 * 60);
        return String.format("%d hrs %d mins %d secs", hours, minutes, seconds);
    }
}
