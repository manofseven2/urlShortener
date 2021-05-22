package com.example.urlshortener.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("${config.properties.location:classpath:config.properties}")
public class AppConfig {
    @Value("${url.base.address}")
    public String urlBaseAddress;
}
