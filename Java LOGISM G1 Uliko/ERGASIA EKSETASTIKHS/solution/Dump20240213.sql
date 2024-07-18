-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: mydatabase
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `absence_history`
--

DROP TABLE IF EXISTS `absence_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `absence_history` (
  `id` int NOT NULL AUTO_INCREMENT,
  `afm` varchar(9) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `absence_history`
--

LOCK TABLES `absence_history` WRITE;
/*!40000 ALTER TABLE `absence_history` DISABLE KEYS */;
INSERT INTO `absence_history` VALUES (1,'123456789','2023-01-01','2023-01-02'),(2,'987654321','2023-01-01','2023-01-05'),(3,'456789012','2023-01-01','2023-01-01');
/*!40000 ALTER TABLE `absence_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aneu_apodoxon`
--

DROP TABLE IF EXISTS `aneu_apodoxon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aneu_apodoxon` (
  `id` int NOT NULL AUTO_INCREMENT,
  `afm` varchar(9) DEFAULT NULL,
  `total` int DEFAULT NULL,
  `month` int DEFAULT NULL,
  `year` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aneu_apodoxon`
--

LOCK TABLES `aneu_apodoxon` WRITE;
/*!40000 ALTER TABLE `aneu_apodoxon` DISABLE KEYS */;
INSERT INTO `aneu_apodoxon` VALUES (1,'123456789',3,1,2023),(2,'456789012',4,1,2023);
/*!40000 ALTER TABLE `aneu_apodoxon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emails`
--

DROP TABLE IF EXISTS `emails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emails` (
  `id` int NOT NULL AUTO_INCREMENT,
  `afm` varchar(9) DEFAULT NULL,
  `email1` varchar(40) DEFAULT NULL,
  `email2` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emails`
--

LOCK TABLES `emails` WRITE;
/*!40000 ALTER TABLE `emails` DISABLE KEYS */;
INSERT INTO `emails` VALUES (1,'123456789','john.doe@example.com','john.doe.personal@example.com'),(2,'987654321','jane.smith@example.com',NULL),(3,'456789012','alice.johnson@example.com','alice.johnson.personal@example.com');
/*!40000 ALTER TABLE `emails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `fathers_name` varchar(20) DEFAULT NULL,
  `mothers_name` varchar(20) DEFAULT NULL,
  `afm` varchar(9) DEFAULT NULL,
  `amka` varchar(11) DEFAULT NULL,
  `adress` varchar(20) DEFAULT NULL,
  `employee_type` int DEFAULT '0',
  `salary_type` int DEFAULT '0',
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `children_count` int DEFAULT NULL,
  `married` int DEFAULT '0',
  `level_of_education` int DEFAULT '0',
  `date_stopped` date DEFAULT NULL,
  `position` varchar(10) DEFAULT NULL,
  `department` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `employees_chk_1` CHECK ((`employee_type` between 0 and 2)),
  CONSTRAINT `employees_chk_2` CHECK ((`salary_type` between 0 and 1)),
  CONSTRAINT `employees_chk_3` CHECK ((`married` in (0,1))),
  CONSTRAINT `employees_chk_4` CHECK ((`level_of_education` in (0,1)))
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'John','Doe','Michael','Anna','123456789','12345678901','123 Main St',2,1,'one','two',2,1,1,NULL,'Manager','HR'),(2,'Jane','Smith','David','Sarah','987654321','98765432101','456 Elm St',0,0,'janesmith','password123',1,0,0,NULL,'Assistant','Marketing'),(3,'Alice','Johnson','Robert','Emily','456789012','45678901201','789 Oak St',1,0,'alicejohnson','pass123',0,1,1,NULL,'Developer','IT');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `final_salary`
--

DROP TABLE IF EXISTS `final_salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `final_salary` (
  `id` int NOT NULL AUTO_INCREMENT,
  `afm` varchar(9) DEFAULT NULL,
  `dateOfPayment` date DEFAULT NULL,
  `salary` int DEFAULT NULL,
  `totalAbsences` int DEFAULT NULL,
  `totalHealthAbsences` int DEFAULT NULL,
  `totalAneu` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `final_salary`
--

LOCK TABLES `final_salary` WRITE;
/*!40000 ALTER TABLE `final_salary` DISABLE KEYS */;
INSERT INTO `final_salary` VALUES (16,'123456789','2023-01-31',4400,2,1,3),(17,'987654321','2023-01-31',3600,5,1,0),(18,'456789012','2023-01-31',57600,1,2,4);
/*!40000 ALTER TABLE `final_salary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `health_history`
--

DROP TABLE IF EXISTS `health_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `health_history` (
  `id` int NOT NULL AUTO_INCREMENT,
  `afm` varchar(9) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `health_history`
--

LOCK TABLES `health_history` WRITE;
/*!40000 ALTER TABLE `health_history` DISABLE KEYS */;
INSERT INTO `health_history` VALUES (1,'123456789','2023-01-01','2023-01-01'),(2,'987654321','2023-01-01','2023-01-01'),(3,'456789012','2023-01-01','2023-01-02');
/*!40000 ALTER TABLE `health_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hours_work`
--

DROP TABLE IF EXISTS `hours_work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hours_work` (
  `id` int NOT NULL AUTO_INCREMENT,
  `afm` varchar(9) DEFAULT NULL,
  `hours` int DEFAULT NULL,
  `month` int DEFAULT NULL,
  `year` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hours_work`
--

LOCK TABLES `hours_work` WRITE;
/*!40000 ALTER TABLE `hours_work` DISABLE KEYS */;
INSERT INTO `hours_work` VALUES (1,'987654321',160,1,2023),(2,'987654321',360,5,2023);
/*!40000 ALTER TABLE `hours_work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary_history`
--

DROP TABLE IF EXISTS `salary_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary_history` (
  `id` int NOT NULL AUTO_INCREMENT,
  `afm` varchar(9) DEFAULT NULL,
  `Salary` int DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary_history`
--

LOCK TABLES `salary_history` WRITE;
/*!40000 ALTER TABLE `salary_history` DISABLE KEYS */;
INSERT INTO `salary_history` VALUES (1,'123456789',50000,'2023-01-01','2023-01-31'),(2,'987654321',40000,'2023-01-01','2023-01-31'),(3,'456789012',3000,'2023-01-01','2023-01-31'),(4,'123456789',5000,'2023-01-01','2023-05-31'),(5,'987654321',7000,'2023-01-01','2023-05-31'),(6,'456789012',60000,'2023-01-01','2023-05-31');
/*!40000 ALTER TABLE `salary_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telephones`
--

DROP TABLE IF EXISTS `telephones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telephones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `afm` varchar(9) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telephones`
--

LOCK TABLES `telephones` WRITE;
/*!40000 ALTER TABLE `telephones` DISABLE KEYS */;
INSERT INTO `telephones` VALUES (1,'123456789','123-456-7890'),(2,'987654321','987-654-3210'),(3,'456789012','456-789-0120');
/*!40000 ALTER TABLE `telephones` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-13 10:10:38
