package com.gorodev.dictionary.providers.yandex;


import com.gorodev.dictionary.model.Translation;
import com.gorodev.dictionary.model.TranslationExample;
import com.gorodev.dictionary.model.TranslationOption;
import com.gorodev.dictionary.service.Dictionary;
import com.gorodev.dictionary.providers.yandex.model.TranslationAllDefinitions;
import com.gorodev.dictionary.providers.yandex.model.TranslationDefinition;
import com.gorodev.dictionary.providers.yandex.model.TranslationSyn;
import com.gorodev.dictionary.util.HttpUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class YandexDictionary implements Dictionary {

    private final static String DICTIONARY_API_ENDPOINT =
            "https://dictionary.yandex.net/api/v1/dicservice.json/";

    private final String yandexDictionaryToken;

    public YandexDictionary(String yandexDictionaryToken) {
        this.yandexDictionaryToken = yandexDictionaryToken;
    }

    @Override
    public Optional<Translation> translate(String from,
                                           String to,
                                           String word) {
        List<TranslationDefinition> definitions = HttpUtils
                .getObject(getDictionaryUrl(from, to, word), TranslationAllDefinitions.class)
                .getDef();

        return definitions.isEmpty()
                ? Optional.empty()
                : Optional.of(toDictionaryItem(definitions));
    }

    //////////////////////////////////
    //           private            //
    //////////////////////////////////

    private Translation toDictionaryItem(final List<TranslationDefinition> definitions) {
        return new Translation(definitions.stream()
                .map(yaDefinition -> yaDefinition.getTr().stream()
                        .map(yaTrOpt -> {
                            TranslationOption trOpt = new TranslationOption();
                            trOpt.setTx(yaDefinition.getText());
                            trOpt.setTs(yaDefinition.getTs());
                            trOpt.setTr(yaTrOpt.getText());
                            trOpt.setPartOfSpeech(yaDefinition.getPos());
                            trOpt.setSynonyms(yaTrOpt.getSyn().stream()
                                    .map(TranslationSyn::getText)
                                    .collect(Collectors.joining(", ")));
                            trOpt.setExamples(yaTrOpt.getEx().stream()
                                    .map(translationExample ->
                                            new TranslationExample(
                                                    translationExample.getTr().get(0).getText(),
                                                    translationExample.getText()))
                                    .collect(Collectors.toList()));
                            return trOpt;
                        }).collect(Collectors.toList())
                ).collect(Collectors.toList()).stream()
                .flatMap(List::stream)
                .collect(Collectors.toList()));
    }

    private String getDictionaryUrl(String from, String to, String word) {
        String langParam = (from + "-" + to).toLowerCase();
        return DICTIONARY_API_ENDPOINT
                + "lookup?lang=" + langParam
                + "&key=" + yandexDictionaryToken
                + "&text=" + word
                + "&flags=4";
    }

}