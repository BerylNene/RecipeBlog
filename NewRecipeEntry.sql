-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2015 at 08:56 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `recipeblog`
--

-- --------------------------------------------------------

--
-- Table structure for table `newrecipeentry`
--

CREATE TABLE IF NOT EXISTS `newrecipeentry` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `author` varchar(50) NOT NULL,
  `category` varchar(100) NOT NULL,
  `recipeName` varchar(100) NOT NULL,
  `ingredient` varchar(1000) NOT NULL,
  `step` varchar(1000) NOT NULL,
   `dateCreated` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `newrecipeentry`
--

INSERT INTO `newrecipeentry` (`id`, `email`, `author`, `category`, `recipeName`, `ingredient`, `step`, `dateCreated`) VALUES
(1, 'nenebawoberyl@gmail.com', 'Beryl Nene', '', 'Jollof Rice', 'rice\r\ntomato\r\npepper\r\nvegetable oil\r\nsalt\r\nmaggi', '1. preboil rice\r\n2. put pot on medium heat fire then add rice, blended tomato, pepper, onion, salt to taste, maggi and vegetable oil and water to cook the rice\r\n3. leave to boil with stiring it. \r\n4. then when the rice is fully cooked then stir the rice.\r\n5. serve hot with chicken or gizzard, beef or any thing of you choice.', '2015-04-14 21:24:34'),
(2, 'nenebawoberyl@gmail.com', 'Beryl Nene', '', 'Fried Rice', 'rice\r\ncurry\r\nthyme\r\npepper\r\nvegetable oil\r\nwater\r\nsalt\r\nmaggi', 'put rice and all ingredients into pot and cook', '2015-04-14 21:30:40');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
