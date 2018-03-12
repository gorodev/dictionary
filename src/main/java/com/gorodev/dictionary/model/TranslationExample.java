package com.gorodev.dictionary.model;

public class TranslationExample {

    private String tr;
    private String text;

    public TranslationExample(String tr, String text) {
        this.tr = tr;
        this.text = text;
    }

    public String getTr() {
        return tr;
    }

    public void setTr(String tr) {
        this.tr = tr;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}