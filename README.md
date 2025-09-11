# Proyecto Spring Boot - Ejemplo Básico

Este proyecto es un ejemplo básico desarrollado con **Spring Boot**.  
Sirve como guía de aprendizaje para comprender la estructura de un proyecto y la organización de controladores, servicios y repositorios.

---

## 🚀 Tecnologías utilizadas
- Java 17+
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- H2 Database (para pruebas)
- Maven

---

## 📂 Estructura del proyecto

```
proyecto-springboot/
├── src/
│   ├── main/
│   │   ├── java/com/ejemplo/demo/
│   │   │   ├── controller/
│   │   │   │   ├── HelloController.java
│   │   │   │   ├── ProductoController.java
│   │   │   │   └── UsuarioController.java
│   │   │   ├── service/
│   │   │   │   ├── ProductoService.java
│   │   │   │   └── UsuarioService.java
│   │   │   ├── repository/
│   │   │   │   ├── ProductoRepository.java
│   │   │   │   └── UsuarioRepository.java
│   │   │   └── DemoApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql
│   └── test/java/com/ejemplo/demo/
│       └── DemoApplicationTests.java
├── pom.xml
└── README.md
```

---

## ▶️ Ejecución del proyecto

1. Clonar este repositorio:  
   ```bash
   git clone https://github.com/tu-usuario/proyecto-springboot.git
   ```

2. Entrar en la carpeta del proyecto:  
   ```bash
   cd proyecto-springboot
   ```

3. Ejecutar con Maven:  
   ```bash
   mvn spring-boot:run
   ```

4. Probar en el navegador o con Postman:  
   ```
   http://localhost:8080/hello
   http://localhost:8080/productos
   http://localhost:8080/usuarios
   ```

---

## 📑 Control de cambios

| Versión | Fecha       | Autor          | Descripción                               |
|---------|------------|----------------|-------------------------------------------|
| 0.1.0   | 2025-08-28 | Wilder Duarte  | Creación del proyecto base con Spring Boot |
| 0.1.1   | 2025-08-29 | Wilder Duarte  | Se agregan controladores de Producto y Usuario |
| 0.1.2   | 2025-08-30 | Wilder Duarte  | Se implementa capa de servicio y repositorios |
| 0.1.3   | 2025-09-01 | Wilder Duarte  | Se agrega base de datos H2 y script inicial |

---

## ✨ Notas

- Este proyecto es para **aprendizaje académico**.
- Puede extenderse agregando autenticación, validaciones y más servicios.
