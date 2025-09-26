package com.example.smartfit2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class LegsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    WorkoutAdapter adapter;
    ArrayList<Workout> legsWorkouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legs);

        recyclerView = findViewById(R.id.legsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        legsWorkouts = new ArrayList<>();
        legsWorkouts.add(new Workout("Squats", android.R.drawable.ic_menu_gallery));
        legsWorkouts.add(new Workout("Lunges", android.R.drawable.ic_menu_gallery));
        legsWorkouts.add(new Workout("Leg Press", android.R.drawable.ic_menu_gallery));
        legsWorkouts.add(new Workout("Calf Raises", android.R.drawable.ic_menu_gallery));

        adapter = new WorkoutAdapter(legsWorkouts);
        recyclerView.setAdapter(adapter);
    }
}
