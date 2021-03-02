package com.example.proyectom07_izimoto.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
//SE USA PARA AÑADIR ALUMNOS
public class Alumno {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String nombre;
    public String apellido;
    public String imagen;

    public Alumno(String nombre, String apellido, String imagen) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagen = imagen;
    }
}
