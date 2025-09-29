package com.example.model;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.interfaz.AlumnoInterface;

@ExtendWith(MockitoExtension.class) 
public class AlumnoModelTestMock {

    @Mock
    AlumnoInterface mockAlumnoInterface;

    @InjectMocks
    AlumnoModel alumnoModel;

    @Test
    void testListarAlumnosConMock() {
       
        Alumno alumno = new Alumno("Juan", "Pérez", 20);


        when(mockAlumnoInterface.listar()).thenReturn(Arrays.asList(alumno));

     
        List<Alumno> resultado = mockAlumnoInterface.listar();

        assertEquals(1, resultado.size());
        assertEquals("Juan", resultado.get(0).getNombre());
        assertEquals("Pérez", resultado.get(0).getApellidos());
        assertEquals(20, resultado.get(0).getEdad());

        verify(mockAlumnoInterface).listar();
    }

    @Test
    void testInsertarAlumnoConMock() {
       
        Alumno alumno = new Alumno("Marcos", "Carretero", 22);
        mockAlumnoInterface.insertar(alumno);
        verify(mockAlumnoInterface).insertar(any(Alumno.class));
    }
}

