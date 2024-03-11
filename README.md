# Proyecto de Demostración - Gestión de Precios

Este proyecto es una demostración de una aplicación de gestión de precios utilizando Java 11 y Spring Boot. Utiliza una arquitectura hexagonal para separar las diferentes capas de la aplicación y mantenerla modular y fácilmente escalable.

## Requisitos

- Java 11
- Spring Boot
- Maven

## Dependencias Utilizadas

- MapStruct: Librería utilizada para mapear objetos entre diferentes capas de la aplicación.
- JUnit y Mockito: Utilizados para realizar pruebas unitarias.
- Base de datos H2 en memoria: Utilizada para pruebas de integración.

## Arquitectura

La aplicación sigue una arquitectura hexagonal, lo que significa que está dividida en capas con una clara separación de responsabilidades. Las principales capas son:

- Controladores REST: Exponen los endpoints HTTP y manejan las solicitudes de los clientes.
- Casos de Uso: Contienen la lógica de negocio de la aplicación.
- Puertos de Persistencia: Define interfaces para la persistencia de datos, permitiendo la flexibilidad de implementar diferentes tecnologías de almacenamiento.

## Ejecución del Proyecto

Para ejecutar el proyecto, simplemente clona este repositorio y ejecuta la aplicación utilizando Maven:



## Uso del Endpoint

Puedes usar `curl` u otras herramientas para probar el endpoint `specific` del controlador de precios. Aquí tienes un ejemplo de cómo puedes hacerlo con `curl`:

```bash
curl --location --request GET 'http://localhost:8080/prices/specific?fecha=2020-06-14-00.00.00&productoId=35455&cadenaId=1'
