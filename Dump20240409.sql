-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sistema_contratacion
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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

--
-- Table structure for table `coder`
--

DROP TABLE IF EXISTS `coder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_coder` varchar(40) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `documento` varchar(40) NOT NULL,
  `cohorte` int(11) NOT NULL,
  `cv` text NOT NULL,
  `clan` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `documento` (`documento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coder`
--

LOCK TABLES `coder` WRITE;
/*!40000 ALTER TABLE `coder` DISABLE KEYS */;
INSERT INTO `coder` VALUES (1,'Santiago','Peláez','1025523438',1,'www.santiagopelaez.com',''),(4,'Luisa','Rodriguez','120923021',2,'HTML','Lovelace');
/*!40000 ALTER TABLE `coder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contratacion`
--

DROP TABLE IF EXISTS `contratacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contratacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_aplicacion` timestamp NOT NULL DEFAULT current_timestamp(),
  `estado` varchar(40) NOT NULL,
  `salario` decimal(10,0) NOT NULL,
  `vacante_id` int(11) NOT NULL,
  `coder_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `vacante_id` (`vacante_id`),
  KEY `coder_id` (`coder_id`),
  CONSTRAINT `contratacion_ibfk_1` FOREIGN KEY (`vacante_id`) REFERENCES `vacante` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `contratacion_ibfk_2` FOREIGN KEY (`coder_id`) REFERENCES `coder` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contratacion`
--

LOCK TABLES `contratacion` WRITE;
/*!40000 ALTER TABLE `contratacion` DISABLE KEYS */;
INSERT INTO `contratacion` VALUES (7,'2024-04-09 17:58:58','Activa',24123,1,1),(8,'2024-04-09 17:59:37','Activa',213,1,1),(9,'2024-04-09 18:16:57','Activa',324533,1,1),(10,'2024-04-09 18:18:31','Activa',34231,1,4),(11,'2024-04-09 18:19:32','Activa',1321,1,1),(12,'2024-04-09 18:21:39','Activa',2131,1,4),(13,'2024-04-09 18:22:34','Activa',13212,1,1),(14,'2024-04-09 18:26:22','Activa',23123,1,1),(15,'2024-04-09 18:29:25','Activa',21321,1,4),(16,'2024-04-09 18:34:03','Activa',1231,1,4),(17,'2024-04-09 18:35:59','Activa',1321321,1,1),(18,'2024-04-09 18:38:05','Activa',2131312,1,4),(19,'2024-04-09 18:38:35','Activa',123131,1,1),(20,'2024-04-09 18:42:11','Activa',2143123,1,4),(21,'2024-04-09 18:45:18','Activa',2131231,1,4),(22,'2024-04-09 18:46:12','Activa',2311,1,4),(23,'2024-04-09 18:47:16','Activa',123123,1,4),(24,'2024-04-09 18:47:57','Activa',2312131,1,4);
/*!40000 ALTER TABLE `contratacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) NOT NULL,
  `sector` varchar(40) NOT NULL,
  `ubicacion` varchar(40) NOT NULL,
  `contacto` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (1,'InterRapidísimo','Transporte logístico','Bogotá, Colombia','(604) 4562910');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacante`
--

DROP TABLE IF EXISTS `vacante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vacante` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(40) NOT NULL,
  `descripcion` text NOT NULL,
  `duracion` varchar(40) NOT NULL,
  `estado` varchar(40) NOT NULL,
  `empresa_id` int(11) NOT NULL,
  `tecnologia` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `empresa_id` (`empresa_id`),
  CONSTRAINT `vacante_ibfk_1` FOREIGN KEY (`empresa_id`) REFERENCES `empresa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacante`
--

LOCK TABLES `vacante` WRITE;
/*!40000 ALTER TABLE `vacante` DISABLE KEYS */;
INSERT INTO `vacante` VALUES (1,'Conductor/Ayudante','Realizar las entregas diarias dependiendo los pedidos disponibles para repartir','6 Meses','Inactivo',1,''),(2,'Desarrollador fron-end','Realizar ajuste, cambios y mejoras de nuevas interfaces que estén familiarizadas con los usuarios','Indefinido','Inactivo',1,'HTML, CSS, JS'),(3,'fafsas','asfadsa','sdadsa','Inactivo',1,'asda');
/*!40000 ALTER TABLE `vacante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'sistema_contratacion'
--

--
-- Dumping routines for database 'sistema_contratacion'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-09 13:55:47
