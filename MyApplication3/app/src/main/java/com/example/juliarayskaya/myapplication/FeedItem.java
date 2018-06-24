package com.example.juliarayskaya.myapplication;

public class FeedItem {
    private String name;
    private String image;
    private boolean checkboxMarked;

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCheckBoxMarked(boolean checkboxMarked) {
        this.checkboxMarked = checkboxMarked;
    }

    public FeedItem(boolean checkboxMarked, String name, String image) {
        this.checkboxMarked = checkboxMarked;
        this.name = name;
        this.image = image;
    }

    public boolean checkBoxMarked() { return checkboxMarked;}
    public String getImage() { return image; }
    public String getName() { return name; }

}
