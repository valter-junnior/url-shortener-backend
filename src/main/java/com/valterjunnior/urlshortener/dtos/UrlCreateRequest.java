package com.valterjunnior.urlshortener.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class UrlCreateRequest {
    @NotBlank(message = "A URL original não pode estar em branco.")
    @Pattern(regexp = "^(http|https)://.*", message = "A URL deve começar com 'http://' ou 'https://'.")
    private String url;
}
