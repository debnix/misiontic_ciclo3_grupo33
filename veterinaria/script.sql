
# Consultar bases de datos
show databases;

# Crear base de datos
CREATE DATABASE utp_grupo_33;

# Consultar las tablas en la BD
show tables;

# Conectarse a una BD
USE utp_grupo_33;

# Crear tabla
CREATE TABLE mascotas(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    apellido VARCHAR(80) NOT NULL,
    raza VARCHAR(20) NOT NULL,
    foto TEXT NOT NULL,
    observacion TEXT NOT NULL
);