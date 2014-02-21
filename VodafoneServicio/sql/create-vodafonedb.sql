-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: vodafone
-- ------------------------------------------------------
-- Server version	5.0.51b-community-nt

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Not dumping tablespaces as no INFORMATION_SCHEMA.FILES table on this server
--

--
-- Current Database: `vodafone`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `vodafone` /*!40100 DEFAULT CHARACTER SET latin1 */;

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP
           ON vodafone.*
           TO asf@'%'
           IDENTIFIED BY 'asf';

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP
           ON vodafone.*
           TO asf@localhost
           IDENTIFIED BY 'asf';

USE `vodafone`;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `dni` varchar(8) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(45) default NULL,
  `email` varchar(45) default NULL,
  PRIMARY KEY  (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES ('111','Marta Lopez','C\\Iparraguirre 4','marta@gmail.com'),('222','Aitor Angulo','Avda. Madariaga 5, Bilbao','aitor@gmail.com'),('333','Monica Fernandez','C\\Correos 5, Portugalete','monica@gmail.com');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturas`
--

DROP TABLE IF EXISTS `facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facturas` (
  `idFactura` int(11) NOT NULL auto_increment,
  `fecha` varchar(10) NOT NULL,
  `periodo` varchar(45) default NULL,
  `importe` float NOT NULL,
  `telefono` varchar(15) NOT NULL,
  PRIMARY KEY  (`idFactura`),
  KEY `telefono` (`telefono`),
  CONSTRAINT `telefono` FOREIGN KEY (`telefono`) REFERENCES `lineas` (`telefono`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturas`
--

LOCK TABLES `facturas` WRITE;
/*!40000 ALTER TABLE `facturas` DISABLE KEYS */;
INSERT INTO `facturas` VALUES (1,'2011-07-08','Junio',140,'666111000'),(2,'2011-06-08','Mayo',95,'666111000'),(3,'2011-05-08','Abril',80,'666111000'),(4,'2011-06-10','Enero, Febrero, Marzo',200,'666111111'),(5,'2011-04-03','Enero',300,'666222000'),(6,'2011-05-03','Enero',300,'666222000'),(7,'2011-03-03','Enero',300,'666222000'),(8,'2011-03-03','Enero',300,'666222000');
/*!40000 ALTER TABLE `facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineas`
--

DROP TABLE IF EXISTS `lineas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lineas` (
  `telefono` varchar(15) NOT NULL,
  `antiguedad` varchar(10) default NULL,
  `activa` tinyint(1) NOT NULL,
  `tarifaVoz` varchar(45) default NULL,
  `tarifaDatos` varchar(45) default NULL,
  `promocion` varchar(100) default NULL,
  `dni` varchar(8) NOT NULL,
  PRIMARY KEY  (`telefono`),
  KEY `cliente` (`dni`),
  CONSTRAINT `dni` FOREIGN KEY (`dni`) REFERENCES `clientes` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineas`
--

LOCK TABLES `lineas` WRITE;
/*!40000 ALTER TABLE `lineas` DISABLE KEYS */;
INSERT INTO `lineas` VALUES ('666111000','2006-08-03',1,'@M','@M','Ninguna','111'),('666111111','2009-01-01',0,'Consumo','No','50% hasta 2012','111'),('666222000','2010-03-01',0,NULL,NULL,'Ninguna','222'),('666333000','2005-11-20',1,'@S','@S','Movil gratis en enero','333');
/*!40000 ALTER TABLE `lineas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `terminales`
--

DROP TABLE IF EXISTS `terminales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `terminales` (
  `idTerminal` varchar(10) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `precio` float NOT NULL,
  `promoOro` float default NULL,
  `promoPlata` float default NULL,
  `promoBronce` float default NULL,
  PRIMARY KEY  (`idTerminal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terminales`
--

LOCK TABLES `terminales` WRITE;
/*!40000 ALTER TABLE `terminales` DISABLE KEYS */;
INSERT INTO `terminales` VALUES ('1','Samsung','Galaxy S',300,29,89,169),('2','Apple','IPhone4',300,59,129,199),('3','HTC','HD7',250,0,39,99);
/*!40000 ALTER TABLE `terminales` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-12-29 20:23:50
