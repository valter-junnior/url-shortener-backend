package com.valterjunnior.urlshortener.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UrlResponse {
    private final String shortUrl;
    private final String originalUrl;
    private final int clicks;
}