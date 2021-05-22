package com.example.urlshortener.service;

import com.example.urlshortener.domain.dto.UrlDto;

public interface UrlService {
    UrlDto saveUrl(String url);

    UrlDto retrieveOriginalUrl(String shortenedUrl);
}
