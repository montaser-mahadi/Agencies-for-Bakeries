-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 30, 2022 at 08:31 AM
-- Server version: 8.0.21
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wekala`
--

-- --------------------------------------------------------

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
CREATE TABLE IF NOT EXISTS `permission` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `isdelete` bit(1) DEFAULT NULL,
  `isread` bit(1) DEFAULT NULL,
  `iswrite` bit(1) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  `workspace` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `permission`
--

INSERT INTO `permission` (`id`, `isdelete`, `isread`, `iswrite`, `roles`, `workspace`) VALUES
(1, b'1', b'1', b'1', 'Admin', 'dashboard'),
(2, b'1', b'1', b'1', 'Admin', 'Bakery'),
(3, b'1', b'1', b'1', 'Admin', 'ClientSearch'),
(4, b'1', b'1', b'1', 'Admin', 'weatCompany'),
(5, b'1', b'1', b'1', 'Admin', 'searchWeat'),
(6, b'1', b'1', b'1', 'Admin', 'createWeatCompany');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
