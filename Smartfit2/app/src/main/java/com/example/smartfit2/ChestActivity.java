package com.example.smartfit2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ChestActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    WorkoutAdapter adapter;
    ArrayList<Workout> chestWorkouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);

        recyclerView = findViewById(R.id.chestRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Dummy dataset for Chest
        chestWorkouts = new ArrayList<>();
        chestWorkouts.add(new Workout("Push Ups", android.R.drawable.ic_menu_gallery));
        chestWorkouts.add(new Workout("Bench Press", android.R.drawable.ic_menu_gallery));
        chestWorkouts.add(new Workout("Dumbbell Fly", android.R.drawable.ic_menu_gallery));
        chestWorkouts.add(new Workout("Incline Press", android.R.drawable.ic_menu_gallery));

        adapter = new WorkoutAdapter(chestWorkouts);
        recyclerView.setAdapter(adapter);
    }
}
