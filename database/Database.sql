CREATE DATABASE  IF NOT EXISTS `inventory_management` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `inventory_management`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: inventory_management
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `auth`
--

DROP TABLE IF EXISTS `auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auth` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  `permisstion` int(1) NOT NULL DEFAULT '1',
  `active_flag` int(1) NOT NULL DEFAULT '1',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `auth_roleid_foreign_key` (`role_id`),
  KEY `auth_menuid_foreign_key_idx` (`menu_id`),
  CONSTRAINT `auth_menuid_foreign_key` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `auth_roleid_foreign_key` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth`
--

LOCK TABLES `auth` WRITE;
/*!40000 ALTER TABLE `auth` DISABLE KEYS */;
INSERT INTO `auth` VALUES (1,1,1,1,1,'2022-09-05 15:24:11','2022-09-10 17:01:09'),(2,1,2,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(3,1,3,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(4,1,4,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(5,1,5,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(6,1,6,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(7,1,7,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(8,1,8,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(9,1,9,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(10,1,10,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(11,1,11,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(12,1,12,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(13,1,13,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(14,1,14,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(15,1,15,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(16,1,16,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(17,1,17,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(18,1,18,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(19,1,19,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(20,1,20,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(21,1,21,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(22,1,22,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(23,1,23,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(24,1,24,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(25,1,25,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(26,1,26,1,1,'2022-09-05 15:24:11','2022-09-05 15:24:11'),(27,1,27,1,1,'2022-09-09 07:09:03','2022-09-09 07:09:03'),(28,1,28,1,1,'2022-09-09 07:09:03','2022-09-09 07:09:03'),(29,1,29,1,1,'2022-09-09 07:09:03','2022-09-09 07:09:03'),(30,1,30,1,1,'2022-09-09 07:09:03','2022-09-09 07:09:03'),(31,1,31,1,1,'2022-09-09 10:58:45','2022-09-09 10:58:45'),(32,1,32,1,1,'2022-09-10 05:39:17','2022-09-10 05:39:17'),(33,1,33,1,1,'2022-09-10 05:39:17','2022-09-10 05:39:17'),(34,1,34,1,1,'2022-09-10 05:39:17','2022-09-10 05:39:17'),(35,1,35,1,1,'2022-09-10 05:39:17','2022-09-10 05:39:17'),(36,1,36,1,1,'2022-09-10 05:39:35','2022-09-10 05:39:35'),(37,1,37,1,1,'2022-09-10 14:09:22','2022-09-10 14:09:22'),(38,1,38,1,1,'2022-09-10 14:09:22','2022-09-10 14:09:22'),(39,1,39,1,1,'2022-09-10 15:41:48','2022-09-10 15:41:48'),(40,2,1,1,1,'2022-09-10 17:04:18','2022-09-10 17:04:18'),(41,2,4,1,1,'2022-09-10 17:05:41','2022-09-10 17:05:41'),(42,1,40,1,1,'2022-09-11 15:05:56','2022-09-11 15:05:56'),(43,1,41,1,1,'2022-09-11 15:52:24','2022-09-11 15:52:24'),(44,1,42,1,1,'2022-09-11 16:01:14','2022-09-11 16:01:14'),(45,1,43,1,1,'2022-09-11 16:01:14','2022-09-11 16:01:14'),(46,1,44,1,1,'2022-09-12 00:59:10','2022-09-12 00:59:10'),(47,1,45,1,1,'2022-09-12 01:02:52','2022-09-12 01:02:52');
/*!40000 ALTER TABLE `auth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `code` varchar(50) CHARACTER SET utf8 NOT NULL,
  `description` text CHARACTER SET utf8,
  `active_flag` int(1) NOT NULL DEFAULT '1',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Iphone 11 USA','IP11','Iphone 11 From USA',1,'2022-08-31 09:55:17','2022-08-31 09:55:17'),(2,'Iphone 11 Pro Max USA','IP11PR','Iphone 11 Pro Max From USA',1,'2022-08-31 09:55:50','2022-11-03 10:33:29'),(3,'Iphone 5 USA','IP5','Iphone 5 From USA',1,'2022-08-31 09:56:32','2022-08-31 09:56:32'),(4,'Iphone 6 USA','IP6','Iphone 6 From USA',1,'2022-08-31 09:56:56','2022-08-31 09:56:56'),(5,'Iphone 7 USA','akjdhskáº¡káº¡lsakjhd','Iphone 7 From USA',1,'2022-08-31 09:57:35','2022-11-03 11:12:58'),(6,'Iphone 12 USA','IP12','Iphone 12 From USA',1,'2022-08-31 09:57:58','2022-08-31 09:57:58'),(7,'Iphone 13 USA','IP13','Iphone 13 From USA',1,'2022-08-31 09:58:28','2022-08-31 09:58:28'),(8,'Buá»n ngá»§','Buá»n ngá»§ quÃ¡ tÃ¬m ko ra lá»i','Buá»n ngá»§',1,'2022-09-12 06:56:17','2022-09-12 06:56:17'),(9,'Buá»n ngá»§','Buá»n ngá»§','Buá»n ngá»§',1,'2022-09-12 06:58:44','2022-09-12 06:58:44'),(10,'buon ngu','buon ngu','buon ngu',1,'2022-09-12 07:01:40','2022-09-12 07:01:40'),(11,'fix bug','fix bug','fix bug',1,'2022-09-12 07:50:25','2022-09-12 07:50:25'),(12,'test','e744772a-bb5a-40e4-a878-91c27d904a13','test',1,'2022-11-03 06:18:18','2022-11-03 06:18:18'),(13,',m,mb','8af34ed2-1129-45','kjhj',1,'2022-11-03 08:45:25','2022-11-03 08:45:25'),(14,'test 3','1234','test 3',1,'2022-11-03 10:26:28','2022-11-03 10:33:51'),(15,'admin','8c77720a-c0ae-4f','1234',0,'2022-11-03 10:35:08','2022-11-03 10:35:19');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `action_name` varchar(100) NOT NULL,
  `type` int(1) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` decimal(15,2) NOT NULL,
  `active_flag` int(1) NOT NULL DEFAULT '1',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `history_product_id_foreign_key` (`product_id`),
  CONSTRAINT `history_product_id_foreign_key` FOREIGN KEY (`product_id`) REFERENCES `product_info` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES (1,'Add',1,1,5,2000000.00,1,'2022-09-07 09:38:53','2022-09-07 09:38:53'),(2,'Add',1,1,3,2000000.00,1,'2022-09-07 09:48:38','2022-09-07 09:48:38'),(11,'Add',1,1,4,2500000.00,1,'2022-09-07 11:04:26','2022-09-07 11:04:26'),(15,'Add',1,1,3,2500000.00,1,'2022-09-08 14:02:57','2022-09-08 14:02:57'),(16,'Add',1,3,3,15000000.00,1,'2022-09-10 03:33:50','2022-09-10 03:33:50'),(17,'Add',1,2,3,9860000.00,1,'2022-09-10 03:35:06','2022-09-10 03:35:06'),(18,'Add',1,2,5,9860000.00,1,'2022-09-10 03:50:04','2022-09-10 03:50:04'),(19,'Edit',0,1,7,2000000.00,1,'2022-09-11 15:14:01','2022-09-11 15:14:01'),(20,'Edit',1,1,3,2000000.00,1,'2022-09-11 15:20:22','2022-09-11 15:20:22'),(21,'Edit',1,1,2,2000000.00,1,'2022-09-11 15:36:22','2022-09-11 15:36:22'),(22,'Edit',1,1,5,2000000.00,1,'2022-09-11 15:37:15','2022-09-11 15:37:15'),(23,'Edit',1,1,4,2000000.00,1,'2022-09-11 15:37:42','2022-09-11 15:37:42'),(24,'Add',2,1,5,2500000.00,1,'2022-09-11 16:02:03','2022-09-11 16:02:03'),(25,'Edit',2,1,5,2900000.00,1,'2022-09-12 01:16:54','2022-09-12 01:16:54'),(26,'Edit',2,1,2,2900000.00,1,'2022-09-12 01:19:26','2022-09-12 01:19:26'),(27,'Add',1,1,3,2900000.00,1,'2022-09-12 01:48:00','2022-09-12 01:48:00'),(28,'Add',1,1,10,3000000.00,1,'2022-09-12 01:48:29','2022-09-12 01:48:29'),(29,'Add',2,1,3,3500000.00,1,'2022-09-12 01:50:08','2022-09-12 01:50:08'),(30,'Edit',2,1,4,3500000.00,1,'2022-09-12 01:56:08','2022-09-12 01:56:08'),(31,'Edit',2,1,5,3500000.00,1,'2022-09-12 01:56:23','2022-09-12 01:56:23'),(32,'Edit',1,1,6,2000000.00,1,'2022-09-12 01:59:25','2022-09-12 01:59:25'),(33,'Edit',1,1,5,2000000.00,1,'2022-09-12 02:00:08','2022-09-12 02:00:08'),(34,'Edit',1,1,5,5000000.00,1,'2022-09-12 02:02:18','2022-09-12 02:02:18'),(35,'Edit',2,1,5,2900000.00,1,'2022-09-12 02:22:59','2022-09-12 02:22:59'),(36,'Edit',2,1,4,2900000.00,1,'2022-09-12 02:23:10','2022-09-12 02:23:10'),(37,'Edit',1,1,5,2800000.00,1,'2022-09-12 02:24:42','2022-09-12 02:24:42'),(38,'Edit',1,1,5,1000000.00,1,'2022-09-12 03:26:30','2022-09-12 03:26:30'),(39,'Edit',1,1,5,1500000.00,1,'2022-09-12 03:28:14','2022-09-12 03:28:14'),(40,'Add',1,1,4,5000000.00,1,'2022-09-12 03:29:05','2022-09-12 03:29:05'),(45,'Add',1,1,3,9000000.00,1,'2022-09-12 04:00:53','2022-09-12 04:00:53'),(46,'Edit',1,1,5,3000000.00,1,'2022-09-12 04:01:22','2022-09-12 04:01:22'),(47,'Edit',1,1,8,3000000.00,1,'2022-09-12 04:28:12','2022-09-12 04:28:12'),(48,'Edit',1,1,2,3000000.00,1,'2022-09-12 04:30:36','2022-09-12 04:30:36'),(49,'Edit',1,1,3,3000000.00,1,'2022-09-12 04:32:54','2022-09-12 04:32:54'),(50,'Edit',1,1,6,3000000.00,1,'2022-09-12 04:34:49','2022-09-12 04:34:49'),(51,'Edit',1,1,11,3000000.00,1,'2022-09-12 04:35:09','2022-09-12 04:35:09'),(52,'Add',2,1,20,50000000.00,1,'2022-09-12 04:35:53','2022-09-12 04:35:53'),(53,'Add',1,1,20,3000000.00,1,'2022-09-12 04:38:13','2022-09-12 04:38:13'),(54,'Edit',1,1,5,2000000.00,1,'2022-09-12 04:39:51','2022-09-12 04:39:51'),(55,'Edit',2,1,6,2900000.00,1,'2022-09-12 05:15:21','2022-09-12 05:15:21'),(56,'Edit',2,1,7,2900000.00,1,'2022-09-12 05:15:46','2022-09-12 05:15:46'),(57,'Edit',2,1,12,2900000.00,1,'2022-09-12 05:16:05','2022-09-12 05:16:05'),(58,'Add',1,4,2,5500000.00,1,'2022-09-12 05:18:23','2022-09-12 05:18:23'),(59,'Add',2,4,1,6000000.00,1,'2022-09-12 05:19:00','2022-09-12 05:19:00'),(60,'Add',1,4,5,7000000.00,1,'2022-09-12 05:19:31','2022-09-12 05:19:31'),(61,'Edit',1,1,4,7000000.00,1,'2022-09-12 05:20:24','2022-09-12 05:20:24'),(62,'Edit',1,1,3,7000000.00,1,'2022-09-12 05:20:50','2022-09-12 05:20:50'),(63,'Add',1,4,5,7000000.00,1,'2022-09-12 05:24:25','2022-09-12 05:24:25'),(64,'Edit',1,1,4,7000000.00,1,'2022-09-12 05:25:55','2022-09-12 05:25:55'),(65,'Add',1,4,2,6000000.00,1,'2022-09-12 05:26:42','2022-09-12 05:26:42'),(66,'Add',1,2,100,3000000.00,1,'2022-09-12 05:33:52','2022-09-12 05:33:52'),(67,'Edit',1,4,3,7000000.00,1,'2022-09-12 05:34:37','2022-09-12 05:34:37'),(68,'Edit',1,4,4,7000000.00,1,'2022-09-12 05:35:03','2022-09-12 05:35:03'),(69,'Edit',1,4,1,6000000.00,1,'2022-09-12 05:37:29','2022-09-12 05:37:29'),(70,'Add',2,4,8000000,10.00,1,'2022-09-12 05:38:02','2022-09-12 05:38:02'),(71,'Add',2,4,1,8000000.00,1,'2022-09-12 05:39:12','2022-09-12 05:39:12'),(72,'Edit',2,1,2,8000000.00,1,'2022-09-12 05:39:37','2022-09-12 05:39:37'),(73,'Edit',2,4,1,8000000.00,1,'2022-09-12 05:40:10','2022-09-12 05:40:10'),(74,'Add',1,5,50,20000000.00,1,'2022-09-12 05:42:18','2022-09-12 05:42:18'),(75,'Edit',1,5,48,20000000.00,1,'2022-09-12 05:42:59','2022-09-12 05:42:59'),(76,'Edit',1,5,52,20000000.00,1,'2022-09-12 05:43:15','2022-09-12 05:43:15'),(77,'Add',2,5,2,25000000.00,1,'2022-09-12 05:43:44','2022-09-12 05:43:44'),(78,'Edit',2,1,5,25000000.00,1,'2022-09-12 05:44:02','2022-09-12 05:44:02'),(79,'Edit',2,5,5,25000000.00,1,'2022-09-12 05:44:18','2022-09-12 05:44:18'),(80,'Add',2,5,2,20500000.00,1,'2022-09-12 05:44:50','2022-09-12 05:44:50'),(81,'Edit',2,5,4,20500000.00,1,'2022-09-12 05:45:23','2022-09-12 05:45:23'),(82,'Edit',2,5,4,20500000.00,1,'2022-09-12 05:47:05','2022-09-12 05:47:05'),(83,'Edit',2,1,6,20500000.00,1,'2022-09-12 05:47:20','2022-09-12 05:47:20'),(84,'Edit',2,5,6,20500000.00,1,'2022-09-12 05:47:39','2022-09-12 05:47:39'),(85,'Add',1,5,3,9000000.00,1,'2022-09-12 06:00:53','2022-09-12 06:00:53'),(86,'Add',1,5,3,123212.00,1,'2022-09-12 06:08:58','2022-09-12 06:08:58'),(87,'Add',1,6,5,100000.00,1,'2022-09-12 07:02:38','2022-09-12 07:02:38'),(88,'Edit',1,6,3,100000.00,1,'2022-09-12 07:04:07','2022-09-12 07:04:07'),(89,'Edit',1,6,6,100000.00,1,'2022-09-12 07:04:22','2022-09-12 07:04:22'),(90,'Add',1,6,6,200000.00,1,'2022-09-12 07:04:41','2022-09-12 07:04:41'),(91,'Edit',1,6,5,100000.00,1,'2022-09-12 07:04:55','2022-09-12 07:04:55'),(92,'Add',2,6,3,300000.00,1,'2022-09-12 07:05:30','2022-09-12 07:05:30'),(93,'Edit',2,6,4,300000.00,1,'2022-09-12 07:05:55','2022-09-12 07:05:55'),(94,'Edit',2,6,2,300000.00,1,'2022-09-12 07:06:36','2022-09-12 07:06:36'),(95,'Edit',2,6,3,300000.00,1,'2022-09-12 07:20:42','2022-09-12 07:20:42'),(96,'Edit',2,6,2,300000.00,1,'2022-09-12 07:41:20','2022-09-12 07:41:20'),(97,'Edit',2,6,5,300000.00,1,'2022-09-12 07:42:58','2022-09-12 07:42:58'),(98,'Edit',1,6,12,200000.00,1,'2022-09-12 07:44:34','2022-09-12 07:44:34'),(99,'Edit',1,6,2,200000.00,1,'2022-09-12 07:44:52','2022-09-12 07:44:52'),(100,'Add',1,7,10,100000.00,1,'2022-09-12 07:51:55','2022-09-12 07:51:55'),(101,'Edit',1,7,11,100000.00,1,'2022-09-12 07:52:41','2022-09-12 07:52:41'),(102,'Edit',1,7,3,100000.00,1,'2022-09-12 07:52:56','2022-09-12 07:52:56'),(103,'Add',1,7,3,200000.00,1,'2022-09-12 07:57:49','2022-09-12 07:57:49'),(104,'Add',2,7,7,2500000.00,1,'2022-09-12 08:11:28','2022-09-12 08:11:28'),(105,'Add',2,7,1,23232.00,1,'2022-09-12 08:24:13','2022-09-12 08:24:13'),(106,'Add',1,7,10,1231312.00,1,'2022-09-12 08:24:34','2022-09-12 08:24:34'),(107,'Add',2,7,4,123.00,1,'2022-09-12 08:24:46','2022-09-12 08:24:46'),(108,'Edit',2,7,3,123.00,1,'2022-09-12 08:25:06','2022-09-12 08:25:06'),(109,'Edit',1,1,20,3000000.00,1,'2022-09-12 08:28:29','2022-09-12 08:28:29'),(110,'Edit',1,1,20,3000000.00,1,'2022-09-12 08:35:55','2022-09-12 08:35:55'),(111,'Edit',2,7,8,123.00,1,'2022-09-12 11:28:11','2022-09-12 11:28:11'),(112,'Edit',2,7,2,123.00,1,'2022-09-12 11:31:23','2022-09-12 11:31:23'),(113,'Edit',2,7,2,123.00,1,'2022-09-12 11:37:42','2022-09-12 11:37:42'),(114,'Edit',2,7,4,123.00,1,'2022-09-12 11:38:04','2022-09-12 11:38:04'),(115,'Edit',2,7,7,123.00,1,'2022-09-12 11:38:26','2022-09-12 11:38:26'),(116,'Add',2,5,108,5000000.00,1,'2022-09-12 11:47:34','2022-09-12 11:47:34'),(117,'Add',2,7,2,2342342.00,1,'2022-09-12 11:49:39','2022-09-12 11:49:39'),(118,'Edit',2,7,6,2342342.00,1,'2022-09-12 11:57:35','2022-09-12 11:57:35'),(119,'Add',2,2,108,2500000.00,1,'2022-09-12 12:15:59','2022-09-12 12:15:59'),(120,'Edit',2,2,109,2500000.00,1,'2022-09-12 12:16:27','2022-09-12 12:16:27'),(121,'Edit',2,2,107,2500000.00,1,'2022-09-12 12:16:39','2022-09-12 12:16:39'),(122,'Edit',2,4,5,10.00,1,'2022-09-12 12:27:06','2022-09-12 12:27:06'),(123,'Add',1,7,5,55555555555.00,1,'2022-09-18 11:29:47','2022-09-18 11:29:47'),(124,'Add',1,5,53,1233333.00,1,'2022-09-18 11:30:50','2022-09-18 11:30:50'),(125,'Edit',2,2,107,2500000.00,1,'2022-09-18 11:31:58','2022-09-18 11:31:58'),(126,'Edit',2,1,65,2900000.00,1,'2022-09-18 11:32:22','2022-09-18 11:32:22'),(127,'Add',2,3,1,1000000.00,1,'2022-09-18 11:41:53','2022-09-18 11:41:53'),(128,'Edit',2,3,4,1000000.00,1,'2022-09-18 11:42:17','2022-09-18 11:42:17'),(129,'Add',2,4,7999980,10000000.00,1,'2022-09-18 11:46:52','2022-09-18 11:46:52'),(130,'Edit',2,4,7999996,10000000.00,1,'2022-09-18 11:51:00','2022-09-18 11:51:00'),(131,'Edit',2,2,108,2500000.00,1,'2022-09-18 11:55:28','2022-09-18 11:55:28'),(132,'Edit',2,3,3,1000000.00,1,'2022-09-18 12:20:42','2022-09-18 12:20:42'),(133,'Add',2,7,4,10000.00,1,'2022-11-03 05:31:45','2022-11-03 05:31:45'),(134,'Add',1,1,100,10000000.00,1,'2022-11-04 03:19:57','2022-11-04 03:19:57'),(135,'Add',2,1,90,123.00,1,'2022-11-04 03:20:38','2022-11-04 03:20:38'),(136,'Add',2,1,11,123.00,1,'2022-11-04 03:33:34','2022-11-04 03:33:34'),(137,'Add',2,1,11,1234.00,1,'2022-11-04 03:38:08','2022-11-04 03:38:08');
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL,
  `type` int(1) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` decimal(15,2) NOT NULL,
  `active_flag` int(1) NOT NULL DEFAULT '1',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `invoice_product_id_foreign_key` (`product_id`),
  CONSTRAINT `invoice_product_id_foreign_key` FOREIGN KEY (`product_id`) REFERENCES `product_info` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (3,'AP1',1,1,20,3000000.00,1,'2022-09-07 09:38:53','2022-09-12 08:35:55'),(4,'APPLE1',1,1,5,2000000.00,1,'2022-09-07 09:48:38','2022-09-12 04:39:51'),(13,'APPLE2',1,1,4,2500000.00,1,'2022-09-07 11:04:26','2022-09-07 11:04:26'),(17,'AP',1,1,3,2500000.00,1,'2022-09-08 14:02:57','2022-09-08 14:02:57'),(18,'APPLE',1,3,3,15000000.00,1,'2022-09-10 03:33:50','2022-09-10 03:33:50'),(19,'APPLE11',1,2,3,9860000.00,1,'2022-09-10 03:35:06','2022-09-10 03:35:06'),(20,'IP11',1,2,5,9860000.00,1,'2022-09-10 03:50:04','2022-09-10 03:50:04'),(21,'XP',2,1,65,2900000.00,1,'2022-09-11 16:02:03','2022-09-18 11:32:22'),(22,'AP123',1,1,3,2900000.00,1,'2022-09-12 01:48:00','2022-09-12 01:48:00'),(23,'AP11114',1,1,10,3000000.00,1,'2022-09-12 01:48:29','2022-09-12 01:48:29'),(24,'AP3M5',2,1,5,3500000.00,1,'2022-09-12 01:50:08','2022-09-12 01:56:23'),(25,'ADS',1,1,4,5000000.00,1,'2022-09-12 03:29:05','2022-09-12 03:29:05'),(30,'IPCUI',1,1,3,9000000.00,1,'2022-09-12 04:00:53','2022-09-12 04:00:53'),(31,'IP50',2,1,20,50000000.00,1,'2022-09-12 04:35:53','2022-09-12 04:35:53'),(32,'AP675',1,1,20,3000000.00,1,'2022-09-12 04:38:13','2022-09-12 04:38:13'),(33,'AP7',1,4,2,5500000.00,1,'2022-09-12 05:18:23','2022-09-12 05:18:23'),(34,'EX7',2,4,1,6000000.00,1,'2022-09-12 05:19:00','2022-09-12 05:19:00'),(35,'APPLE7',1,4,3,7000000.00,1,'2022-09-12 05:19:31','2022-09-12 05:34:37'),(36,'AP7PL',1,4,4,7000000.00,1,'2022-09-12 05:24:25','2022-09-12 05:35:03'),(37,'APPL',1,4,1,6000000.00,1,'2022-09-12 05:26:42','2022-09-12 05:37:29'),(38,'142jn',1,2,100,3000000.00,1,'2022-09-12 05:33:52','2022-09-12 05:33:52'),(39,'hbhb',2,4,5,10.00,1,'2022-09-12 05:38:02','2022-09-12 12:27:06'),(40,'45jg',2,4,1,8000000.00,1,'2022-09-12 05:39:12','2022-09-12 05:40:10'),(41,'APPLEbn',1,5,52,20000000.00,1,'2022-09-12 05:42:18','2022-09-12 05:43:15'),(42,'APPLEEX11',2,5,5,25000000.00,1,'2022-09-12 05:43:44','2022-09-12 05:44:18'),(43,'APPLE23123121',2,5,6,20500000.00,1,'2022-09-12 05:44:50','2022-09-12 05:47:39'),(44,'12312kn',1,5,3,9000000.00,1,'2022-09-12 06:00:53','2022-09-12 06:00:53'),(45,'rewfwe',1,5,3,123212.00,1,'2022-09-12 06:08:58','2022-09-12 06:08:58'),(46,'buon ngu',1,6,5,100000.00,1,'2022-09-12 07:02:38','2022-09-12 07:04:55'),(47,'buon ngu 1',1,6,2,200000.00,1,'2022-09-12 07:04:41','2022-09-12 07:44:52'),(48,'buon ngu 3',2,6,5,300000.00,1,'2022-09-12 07:05:30','2022-09-12 07:42:58'),(49,'fix bug',1,7,3,100000.00,1,'2022-09-12 07:51:55','2022-09-12 07:52:56'),(50,'fix bug 1',1,7,3,200000.00,1,'2022-09-12 07:57:49','2022-09-12 07:57:49'),(51,'adls;k',2,7,7,2500000.00,1,'2022-09-12 08:11:28','2022-09-12 08:11:28'),(52,'damn',2,7,1,23232.00,1,'2022-09-12 08:24:13','2022-09-12 08:24:13'),(53,'ewqdkl',1,7,10,1231312.00,1,'2022-09-12 08:24:34','2022-09-12 08:24:34'),(54,'41231',2,7,7,123.00,1,'2022-09-12 08:24:46','2022-09-12 11:38:26'),(55,'APPLEqea',2,5,108,5000000.00,1,'2022-09-12 11:47:34','2022-09-12 11:47:34'),(56,'1232dw',2,7,6,2342342.00,1,'2022-09-12 11:49:39','2022-09-12 11:57:35'),(57,'esffds',2,2,108,2500000.00,1,'2022-09-12 12:15:59','2022-09-18 11:55:28'),(58,'eert',1,7,5,55555555555.00,1,'2022-09-18 11:29:47','2022-09-18 11:29:47'),(59,'addsad',1,5,53,1233333.00,1,'2022-09-18 11:30:50','2022-09-18 11:30:50'),(60,'231ds',2,3,3,1000000.00,1,'2022-09-18 11:41:53','2022-09-18 12:20:42'),(61,'100000',2,4,7999996,10000000.00,1,'2022-09-18 11:46:52','2022-09-18 11:51:00'),(62,'ijeoifj',2,7,4,10000.00,1,'2022-11-03 05:31:45','2022-11-03 05:31:45'),(63,'123asds',1,1,100,10000000.00,1,'2022-11-04 03:19:57','2022-11-04 03:19:57'),(64,'234',2,1,90,123.00,1,'2022-11-04 03:20:38','2022-11-04 03:20:38'),(65,'123lnlkn',2,1,11,123.00,1,'2022-11-04 03:33:34','2022-11-04 03:33:34'),(66,'123',2,1,11,1234.00,1,'2022-11-04 03:38:08','2022-11-04 03:38:08');
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL,
  `url` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `order_index` int(1) NOT NULL DEFAULT '0',
  `active_flag` int(1) NOT NULL DEFAULT '1',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,0,'/product','Sản phẩm',1,1,'2022-09-05 15:23:21','2022-11-03 05:39:40'),(2,0,'/stock','Kho',2,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(3,0,'/management','Quản lý',3,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(4,1,'/product-info/list','Danh sách sản phẩm',2,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(5,1,'/category/list','Danh sách category',1,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(6,1,'/category/edit','Sửa',-1,1,'2022-09-05 15:23:21','2022-09-10 16:14:17'),(7,1,'/category/view','Xem',-1,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(8,1,'/category/add','Thêm mới',-1,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(9,1,'/category/save','Lưu',-1,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(10,1,'/category/delete','Xoá',-1,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(11,1,'/product-info/edit','Sửa',-1,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(12,1,'/product-info/view','Xem',-1,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(13,1,'/product-info/add','Thêm mới',-1,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(14,1,'/product-info/save','Lưu',-1,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(15,1,'/product-info/delete','Xoá',-1,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(16,2,'/goods-receipt/list','Danh sách nhập kho',1,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(17,2,'/goods-receipt/view','Xem',-1,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(18,2,'/goods-receipt/add','Thêm mới',-1,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(19,2,'/goods-receipt/save','Lưu',-1,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(20,2,'/goods-receipt/export','Xuất báo cáo',-1,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(21,2,'/goods-issue/list','Danh sách xuất kho',2,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(22,2,'/product-in-stock/list','Sản phẩm trong kho',3,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(23,2,'/history/list','Lịch sử kho',4,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(24,3,'/user/list','Danh sách user',1,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(25,3,'/menu/list','Danh sách menu',2,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(26,3,'/role/list','Danh sách quyền',3,1,'2022-09-05 15:23:21','2022-09-05 15:23:21'),(27,3,'/user/save','Save',-1,1,'2022-09-09 07:06:53','2022-09-09 07:06:53'),(28,3,'/user/edit','Edit',-1,1,'2022-09-09 07:06:53','2022-09-09 07:06:53'),(29,3,'/user/view','View',-1,1,'2022-09-09 07:06:53','2022-09-09 07:06:53'),(30,3,'/user/add','Add',-1,1,'2022-09-09 07:06:53','2022-09-09 07:06:53'),(31,3,'/user/delete','Delete',-1,1,'2022-09-09 10:58:32','2022-09-09 10:58:32'),(32,3,'/role/view','View',-1,1,'2022-09-10 05:38:20','2022-09-10 05:38:20'),(33,3,'/role/edit','Edit',-1,1,'2022-09-10 05:38:20','2022-09-10 05:38:20'),(34,3,'/role/add','Add',-1,1,'2022-09-10 05:38:20','2022-09-10 05:38:20'),(35,3,'/role/delete','Delete',-1,1,'2022-09-10 05:38:20','2022-09-10 05:38:20'),(36,3,'/role/save','Save',-1,1,'2022-09-10 05:38:45','2022-09-10 05:38:45'),(37,3,'/menu/change-status','Update',-1,1,'2022-09-10 14:07:43','2022-09-10 14:07:43'),(38,3,'/menu/update-permission','Update',-1,1,'2022-09-10 14:07:43','2022-09-10 14:07:43'),(39,3,'/menu/permission','Permission',-1,1,'2022-09-10 15:17:23','2022-09-10 15:17:23'),(40,2,'/goods-receipt/edit','Edit',-1,1,'2022-09-11 15:04:45','2022-09-11 15:04:45'),(41,2,'/goods-issue/add','Add',-1,1,'2022-09-11 15:52:05','2022-09-11 15:52:05'),(42,2,'/goods-issue/view','View',-1,1,'2022-09-11 16:00:45','2022-09-11 16:00:45'),(43,2,'/goods-issue/save','Save',-1,1,'2022-09-11 16:00:45','2022-09-11 16:00:45'),(44,2,'/goods-issue/export','Xuất báo cáo',-1,1,'2022-09-12 00:58:45','2022-09-12 00:58:45'),(45,2,'/goods-issue/edit','Edit',-1,1,'2022-09-12 01:02:24','2022-09-12 01:02:24');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_in_stock`
--

DROP TABLE IF EXISTS `product_in_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_in_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` decimal(15,2) NOT NULL,
  `active_flag` int(1) NOT NULL DEFAULT '1',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `product_id_foreign_key` (`product_id`),
  CONSTRAINT `product_id_foreign_key` FOREIGN KEY (`product_id`) REFERENCES `product_info` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_in_stock`
--

LOCK TABLES `product_in_stock` WRITE;
/*!40000 ALTER TABLE `product_in_stock` DISABLE KEYS */;
INSERT INTO `product_in_stock` VALUES (1,1,-1,10000000.00,1,'2022-09-07 11:04:26','2022-11-04 03:38:08'),(2,3,0,15000000.00,1,'2022-09-10 03:33:50','2022-09-18 12:20:42'),(3,2,0,3000000.00,1,'2022-09-10 03:35:06','2022-09-18 11:55:28'),(4,4,-1,6000000.00,1,'2022-09-12 05:18:23','2022-09-18 11:51:00'),(5,5,1,1233333.00,1,'2022-09-12 05:42:18','2022-09-18 11:30:50'),(6,6,0,200000.00,1,'2022-09-12 07:02:38','2022-09-12 07:44:52'),(7,7,-1,55555555555.00,1,'2022-09-12 07:51:55','2022-11-03 05:31:45');
/*!40000 ALTER TABLE `product_in_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_info`
--

DROP TABLE IF EXISTS `product_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `code` varchar(50) NOT NULL,
  `description` text,
  `img_url` varchar(200) NOT NULL,
  `active_flag` int(1) NOT NULL DEFAULT '1',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `category_id_foreign_key` (`category_id`),
  CONSTRAINT `category_id_foreign_key` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_info`
--

LOCK TABLES `product_info` WRITE;
/*!40000 ALTER TABLE `product_info` DISABLE KEYS */;
INSERT INTO `product_info` VALUES (1,3,'Iphone 5 Gold','IP5GOLD','Iphone 5 gold color from USA','/upload/1661940062301_apple_iphone_5_vang.png',1,'2022-08-31 10:01:02','2022-08-31 10:02:33'),(2,1,'Iphone 11 Black','IP11BLACK','Iphone 11 back color from USA','/upload/1661940136359_iphone_11_black.png',1,'2022-08-31 10:02:16','2022-08-31 10:02:16'),(3,6,'Iphone 12 Red','IP12RED','Iphone 12 red color from USA\r\n','/upload/1661940192531_iphone_12_red.png',1,'2022-08-31 10:03:13','2022-08-31 10:03:13'),(4,5,'Iphone 7 Gold','IP7GOLD','Iphone 7 gold color from USA','/upload/1661940443643_iphone_7_gold.png',1,'2022-08-31 10:05:01','2022-08-31 10:07:24'),(5,2,'Iphone 11 Pro Max','APPLEUSA','ygh','/upload/1662961319142_xiaomi_redmi_note_11.png',1,'2022-09-12 05:41:59','2022-09-12 05:41:59'),(6,10,'buon ngu','buon ngu','buon ngu','/upload/1662966128898_cach-chong-buon-ngu-3.jpg',1,'2022-09-12 07:02:09','2022-09-12 07:02:09'),(7,11,'fix bug','fix bug','fix bug','/upload/1662969078950_6-buoc-don-gian-chan-doan-loi-he-thong-mang-2.jpg',1,'2022-09-12 07:51:19','2022-09-12 07:51:19');
/*!40000 ALTER TABLE `product_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  `description` varchar(200) NOT NULL,
  `active_flag` int(1) NOT NULL DEFAULT '1',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin','Admin of system',1,'2022-08-31 09:49:03','2022-09-10 06:40:13'),(2,'BA','BA of system',1,'2022-08-31 09:49:03','2022-09-10 06:42:19'),(3,'employee','Employee of system',1,'2022-08-31 09:49:03','2022-09-10 06:29:49'),(4,'manager','Manager of system',1,'2022-08-31 09:49:03','2022-09-10 06:48:44'),(5,'HR','HR of system',1,'2022-09-10 06:41:16','2022-09-10 06:47:23');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `active_flag` int(1) NOT NULL DEFAULT '1',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `userid_foreign_key` (`user_id`),
  KEY `roleid_foreign_key` (`role_id`),
  CONSTRAINT `roleid_foreign_key` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `userid_foreign_key` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1,1,'2022-08-31 09:50:59','2022-09-18 11:14:50'),(2,2,2,1,'2022-09-09 10:48:15','2022-10-01 04:54:36'),(3,3,1,1,'2022-09-09 11:15:52','2022-09-09 11:15:52'),(4,4,2,1,'2022-09-10 02:54:59','2022-09-10 02:54:59'),(5,5,2,1,'2022-09-10 17:00:38','2022-09-10 17:00:38');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `active_flag` int(1) NOT NULL DEFAULT '1',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','T7IaJPtdeF15b+ONqJ1JeuhCkeSN11Se','admin@gmail.com','Admin',1,'2022-08-31 09:48:39','2022-09-09 10:59:38'),(2,'dangquyitt','T7IaJPtdeF15b+ONqJ1JeuhCkeSN11Se','dangquyitt@gmail.com','Nguyen Dang Quy',1,'2022-09-09 10:48:15','2022-10-01 04:54:36'),(3,'Do Duc Phong','T7IaJPtdeF15b+ONqJ1JeuhCkeSN11Se','doducphong123123123@gmail.com','Do Duc Phong',1,'2022-09-09 11:15:52','2022-09-09 11:15:52'),(4,'tuanhung','gpaLLq1sZSPvwRQ6xApGgG+LKziOBmlx','tuanhung@gmail.com','Vo Tuan Hung',1,'2022-09-10 02:54:59','2022-09-10 02:54:59'),(5,'employee','T7IaJPtdeF15b+ONqJ1JeuhCkeSN11Se','employee@gmail.com','Employee',1,'2022-09-10 17:00:38','2022-09-10 17:00:38');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'inventory_management'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-23 13:32:21
