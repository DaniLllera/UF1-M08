package com.example.proyectom07_izimoto;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectom07_izimoto.databinding.FragmentLoginBinding;
import com.example.proyectom07_izimoto.databinding.FragmentPaginaPrincipalBinding;
import com.example.proyectom07_izimoto.databinding.FragmentPermisoMotoBinding;


public class PermisoMotoFragment extends Fragment {

    FragmentPermisoMotoBinding binding;
    private NavController navController;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentPermisoMotoBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        binding.senales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_permisoMotoFragment_to_testTemasFragment);
            }
        });

        binding.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_permisoMotoFragment_to_testTemasFragment);
            }
        });

        binding.senales2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_permisoMotoFragment_to_testTemasFragment);
            }
        });
        binding.linearLayout24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_permisoMotoFragment_to_testTemasFragment);
            }
        });
    }
}