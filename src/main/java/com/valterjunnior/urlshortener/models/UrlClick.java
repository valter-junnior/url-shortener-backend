package com.valterjunnior.urlshortener.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "url_clicks")
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UrlClick {
    @Id
    private String id;
    private String urlId;
    private String ip;
    private LocalDateTime timestamp;
}

