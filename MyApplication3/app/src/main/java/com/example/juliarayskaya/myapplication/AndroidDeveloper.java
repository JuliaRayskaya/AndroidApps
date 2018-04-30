package com.example.juliarayskaya.myapplication;


public class AndroidDeveloper {

    private final String name;
    private final String image;
    private final boolean isLecturer;

    public AndroidDeveloper(String name, String image, boolean isLecturer) {
        this.name = name;
        this.image = image;
        this.isLecturer = isLecturer;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public boolean isLecturer() {
        return isLecturer;
    }
}
