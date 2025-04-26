package com.valterjunnior.urlshortener.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "urls")
@AllArgsConstructor
@Getter
public class Url {
    @Id
    private String shortUrl;

    @Indexed(unique = true)
    private String originalUrl;
}

