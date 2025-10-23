package com.example.smartfit2.model;

public class User {
    private String name;
    private String email;
    private String password;
    private int age;
    private int height;
    private int weight;
    private String goal;

    public User(String name, String email, String password, int age, int height, int weight, String goal) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.goal = goal;
    }

    // Getters and setters if needed
}
