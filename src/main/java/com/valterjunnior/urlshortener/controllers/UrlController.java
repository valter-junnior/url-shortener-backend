package com.valterjunnior.urlshortener.controllers;

import com.valterjunnior.urlshortener.dtos.UrlCreateRequest;
import com.valterjunnior.urlshortener.dtos.UrlResponse;
import com.valterjunnior.urlshortener.services.UrlService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/urls")
@AllArgsConstructor
public class UrlController {
    private UrlService urlService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UrlResponse create(@RequestBody @Valid UrlCreateRequest urlCreateRequest) {
        return urlService.create(urlCreateRequest);
    }

    @GetMapping("/{shortUrl}")
    public UrlResponse getByShortUrl(@PathVariable String shortUrl) {
        return urlService.getByShortUrl(shortUrl);
    }
}
