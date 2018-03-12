package com.gorodev.dictionary.providers.yandex.model;


public class TranslationSyn {

    private String text;
    private String pos;
    private String gen;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }
}