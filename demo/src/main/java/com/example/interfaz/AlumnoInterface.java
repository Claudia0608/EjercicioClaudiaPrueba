package com.example.interfaz;

import java.util.List;

import com.example.model.Alumno;

public interface  AlumnoInterface {
    void insertar(Alumno alumno);
    List<Alumno> listar();
}
