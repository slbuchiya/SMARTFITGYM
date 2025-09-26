package com.example.smartfit2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SignupActivity extends AppCompatActivity {

    private TextView tvLogin;
    private Button btnSignup;
    private Spinner spinnerGoals; // Spinner ka variable declare karein

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // XML elements ko unki ID se jodna
        tvLogin = findViewById(R.id.tvLogin);
        btnSignup = findViewById(R.id.btnSignup);
        spinnerGoals = findViewById(R.id.spinnerGoals); // Spinner ko uski ID se find karein

        // Spinner ke liye data (goals) taiyaar karna
        List<String> goals = new ArrayList<>();
        goals.add("Select Your Goal"); // Default item
        goals.add("Weight Loss");
        goals.add("Muscle Gain");
        goals.add("Stay Fit");

        // ArrayAdapter banakar data ko spinner se jodein
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item, // Default spinner layout
                goals
        );

        // Dropdown menu ke liye layout set karna
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Adapter ko spinner par set karna
        spinnerGoals.setAdapter(adapter);

        // 'Login' TextView par click listener lagana
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 'Sign Up' Button par click listener lagana
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aap yahan par Spinner ki value ko bhi access kar sakte hain:
                String selectedGoal = spinnerGoals.getSelectedItem().toString();
                // Ab MainActivity par jaana hai
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}