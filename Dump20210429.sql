-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: exchange
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `curs_valutar`
--

DROP TABLE IF EXISTS `curs_valutar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curs_valutar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cod_valuta` varchar(255) DEFAULT NULL,
  `rata` int(11) DEFAULT NULL,
  `curs` float DEFAULT NULL,
  `data_adaugare` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curs_valutar`
--

LOCK TABLES `curs_valutar` WRITE;
/*!40000 ALTER TABLE `curs_valutar` DISABLE KEYS */;
INSERT INTO `curs_valutar` VALUES (1,'KZH',1,11,'2021-04-29 11:58:49'),(2,'USD',3,18,'2021-04-29 11:59:31'),(3,'EUR',5,22,'2021-04-29 11:59:41'),(4,'KZM',5,12,'2021-04-29 15:21:44');
/*!40000 ALTER TABLE `curs_valutar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `numerar`
--

DROP TABLE IF EXISTS `numerar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `numerar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `curs_valutar_id` int(11) DEFAULT NULL,
  `operator_id` int(11) DEFAULT NULL,
  `suma_disponibila` int(11) DEFAULT NULL,
  `data_adaugare_numerar` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `curs_valutar_id` (`curs_valutar_id`),
  KEY `operator_id` (`operator_id`),
  CONSTRAINT `numerar_ibfk_1` FOREIGN KEY (`curs_valutar_id`) REFERENCES `curs_valutar` (`id`),
  CONSTRAINT `numerar_ibfk_2` FOREIGN KEY (`operator_id`) REFERENCES `operator` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `numerar`
--

LOCK TABLES `numerar` WRITE;
/*!40000 ALTER TABLE `numerar` DISABLE KEYS */;
INSERT INTO `numerar` VALUES (1,2,1,2323,'2021-04-29 13:50:56'),(2,3,2,5000,'2021-04-29 13:52:32');
/*!40000 ALTER TABLE `numerar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operator`
--

DROP TABLE IF EXISTS `operator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `nume` varchar(255) DEFAULT NULL,
  `prenume` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operator`
--

LOCK TABLES `operator` WRITE;
/*!40000 ALTER TABLE `operator` DISABLE KEYS */;
INSERT INTO `operator` VALUES (1,'oper1','Marina','Culacova'),(2,'oper2','Marina','Culacova'),(3,'oper2','Vasile','Popic'),(4,'oper3','Losi','Culer'),(5,'oper23','Losi','Vasile'),(6,'oper23','Lomonosov','Vasile');
/*!40000 ALTER TABLE `operator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schimb_valutar`
--

DROP TABLE IF EXISTS `schimb_valutar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schimb_valutar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `curs_valutar_id` int(11) DEFAULT NULL,
  `operator_id` int(11) DEFAULT NULL,
  `suma_primita` int(11) DEFAULT NULL,
  `suma_eliberata` int(11) DEFAULT NULL,
  `data_efectuare_operatiune` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `curs_valutar_id` (`curs_valutar_id`),
  KEY `operator_id` (`operator_id`),
  CONSTRAINT `schimb_valutar_ibfk_1` FOREIGN KEY (`curs_valutar_id`) REFERENCES `curs_valutar` (`id`),
  CONSTRAINT `schimb_valutar_ibfk_2` FOREIGN KEY (`operator_id`) REFERENCES `operator` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schimb_valutar`
--

LOCK TABLES `schimb_valutar` WRITE;
/*!40000 ALTER TABLE `schimb_valutar` DISABLE KEYS */;
INSERT INTO `schimb_valutar` VALUES (1,3,1,100,2200,'2021-04-29 15:20:04'),(2,3,1,2332,51304,'2021-04-29 15:20:48'),(3,3,1,122,2684,'2021-04-29 15:21:57'),(4,3,1,122,2684,'2021-04-29 15:34:33');
/*!40000 ALTER TABLE `schimb_valutar` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-29 15:53:47
