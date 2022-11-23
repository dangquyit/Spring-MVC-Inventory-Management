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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-23 12:40:10
