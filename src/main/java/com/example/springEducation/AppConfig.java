package com.example.springEducation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.example") // Replace with your package name
@PropertySource("classpath:application.properties")
public class AppConfig {
}