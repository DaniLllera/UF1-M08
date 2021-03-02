package com.example.proyectom07_izimoto.Model;

import android.app.Application;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AutenticacionManager {

    Executor executor = Executors.newSingleThreadExecutor();

    public interface IniciarSesionCallback {
        void cuandoUsuarioAutenticado(Usuario usuario);
        void cuandoAutenticacionNoValida();
    }

    public interface RegistrarCallback {
        void cuandoRegistroCompletado();
        void cuandoNombreNoDisponible();

    }

    AppBaseDeDatos.AppDao dao;

    public AutenticacionManager(Application application){
        dao = AppBaseDeDatos.getInstance(application).obtenerDao();
    }

    public void iniciarSesion(String username, String password, IniciarSesionCallback callback){
        executor.execute(() -> {
            Usuario usuario = dao.autenticar(username, password);

            if (usuario != null){
                callback.cuandoUsuarioAutenticado(usuario);
            } else {
                callback.cuandoAutenticacionNoValida();
            }
        });
    }

    public void crearCuenta(String username, String password, String email, RegistrarCallback callback) {
        executor.execute(() -> {
            Usuario usuario = dao.comprobarNombreDisponible(username);

            if (usuario == null){
                dao.insertarUsuario(new Usuario(username, password, email));
                callback.cuandoRegistroCompletado();
            } else {
                callback.cuandoNombreNoDisponible();
            }
        });
    }
}