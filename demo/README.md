# Sistema de Gestión de Alumnos

- **Registrar alumnos**: agregar nombre, apellido y edad.  
- **Consultar alumnos**: listar todos los alumnos guardados.



---

## Entidad Alumno

La clase `Alumno` representa un estudiante e incluye:

- `nombre`  
- `apellido`  
- `edad`  

Se implementa constructor y métodos **getter y setter** para acceder a los datos.

---

## Modelo de Datos

`AlumnoModel` se encarga de la gestión interna de los alumnos:

- **insertar(Alumno alumno)**: agrega un nuevo alumno a la lista.  
- **listar()**: devuelve una copia de la lista, evitando la manipulación directa desde fuera.

---

## Interfaz de Datos

`AlumnoInterface` 

- Permite crear **pruebas unitarias** usando mocks.  
- Métodos disponibles: `insertar()` y `listar()`.

---

## Controlador

`AlumnoController` actúa como intermediario entre la vista y el modelo:

- **añadirAlumno()**: valida los datos recibidos y los envía al modelo.  
- **verAlumnos()**: retorna la lista de alumnos desde el modelo.

---

## Vista

`AlumnoVista` es la capa de interacción con el usuario:

- Solicita información de los alumnos (nombre, apellido, edad).  
- Llama al controlador para registrar y listar alumnos.  
- Contiene un menú principal (`ejecutarMenu()`) para manejar la interacción.

---

## Pruebas 

### Mockito

- Permite **simular el modelo** y probar el controlador sin depender de la implementación real.  

### JUnit

- Se prueban **funcionalidades del modelo y controlador**.  
- Incluye validación de inserciones y manejo de errores con datos inválidos (campos vacíos o edad negativa).
