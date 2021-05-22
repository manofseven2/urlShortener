package com.example.urlshortener.repository;

import com.example.urlshortener.domain.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    Url findByOriginalUrl(String url);
    Url findByShortenedUrl(String url);
}
