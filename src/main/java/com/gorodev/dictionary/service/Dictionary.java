package com.gorodev.dictionary.service;

import com.gorodev.dictionary.model.Translation;

import java.util.Optional;

public interface Dictionary {

    Optional<Translation> translate(String from, String to, String word);

}