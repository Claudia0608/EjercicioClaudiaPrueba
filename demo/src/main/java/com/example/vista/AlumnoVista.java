package com.example.vista;

import java.util.List;
import java.util.Scanner;

import com.example.controller.AlumnoController;
import com.example.model.Alumno;

public class AlumnoVista {
    public static final int AÑADIR_ALUMNOS = 1;
    public static final int LISTAR_ALUMNOS = 2;
    public static final int SALIR = 3;
    private final AlumnoController controller;
    private final Scanner scanner = new Scanner(System.in);

    public AlumnoVista(AlumnoController controller){
        this.controller = controller;
    }

     private String introducirDato(String dato){
         System.out.println("Introduce el "+ dato+ " del alumno:");
        return scanner.nextLine();
     }

     private int introducirEdad(){
         while (true) {
            String textoEdad = introducirDato("edad");
            try {
                return Integer.parseInt(textoEdad);
            } catch (NumberFormatException e) {
                System.out.println("Error, introduce un número válido.");
            }
        }
     }

     public  void añadirAlumno(){
        String nombre = introducirDato("Nombre del alumno");
        String apellidos = introducirDato("Apellidos del alumno");
        int edad = introducirEdad();

        if (nombre.isEmpty()||apellidos.isEmpty()||edad <= 0) {
            System.out.println("Error, datos no válidos. ");
            return;
        }

        try {
            controller.añadirAlumno(nombre, apellidos, edad);
            System.out.println("Alumno añadido correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void listarAlumnos(){
        List<Alumno> lista = controller.verAlumnos();

        if (lista.isEmpty()) {
            System.out.println("No hay ningún alumno registrado.");
        } else {
            for (Alumno alumno : lista) {
                    System.out.println("-> " + alumno);
            }
        }
    }

    
    private void menu(){
        System.out.println(AÑADIR_ALUMNOS+ ". Añadir Alumno");
        System.out.println(LISTAR_ALUMNOS + ". Listar Alumno");
        System.out.println(SALIR + ". Salir");
        System.out.println("Selecciona una opción:");
    }

    public void ejecutarMenu() {
        boolean activo = true;

        while (activo) {
            menu();
            String texto = scanner.nextLine();
            int opcion;

            try {
                opcion = Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.println("Error, introduce un número.");
                continue;
            }

            switch (opcion) {
            case AÑADIR_ALUMNOS:
                añadirAlumno();
                break;
            case LISTAR_ALUMNOS:
                listarAlumnos();
                break;
            case SALIR:
                System.out.println("Cerrando programa...");
                activo = false;
                break;
            default:
                System.out.println("Opción no válida");
                break;
            }
        }
    }

}
