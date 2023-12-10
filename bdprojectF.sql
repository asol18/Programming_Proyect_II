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
  `description` varchar(200) NOT NULL DEFAULT '0',
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
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla eventsystem.events: ~43 rows (aproximadamente)
INSERT INTO `events` (`id`, `name`, `description`, `date`, `address`, `city`, `postal_code`, `price`, `room`, `place_id`) VALUES
	(1, 'Viaje', 'Viaje en crucero', '2023-12-31 07:30:00', 'Tamarindo', '0', 50309, 80000, '124', 1),
	(2, 'Fiesta', 'party nigh', '2023-12-24 09:00:00', 'Barrio san antonio', 'Ciudad quesada', 21001, 8000, '2', 2),
	(7, 'Maraton', 'En la playa', '2023-12-31 18:00:00', '123 Calle Principal', 'San Jose', 10101, 50, 'Avenida 34', 1),
	(8, 'Partido', 'LDA vs Saprissa', '2024-01-15 20:30:00', '456 Avenida Secundaria', 'San jose', 20202, 35, 'Estadio Rosabal Cordero', 6),
	(9, 'Concierto', 'Picnic fest', '2024-02-28 15:45:00', '789 Calle Alternativa', 'Heredia', 30303, 40, 'Salón de Eventos', 8),
	(10, 'Feria', 'Feria del agricultor', '2023-12-31 18:00:00', '123 Calle Principal', 'San Jose', 10101, 50, 'Salon del agricultor', 3),
	(11, 'Desfile', 'Desfile de bandas', '2024-01-15 20:30:00', '456 Avenida Secundaria', 'Heredia', 20202, 35, 'Salon principal', 2),
	(12, 'Fin de Año', 'Celebracion de Año Nuevo con fuegos artificiales', '2023-12-31 12:33:00', '789 Calle Alternativa', 'San jose', 30303, 40, 'Salón de Eventos', 6),
	(13, 'Concierto en el Parque Nacional', 'Un emocionante concierto al aire libre', '2023-11-15 19:30:00', 'Parque Nacional', 'San Jose', 10101, 20, 'Área de conciertos', 3),
	(14, 'Charla Educativa en el Museo de Arte', 'Una charla sobre historia del arte', '2023-12-01 15:00:00', 'Museo de Arte Contemporáneo', 'San Jose', 10101, 10, 'Sala de Conferencias', 4),
	(15, 'Feria Gastronómica en la Playa', 'Degustación de platillos locales', '2024-02-10 17:00:00', 'Playa Manuel Antonio', 'Quepos', 60601, 30, 'Zona de la Feria', 5),
	(16, 'Evento Deportivo en el Estadio Nacional', 'Competición emocionante', '2024-03-20 14:00:00', 'Estadio Nacional', 'San Jose', 10101, 25, 'Campo de Juego', 6),
	(17, 'Exposición de Arte en la Galería', 'Muestra de artistas locales', '2024-04-05 10:00:00', 'Galería Nacional de Costa Rica', 'San Jose', 10101, 15, 'Salón de Exposiciones', 7),
	(18, 'Observación de Aves', 'Tour guiado para observar aves en el Parque Nacional', '2023-11-20 08:00:00', 'Parque Nacional', 'San Jose', 10101, 15, 'Área de Observación', 3),
	(19, 'Noche de Estrellas', 'Experiencia única para observar las estrellas en el Parque Nacional', '2023-12-10 19:00:00', 'Parque Nacional', 'San Jose', 10101, 25, 'Área de Camping', 3),
	(20, 'Exposición de Pintura', 'Exhibición de pinturas de artistas locales en la Galería Nacional', '2023-12-15 11:00:00', 'Calle 1, San Jose', 'San Jose', 10101, 15, 'Salón de Exposiciones', 7),
	(21, 'Taller de Escultura', 'Taller práctico de escultura en la Galería Nacional', '2024-02-20 14:30:00', 'Calle 1, San Jose', 'San Jose', 10101, 20, 'Área de Talleres', 4),
	(22, 'Charla de Arte Moderno', 'Conferencia sobre los movimientos artísticos modernos', '2023-12-05 16:30:00', 'Av. 3ra, C. 15', 'San Jose', 10101, 10, 'Sala de Conferencias', 4),
	(23, 'Noche Cultural', 'Evento nocturno con música y exposiciones en el Museo de Arte Contemporáneo', '2024-02-15 20:00:00', 'Av. 3ra, C. 15', 'San Jose', 10101, 20, 'Área de Exposiciones', 2),
	(24, 'Caminata Nocturna', 'Exploración de la selva por la noche en Tortuguero National Park', '2024-02-15 21:00:00', 'Tortuguero', 'Limón', 70105, 20, 'Sendero Nocturno', 11),
	(25, 'Taller de Conservación de Tortugas', 'Actividad educativa sobre la conservación de tortugas marinas', '2024-03-30 15:30:00', 'Tortuguero', 'Limón', 70105, 15, 'Centro de Visitantes', 11),
	(26, 'Recorrido Nocturno por la Selva', 'Exploración de la selva en Monteverde de noche', '2024-04-20 18:00:00', 'Monteverde', 'Puntarenas', 60101, 25, 'Sendero Nocturno', 12),
	(27, 'Conferencia sobre Conservación', 'Charla sobre la importancia de la conservación en Monteverde', '2024-05-10 14:00:00', 'Monteverde', 'Puntarenas', 60101, 10, 'Sala de Conferencias', 12),
	(30, 'Caminata Nocturna', 'Exploración de la selva por la noche en Tortuguero National Park', '2024-02-15 21:00:00', 'Tortuguero', 'Limón', 70105, 20, 'Sendero Nocturno', 11),
	(31, 'Taller de Conservación de Tortugas', 'Actividad educativa sobre la conservación de tortugas marinas', '2024-03-30 15:30:00', 'Tortuguero', 'Limón', 70105, 15, 'Centro de Visitantes', 11),
	(32, 'Recorrido Nocturno por la Selva', 'Exploración de la selva en Monteverde de noche', '2024-04-20 18:00:00', 'Monteverde', 'Puntarenas', 60101, 25, 'Sendero Nocturno', 12),
	(33, 'Conferencia sobre Conservación', 'Charla sobre la importancia de la conservación en Monteverde', '2024-05-10 14:00:00', 'Monteverde', 'Puntarenas', 60101, 10, 'Sala de Conferencias', 12),
	(36, 'Caminata Nocturna', 'Exploración de la selva por la noche en Tortuguero National Park', '2024-02-15 21:00:00', 'Tortuguero', 'Limón', 70105, 20, 'Sendero Nocturno', 11),
	(37, 'Taller de Conservación de Tortugas', 'Actividad educativa sobre la conservación de tortugas marinas', '2024-03-30 15:30:00', 'Tortuguero', 'Limón', 70105, 15, 'Centro de Visitantes', 11),
	(38, 'Recorrido Nocturno por la Selva', 'Exploración de la selva en Monteverde de noche', '2024-04-20 18:00:00', 'Monteverde', 'Puntarenas', 60101, 25, 'Sendero Nocturno', 12),
	(39, 'Conferencia sobre Conservación', 'Charla sobre la importancia de la conservación en Monteverde', '2024-05-10 14:00:00', 'Monteverde', 'Puntarenas', 60101, 10, 'Sala de Conferencias', 12),
	(42, 'Recorrido Nocturno por la Selva', 'Exploración de la selva en Monteverde de noche', '2024-04-20 18:00:00', 'Monteverde', 'Puntarenas', 60101, 25, 'Sendero Nocturno', 12),
	(43, 'Conferencia sobre Conservación', 'Charla sobre la importancia de la conservación en Monteverde', '2024-05-10 14:00:00', 'Monteverde', 'Puntarenas', 60101, 10, 'Sala de Conferencias', 12),
	(56, 'Recorrido de Observación de Aves en Monteverde', 'Excursión guiada para observar aves en Monteverde', '2024-08-20 07:00:00', 'Monteverde', 'Puntarenas', 60101, 25, 'Sendero de Aves', 12),
	(57, 'Noche de Astronomía en Monteverde', 'Observación de estrellas y planetas en Reserva Biológica Monteverde', '2024-09-15 20:30:00', 'Monteverde', 'Puntarenas', 60101, 30, 'Área de Observación Nocturna', 12),
	(58, 'Torneo de Vóley Playero en Playa Conchal', 'Competición de vóley playero en Playa Conchal', '2024-10-10 14:00:00', 'Guanacaste', 'Santa Cruz', 50308, 20, 'Área de Juegos', 16),
	(59, 'Noche de Fogatas en la Playa Conchal', 'Evento nocturno con fogatas y música en Playa Conchal', '2024-11-25 18:30:00', 'Guanacaste', 'Santa Cruz', 50308, 15, 'Zona de Fogatas', 19),
	(60, 'Tour de Senderismo al Cráter del Volcán Poás', 'Caminata guiada hasta el cráter del Volcán Poás', '2025-01-15 10:00:00', 'Parque Nacional Volcán Poás', 'Alajuela', 20801, 35, 'Sendero Principal', 17),
	(61, 'Conferencia de Geología en el Volcán Poás', 'Charla sobre la geología del Volcán Poás', '2025-02-20 16:30:00', 'Parque Nacional Volcán Poás', 'Alajuela', 20801, 10, 'Centro de Visitantes', 17),
	(62, 'Competencia de Surf en Playa Tamarindo', 'Campeonato de surf en Playa Tamarindo', '2025-03-10 08:30:00', 'Guanacaste', 'Santa Cruz', 50309, 30, 'Área de Surf', 1),
	(63, 'Festival de Música en la Playa Tamarindo', 'Evento musical con bandas locales en Playa Tamarindo', '2025-04-20 17:00:00', 'Guanacaste', 'Santa Cruz', 50309, 25, 'Área de Conciertos', 5),
	(64, 'Buceo en la Isla del Coco', 'Excursión de buceo en aguas cristalinas de la Isla del Coco', '2025-05-15 09:00:00', 'Océano Pacífico', 'Puntarenas', 60504, 50, 'Punto de Buceo', 11),
	(65, 'Caminata por la Isla del Coco', 'Exploración de senderos en la Isla del Coco', '2025-06-25 11:00:00', 'Océano Pacífico', 'Puntarenas', 60504, 15, 'Sendero Costero', 11);

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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla eventsystem.places: ~18 rows (aproximadamente)
INSERT INTO `places` (`id`, `name`, `address`, `city`, `postal_code`, `latitude`, `longitude`, `tripAdvisor_link`) VALUES
	(1, 'Playa Tamarindo', 'Tamarindo', 'Tamarindo', 50309, 102976, 858412, 'none'),
	(2, 'Alkimia', 'Barrio San Antonio', 'Cd Quesada', 21001, 102039, 842512, 'none'),
	(3, 'Parque Nacional', 'Parque Nacional', 'San Jose', 10101, 299330, 886566, 'none'),
	(4, 'Museo de Arte Contemporáneo', 'Av. 3ra, C. 15', 'San Jose', 10101, 10083, 776956, 'none'),
	(5, 'Playa Manuel Antonio', 'Manuel Antonio, Quepos', 'Quepos', 60601, 7543, 965545, 'none'),
	(6, 'Estadio Nacional', 'La Uruca', 'San Jose', 10101, 998322, 565677, 'none'),
	(7, 'Galería Nacional de Costa Rica', 'Calle 1, San Jose', 'San Jose', 10101, 50743, 843454, 'none'),
	(8, 'Eventos pedregal', 'San Antonio, Belen ', 'Heredia', 20343, 346233, 993223, 'none'),
	(10, 'Volcán Arenal', 'La Fortuna de San Carlos', 'La Fortuna', 21007, 10, -85, 'none'),
	(11, 'Tortuguero National Park', 'Tortuguero', 'Limón', 70105, 11, -84, 'none'),
	(12, 'Monteverde Cloud Forest Reserve', 'Monteverde', 'Puntarenas', 60101, 10, -85, 'none'),
	(13, 'Río Celeste', 'Bijagua', 'Alajuela', 21304, 11, -85, 'none'),
	(14, 'Manzanillo Wildlife Refuge', 'Manzanillo', 'Limón', 70403, 10, -83, 'none'),
	(15, 'Reserva Biológica Monteverde', 'Monteverde', 'Puntarenas', 60101, 10, -85, 'none'),
	(16, 'Playa Conchal', 'Guanacaste', 'Santa Cruz', 50308, 10, -86, 'none'),
	(17, 'Volcán Poás', 'Parque Nacional Volcán Poás', 'Alajuela', 20801, 10, -84, 'none'),
	(18, 'Playa Tamarindo', 'Guanacaste', 'Santa Cruz', 50309, 10, -86, 'none'),
	(19, 'Isla del Coco', 'Océano Pacífico', 'Puntarenas', 60504, 6, -87, 'none');

