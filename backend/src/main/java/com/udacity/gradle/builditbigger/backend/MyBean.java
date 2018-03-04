package com.udacity.gradle.builditbigger.backend;

import com.example.supplyjokes.Joke;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private Joke myData;

    public MyBean()  {
        myData = new Joke();
    }

    public String getData() {
        return myData.getJoke();
    }
}