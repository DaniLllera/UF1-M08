package com.example.proyectom07_izimoto.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
//SE USA PARA EL LOGIN Y REGISTRO
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String username;
    public String password;
    public String email;

    public Usuario(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @NonNull
    @Override
    public String toString() {
        return "USER = " + username + " " + password + " " + email;
    }
}