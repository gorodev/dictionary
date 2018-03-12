package com.gorodev.dictionary.providers.yandex.model;


import java.util.LinkedList;
import java.util.List;

public class TranslationAllDefinitions {

    private Object head;
    private List<TranslationDefinition> def = new LinkedList<>();

    public Object getHead() {
        return head;
    }

    public void setHead(Object head) {
        this.head = head;
    }

    public List<TranslationDefinition> getDef() {
        return def;
    }

    public void setDef(List<TranslationDefinition> def) {
        this.def = def;
    }
}