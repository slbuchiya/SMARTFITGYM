package com.example.smartfit2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WorkoutsFragment extends Fragment {

    RecyclerView recyclerView;
    WorkoutAdapter adapter;
    List<Workout> workoutList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workouts, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewWorkouts);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        workoutList = new ArrayList<>();
        workoutList.add(new Workout("Chest", R.drawable.chest));
        workoutList.add(new Workout("Abs", R.drawable.abs));
        workoutList.add(new Workout("Legs", R.drawable.legs));
        workoutList.add(new Workout("Arms", R.drawable.arms));
        workoutList.add(new Workout("Back", R.drawable.back));

        adapter = new WorkoutAdapter(workoutList);
        recyclerView.setAdapter(adapter);

        // 🔹 Click Listener for RecyclerView items
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        String workoutName = workoutList.get(position).getName();

                        if(workoutName.equals("Chest")){
                            Intent intent = new Intent(getContext(), ChestActivity.class);
                            startActivity(intent);
                        }
                        else if(workoutName.equals("Abs")){ // ✅ Abs click condition
                            Intent intent = new Intent(getContext(), AbsActivity.class);
                            startActivity(intent);
                        }
                        else if(workoutName.equals("Legs")){ // ✅ Legs click condition
                            Intent intent = new Intent(getContext(), LegsActivity.class);
                            startActivity(intent);
                        }
                        else if(workoutName.equals("Arms")){ // ✅ Legs click condition
                            Intent intent = new Intent(getContext(), ArmsActivity.class);
                            startActivity(intent);
                        }
                        else if(workoutName.equals("Back")){ // ✅ Legs click condition
                            Intent intent = new Intent(getContext(),BackActivity.class);
                            startActivity(intent);
                        }
                        // baaki categories ke liye aise hi add kar sakte ho
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // Optional: Long click action
                    }
                })
        );

        return view;
    }
}
