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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-23 12:40:10
