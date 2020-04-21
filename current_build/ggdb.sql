-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.11-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table ggdb.booking
CREATE TABLE IF NOT EXISTS `booking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table ggdb.booking: ~0 rows (approximately)
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
REPLACE INTO `booking` (`id`, `user_id`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;

-- Dumping structure for table ggdb.city
CREATE TABLE IF NOT EXISTS `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country_id` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `country_id` (`country_id`),
  CONSTRAINT `city_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table ggdb.city: ~6 rows (approximately)
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
REPLACE INTO `city` (`id`, `country_id`, `name`) VALUES
	(1, 1, 'Sveg'),
	(2, 1, 'Stockholm'),
	(3, 2, 'Köpenhamn'),
	(4, 2, 'Tuborg'),
	(5, 3, 'Oslo'),
	(6, 3, 'Bergen');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;

-- Dumping structure for table ggdb.country
CREATE TABLE IF NOT EXISTS `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table ggdb.country: ~2 rows (approximately)
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
REPLACE INTO `country` (`id`, `name`) VALUES
	(1, 'Sverige'),
	(2, 'Danmark'),
	(3, 'Norge');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;

-- Dumping structure for table ggdb.hotel
CREATE TABLE IF NOT EXISTS `hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city_id` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `restaurant` bit(1) DEFAULT NULL,
  `pool` bit(1) DEFAULT NULL,
  `kidsclub` bit(1) DEFAULT NULL,
  `evening_entertainment` bit(1) DEFAULT NULL,
  `meters_to_city_center` int(11) DEFAULT NULL,
  `meters_to_beach` int(11) DEFAULT NULL,
  `img_url` varchar(300) DEFAULT NULL,
  `description` varchar(300) DEFAULT NULL,
  `rating` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `city_id` (`city_id`),
  CONSTRAINT `hotel_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table ggdb.hotel: ~5 rows (approximately)
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
REPLACE INTO `hotel` (`id`, `city_id`, `name`, `restaurant`, `pool`, `kidsclub`, `evening_entertainment`, `meters_to_city_center`, `meters_to_beach`, `img_url`, `description`, `rating`) VALUES
	(1, 1, 'Svegs Stadshotell', b'1', b'0', b'0', b'1', 20, 4000, 'https://www.safarihotelsnamibia.com/wp-content/uploads/2014/11/Safari-Court-Hotel-Pool.jpg', 'Ett helt ok hotell', 1.8),
	(2, 2, 'Grand Hôtel', b'1', b'1', b'0', b'0', 50, 2000, 'https://www.ma.com/wp-content/uploads/2013/10/morris-adjmi-architects-wythe-hotel-3.jpg', 'Long haired freaky people need not apply', 8.2),
	(3, 2, 'Strandhotellet', b'1', b'1', b'1', b'1', 10000, 5, 'https://www.excelsior.com.mt/wp-content/gallery/hotel-gallery/Outdoor-Pool-at-Night.jpg', 'Elegant hotell vid till badet.', 5),
	(4, 3, 'BnBodega', b'1', b'0', b'0', b'1', 300, 400, 'http://www.idesignarch.com/wp-content/uploads/Oxford-Malmaison-Hotel_1.jpg', 'Pittoreskt hotell vid kajen', 7.3),
	(5, 6, 'Den norske hotel', b'0', b'0', b'1', b'0', 7000, 5000, 'http://ww1.prweb.com/prfiles/2011/11/03/8934854/Moevenpick-Hotel-Accra-exterior.jpg', 'Bergshotell intill fjorden', 6.9);
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;

