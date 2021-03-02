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

import com.example.proyectom07_izimoto.databinding.FragmentPaginaPrincipalProfessorBinding;

public class PaginaPrincipalProfessorFragment extends Fragment {

    FragmentPaginaPrincipalProfessorBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentPaginaPrincipalProfessorBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);


        binding.alumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_paginaPrincipalProfessorFragment_to_administrarUsuariosFragment);
            }
        });

        binding.imageView17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_paginaPrincipalProfessorFragment_to_habilitarFechaExamenFragment);
            }
        });

        binding.imageView18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_paginaPrincipalProfessorFragment_to_splashScreamFragment);
            }
        });
        binding.imageView16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_paginaPrincipalProfessorFragment_to_resultadosParaProfessorFragment);
            }
        });
    }
}