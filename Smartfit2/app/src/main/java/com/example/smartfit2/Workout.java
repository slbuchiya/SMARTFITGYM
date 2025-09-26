package com.example.smartfit2;

public class Workout {
    private String name;
    private int imageRes;

    // Constructor with only name and image
    public Workout(String name, int imageRes) {
        this.name = name;
        this.imageRes = imageRes;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getImageRes() {
        return imageRes;
    }
}
