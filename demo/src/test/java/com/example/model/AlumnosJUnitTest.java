package com.example.model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlumnoUnitTest {

    private AlumnoModel alumnoModel;

    @BeforeEach
    void setPrueba() {
        alumnoModel = new AlumnoModel();
    }

    @Test
    void testInsertarAlumno() {
       Alumno alumno = new Alumno("Juan", "Pérez", 20);
        alumnoModel.insertar(alumno);

        List<Alumno> lista = alumnoModel.listar();
        assertEquals(1, lista.size(), "La lista debe tener un alumno");
        assertEquals("Juan", lista.get(0).getNombre(), "El nombre debe coincidir");
        assertEquals(20, lista.get(0).getEdad(), "La edad debe coincidir");
    }

    @Test
    void testListarAlumnosVacio() {
        List<Alumno> lista = alumnoModel.listar();
        assertTrue(lista.isEmpty(), "La lista debe estar vacía al inicio");
    }

    @Test
    void testListarAlumnosMultiples() {
       Alumno alumno1 = new Alumno("Ana", "López", 22);
        Alumno alumno2 = new Alumno("Luis", "Martínez", 25);

        alumnoModel.insertar(alumno1);
        alumnoModel.insertar(alumno2);

        List<Alumno> lista = alumnoModel.listar();
        assertEquals(2, lista.size(), "La lista debe contener 2 alumnos");
        assertTrue(lista.contains(alumno1), "Debe contener a Ana");
        assertTrue(lista.contains(alumno2), "Debe contener a Luis");
    }
}
