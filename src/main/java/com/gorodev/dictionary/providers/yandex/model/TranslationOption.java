package com.gorodev.dictionary.providers.yandex.model;

import java.util.LinkedList;
import java.util.List;


public class TranslationOption {

    private String text;
    private String pos;
    private List<TranslationSyn> syn = new LinkedList<>();
    private List<Mean> mean = new LinkedList<>();
    private List<TranslationExample> ex = new LinkedList<>();

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

    public List<TranslationSyn> getSyn() {
        return syn;
    }

    public void setSyn(List<TranslationSyn> syn) {
        this.syn = syn;
    }

    public List<Mean> getMean() {
        return mean;
    }

    public void setMean(List<Mean> mean) {
        this.mean = mean;
    }

    public List<TranslationExample> getEx() {
        return ex;
    }

    public void setEx(List<TranslationExample> ex) {
        this.ex = ex;
    }
}