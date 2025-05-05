package com.valterjunnior.urlshortener.services;

import com.valterjunnior.urlshortener.repostories.UrlRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@EnableScheduling
@Service
@AllArgsConstructor
public class CleanupService {
    private UrlRepository urlRepository;

    @Scheduled(cron = "0 0 0 * * *")
    public void removeExpiredUrls() {
        urlRepository.deleteByExpirationDateBefore(LocalDateTime.now());
    }
}
