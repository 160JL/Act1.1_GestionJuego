-- Script para crear la base de datos y la tabla para la actividad de gestión de videojuegos.

-- Se recomienda eliminar la base de datos si ya existe para empezar desde cero.
DROP DATABASE IF EXISTS videojuegos_db;

-- Crear la base de datos con el conjunto de caracteres adecuado
CREATE DATABASE videojuegos_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Usar la base de datos recién creada
USE videojuegos_db;

-- Crear la tabla 'videojuegos'
CREATE TABLE videojuegos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL UNIQUE,
    genero VARCHAR(100),
    plataforma VARCHAR(100),
    anio INT,
    valoracion INT CHECK (valoracion >= 1 AND valoracion <= 10)
);

-- Ejemplo de inserción de datos (opcional, para que los alumnos prueben)
INSERT INTO videojuegos (titulo, genero, plataforma, anio, valoracion) VALUES
('The Witcher 3: Wild Hunt', 'RPG', 'PC', 2015, 10),
('Red Dead Redemption 2', 'Aventura', 'PS4', 2018, 10),
('Celeste', 'Plataformas', 'Nintendo Switch', 2018, 9);

-- Mensaje para el usuario al ejecutar el script desde un cliente SQL
SELECT 'Base de datos videojuegos_db y tabla videojuegos creadas correctamente.' AS 'Estado';
