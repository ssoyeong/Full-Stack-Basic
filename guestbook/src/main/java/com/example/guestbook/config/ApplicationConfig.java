package com.example.guestbook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.example.guestbook.dao", "com.example.guestbook.service"})
@Import({DBConfig.class})
public class ApplicationConfig {
}
