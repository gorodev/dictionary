package com.gorodev.dictionary.providers.yandex.model;


import java.util.LinkedList;
import java.util.List;

public class TranslationExample {

    private String text;
    private List<TranslationOption> tr = new LinkedList<>();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<TranslationOption> getTr() {
        return tr;
    }

    public void setTr(List<TranslationOption> tr) {
        this.tr = tr;
    }
}
