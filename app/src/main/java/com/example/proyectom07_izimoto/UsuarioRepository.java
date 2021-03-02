package com.example.proyectom07_izimoto;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.proyectom07_izimoto.Model.Alumno;
import com.example.proyectom07_izimoto.Model.AppBaseDeDatos;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class UsuarioRepository {
    Executor executor = Executors.newSingleThreadExecutor();
    private final AppBaseDeDatos.AppDao usuariosDao;

    public UsuarioRepository(Application application) {

        usuariosDao = AppBaseDeDatos.getInstance(application).obtenerDao();
    }

    LiveData<List<Alumno>> usuariosLiveData;

    LiveData<List<Alumno>> usuarios() {
        return usuariosLiveData;
    }

    public void insertar(String nombre, String apellido, String imagenSeleccionada) {
        executor.execute(() -> {
            usuariosDao.insertarAlumno(new Alumno(nombre, apellido, imagenSeleccionada));

        });
    }

    public void eliminar(Alumno usuario) {
        executor.execute(() -> usuariosDao.eliminarusuarios(usuario));
    }


    public LiveData<List<Alumno>> obtener() {
        return usuariosDao.obtenerUsuarios();
    }
}

