package com.example.juliarayskaya.myapplication;


public class NewsItem {

    private final String image;
    private final String header;
    private final String text;

    public NewsItem(String image, String name, String text) {
        this.image = image;
        this.header = name;
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public String getHeader() {
        return header;
    }

    public String getText() { return text; }
}
