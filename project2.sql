-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         11.1.2-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para eventsystem
CREATE DATABASE IF NOT EXISTS `eventsystem` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `eventsystem`;

-- Volcando estructura para tabla eventsystem.events
CREATE TABLE IF NOT EXISTS `events` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `description` varchar(50) NOT NULL DEFAULT '0',
  `date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `address` varchar(50) NOT NULL DEFAULT '0',
  `city` varchar(50) NOT NULL DEFAULT '0',
  `postal_code` int(11) NOT NULL DEFAULT 0,
  `price` double NOT NULL DEFAULT 0,
  `room` varchar(50) NOT NULL DEFAULT '0',
  `place_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `place_id` (`place_id`),
  CONSTRAINT `place_id` FOREIGN KEY (`place_id`) REFERENCES `places` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla eventsystem.events: ~2 rows (aproximadamente)
INSERT INTO `events` (`id`, `name`, `description`, `date`, `address`, `city`, `postal_code`, `price`, `room`, `place_id`) VALUES
	(1, 'Viaje', 'Viaje en crucero', '2023-12-31 07:30:00', 'Tamarindo', 'Tamarindo', 50309, 80000, '124', 1),
	(2, 'Fiesta', 'party nigh', '2023-12-24 09:00:00', 'Barrio san antonio', 'Ciudad quesada', 21001, 8000, '2', 2);

-- Volcando estructura para tabla eventsystem.places
CREATE TABLE IF NOT EXISTS `places` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `address` varchar(50) NOT NULL DEFAULT '0',
  `city` varchar(50) NOT NULL DEFAULT '0',
  `postal_code` int(11) NOT NULL DEFAULT 0,
  `latitude` int(11) NOT NULL DEFAULT 0,
  `longitude` int(11) NOT NULL DEFAULT 0,
  `tripAdvisor_link` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla eventsystem.places: ~2 rows (aproximadamente)
INSERT INTO `places` (`id`, `name`, `address`, `city`, `postal_code`, `latitude`, `longitude`, `tripAdvisor_link`) VALUES
	(1, 'Playa Tamarindo', 'Tamarindo', 'Tamarindo', 50309, 102976, 858412, 'none'),
	(2, 'Alkimia', 'Barrio San Antonio', 'Cd Quesada', 21001, 102039, 842512, 'none');

-- Volcando estructura para tabla eventsystem.reservations
CREATE TABLE IF NOT EXISTS `reservations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `quantity` int(11) NOT NULL DEFAULT 0,
  `event_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `event_id` (`event_id`),
  CONSTRAINT `event_id` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla eventsystem.reservations: ~0 rows (aproximadamente)
INSERT INTO `reservations` (`id`, `user_name`, `date`, `quantity`, `event_id`) VALUES
	(1, 'Fabricio', '2023-12-24 09:00:00', 1, 2);

-- Volcando estructura para tabla eventsystem.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla eventsystem.roles: ~2 rows (aproximadamente)
INSERT INTO `roles` (`id`, `name`) VALUES
	(1, 'Administrador'),
	(2, 'Usuario');

-- Volcando estructura para tabla eventsystem.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ID_number` int(11) NOT NULL DEFAULT 0,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `last_name` varchar(50) NOT NULL DEFAULT '0',
  `birth_date` date NOT NULL,
  `email` varchar(50) NOT NULL DEFAULT '0',
  `phone_number` int(11) NOT NULL DEFAULT 0,
  `password` varchar(50) NOT NULL DEFAULT '0',
  `rol_id` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `rol_id` (`rol_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla eventsystem.users: ~9 rows (aproximadamente)
INSERT INTO `users` (`id`, `ID_number`, `name`, `last_name`, `birth_date`, `email`, `phone_number`, `password`, `rol_id`) VALUES
	(1, 208640904, 'Fabricio', 'Reyes Acevedo', '2005-04-21', 'reyesufabricio@gmail.com', 85499527, '123', 'Administrador'),
	(2, 207700439, 'Randola', 'Madrigal Perez', '2005-06-20', 'randalltata@gmail.com', 60603535, 'randall123', 'Usuario'),
	(3, 205660865, 'Allyson', 'Sequeira Solis ', '2005-03-17', 'allison@gmail.com', 86774445, 'allyson123', 'Usuario'),
	(4, 208550438, 'Deivis', 'Jimenez Montero', '2005-08-31', 'deivisnetfor@gmail.com', 89653217, 'deivis123', 'Administrador'),
	(5, 209990999, 'Angel', 'do', '2023-04-21', 'rere', 12345678, '123', 'Usuario'),
	(6, 209990999, 'Fabricio', 'a', '2004-05-21', 'bnbn', 232323, '12', 'Usuario'),
	(7, 2222, 'Ana', 'b', '4447-09-12', 'ff', 2345, '123', 'Usuario'),
	(8, 222, 'www', 'www', '5448-07-14', 'q', 11, '1', 'Usuario'),
	(9, 222, 'eee', 'ddd', '6671-06-23', 'x', 1111, '12', 'Usuario');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
