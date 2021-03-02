package com.example.proyectom07_izimoto;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.proyectom07_izimoto.Model.Alumno;
import com.example.proyectom07_izimoto.databinding.FragmentAdministrarUsuariosBinding;
import com.example.proyectom07_izimoto.databinding.ViewholderUsuariosBinding;

import java.util.List;


public class AdministrarUsuariosFragment extends Fragment {

FragmentAdministrarUsuariosBinding binding;
    private NavController navController;
    private AppViewModel appViewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentAdministrarUsuariosBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

         appViewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);


        binding.irAInsertarAlbum.setOnClickListener(v -> {
            navController.navigate(R.id.action_administrarUsuariosFragment_to_insertarUsuariosFragment);
        });

        UsuariosAdapter usuariosAdapter = new UsuariosAdapter();

        binding.recyclerView.setAdapter(usuariosAdapter);

       appViewModel.obtener().observe(getViewLifecycleOwner(), new Observer<List<Alumno>>() {
           @Override
           public void onChanged(List<Alumno> usuarioList) {
               usuariosAdapter.setUsuarioList(usuarioList);
           }
       });

    }

    class  UsuariosAdapter extends RecyclerView.Adapter<UsuariosViewHolder> {

        List<Alumno> usuarioList;
        @NonNull
        @Override
        public UsuariosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new UsuariosViewHolder(ViewholderUsuariosBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull UsuariosViewHolder holder, int position) {

            Alumno usuario = usuarioList.get(position);

            holder.binding.titulo.setText(usuario.nombre);
            holder.binding.anyo.setText(usuario.apellido);
            Glide.with(holder.itemView).load(usuario.imagen).into(holder.binding.portada);
            holder.binding.trash.setOnClickListener(v -> {
                appViewModel.eliminar(usuario);
            });
        }

        @Override
        public int getItemCount() {

            return usuarioList == null ? 0 : usuarioList.size();
        }
        void  setUsuarioList (List<Alumno> usuarioList){
            this.usuarioList = usuarioList;
            notifyDataSetChanged();
        }
    }

    static class UsuariosViewHolder extends RecyclerView.ViewHolder {

        ViewholderUsuariosBinding binding;

        public UsuariosViewHolder(@NonNull ViewholderUsuariosBinding binding) {

            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
