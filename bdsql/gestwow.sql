-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.28-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para gestwow
CREATE DATABASE IF NOT EXISTS `gestwow` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `gestwow`;

-- Volcando estructura para tabla gestwow.characters
CREATE TABLE IF NOT EXISTS `characters` (
  `char_id` int(4) NOT NULL AUTO_INCREMENT,
  `user_id` int(4) unsigned zerofill NOT NULL DEFAULT 0000,
  `name` varchar(20) NOT NULL,
  `race` varchar(10) NOT NULL,
  `faction` varchar(10) NOT NULL,
  `title` varchar(25) NOT NULL,
  `life` double NOT NULL DEFAULT 0,
  `runicpower` double NOT NULL DEFAULT 0,
  `strength` double NOT NULL DEFAULT 0,
  `stamina` double NOT NULL DEFAULT 0,
  PRIMARY KEY (`char_id`),
  UNIQUE KEY `name` (`name`),
  KEY `FK_characters_users` (`user_id`),
  CONSTRAINT `FK_characters_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Here we save the WoW character properties';

-- Volcando datos para la tabla gestwow.characters: ~0 rows (aproximadamente)

-- Volcando estructura para tabla gestwow.users
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(4) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `passwd` varchar(20) NOT NULL,
  `permit` varchar(10) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Here we save the users properties';

-- Volcando datos para la tabla gestwow.users: ~1 rows (aproximadamente)
INSERT INTO `users` (`user_id`, `name`, `passwd`, `permit`) VALUES
	(0001, 'test1', 'con1', 'admin');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
