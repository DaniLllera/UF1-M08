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

import com.example.proyectom07_izimoto.databinding.FragmentRegistroBinding;


public class RegistroFragment extends Fragment {

    private NavController navController;
    FragmentRegistroBinding binding;
    private AppViewModel appViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentRegistroBinding.inflate(inflater, container, false)).getRoot();
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        appViewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);
        navController = Navigation.findNavController(view);

        appViewModel.iniciarRegistro();

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.usuario.getText().toString();
                String password = binding.password.getText().toString();
                String biografia = binding.editTextmail.getText().toString();

                appViewModel.crearCuentaEIniciarSesion(username, password, biografia);
            }
        });

        appViewModel.estadoDelRegistro.observe(getViewLifecycleOwner(), estadoDelRegistro -> {
            switch (estadoDelRegistro){
                case NOMBRE_NO_DISPONIBLE:
                    Toast.makeText(getContext(), "NOMBRE DE USUARIO NO DISPONIBLE", Toast.LENGTH_SHORT).show();
                    break;
            }
        });

        appViewModel.estadoDeLaAutenticacion.observe(getViewLifecycleOwner(), estadoDeLaAutenticacion -> {
            switch (estadoDeLaAutenticacion){
                case AUTENTICADO:
                    navController.navigate(R.id.action_registroFragment_to_paginaPrincipalFragment);
                    break;
            }
        });


    }
}