-- Volcando estructura para tabla eventsystem.reservations
CREATE TABLE IF NOT EXISTS `reservations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `date` datetime NOT NULL,
  `quantity` int(11) NOT NULL DEFAULT 0,
  `event_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `event_id` (`event_id`),
  CONSTRAINT `event_id` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla eventsystem.reservations: ~11 rows (aproximadamente)
INSERT INTO `reservations` (`id`, `user_name`, `date`, `quantity`, `event_id`) VALUES
	(1, 'Fabricio', '2023-12-24 09:00:00', 1, 1),
	(5, 'www', '2023-12-09 00:00:00', 5, 1),
	(6, 'www', '2023-12-09 00:00:00', 1, 2),
	(7, 'www', '2023-12-09 00:00:00', 1, 2),
	(8, 'www', '2023-12-09 00:00:00', 2, 2),
	(9, 'www', '2023-12-09 00:00:00', 2, 2),
	(10, 'www', '2023-12-09 00:00:00', 3, 2),
	(11, 'www', '2023-12-09 00:00:00', 2, 2),
	(12, 'www', '2023-03-21 12:23:55', 1, 2),
	(13, 'www', '2023-12-09 00:00:00', 2, 2),
	(14, 'www', '2023-12-09 00:00:00', 2, 2),
	(15, 'www', '2023-12-09 22:37:40', 2, 2);

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

