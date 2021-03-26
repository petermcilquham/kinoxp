CREATE DATABASE  IF NOT EXISTS `kinoxp` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `kinoxp`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: kinoxp
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `shows`
--

DROP TABLE IF EXISTS `shows`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shows` (
  `show_id` int NOT NULL AUTO_INCREMENT,
  `movie_title` varchar(255) NOT NULL,
  `cinema_hall` int NOT NULL,
  `date` date NOT NULL,
  `start_time` time NOT NULL,
  `duration` time NOT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `age_req` int DEFAULT NULL,
  `stars` varchar(500) DEFAULT NULL,
  `movie_img` blob,
  PRIMARY KEY (`show_id`),
  UNIQUE KEY `show_id_UNIQUE` (`show_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shows`
--

LOCK TABLES `shows` WRITE;
/*!40000 ALTER TABLE `shows` DISABLE KEYS */;
INSERT INTO `shows` VALUES (1,'Jaws 9',1,'2021-03-18','16:30:00','01:35:00','Horror',12,'Jackie Chan, Helena Bonham Carter, The Rock',NULL),(2,'The Fast & the Furious 12',2,'2021-04-02','20:00:00','02:05:00','Action',7,'The Rock, John Statham',NULL),(3,'Zorro 3',1,'2021-06-07','17:30:00','01:45:00','Action',7,'Catarina Zeta-Jones, Anthony Hopkins, Antonio Banderas, The Rock',NULL),(4,'Generic Christmas Movie nr. 7198',2,'2021-11-20','18:00:00','01:32:00','Romantic, Family',0,'Hugh Grant, Liam Neeson, The Rock, Bill Nighy, Colin Firth, Emma Thompson',NULL),(5,'Murder on the Orient Express',2,'2021-04-02','18:30:00','02:10:00','Mystik',8,'Hercule Poirot, Chris Hemsworth, The Rock, Julia Roberts',NULL),(6,'Adam er Væk!',1,'2021-03-18','14:30:00','00:15:00','Horror',21,'Adam, The Rock',NULL),(7,'Avengers 7: The Reckoning',1,'2021-03-18','19:30:00','03:15:00','Action, Superhelte',7,'Sandra Bullock, Samuel L. Jackson, The Rock, Paul Bettany',NULL),(12,'Narnia: Adam og Anton på Eventyr i Klædeskabet',2,'2021-03-18','19:30:00','03:15:00','Fantasy',2,'Adam, Anton, Aslan, The rock, Jackie Chan',NULL),(14,'Parry Hotter & the Heathly Dallows: Dobbys Revenge',2,'2021-04-20','23:00:00','06:32:00','Erotik',18,'Dobby, Raniel Dadcliffe, Rhe Tock',NULL);
/*!40000 ALTER TABLE `shows` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-25 10:26:22
