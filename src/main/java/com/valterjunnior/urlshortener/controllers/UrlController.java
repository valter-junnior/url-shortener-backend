package com.valterjunnior.urlshortener.controllers;

import com.valterjunnior.urlshortener.dtos.UrlCreateRequest;
import com.valterjunnior.urlshortener.dtos.UrlResponse;
import com.valterjunnior.urlshortener.services.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UrlController {
    private UrlService urlService;

    @PostMapping("/shorten")
    @ResponseStatus(HttpStatus.CREATED)
    public UrlResponse create(@RequestBody @Valid UrlCreateRequest urlCreateRequest) {
        return urlService.create(urlCreateRequest);
    }

    @GetMapping("/links")
    public List<UrlResponse> getLinks() {
        return urlService.all();
    }

    @GetMapping("/links/{shortUrl}")
    public ResponseEntity<Void> getByShortUrl(@PathVariable String shortUrl, HttpServletRequest request) {
        UrlResponse url = urlService.getByShortUrl(shortUrl, request.getRemoteAddr());

        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
                .header("Location", url.getOriginalUrl())
                .build();
    }

    @DeleteMapping("/links/{shortUrl}")
    public ResponseEntity<Void> delete(@PathVariable String shortUrl) {
        urlService.delete(shortUrl);


        return ResponseEntity.noContent().build();
    }
}
