-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2018 at 12:13 PM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `springdemodb`
--
CREATE DATABASE IF NOT EXISTS `springdemodb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `springdemodb`;

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `read_foodgroup_name_desc` (IN `in_id` INT(11), OUT `group_name` VARCHAR(45), OUT `group_description` VARCHAR(100))  BEGIN
  SELECT 
  	name, description INTO group_name, group_description
  FROM
  	foodgroups
  WHERE 
  	id = in_id;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `foodgroups`
--

CREATE TABLE `foodgroups` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `foodgroups`
--

INSERT INTO `foodgroups` (`id`, `name`, `description`) VALUES
(1, 'Fruits', 'Hi I\'m fruit. I come from plants or trees.'),
(2, 'Vegetables', 'Hi. I\'m vegetable. I come from plants.'),
(3, 'Grains', 'Hi. I\'m a grain. I\'m small hard seed'),
(4, 'Meats', 'Hi. I\'m meat. I\'m animal flesh'),
(6, 'Dairy', 'Hi. I\'m dairy.');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `foodgroups`
--
ALTER TABLE `foodgroups`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `foodgroups`
--
ALTER TABLE `foodgroups`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
