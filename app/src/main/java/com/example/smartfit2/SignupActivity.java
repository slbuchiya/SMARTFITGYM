package com.example.smartfit2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartfit2.api.ApiService;
import com.example.smartfit2.api.RetrofitClient;
import com.example.smartfit2.model.User;
import com.example.smartfit2.model.UserResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    private TextView tvLogin;
    private Button btnSignup;
    private Spinner spinnerGoals;
    private EditText etName, etEmail, etPassword, etAge, etHeight, etWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        tvLogin = findViewById(R.id.tvLogin);
        btnSignup = findViewById(R.id.btnSignup);
        spinnerGoals = findViewById(R.id.spinnerGoals);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etAge = findViewById(R.id.etAge);
        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);

        List<String> goals = new ArrayList<>();
        goals.add("Select Your Goal");
        goals.add("Weight Loss");
        goals.add("Muscle Gain");
        goals.add("Stay Fit");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                goals
        ) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ((TextView) view).setTextColor(Color.WHITE);
                return view;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                ((TextView) view).setTextColor(Color.WHITE);
                return view;
            }
        };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGoals.setAdapter(adapter);

        tvLogin.setOnClickListener(v -> {
            startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            finish();
        });

        btnSignup.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String ageStr = etAge.getText().toString().trim();
            String heightStr = etHeight.getText().toString().trim();
            String weightStr = etWeight.getText().toString().trim();
            String goal = spinnerGoals.getSelectedItem().toString();

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() ||
                    ageStr.isEmpty() || heightStr.isEmpty() || weightStr.isEmpty() ||
                    goal.equals("Select Your Goal")) {
                Toast.makeText(SignupActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            int age = Integer.parseInt(ageStr);
            int height = Integer.parseInt(heightStr);
            int weight = Integer.parseInt(weightStr);

            performSignup(name, email, password, age, height, weight, goal);
        });
    }

    private void performSignup(String name, String email, String password, int age, int height, int weight, String goal) {
        ApiService apiService = RetrofitClient.getClient()
                .create(ApiService.class);

        User user = new User(name, email, password, age, height, weight, goal);
        Call<UserResponse> call = apiService.signupUser(user);

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(SignupActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    if (response.body().isSuccess()) {
                        startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                        finish();
                    }
                } else {
                    Toast.makeText(SignupActivity.this, "Signup failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(SignupActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
