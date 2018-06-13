package com.udacity.gradle.builditbigger.backend;

import com.example.supplyjokes.Joke;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyJoke {

    private String myData;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
}