-- Volcando datos para la tabla eventsystem.users: ~8 rows (aproximadamente)
INSERT INTO `users` (`id`, `ID_number`, `name`, `last_name`, `birth_date`, `email`, `phone_number`, `password`, `rol_id`) VALUES
	(1, 208640904, 'Fabricio', 'Reyes Acevedo', '2005-04-21', 'reyesufabricio@gmail.com', 85499527, '123', 'Administrador'),
	(2, 207700439, 'Randola', 'Madrigal Perez', '2005-06-20', 'randalltata@gmail.com', 60603535, 'randall123', 'Usuario'),
	(3, 205660865, 'Allyson', 'Sequeira Solis ', '2005-03-17', 'allison@gmail.com', 86774445, 'allyson123', 'Usuario'),
	(4, 208550438, 'Deivis', 'Jimenez Montero', '2005-08-31', 'deivisnetfor@gmail.com', 89653217, 'deivis123', 'Administrador'),
	(5, 209990999, 'Angel', 'do', '2023-04-21', 'rere', 12345678, '123', 'Usuario'),
	(6, 209990999, 'Fabricio', 'a', '2004-05-21', 'bnbn', 232323, '12', 'Usuario'),
	(7, 2222, 'Ana', 'b', '4447-09-12', 'f', 2345, '1', 'Administrador'),
	(8, 222, 'www', 'bb7', '5448-07-14', 'q', 11, '1', 'Usuario');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
