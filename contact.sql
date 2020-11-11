CREATE DATABASE  IF NOT EXISTS `contact_list`;
USE `contact_list`;

DROP TABLE IF EXISTS `contact`;

CREATE TABLE `contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `contact` VALUES 
	(1,'Jan','Kowalski','j@kowal.com'),
	(2,'Drugi','Kontakt','drugi@kontakt.com'),
	(3,'Trzeci','Test','trz@test.com');

