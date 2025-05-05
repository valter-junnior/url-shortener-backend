package com.valterjunnior.urlshortener.services;

import com.valterjunnior.urlshortener.dtos.UrlCreateRequest;
import com.valterjunnior.urlshortener.dtos.UrlResponse;
import com.valterjunnior.urlshortener.exceptions.UrlNotFoundException;
import com.valterjunnior.urlshortener.models.Url;
import com.valterjunnior.urlshortener.models.UrlClick;
import com.valterjunnior.urlshortener.repostories.UrlClickRepository;
import com.valterjunnior.urlshortener.repostories.UrlRepository;
import com.valterjunnior.urlshortener.utils.ShortIdGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UrlService {
    private final UrlRepository urlRepository;
    private final UrlClickRepository urlClickRepository;
    private final ShortIdGenerator shortIdGenerator;

    public List<UrlResponse> all() {
        List<Url> urls = urlRepository.findAll();

        return urls.stream().map(url -> getUrlResponse(url, urlClickRepository.countByUrlId(url.getId()))).toList();
    }

    public UrlResponse create(UrlCreateRequest urlCreateRequest) {
        Url urlCreated = urlRepository.save(
            Url.builder()
                .shortUrl(shortIdGenerator.generateRandomHash())
                .originalUrl(urlCreateRequest.getUrl())
                .expirationDate(LocalDateTime.now().plusDays(1))
                .build()
        );

        return getUrlResponse(urlCreated, 0);
    }

    public UrlResponse getByShortUrl(String shortUrl, String ipAddress) {
        Url url = urlRepository.findByShortUrl(shortUrl).orElseThrow(() -> new UrlNotFoundException("URL not found for shortUrl: " + shortUrl));

        // Increment clicks
        urlClickRepository.save(
                UrlClick.builder()
                .urlId(url.getId())
                .ip(ipAddress)
                .timestamp(LocalDateTime.now())
                .build()
        );

        return getUrlResponse(url, 0);
    }

    private UrlResponse getUrlResponse(Url url, int clicks) {
        return new UrlResponse(url.getShortUrl(), url.getOriginalUrl(), clicks);
    }

    public void delete(String shortUrl) {
        urlClickRepository.deleteAll(urlClickRepository.findAllByUrlId(shortUrl));
        urlRepository.deleteByShortUrl(shortUrl);
    }
}
