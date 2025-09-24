<img width="100%" src="https://capsule-render.vercel.app/api?type=waving&color=85e3ff&animation=fadeIn&height=120&section=header"/>

# 📚 Mini Biblioteca

## 📌 Descripción
Este proyecto consiste en desarrollar una **mini aplicación de consola en Java** para gestionar una biblioteca básica.  
El objetivo es aplicar los conceptos de la **Unidad Didáctica 1 (Almacenamiento de la Información)** trabajando con **ficheros CSV**, manejo de datos en memoria y persistencia sencilla.

---

## 🎯 Objetivos de Aprendizaje
- Entender el concepto de **modelo de dominio** (`Book`) y sus campos.
- Aplicar **invariantes** y validaciones simples al crear objetos.
- Practicar el guardado en **ficheros planos (CSV)** con cabecera y separador `;`.
- Aprender cómo un programa puede **crear carpetas y archivos automáticamente** si no existen.
- Desarrollar un menú de consola para interactuar con la aplicación.
- Diferenciar entre el estado **en memoria** y el estado **persistido en disco**.

---

## 🛠️ Requisitos Funcionales Implementados
- Al iniciar:
    - Cargar los libros existentes desde `data/books.csv` (si existe).
    - Si no existe, la aplicación comienza vacía.
- Menú de opciones:
    1. **Añadir libro** → pide datos al usuario y los guarda en memoria y CSV.
    2. **Listar libros** → muestra todos los libros almacenados.
    3. **Salir** → termina el programa.
- Cada libro contiene:
    - ID único (UUID).
    - Título.
    - Autor.
    - Género.
    - Año de publicación.
    - ISBN.

---

## 🔮 Mejoras Opcionales (no implementadas todavía)
- **Búsqueda secuencial**: recorrer todos los libros para encontrar coincidencias en el título.
- **Búsqueda indexada en memoria**: usar un índice de palabras para encontrar más rápido.
- **Exportar a JSON**: generar un fichero adicional con todos los libros en formato JSON.
- **Gestión de usuarios y préstamos**: ampliar la aplicación hacia un sistema de biblioteca más completo.
- **Simular fragmentación de datos**: guardar libros en subcarpetas por sucursal o género.

---

## 🚀 Tecnologías
- **Java (JDK 21)**
- **Maven** para gestión del proyecto
- **IntelliJ IDEA** como IDE recomendado

---

📝 Autor

Proyecto educativo desarrollado como práctica de la UD1 de Bases de Datos (DAW 1º).
<img src="https://raw.githubusercontent.com/matfantinel/matfantinel/master/waves.svg" width="100%" height="100">