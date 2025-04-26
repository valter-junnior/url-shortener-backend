package com.valterjunnior.urlshortener.repostories;

import com.valterjunnior.urlshortener.models.Url;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<Url, String> {

}
