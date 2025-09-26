package com.example.smartfit2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class BackActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    WorkoutAdapter adapter;
    ArrayList<Workout> backWorkouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);

        recyclerView = findViewById(R.id.backRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        backWorkouts = new ArrayList<>();
        backWorkouts.add(new Workout("Pull Ups", android.R.drawable.ic_menu_gallery));
        backWorkouts.add(new Workout("Lat Pulldown", android.R.drawable.ic_menu_gallery));
        backWorkouts.add(new Workout("Deadlifts", android.R.drawable.ic_menu_gallery));
        backWorkouts.add(new Workout("Seated Rows", android.R.drawable.ic_menu_gallery));

        adapter = new WorkoutAdapter(backWorkouts);
        recyclerView.setAdapter(adapter);
    }
}
