package com.example.smartfit2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Edit Profile button
        Button btnEditProfile = view.findViewById(R.id.btnEditProfile);
        btnEditProfile.setOnClickListener(v ->
                Toast.makeText(getActivity(), "Edit Profile coming soon!", Toast.LENGTH_SHORT).show()
        );

        // Logout button
        Button btnLogout = view.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(v -> {
            // Confirmation (optional) or directly logout
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            if(getActivity() != null) {
                getActivity().finish(); // Current activity finish
            }
        });

        return view;
    }
}
