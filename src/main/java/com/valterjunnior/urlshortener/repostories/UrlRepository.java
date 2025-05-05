package com.valterjunnior.urlshortener.repostories;

import com.valterjunnior.urlshortener.models.Url;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface UrlRepository extends MongoRepository<Url, String> {
    Optional<Url> findByShortUrl(String shortUrl);
    void deleteByShortUrl(String shortUrl);
    void deleteByExpirationDateBefore(LocalDateTime expirationDate);
}
