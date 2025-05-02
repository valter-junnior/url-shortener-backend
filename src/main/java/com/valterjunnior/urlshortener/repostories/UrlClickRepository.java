package com.valterjunnior.urlshortener.repostories;

import com.valterjunnior.urlshortener.models.UrlClick;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UrlClickRepository extends MongoRepository<UrlClick, String> {
    int countByUrlId(String urlId);
    List<UrlClick> findAllByUrlId(String shortUrl);
}
