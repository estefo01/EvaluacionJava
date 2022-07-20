CREATE DATABASE IF NOT EXISTS EjercicioMicroservicios;

USE EjercicioMicroservicios;

CREATE TABLE EjercicioMicroservicios.Usuario
( 
ID int NOT NULL PRIMARY KEY AUTO_INCREMENT, 
name VARCHAR (50) NOT NULL,
email VARCHAR (50) NOT NULL,
password VARCHAR (50) NOT NULL,
created date NOT NULL, 
modified date NOT NULL, 
last_login date NOT NULL, 
isactive boolean NOT NULL

) ;

CREATE TABLE EjercicioMicroservicios.TelefonoUsuario (
ID int NOT NULL PRIMARY KEY AUTO_INCREMENT, 
number INT NOT NULL,
citycode INT NOT NULL,
contrycode INT NOT NULL,
id_usuario INT NOT NULL,
FOREIGN KEY (id_usuario) REFERENCES EjercicioMicroservicios.Usuario (ID)
);