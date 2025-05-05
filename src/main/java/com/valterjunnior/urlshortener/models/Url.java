package com.valterjunnior.urlshortener.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "urls")
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Url {
    @Id
    private String id;

    @Indexed(unique = true)
    private String shortUrl;

    @Indexed(unique = true)
    private String originalUrl;

    private LocalDateTime expirationDate;
}

