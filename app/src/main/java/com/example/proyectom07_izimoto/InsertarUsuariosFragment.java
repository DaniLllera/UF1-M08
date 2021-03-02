package com.example.proyectom07_izimoto;

import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.proyectom07_izimoto.databinding.FragmentInsertarUsuariosBinding;
import com.example.proyectom07_izimoto.databinding.FragmentPaginaPrincipalProfessorBinding;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;
import static androidx.core.content.ContextCompat.checkSelfPermission;


public class InsertarUsuariosFragment extends Fragment {

    FragmentInsertarUsuariosBinding binding;
    private NavController navController;

    Uri imagenSeleccionada;
    private AppViewModel appViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentInsertarUsuariosBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        appViewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);
        binding.portada.setOnClickListener(v ->{
            abrirGaleria();
        } );

            binding.insertar.setOnClickListener(v ->{
                String nombre = binding.nombre.getText().toString();
                String apellido = binding.apellido.getText().toString();

                appViewModel.insertar(nombre, apellido, imagenSeleccionada.toString());

                navController.popBackStack();
            });

    }

    private void abrirGaleria(){
        if (checkSelfPermission(requireContext(), READ_EXTERNAL_STORAGE) == PERMISSION_GRANTED){
            lanzadorGaleria.launch("image/*");
        }else {
            lanzadorPermisos.launch(READ_EXTERNAL_STORAGE);
        }
    }

    private  final ActivityResultLauncher lanzadorGaleria =
             registerForActivityResult(new ActivityResultContracts.GetContent(), uri -> {

                 imagenSeleccionada= uri;
                 Glide.with(requireView()).load(uri).into(binding.portada);
             });
    private  final ActivityResultLauncher<String> lanzadorPermisos =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
               if (isGranted){
                   lanzadorGaleria.launch("image/*");
               }
            });

}