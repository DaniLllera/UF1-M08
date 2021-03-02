package com.example.proyectom07_izimoto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.proyectom07_izimoto.databinding.FragmentLoginBinding;
import com.example.proyectom07_izimoto.databinding.FragmentPaginaPrincipalBinding;


public class PaginaPrincipalFragment extends Fragment {

    private NavController navController;
    private  AppViewModel appViewModel;
    FragmentPaginaPrincipalBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentPaginaPrincipalBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        appViewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);
        if (!appViewModel.cargados ) {

            navController.navigate(R.id.splashScreamFragment);
        }else {
            binding.imageView2.setOnClickListener(view1 -> navController.navigate(R.id.action_paginaPrincipalFragment_to_permisoMotoFragment));

            binding.imageView3.setOnClickListener(view12 -> navController.navigate(R.id.action_paginaPrincipalFragment_to_permisoCamionFragment));

            binding.imageView4.setOnClickListener(view13 -> navController.navigate(R.id.action_paginaPrincipalFragment_to_permisoCocheFragment));
        }

    }
}