package com.example.urlshortener.controller;

import com.example.urlshortener.domain.dto.UrlDto;
import com.example.urlshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlController {

    @Autowired
    private UrlService service;

    /**
     * This method is regarding to save new url with generated shortened url
     * @param urlDto containd original url
     * @return dto contains new calculated shortened url
     */
    @PostMapping("resources/urls")
    public ResponseEntity<UrlDto> saveNewUrl(@RequestBody UrlDto urlDto){
        return new ResponseEntity<>(service.saveUrl(urlDto.getUrl()), HttpStatus.OK);
    }

    /**
     * This method is regarding to retrieve original url from shortened url
     * @param url is shortened url
     * @return dto contains original url
     */
    @GetMapping("resources/urls")
    public ResponseEntity<UrlDto> getOriginalUrl(@RequestParam String url){
        return new ResponseEntity<>(service.retrieveOriginalUrl(url), HttpStatus.OK);
    }
}
