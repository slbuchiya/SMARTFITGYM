package com.example.smartfit2; // તમારું પેકેજ નેમ

public class RegisterRequest {
    String username;
    String email;
    String password;
    int age;
    double height;
    double weight;

    // આ કન્સ્ટ્રક્ટર તમારી SignupActivity.java લાઇન 132 સાથે મેળ ખાય છે
    public RegisterRequest(String username, String email, String password, int age, double height, double weight) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
}