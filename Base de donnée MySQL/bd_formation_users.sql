-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_formation
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `idusers` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nickname` varchar(45) NOT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `zipcode` int(11) DEFAULT NULL,
  `startdate` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idusers`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `pseudo_UNIQUE` (`nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Table du projet';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,'je@suis.email','$2a$12$mMLywKQLcSxFu6EsrTAiY.h6wK8Dee6J8aJiQ9fHsOB/5TR1WA4l2','Je suis pseudo','Titouan','Faure','Je suis Adresse','Je suis Villea',80500,'2023-02-09 14:59:38',NULL),(3,'zfzfzef','ezfzfzef','zefzefez',NULL,NULL,NULL,NULL,NULL,'2023-02-07 17:23:16',NULL),(4,'sommer880@gmail.com','$2a$12$YHfkEZX7gwqEF.N9d12ekOnlRW.stavtOpUiqvJUPVIo9T2f963W2','Maxime','maxime','maxime',NULL,NULL,NULL,'2023-02-09 14:57:04','USER'),(5,'admin@moi.fr','$2a$12$cD7hg2ZfOc0hQQo7q3pltu7seYuvVpunf3l5mgfNEhsF.KGh5xDSW','admin@moi.fr','azdad','azdazd',NULL,NULL,NULL,'2023-02-09 15:09:45','USER'),(6,'kherzanekarim@gmail.com','$2a$12$W8TD2tiHPKIT9eqNccHoOevnRG/wrlVf4Uyz79GnrHlkrOqHgX0gG','Nizoryu','Karim','Kherzane',NULL,NULL,NULL,'2023-02-10 08:33:07','USER'),(7,'kherza@eaz.com','$2a$12$bhQsRwXu/.nPQ/XAJN7gIOSWfbyNlLnSayBFQcg2KjhStIaf04g1O','leK','karim','kherzane',NULL,NULL,NULL,'2023-02-10 12:31:00','USER');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-14 15:23:29
