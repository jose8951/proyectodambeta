-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: academiavega
-- ------------------------------------------------------
-- Server version	8.0.25
-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS respandoacademia;
USE respandoacademia;

-- Configuraciones iniciales
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Tabla: administradores
DROP TABLE IF EXISTS `administradores`;
CREATE TABLE `administradores` (
  `id_administradores` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `roles_id_rol` int NOT NULL,
  `foto_administrador` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_administradores`),
  UNIQUE KEY `email` (`email`),
  KEY `roles_id_rol` (`roles_id_rol`),
  CONSTRAINT `administradores_ibfk_1` FOREIGN KEY (`roles_id_rol`) REFERENCES `roles` (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Datos: administradores
LOCK TABLES `administradores` WRITE;
INSERT INTO `administradores` VALUES 
(2,'bener','gomez@academia.com','$argon2id$v=19$m=15360,t=2,p=1$Iu8...',1,'bender.jpg'),
(6,'homer','pepe.pepe@gmail.com','$argon2id$v=19$m=15360,t=2,p=1$6vQ...',3,'homer.jpg');
UNLOCK TABLES;

-- Tabla: alumnos
DROP TABLE IF EXISTS `alumnos`;
CREATE TABLE `alumnos` (
  `id_alumno` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `apellido` varchar(45) NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `correo_electronico` varchar(100) DEFAULT NULL,
  `foto_alumno` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_alumno`),
  UNIQUE KEY `correo_electronico` (`correo_electronico`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Datos: alumnos
LOCK TABLES `alumnos` WRITE;
INSERT INTO `alumnos` VALUES 
(2,'María','Gómez','2023-01-11','Avenida siemore 456','gomez@gmail.com','lisa.png'),
(4,'Ana','Martinez','2010-05-19','Calle marzo 234','martinez@gmail.com','bender.jpg');
UNLOCK TABLES;

-- Tabla: curso_matricula
DROP TABLE IF EXISTS `curso_matricula`;
CREATE TABLE `curso_matricula` (
  `id_matricula` int NOT NULL,
  `id_profesor` int NOT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id_matricula`,`id_profesor`),
  KEY `fk_curso_matricula_profesores` (`id_profesor`),
  CONSTRAINT `fk_curso_matricula_matriculas` FOREIGN KEY (`id_matricula`) REFERENCES `matriculas` (`id_matricula`) ON DELETE CASCADE,
  CONSTRAINT `fk_curso_matricula_profesores` FOREIGN KEY (`id_profesor`) REFERENCES `profesores` (`id_profesor`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Datos: curso_matricula
LOCK TABLES `curso_matricula` WRITE;
INSERT INTO `curso_matricula` VALUES 
(2,1,'2025-01-27'),
(2,2,'2025-01-27');
UNLOCK TABLES;

-- Tabla: evaluaciones
DROP TABLE IF EXISTS `evaluaciones`;
CREATE TABLE `evaluaciones` (
  `id_evaluacion` int NOT NULL AUTO_INCREMENT,
  `id_alumno` int DEFAULT NULL,
  `id_profesor` int DEFAULT NULL,
  `fecha_evaluacion` date DEFAULT NULL,
  `nota` decimal(5,2) DEFAULT NULL,
  `comentarios` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_evaluacion`),
  KEY `fk_evaluaciones_profesores` (`id_profesor`),
  KEY `fk_evaluaciones_alumnos` (`id_alumno`),
  CONSTRAINT `fk_evaluaciones_alumnos` FOREIGN KEY (`id_alumno`) REFERENCES `alumnos` (`id_alumno`) ON DELETE CASCADE,
  CONSTRAINT `fk_evaluaciones_profesores` FOREIGN KEY (`id_profesor`) REFERENCES `profesores` (`id_profesor`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Datos: evaluaciones
LOCK TABLES `evaluaciones` WRITE;
INSERT INTO `evaluaciones` VALUES 
(13,11,3,'2025-01-25',10.00,'suspenso'),
(14,12,1,'2025-01-29',3.00,'sobre');
UNLOCK TABLES;

-- Tabla: facturas
DROP TABLE IF EXISTS `facturas`;
CREATE TABLE `facturas` (
  `id_factura` int NOT NULL AUTO_INCREMENT,
  `id_matricula` int DEFAULT NULL,
  `fecha_factura` date DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `estado_pago` varchar(50) DEFAULT NULL,
  `visto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_factura`),
  UNIQUE KEY `unique_id_matricula` (`id_matricula`),
  CONSTRAINT `fk_facturas_matriculas` FOREIGN KEY (`id_matricula`) REFERENCES `matriculas` (`id_matricula`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Datos: facturas
LOCK TABLES `facturas` WRITE;
INSERT INTO `facturas` VALUES 
(30,7,'2025-01-29',0.00,'Rechazado','visto'),
(31,2,'2025-01-29',90.00,'En proceso','visto');
UNLOCK TABLES;

-- Tabla: matriculas
DROP TABLE IF EXISTS `matriculas`;
CREATE TABLE `matriculas` (
  `id_matricula` int NOT NULL AUTO_INCREMENT,
  `id_alumno` int NOT NULL,
  `fecha_matricula` date DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_matricula`),
  UNIQUE KEY `id_alumno` (`id_alumno`),
  CONSTRAINT `fk_matriculas_alumnos` FOREIGN KEY (`id_alumno`) REFERENCES `alumnos` (`id_alumno`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Datos: matriculas
LOCK TABLES `matriculas` WRITE;
INSERT INTO `matriculas` VALUES 
(2,4,'2025-01-21','Inactiva'),
(4,2,'2025-01-21','Activa');
UNLOCK TABLES;

-- Tabla: profesores
DROP TABLE IF EXISTS `profesores`;
CREATE TABLE `profesores` (
  `id_profesor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `especialidad` varchar(100) DEFAULT NULL,
  `correo_electronico` varchar(100) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `foto_profesor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_profesor`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Datos: profesores
LOCK TABLES `profesores` WRITE;
INSERT INTO `profesores` VALUES 
(1,'Luis','Sánchez','Sistemas informáticos','luis@gmail.com','888889900','profesor1.jpg'),
(2,'Elena','Perez','Bases de Datos','elena@gmail.com','900112233','profesor2.png');
UNLOCK TABLES;

-- Configuraciones finales
/*!40101 SET SQL_MODE=@OLD_SQL
