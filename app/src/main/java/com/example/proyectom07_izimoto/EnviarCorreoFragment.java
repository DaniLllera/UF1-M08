package com.example.proyectom07_izimoto;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.proyectom07_izimoto.databinding.FragmentEnviarCorreoBinding;
import com.example.proyectom07_izimoto.databinding.FragmentResultadosDelTestBinding;
import com.github.jinatonic.confetti.CommonConfetti;

import java.util.concurrent.Delayed;


public class EnviarCorreoFragment extends Fragment {

    FragmentEnviarCorreoBinding binding;
    private NavController navController;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentEnviarCorreoBinding.inflate(inflater, container, false)).getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);


        binding.button2.setOnClickListener(view1 -> {
            Toast.makeText(getContext(), "Correo Enviado con EXITO", (Toast.LENGTH_LONG)).show();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            navController.navigate(R.id.action_enviarCorreoFragment_to_paginaPrincipalProfessorFragment);
        });


    }
}