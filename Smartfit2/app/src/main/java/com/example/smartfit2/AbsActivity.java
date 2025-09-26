package com.example.smartfit2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AbsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    WorkoutAdapter adapter;
    ArrayList<Workout> absWorkouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs);

        recyclerView = findViewById(R.id.absRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Dummy dataset for Abs
        absWorkouts = new ArrayList<>();
        absWorkouts.add(new Workout("Crunches", android.R.drawable.ic_menu_gallery));
        absWorkouts.add(new Workout("Leg Raises", android.R.drawable.ic_menu_gallery));
        absWorkouts.add(new Workout("Plank", android.R.drawable.ic_menu_gallery));
        absWorkouts.add(new Workout("Bicycle Crunch", android.R.drawable.ic_menu_gallery));
        absWorkouts.add(new Workout("Russian Twist", android.R.drawable.ic_menu_gallery));

        adapter = new WorkoutAdapter(absWorkouts);
        recyclerView.setAdapter(adapter);
    }
}
