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

-- Volcando estructura para tabla gestwow.faction
CREATE TABLE IF NOT EXISTS `faction` (
  `ID` bit(1) NOT NULL DEFAULT b'0',
  `factionName` varchar(7) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla gestwow.faction: ~2 rows (aproximadamente)
INSERT INTO `faction` (`ID`, `factionName`) VALUES
	(b'0', 'Alianza'),
	(b'1', 'Horda');

-- Volcando estructura para tabla gestwow.hero
CREATE TABLE IF NOT EXISTS `hero` (
  `char_id` int(4) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(4) unsigned zerofill NOT NULL DEFAULT 0000,
  `name` varchar(20) NOT NULL,
  `race_ID` tinyint(15) unsigned NOT NULL,
  `class_ID` tinyint(13) unsigned NOT NULL,
  `faction_ID` bit(1) NOT NULL DEFAULT b'0',
  `title` varchar(20) NOT NULL,
  `life` decimal(8,2) unsigned NOT NULL DEFAULT 0.00,
  `runicpower` int(8) unsigned NOT NULL DEFAULT 0,
  `strength` decimal(8,2) unsigned NOT NULL DEFAULT 0.00,
  `stamina` decimal(8,2) unsigned NOT NULL DEFAULT 0.00,
  PRIMARY KEY (`char_id`),
  UNIQUE KEY `name` (`name`),
  KEY `FK_characters_users` (`user_id`),
  KEY `FK_character_faction` (`faction_ID`),
  KEY `FK_characters_race` (`race_ID`),
  KEY `FK_hero_heroclass` (`class_ID`),
  CONSTRAINT `FK_character_faction` FOREIGN KEY (`faction_ID`) REFERENCES `faction` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_characters_race` FOREIGN KEY (`race_ID`) REFERENCES `race` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_characters_users` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_hero_heroclass` FOREIGN KEY (`class_ID`) REFERENCES `heroclass` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Here we save the WoW character properties';

-- Volcando datos para la tabla gestwow.hero: ~2 rows (aproximadamente)
INSERT INTO `hero` (`char_id`, `user_id`, `name`, `race_ID`, `class_ID`, `faction_ID`, `title`, `life`, `runicpower`, `strength`, `stamina`) VALUES
	(1, 0001, 'Warrhumluis', 1, 0, b'0', 'la Perdición del Rey', 20420.00, 532, 841.00, 1021.00),
	(2, 0001, 'Palorcale', 1, 0, b'1', 'El Programador de Ja', 32856.00, 254, 768.00, 1265.00);

-- Volcando estructura para tabla gestwow.heroclass
CREATE TABLE IF NOT EXISTS `heroclass` (
  `ID` tinyint(13) unsigned NOT NULL,
  `className` varchar(25) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla gestwow.heroclass: ~13 rows (aproximadamente)
INSERT INTO `heroclass` (`ID`, `className`) VALUES
	(0, 'Guerrero'),
	(1, 'Paladín'),
	(2, 'Cazador'),
	(3, 'Pícaro'),
	(4, 'Sacerdote'),
	(5, 'Chamán'),
	(6, 'Mago'),
	(7, 'Brujo'),
	(8, 'Monje'),
	(9, 'Druida'),
	(10, 'Cazador de demonios'),
	(11, 'Caballero de la Muerte'),
	(12, 'Invocador');

-- Volcando estructura para tabla gestwow.race
CREATE TABLE IF NOT EXISTS `race` (
  `ID` tinyint(15) unsigned NOT NULL,
  `raceName` varchar(15) NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla gestwow.race: ~14 rows (aproximadamente)
INSERT INTO `race` (`ID`, `raceName`) VALUES
	(0, 'Humano'),
	(1, 'Enano'),
	(2, 'Elfo de Noche'),
	(3, 'Gnomo'),
	(4, 'Draenei'),
	(5, 'Huargen'),
	(6, 'Pandaren'),
	(7, 'Dracthyr'),
	(8, 'Orco'),
	(9, 'No-muerto'),
	(10, 'Tauren'),
	(11, 'Trol'),
	(12, 'Elfo de Sangre'),
	(13, 'Goblin');

-- Volcando estructura para tabla gestwow.user
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(4) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `passwd` char(64) NOT NULL DEFAULT '',
  `isAdmin` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Here we save the users properties';

-- Volcando datos para la tabla gestwow.user: ~2 rows (aproximadamente)
INSERT INTO `user` (`user_id`, `name`, `passwd`, `isAdmin`) VALUES
	(0001, 'alejandro', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', b'1'),
	(0002, 'luis', 'cbfad02f9ed2a8d1e08d8f74f5303e9eb93637d47f82ab6f1c15871cf8dd0481', b'0');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
