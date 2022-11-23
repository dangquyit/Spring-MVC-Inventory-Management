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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-23 12:40:10
