package com.attentionhub.worder;

public class Word {

    private String title;
    private int value;

    public Word() {
    }

    public Word(String title, int value){
        this.title = title;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
