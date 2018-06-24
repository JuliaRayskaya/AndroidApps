package com.example.juliarayskaya.myapplication;

public class FeedItem {
    private String image;
    private String header;
    private String text;


    public String getImage() {
        return image;
    }
    public String getHeader() {
        return header;
    }
    public String getText() { return text; }

    public void setImage(String image){this.image = image;}
    public void setHeader(String header){this.header = header;}
    public void setText(String text){this.text = text;}
}
