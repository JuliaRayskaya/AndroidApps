package com.example.juliarayskaya.myapplication;


public class NewsItem {

    private String image;
    private String header;
    private String text;
    private String content;


    public String getImage() {
        return image;
    }
    public String getHeader() {
        return header;
    }
    public String getText() { return text; }
    public String getContent() { return content; }

    public void setImage(String image){this.image = image;}
    public void setHeader(String header){this.header = header;}
    public void setText(String text){this.text = text;}
    public void setContent(String content){this.content = content;}
}
