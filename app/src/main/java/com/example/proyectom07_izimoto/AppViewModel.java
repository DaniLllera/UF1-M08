package com.example.proyectom07_izimoto;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.proyectom07_izimoto.Model.Alumno;
import com.example.proyectom07_izimoto.Model.AutenticacionManager;
import com.example.proyectom07_izimoto.Model.Usuario;

import java.util.List;


public class AppViewModel extends AndroidViewModel{
    public AppViewModel(@NonNull Application application) {
        super(application);


        autenticacionManager = new AutenticacionManager(application);
        usuarioRepository = new UsuarioRepository(application);
    }
    public String startday;
    public boolean cargados = false;
    UsuarioRepository usuarioRepository;

    public void insertar(String nombre, String apellido, String imagenSeleccionada) {
        usuarioRepository.insertar(nombre, apellido, imagenSeleccionada);
    }
    public void eliminar(Alumno usuario) {
        usuarioRepository.eliminar(usuario);
    }


    public LiveData<List<Alumno>> obtener() {
         return usuarioRepository.obtener();
    }

    enum EstadoDeLaAutenticacion {
        NO_AUTENTICADO,
        AUTENTICADO,
        AUTENTICACION_INVALIDA
    }

    enum EstadoDelRegistro {
        INICIO_DEL_REGISTRO,
        NOMBRE_NO_DISPONIBLE,
        REGISTRO_COMPLETADO
    }

    MutableLiveData<EstadoDeLaAutenticacion> estadoDeLaAutenticacion = new MutableLiveData<>(EstadoDeLaAutenticacion.NO_AUTENTICADO);
    MutableLiveData<EstadoDelRegistro> estadoDelRegistro = new MutableLiveData<>(EstadoDelRegistro.INICIO_DEL_REGISTRO);
    MutableLiveData<Usuario> usuarioAutenticado = new MutableLiveData<>();

    AutenticacionManager autenticacionManager;
    LiveData<List<Alumno>> usuarios(){
        return usuarioRepository.usuarios();
    }



    void iniciarSesion(String username, String password){
        autenticacionManager.iniciarSesion(username, password, new AutenticacionManager.IniciarSesionCallback() {
            @Override
            public void cuandoUsuarioAutenticado(Usuario usuario) {
                usuarioAutenticado.postValue(usuario);
                estadoDeLaAutenticacion.postValue(EstadoDeLaAutenticacion.AUTENTICADO);
            }

            @Override
            public void cuandoAutenticacionNoValida() {
                estadoDeLaAutenticacion.postValue(EstadoDeLaAutenticacion.AUTENTICACION_INVALIDA);
            }
        });
    }

    void iniciarRegistro(){
        estadoDelRegistro.postValue(EstadoDelRegistro.INICIO_DEL_REGISTRO);
    }

    void crearCuentaEIniciarSesion(String username, String password, String email){
        autenticacionManager.crearCuenta(username, password, email, new AutenticacionManager.RegistrarCallback() {
            @Override
            public void cuandoRegistroCompletado() {
                estadoDelRegistro.postValue(EstadoDelRegistro.REGISTRO_COMPLETADO);
                iniciarSesion(username, password);
            }

            @Override
            public void cuandoNombreNoDisponible() {
                estadoDelRegistro.postValue(EstadoDelRegistro.NOMBRE_NO_DISPONIBLE);
            }
        });
    }

    void cerrarSesion(){
        usuarioAutenticado.postValue(null);
        estadoDeLaAutenticacion.postValue(EstadoDeLaAutenticacion.NO_AUTENTICADO);
    }
}
