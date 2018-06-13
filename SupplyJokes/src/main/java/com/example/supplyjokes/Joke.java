package com.example.supplyjokes;

import java.util.Random;

public class Joke {
    public String getNewJoke() {
        String[] jokes = {
                "Q. What is the biggest lie in the entire universe?\n" +
                        "A. I have read and agree to the Terms & Conditions.",

                "Algorthm(noun)\n" + "Word used by programmers when ... \n"+
                        "they dont want to explain what they did"};
        Random random = new Random();
        int rand = random.nextInt(jokes.length);
        return jokes[rand];
    }
}
