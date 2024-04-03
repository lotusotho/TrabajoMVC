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
CREATE DATABASE IF NOT EXISTS `gestwow` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;
USE `gestwow`;

-- Volcando estructura para tabla gestwow.characters
CREATE TABLE IF NOT EXISTS `characters` (
  `char_id` int(4) NOT NULL AUTO_INCREMENT,
  `user_id` int(4) unsigned zerofill NOT NULL DEFAULT 0000,
  `name` varchar(20) NOT NULL,
  `race` varchar(10) NOT NULL,
  `faction` varchar(10) NOT NULL,
  `title` varchar(25) NOT NULL,
  `life` decimal(8,2) NOT NULL DEFAULT 0.00,
  `runicpower` int(8) NOT NULL DEFAULT 0,
  `strength` decimal(8,2) NOT NULL DEFAULT 0.00,
  `stamina` decimal(8,2) NOT NULL DEFAULT 0.00,
  PRIMARY KEY (`char_id`),
  UNIQUE KEY `name` (`name`),
  KEY `FK_characters_users` (`user_id`),
  CONSTRAINT `FK_characters_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Here we save the WoW character properties';

-- Volcando datos para la tabla gestwow.characters: ~1 rows (aproximadamente)
INSERT INTO `characters` (`char_id`, `user_id`, `name`, `race`, `faction`, `title`, `life`, `runicpower`, `strength`, `stamina`) VALUES
	(23, 0013, 'testcharacter', 'race', 'faction', 'title', 1212.12, 2121, 1212.12, 1212.12);

-- Volcando estructura para tabla gestwow.users
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(4) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `passwd` char(64) NOT NULL DEFAULT '',
  `isAdmin` varchar(10) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Here we save the users properties';

-- Volcando datos para la tabla gestwow.users: ~2 rows (aproximadamente)
INSERT INTO `users` (`user_id`, `name`, `passwd`, `isAdmin`) VALUES
	(0013, 'test1', '3b1d7e9a7c37141350fb473fa099b8b18030cde1909f363e3758e52d4ea1a7b4', 'admin');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
