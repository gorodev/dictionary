package com.gorodev.dictionary.service;

import com.gorodev.dictionary.model.Translation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CachedDictionary implements Dictionary {

    private final Map<String, Translation> cache = new HashMap<>();
    private final Dictionary dictionary;

    public CachedDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public Optional<Translation> translate(String from, String to, String word) {
        return Optional.ofNullable(
                cache.computeIfAbsent(word, (k) -> dictionary
                        .translate(from, to, word)
                        .orElse(null))
        );
    }
}