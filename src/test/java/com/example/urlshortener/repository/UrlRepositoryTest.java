package com.example.urlshortener.repository;

import com.example.urlshortener.domain.model.Url;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UrlRepositoryTest {
    @Autowired
    private UrlRepository urlRepository;

    @Test
    public void autowireTest(){
        assertNotNull(urlRepository);
    }

    @Test
    public void inserttest(){
        Url url = new Url();
        String original = "test/test/" + UUID.randomUUID().toString();
        url.setOriginalUrl(original);
        String shorten = "test/" + UUID.randomUUID().toString();
        url.setShortenedUrl(shorten);
        urlRepository.save(url);
        Url savedUrl = urlRepository.findByOriginalUrl(original);
        assertNotNull(savedUrl);
        System.out.println(savedUrl);
    }

    @Test
    public void findByOriginalUrlEmpty(){
        Url url = urlRepository.findByOriginalUrl("mhgjvhgsjhvgjfdh");
        assertNull(url);
    }

    @Test
    public void findByOriginalUrlNotEmpty(){
        assertNotNull(urlRepository.findByOriginalUrl("test/test/test"));
    }

    @Test
    public void findByShortenedUrlNotEmpty(){
        assertNotNull(urlRepository.findByShortenedUrl("test3"));
    }

    @Test
    public void findByShortenedUrlEmpty(){
        assertNull(urlRepository.findByShortenedUrl("test3jhdvkjhdfkjvhfdkjvhdfkjhvdkj"));
    }
}