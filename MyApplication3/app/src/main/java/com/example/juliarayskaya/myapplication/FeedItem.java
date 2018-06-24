package com.example.juliarayskaya.myapplication;

public class FeedItem {
    private final boolean checkboxMarked;
    private String name;
    private String image;

    public FeedItem(boolean checkboxMarked, String name, String image) {
        this.checkboxMarked = checkboxMarked;
        this.name = name;
        this.image = image;
    }

    public boolean checkboxMarked() { return checkboxMarked;}
    public String getImage() { return image; }
    public String getName() { return name; }

}
