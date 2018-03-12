package com.gorodev.dictionary.model;

import java.util.List;

public class TranslationOption {

    private Long id;
    private String tx;
    private String ts;
    private String tr;
    private String synonyms;
    private String partOfSpeech;
    private List<TranslationExample> examples;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTx() {
        return tx;
    }

    public void setTx(String tx) {
        this.tx = tx;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getTr() {
        return tr;
    }

    public void setTr(String tr) {
        this.tr = tr;
    }

    public String getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(String synonyms) {
        this.synonyms = synonyms;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public List<TranslationExample> getExamples() {
        return examples;
    }

    public void setExamples(List<TranslationExample> examples) {
        this.examples = examples;
    }

    @Override
    public String toString() {
        return String.format("%s - [%s] - %s", tx, ts, tr);
    }
}