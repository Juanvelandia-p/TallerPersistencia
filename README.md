# Backend - Taller Persistencia (Spring Boot + MongoDB)

Este proyecto es el backend de una aplicación de gestión de estudiantes, desarrollado con **Spring Boot** y **MongoDB**. Expone una API REST para registrar y listar estudiantes.

---

## Tabla de Contenidos

- [Descripción General](#descripción-general)
- [Requisitos Previos](#requisitos-previos)
- [Instalación y Ejecución](#instalación-y-ejecución)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Configuración de la Base de Datos](#configuración-de-la-base-de-datos)
- [Principales Clases y Paquetes](#principales-clases-y-paquetes)
- [API REST - Endpoints](#api-rest---endpoints)


---

## Descripción General

El backend permite:
- Registrar estudiantes (nombre, correo, fecha de nacimiento, programa).
- Listar todos los estudiantes registrados.
- Persistir los datos en una base de datos MongoDB Atlas.

---

## Requisitos Previos

- **Java 17** o superior
- **Maven** (o usar el wrapper `mvnw`)
- **MongoDB Atlas** (o local, pero el proyecto está configurado para Atlas)

---

## Instalación y Ejecución

1. Abre una terminal en la carpeta `TallerPersistencia`.
2. Compila el proyecto:
   ```sh
   ./mvnw clean install
   ```
3. Ejecuta la aplicación:
   ```sh
   ./mvnw spring-boot:run
   ```
   El backend quedará disponible en [http://localhost:8080](http://localhost:8080).

---

## Estructura del Proyecto

```
TallerPersistencia/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── escuelaing/
│   │   │       └── edu/
│   │   │           └── arsw/
│   │   │               └── TallerPersistencia/
│   │   │                   ├── controller/
│   │   │                   │   └── StudentController.java
│   │   │                   ├── dto/
│   │   │                   │   └── StudentDTO.java
│   │   │                   ├── model/
│   │   │                   │   └── Student.java
│   │   │                   ├── repository/
│   │   │                   │   └── StudentRepository.java
│   │   │                   ├── service/
│   │   │                   │   └── StudentService.java
│   │   │                   └── TallerPersistenciaApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── escuelaing/
│               └── edu/
│                   └── arsw/
│                       └── TallerPersistencia/
│                           └── TallerPersistenciaApplicationTests.java
├── pom.xml
└── mvnw / mvnw.cmd
```

---

## Configuración de la Base de Datos

El archivo [`src/main/resources/application.properties`](src/main/resources/application.properties) contiene la configuración de la conexión a MongoDB:

```properties
spring.application.name=TallerPersistencia
spring.data.mongodb.uri=mongodb+srv://<usuario>:<password>@<cluster>/<dbname>?retryWrites=true&w=majority&appName=Students
```

> **Nota:** Cambia `<usuario>`, `<password>`, `<cluster>` y `<dbname>` si usas tu propia base de datos.

---

## Principales Clases y Paquetes

- **controller/StudentController.java**  
  Controlador REST. Expone los endpoints `/students` para GET y POST.

- **dto/StudentDTO.java**  
  Objeto de transferencia de datos para recibir estudiantes desde el frontend.

- **model/Student.java**  
  Entidad que representa a un estudiante en la base de datos.

- **repository/StudentRepository.java**  
  Interfaz que extiende `MongoRepository` para operaciones CRUD.

- **service/StudentService.java**  
  Lógica de negocio para manejar estudiantes.

- **TallerPersistenciaApplication.java**  
  Clase principal de arranque de Spring Boot.

---

## API REST - Endpoints

### Listar estudiantes

- **GET** `/students`
- **Respuesta:**  
  ```json
  [
    {
      "id": "string",
      "name": "string",
      "email": "string",
      "birthday": "YYYY-MM-DD",
      "program": "string"
    }
  ]
  ```

### Registrar estudiante

- **POST** `/students`
- **Body (JSON):**
  ```json
  {
    "name": "string",
    "email": "string",
    "birthday": "YYYY-MM-DD",
    "program": "string"
  }
  ```
- **Respuesta:**  
  El estudiante creado (incluyendo su `id`).

---

