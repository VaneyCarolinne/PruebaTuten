# PruebaTuten SOLUCION A PROBLEMA 2

Por: Vanessa Cruz

Para correr de forma local se puede abrir el proyecto con intelliJ 2019, descargar el servidor Tomcat 9, desplegar el artefacto como sale en la imagen1 y sus respectivas configuraciones

Hecho con Java, Hibernate, Spring Boot, Base de Datos Postgresql y pruebas hechas con postman.

Url para probar la api en el postman de manera local:

localhost:8080/RestApi/getTimeZoneUTC_REST

tipo de entrada JSON en el body, ejemplo de JSON:

{
    "dato1": "18:31:45",
    "dato2": "-3"
}


Correr el siguiente script sql para crear la pequeña base de datos de prueba en postgresql.

//Crear bd en postgres luego conectarse y por ultimo correr el script BD.sql que se encuentra en la carpeta
create database prueba;
