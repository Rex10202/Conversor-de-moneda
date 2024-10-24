# 🌍 Conversor De Moneda App

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)  
[![Java](https://img.shields.io/badge/Java-11+-orange.svg)](https://openjdk.org/projects/jdk/11/)  
[![API](https://img.shields.io/badge/ExchangeRate-API-blue)](https://www.exchangerate-api.com/)

Currency Exchange App es una aplicación escrita en **Java** para gestionar conversiones de divisas con tasas actualizadas. Permite seleccionar cualquier par de divisas disponibles mediante una lista dinámica obtenida de la API de ExchangeRate y almacenar los resultados en archivos JSON.

---

## 📑 Tabla de Contenidos

- [🌍 Currency Exchange App](#-currency-exchange-app)
- [📑 Tabla de Contenidos](#-tabla-de-contenidos)
- [✨ Características](#-características)
- [🔧 Tecnologías](#-tecnologías)
- [✅ Requisitos Previos](#-requisitos-previos)
- [⚙️ Instalación](#️-instalación)
- [💻 Uso](#-uso)
- [🔍 Ejemplo de Ejecución](#-ejemplo-de-ejecución)
- [📁 Estructura del Proyecto](#-estructura-del-proyecto)

---

## ✨ Características

- **Consulta en tiempo real** de tasas de cambio con más de 160 divisas.
- **Selección dinámica** de divisas obtenidas directamente desde la API.
- **Conversión precisa** entre pares de divisas.
- **Almacenamiento automático** de resultados en archivos JSON.
- **Interfaz CLI amigable** para facilitar la interacción.

---

## 🔧 Tecnologías

- **Lenguaje**: Java 11+
- **API**: [ExchangeRate API](https://www.exchangerate-api.com/)
- **Dependencias**:
  - `Gson` para manejar archivos JSON.
  - `HttpClient` para consumir la API.

---

## ✅ Requisitos Previos

- **Java 11+**: [Descargar OpenJDK](https://jdk.java.net/11/)
- **Visual Studio Code**: [Descargar](https://code.visualstudio.com/)
- **Dependencia de Gson**: [Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)
- **Internet Activo** para acceder a la API.

---

## ⚙️ Instalación

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/Rex10202/Conversor-de-moneda.git
   cd currency-exchange-app

2. **Compila el proyecto:**
    ```bash
    javac -cp gson-2.8.9.jar:. *.java

3. **Ejecuta la aplicación:**
    ```bash
    java -cp gson-2.8.9.jar:. Principal

---

## 💻 Uso

1. Al iniciar la aplicación, se mostrará una lista completa de divisas disponibles.
2. Elige la moneda base y la moneda destino.
3. Ingresa el monto a convertir y obtén el resultado.
4. Los resultados se guardarán automáticamente en un archivo JSON.

## 
Aquí tienes un formato optimizado en Markdown para presentar las secciones de Uso, Ejemplo de Ejecución y Estructura del Proyecto, que se verá claro y atractivo en GitHub:

💻 Uso
Explica el flujo básico de la aplicación para que los usuarios comprendan cómo interactuar con ella:

Inicia la aplicación y se mostrará una lista completa de divisas disponibles.
Selecciona la moneda base y moneda destino.
Introduce el monto que deseas convertir.
Recibe el resultado y observa cómo se guarda en un archivo JSON.
Decide si deseas realizar otra conversión o salir de la aplicación.

---

## 🔍 Ejemplo de Ejecución
**Print:**
    ```bash
    Lista de divisas disponibles:
    USD - United States Dollar
    EUR - Euro
    JPY - Japanese Yen
    COP - Colombian Peso
    ...

    Seleccione la moneda base: USD
    Seleccione la moneda destino: COP
    Tasa de cambio: 1 USD = 4500.0000 COP
    Ingrese la cantidad a convertir: 100
    Monto convertido: 450000.00 COP
    Conversión guardada en archivo JSON.

    ¿Desea realizar otra conversión? (s/n): n
    ¡Hasta luego!

---

## 📁 Estructura del Proyecto
**Organización de carpetas:**
    ```bash
    conversor-de-moneda/
    │
    ├── ConsultarTasa.java       # Clase para consultar tasas y obtener divisas
    ├── Principal.java           # Clase principal con la lógica del menú
    ├── Tasa.java                # Modelo para los datos de conversión
    ├── GeneradorDeArchivo.java  # Clase para gestionar archivos JSON
    └── README.md                # Documentación del proyecto

