package com.example.urlshortener.service;

import com.example.urlshortener.config.AppConfig;
import com.example.urlshortener.domain.dto.UrlDto;
import com.example.urlshortener.domain.model.Url;
import com.example.urlshortener.exception.BusinessException;
import com.example.urlshortener.exception.BusinessExceptionMessages;
import com.example.urlshortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UrlServiceImpl implements UrlService {
    @Autowired
    private UrlRepository urlRepository;
    @Autowired
    private AppConfig appConfig;

    /**
     * This method is used to shorten new URL and save it.
     *
     * @param originalUrl this parameter shows entered url that we would shorten
     * @return a dto that represents shortened url
     */
    @Override
    @Transactional
    public UrlDto saveUrl(String originalUrl) {
        String uri = getUniqueUrl();
        Url url = new Url();
        url.setShortenedUrl(appConfig.urlBaseAddress + uri);
        url.setOriginalUrl(originalUrl);
        urlRepository.save(url);
        return new UrlDto(url.getShortenedUrl());
    }

    /**
     * This method get shortened url and find appropriate original url from database
     * Method throws exption when can not find shortened url
     * @param shortenedUrl
     * @return UrlDto which contains original url
     */
    @Override
    public UrlDto retrieveOriginalUrl(String shortenedUrl) {
        Url url = urlRepository.findByShortenedUrl(shortenedUrl);
        if(url == null)
            throw new BusinessException(BusinessExceptionMessages.URL_NOT_FOUND);
        return new UrlDto(url.getOriginalUrl());
    }

    private String getUniqueUrl() {
        String str = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        Url url = urlRepository.findByOriginalUrl(appConfig.urlBaseAddress + str);
        if(url != null)
            return getUniqueUrl();
        return str;
    }
}
