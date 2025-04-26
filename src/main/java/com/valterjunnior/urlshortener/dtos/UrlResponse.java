package com.valterjunnior.urlshortener.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UrlResponse {
    @JsonIgnore
    private final String baseUrl;
    private final String shortUrl;
    private final String originalUrl;

    public String getShortUrl() {
        return baseUrl + "/" + shortUrl;
    }
}