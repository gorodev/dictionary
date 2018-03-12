package com.gorodev.dictionary.model;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Translation {

    public Translation(List<TranslationOption> options) {
        this.options = options;
    }

    private List<TranslationOption> options = new ArrayList<>();

    public List<TranslationOption> getOptions() {
        return options;
    }

    public String toMarkdown() {

        long orderNumber = 1;
        for (TranslationOption trOpt : options) {
            trOpt.setId(orderNumber++);
        }

        return options.stream()
                .map(option -> {
                    String shortInfo = option.getTx() + " *[" + option.getTs() + "]* " + option.getTr();
                    String examples = option.getExamples().stream()
                            .map(ex -> "> _" + ex.getText() + " - " + ex.getTr() + "_").
                                    collect(Collectors.joining("\n"));
                    String partOfSpeech = option.getPartOfSpeech();
                    String synonyms = option.getSynonyms();
                    return ":white_check_mark: " + option.getId() + ". " + shortInfo
                            + " (`" + partOfSpeech + "`)\n"
                            + (StringUtils.isEmpty(examples) ? "" : "\n" + examples)
                            + ((!StringUtils.isEmpty(examples) && !StringUtils.isEmpty(synonyms)) ? "\n\n" : "")
                            + (StringUtils.isEmpty(synonyms) ? "" : "synonyms: " + synonyms);
                })
                .collect(Collectors.joining("\n\n"));
    }
}