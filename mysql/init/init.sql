-- MySQL dump 10.13  Distrib 8.0.12, for osx10.13 (x86_64)
--
-- Host: localhost    Database: trendmatch
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `messages` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `send_user_id` int(11) NOT NULL,
  `receive_user_id` int(11) NOT NULL,
  `message_contents` text,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`message_id`),
  KEY `fk_table2_users1_idx` (`send_user_id`),
  KEY `fk_table2_users2_idx` (`receive_user_id`),
  CONSTRAINT `fk_table2_users1` FOREIGN KEY (`send_user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `fk_table2_users2` FOREIGN KEY (`receive_user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `mailaddress` varchar(40) NOT NULL,
  `password` char(255) NOT NULL,
  `name` varchar(20) NOT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `picturepath` varchar(255) DEFAULT NULL,
  `graduate` date DEFAULT NULL,
  `contact` varchar(40) DEFAULT NULL,
  `department` varchar(20) DEFAULT NULL,
  `freespace` varchar(200) DEFAULT NULL,
  `enneagram_1` int(5) DEFAULT NULL,
  `enneagram_2` int(5) DEFAULT NULL,
  `enneagram_3` int(5) DEFAULT NULL,
  `enneagram_4` int(5) DEFAULT NULL,
  `enneagram_5` int(5) DEFAULT NULL,
  `enneagram_6` int(5) DEFAULT NULL,
  `enneagram_7` int(5) DEFAULT NULL,
  `enneagram_8` int(5) DEFAULT NULL,
  `enneagram_9` int(5) DEFAULT NULL,
  `occupation_id` int(11) DEFAULT NULL,
  `sex_id` int(11) DEFAULT NULL,
  `jobofffer_id` int(11) DEFAULT NULL,
  `value_1_id` int(11) DEFAULT NULL,
  `value_2_id` int(11) DEFAULT NULL,
  `value_3_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `mailaddress_UNIQUE` (`mailaddress`),
  KEY `value_id_idx` (`value_1_id`),
  KEY `value_id_idx1` (`value_2_id`),
  KEY `value_id_idx2` (`value_3_id`),
  CONSTRAINT `value_id1` FOREIGN KEY (`value_1_id`) REFERENCES `values` (`value_id`),
  CONSTRAINT `value_id2` FOREIGN KEY (`value_2_id`) REFERENCES `values` (`value_id`),
  CONSTRAINT `value_id3` FOREIGN KEY (`value_3_id`) REFERENCES `values` (`value_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `values`
--

DROP TABLE IF EXISTS `values`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `values` (
  `value_id` int(11) NOT NULL AUTO_INCREMENT,
  `value_name` varchar(50) NOT NULL,
  PRIMARY KEY (`value_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `values`
--

LOCK TABLES `values` WRITE;
/*!40000 ALTER TABLE `values` DISABLE KEYS */;
/*!40000 ALTER TABLE `values` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-23 22:35:35