-- Dumping structure for view ggdb.hotelview
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `hotelview` (
	`id` INT(11) NOT NULL,
	`name` VARCHAR(30) NULL COLLATE 'utf8mb4_general_ci',
	`cityID` INT(11) NOT NULL,
	`City` VARCHAR(30) NULL COLLATE 'utf8mb4_general_ci',
	`countryID` INT(11) NOT NULL,
	`country` VARCHAR(40) NULL COLLATE 'utf8mb4_general_ci',
	`restaurant` BIT(1) NULL,
	`pool` BIT(1) NULL,
	`kidsclub` BIT(1) NULL,
	`evening_entertainment` BIT(1) NULL,
	`meters_to_city_center` INT(11) NULL,
	`meters_to_beach` INT(11) NULL,
	`img_url` VARCHAR(300) NULL COLLATE 'utf8mb4_general_ci',
	`description` VARCHAR(300) NULL COLLATE 'utf8mb4_general_ci',
	`rating` FLOAT(12) NULL
) ENGINE=MyISAM;

-- Dumping structure for table ggdb.room
CREATE TABLE IF NOT EXISTS `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_id` int(11) NOT NULL,
  `roomtype_id` int(11) NOT NULL,
  `sizem2` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `hotel_id` (`hotel_id`),
  KEY `roomtype_id` (`roomtype_id`),
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  CONSTRAINT `room_ibfk_2` FOREIGN KEY (`roomtype_id`) REFERENCES `roomtype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table ggdb.room: ~6 rows (approximately)
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
REPLACE INTO `room` (`id`, `hotel_id`, `roomtype_id`, `sizem2`, `price`) VALUES
	(1, 1, 1, 10, 1000),
	(2, 2, 2, 62, 4999),
	(3, 3, 1, 60, 599),
	(4, 2, 3, 50, 5000),
	(5, 2, 2, 50, 3209),
	(6, 4, 1, 20, 400);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;

-- Dumping structure for table ggdb.roombooking
CREATE TABLE IF NOT EXISTS `roombooking` (
  `id` int(11) NOT NULL,
  `booking_id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  `date_in` date DEFAULT NULL,
  `date_out` date DEFAULT NULL,
  `all_inclusive` bit(1) DEFAULT NULL,
  `half_pension` bit(1) DEFAULT NULL,
  `full_pension` bit(1) DEFAULT NULL,
  `extra_bed` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `booking_id` (`booking_id`),
  KEY `room_id` (`room_id`),
  CONSTRAINT `roombooking_ibfk_1` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`),
  CONSTRAINT `roombooking_ibfk_2` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table ggdb.roombooking: ~0 rows (approximately)
/*!40000 ALTER TABLE `roombooking` DISABLE KEYS */;
REPLACE INTO `roombooking` (`id`, `booking_id`, `room_id`, `date_in`, `date_out`, `all_inclusive`, `half_pension`, `full_pension`, `extra_bed`) VALUES
	(1, 1, 1, '2020-06-10', '2020-06-10', b'1', b'1', b'1', b'1');
/*!40000 ALTER TABLE `roombooking` ENABLE KEYS */;

-- Dumping structure for table ggdb.roomtype
CREATE TABLE IF NOT EXISTS `roomtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table ggdb.roomtype: ~3 rows (approximately)
/*!40000 ALTER TABLE `roomtype` DISABLE KEYS */;
REPLACE INTO `roomtype` (`id`, `name`) VALUES
	(1, 'Enkelrum'),
	(2, 'Dubbelrum'),
	(3, 'Familjerum');
/*!40000 ALTER TABLE `roomtype` ENABLE KEYS */;

-- Dumping structure for table ggdb.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table ggdb.user: ~2 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`id`, `username`, `email`, `password`, `phone`, `first_name`, `last_name`, `address`) VALUES
	(1, 'Bo78', 'bo@email.mail', 'bossesPassword', '0202020202', 'Bosse', 'Boson', 'Vägvägen 7'),
	(2, 'siv324', 'mail@email.mail', 'sassword', '0202020202', 'Siv', 'Sieve', 'Gatgatan 12');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for view ggdb.hotelview
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `hotelview`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `hotelview` AS SELECT h.id , h.name, s.id AS cityID, s.Name AS City, l.id AS countryID, l.Name AS country, restaurant, pool, kidsclub, evening_entertainment, meters_to_city_center, meters_to_beach, img_url, description, rating FROM Hotel h
        INNER JOIN City s ON h.city_id = s.id
        INNER JOIN Country l ON s.country_id = l.id ;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
