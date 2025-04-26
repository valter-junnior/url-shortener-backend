package com.valterjunnior.urlshortener.services;

import com.valterjunnior.urlshortener.dtos.UrlCreateRequest;
import com.valterjunnior.urlshortener.dtos.UrlResponse;
import com.valterjunnior.urlshortener.exceptions.UrlNotFoundException;
import com.valterjunnior.urlshortener.models.Url;
import com.valterjunnior.urlshortener.repostories.UrlRepository;
import com.valterjunnior.urlshortener.utils.ShortIdGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UrlService {
    private final UrlRepository urlRepository;
    private final ShortIdGenerator shortIdGenerator;

    public UrlResponse create(UrlCreateRequest urlCreateRequest) {
        Url urlCreated = urlRepository.save(
            new Url(shortIdGenerator.generateRandomHash(), urlCreateRequest.getUrl())
        );

        return getUrlResponse( urlCreated );
    }

    public UrlResponse getByShortUrl(String shortUrl) {
        Optional<Url> urlOptional = urlRepository.findById(shortUrl);

        if (urlOptional.isPresent()) {
            return getUrlResponse( urlOptional.get() );
        } else {
            throw new UrlNotFoundException("URL not found for shortUrl: " + shortUrl);
        }
    }

    public UrlResponse getUrlResponse(Url url) {
        return new UrlResponse(url.getShortUrl(), url.getOriginalUrl());
    }
}
