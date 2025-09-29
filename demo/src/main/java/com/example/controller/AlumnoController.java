package com.example.controller;

import java.util.List;

import com.example.interfaz.AlumnoInterface;
import com.example.model.Alumno;

public class AlumnoController {
      private final AlumnoInterface gestor; 

    public AlumnoController(AlumnoInterface gestor) { 
        this.gestor = gestor;
    }

    public void añadirAlumno(String nombre, String apellidos, int edad) { 
        if (nombre == null || nombre.isEmpty()
                || apellidos == null || apellidos.isEmpty()
                || edad <= 0) {
            throw new IllegalArgumentException("Los datos del alumno no son válidos");
        }

        Alumno alumno = new Alumno(nombre, apellidos, edad);
        gestor.insertar(alumno);
    }

    public List<Alumno> verAlumnos() { 
        return gestor.listar();
    }
}

