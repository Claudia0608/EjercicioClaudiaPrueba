package com.example.model;

import java.util.ArrayList;
import java.util.List;

import com.example.interfaz.AlumnoInterface;

public class AlumnoModel implements AlumnoInterface {
    private final List<Alumno> alumnos = new ArrayList<>();

    @Override
    public void insertar(Alumno alumno) {
        alumnos.add(alumno);
    }

    @Override
    public List<Alumno> listar() {
        return new ArrayList<>(alumnos);
    }
}
