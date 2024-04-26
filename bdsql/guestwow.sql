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

-- Volcando estructura para tabla gestwow.character
CREATE TABLE IF NOT EXISTS `character` (
  `char_id` int(4) NOT NULL AUTO_INCREMENT,
  `user_id` int(4) unsigned zerofill NOT NULL DEFAULT 0000,
  `name` varchar(20) NOT NULL,
  `race_ID` tinyint(15) unsigned NOT NULL,
  `faction_ID` bit(1) NOT NULL DEFAULT b'0',
  `title` varchar(25) NOT NULL,
  `life` decimal(8,2) NOT NULL DEFAULT 0.00,
  `runicpower` int(8) NOT NULL DEFAULT 0,
  `strength` decimal(8,2) NOT NULL DEFAULT 0.00,
  `stamina` decimal(8,2) NOT NULL DEFAULT 0.00,
  PRIMARY KEY (`char_id`),
  UNIQUE KEY `name` (`name`),
  KEY `FK_characters_users` (`user_id`),
  KEY `FK_characters_race` (`race_ID`),
  KEY `FK_character_faction` (`faction_ID`),
  CONSTRAINT `FK_character_faction` FOREIGN KEY (`faction_ID`) REFERENCES `faction` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_characters_race` FOREIGN KEY (`race_ID`) REFERENCES `race` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_characters_users` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Here we save the WoW character properties';

-- Volcando datos para la tabla gestwow.character: ~0 rows (aproximadamente)

-- Volcando estructura para tabla gestwow.faction
CREATE TABLE IF NOT EXISTS `faction` (
  `ID` bit(1) NOT NULL DEFAULT b'0',
  `factionName` varchar(6) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla gestwow.faction: ~0 rows (aproximadamente)

-- Volcando estructura para tabla gestwow.race
CREATE TABLE IF NOT EXISTS `race` (
  `ID` tinyint(15) unsigned NOT NULL,
  `raceName` varchar(10) NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla gestwow.race: ~0 rows (aproximadamente)

-- Volcando estructura para tabla gestwow.user
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(4) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `passwd` char(64) NOT NULL DEFAULT '',
  `isAdmin` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Here we save the users properties';

-- Volcando datos para la tabla gestwow.user: ~0 rows (aproximadamente)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
