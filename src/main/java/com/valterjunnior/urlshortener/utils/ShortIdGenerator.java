package com.valterjunnior.urlshortener.utils;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import org.springframework.stereotype.Component;

@Component
public class ShortIdGenerator {
    public String generateRandomHash() {
        return generateRandomHash(5);
    }

    public String generateRandomHash(int length) {
        return NanoIdUtils.randomNanoId(NanoIdUtils.DEFAULT_NUMBER_GENERATOR, NanoIdUtils.DEFAULT_ALPHABET, length);
    }
}
