package com.example.urlshortener.service;

import com.example.urlshortener.domain.dto.UrlDto;
import com.example.urlshortener.domain.model.Url;
import com.example.urlshortener.repository.UrlRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class UrlServiceImplTest {

    @Autowired
    private UrlService urlService;
    @Autowired
    private UrlRepository urlRepository;
    @Test
    public void saveUrl() {
        String sampleUrl = "http://example.com/test/test2";
        UrlDto shortenedUrlDto = urlService.saveUrl(sampleUrl);
        assertNotNull(shortenedUrlDto);
        Url url = urlRepository.findByShortenedUrl(shortenedUrlDto.getUrl());
        assertNotNull(url);
        assertEquals(url.getOriginalUrl(), "http://example.com/test/test2");
    }

    @Test
    void retrieveOriginalUrl() {
        UrlDto url = urlService.retrieveOriginalUrl("test3");
        assertNotNull(url);
        assertEquals(url.getUrl(), "test/test/test");
    }

    @Test
    void retrieveOriginalUrlException() {
        try {
            urlService.retrieveOriginalUrl("o797543785438sjkjdhkjdfhgkjjfhdgkhdfgkjhdfkgjhdfkfjghdfkjt3");
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}