package com.example.juliarayskaya.myapplication;

public class User {
    private String first;
    private String second;
    private String third;

    public User(String fWord, String sWord, String tWord) {
        first = fWord;
        second = sWord;
        third = tWord;
    }
        public String getFirst () {
            return first;
        }

        public String getSecond () {
            return second;
        }

        public String getThird () {
            return third;
        }

}
