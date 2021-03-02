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

import com.example.proyectom07_izimoto.databinding.FragmentTestTemas2Binding;
import com.example.proyectom07_izimoto.databinding.FragmentTestTemas3Binding;


public class TestTemas2Fragment extends Fragment {

    FragmentTestTemas2Binding binding;
    private NavController navController;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentTestTemas2Binding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);


        binding.senales.setOnClickListener(view1 -> navController.navigate(R.id.action_testTemas2Fragment2_to_testSenalizacionFragment));

        binding.senales2.setOnClickListener(view12 -> navController.navigate(R.id.action_testTemas2Fragment2_to_testSenalizacionFragment));

        binding.senales3.setOnClickListener(view13 -> navController.navigate(R.id.action_testTemas2Fragment2_to_testSenalizacionFragment));
    }
}