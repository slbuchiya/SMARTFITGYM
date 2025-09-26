package com.example.smartfit2;

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

public class DietFragment extends Fragment {

    RecyclerView recyclerView;
    DietAdapter adapter;
    List<Meal> mealList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diet, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewDiet);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // --- Updated Diet Categories ---
        mealList = new ArrayList<>();
        mealList.add(new Meal("Muscle Gain Diet", R.drawable.mg2));
        mealList.add(new Meal("Weight Loss Diet", R.drawable.wl));
        mealList.add(new Meal("Balanced Diet", R.drawable.bd));


        adapter = new DietAdapter(mealList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
