package com.hellouniverse.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hellouniverse.demo.handler.DemoHandler;

@Configuration
public class HelloUniverseConfig {
    @Bean
    public DemoHandler provideDemoHandler() {
        return new DemoHandler();
    }
}
