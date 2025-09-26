package com.example.smartfit2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ArmsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    WorkoutAdapter adapter;
    ArrayList<Workout> armsWorkouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arms);

        recyclerView = findViewById(R.id.armsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        armsWorkouts = new ArrayList<>();
        armsWorkouts.add(new Workout("Bicep Curls", android.R.drawable.ic_menu_gallery));
        armsWorkouts.add(new Workout("Tricep Dips", android.R.drawable.ic_menu_gallery));
        armsWorkouts.add(new Workout("Hammer Curls", android.R.drawable.ic_menu_gallery));
        armsWorkouts.add(new Workout("Overhead Tricep Extension", android.R.drawable.ic_menu_gallery));

        adapter = new WorkoutAdapter(armsWorkouts);
        recyclerView.setAdapter(adapter);
    }
}
