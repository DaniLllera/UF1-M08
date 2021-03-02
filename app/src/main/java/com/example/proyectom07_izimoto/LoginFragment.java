package com.example.proyectom07_izimoto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.proyectom07_izimoto.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {

    private AppViewModel appViewModel;
    private NavController navController;
    FragmentLoginBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentLoginBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        appViewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);
        navController = Navigation.findNavController(view);

        binding.button2.setOnClickListener(view1 -> navController.navigate(R.id.action_loginFragment_to_registroFragment));

        binding.button.setOnClickListener(view12 -> {
            String usuario = binding.usuario.getText().toString();
            String password = binding.password.getText().toString();
            appViewModel.iniciarSesion(usuario,password);
        });

        appViewModel.estadoDeLaAutenticacion.observe(getViewLifecycleOwner(), estadoDeLaAutenticacion -> {
            switch (estadoDeLaAutenticacion){
                case AUTENTICADO:
                    navController.navigate(R.id.action_loginFragment_to_paginaPrincipalFragment);
                    break;

                case AUTENTICACION_INVALIDA:
                    Toast.makeText(getContext(), "CREDENCIALES NO VALIDAS", Toast.LENGTH_SHORT).show();
                    break;
            }
        });
        binding.button.setOnClickListener(v -> {
            if (binding.checkBox.isChecked()) {
                navController.navigate(R.id.action_loginFragment_to_paginaPrincipalProfessorFragment2);
            }else {
                navController.navigate(R.id.action_loginFragment_to_paginaPrincipalFragment);
            }
        });

        binding.button2.setOnClickListener(v -> {
            if (binding.checkBox.isChecked()) {
                navController.navigate(R.id.action_loginFragment_to_registroProfeFragment);
            }else {
                navController.navigate(R.id.action_loginFragment_to_registroFragment);
            }
        });


    }
}