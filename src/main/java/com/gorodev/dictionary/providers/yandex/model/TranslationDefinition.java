package com.gorodev.dictionary.providers.yandex.model;

import java.util.LinkedList;
import java.util.List;


public class TranslationDefinition {

    private String text;
    private String pos;
    private String ts;
    private List<TranslationOption> tr = new LinkedList<>();

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

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public List<TranslationOption> getTr() {
        return tr;
    }

    public void setTr(List<TranslationOption> tr) {
        this.tr = tr;
    }
}