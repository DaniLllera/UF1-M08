package com.example.proyectom07_izimoto;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.service.autofill.OnClickAction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectom07_izimoto.AppViewModel;
import com.example.proyectom07_izimoto.R;
import com.example.proyectom07_izimoto.databinding.FragmentConfirmarFechaBinding;
import com.example.proyectom07_izimoto.databinding.FragmentFechaExamenBinding;


public class ConfirmarFechaFragment extends DialogFragment {

    private FragmentConfirmarFechaBinding binding;
    private AppViewModel appViewModel;
    private NavController navController;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentConfirmarFechaBinding.inflate(inflater, container, false)).getRoot();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        appViewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);
        navController = Navigation.findNavController(requireParentFragment().requireView());

        binding.seguro.setText("Te parece bien el dia que as selecionado: \n\n " + appViewModel.startday + "?");

        binding.button5.setOnLongClickListener(v -> {
            binding.button5.setVisibility(View.GONE);
            binding.button6.setVisibility(View.GONE);
            binding.seguro.setText("Tu fecha se a Tramitado el dia:\n" + appViewModel.startday);
            return false;
        });

        binding.button6.setOnClickListener(v -> dismiss());
    }

}