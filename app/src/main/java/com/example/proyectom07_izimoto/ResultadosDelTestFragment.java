package com.example.proyectom07_izimoto;

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

import com.example.proyectom07_izimoto.databinding.FragmentResultadosDelTestBinding;
import com.example.proyectom07_izimoto.databinding.FragmentTestPoliglotasBinding;
import com.github.jinatonic.confetti.CommonConfetti;

import java.lang.reflect.Array;


public class ResultadosDelTestFragment extends Fragment {


    FragmentResultadosDelTestBinding binding;
    private NavController navController;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentResultadosDelTestBinding.inflate(inflater, container, false)).getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);


        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_resultadosDelTestFragment_to_paginaPrincipalFragment);
            }
        });

        binding.imageView20.setOnClickListener(v -> {
            CommonConfetti.rainingConfetti((ViewGroup) view, new int[] { Color.RED, Color.YELLOW , Color.BLUE })
                    .stream(3000);
        });
    }
}
