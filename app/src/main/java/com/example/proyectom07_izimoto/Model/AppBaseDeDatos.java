package com.example.proyectom07_izimoto.Model;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

@Database(entities = {Usuario.class , Alumno.class}, version = 5, exportSchema = false)
public abstract class AppBaseDeDatos extends RoomDatabase {


    public abstract AppDao obtenerDao();

    private static volatile AppBaseDeDatos INSTANCE;

    public static AppBaseDeDatos getInstance(final Context context){
        if (INSTANCE == null){
            synchronized (AppBaseDeDatos.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, AppBaseDeDatos.class, "app.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    @Dao
    public interface AppDao {

        @Insert
        void insertarAlumno(Alumno alumno);
        @Delete
        void eliminarusuarios(Alumno usuario);
        @Query("SELECT * FROM Alumno" )
        LiveData<List<Alumno>> obtenerUsuarios();
        @Insert
        void insertarUsuario(Usuario usuario);
        @Query("SELECT * FROM Usuario" )
        LiveData<List<Usuario>> obtener();

        @Query("SELECT * FROM Usuario WHERE username = :nombre AND password = :contrasenya")
        Usuario autenticar(String nombre, String contrasenya);

        @Query("SELECT * FROM Usuario WHERE username = :nombre")
        Usuario comprobarNombreDisponible(String nombre);



    }
}