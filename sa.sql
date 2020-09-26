-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 31, 2020 at 10:20 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sa`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `aid` int(11) NOT NULL,
  `aname` varchar(50) NOT NULL,
  `aaddress` varchar(50) NOT NULL,
  `abirthdate` date NOT NULL,
  `aph1` varchar(11) NOT NULL,
  `aph2` varchar(11) NOT NULL,
  `agen` varchar(50) NOT NULL,
  `assc` varchar(50) NOT NULL,
  `ahsc` varchar(50) NOT NULL,
  `aug` varchar(50) NOT NULL,
  `apg` varchar(50) NOT NULL,
  `acompname` varchar(50) NOT NULL,
  `acomjoin` varchar(20) NOT NULL,
  `acomtime` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`aid`, `aname`, `aaddress`, `abirthdate`, `aph1`, `aph2`, `agen`, `assc`, `ahsc`, `aug`, `apg`, `acompname`, `acomjoin`, `acomtime`) VALUES
(85, 'amruta', 'pune', '0000-00-00', '9067534470', '9067534470', 'female', '66', '99', '66', '87', 'Google', '12/10/2020', '9am to 5pm'),
(86, 'rohit', 'pune', '0000-00-00', '8888189565', '8888189565', 'male', '80', '88', '75', '85', 'hcl', '27/06/2020', '9am to 6pm');

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `name` varchar(50) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`name`, `user_name`, `user_password`) VALUES
('sagar darade', '7498588568', '4215'),
('Rohit', 'rohit123', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `sid` int(11) NOT NULL,
  `sname` varchar(200) NOT NULL,
  `saddress` varchar(200) NOT NULL,
  `sbirthdate` date NOT NULL,
  `smobile` varchar(10) NOT NULL,
  `smobile2` varchar(10) NOT NULL,
  `sgender` varchar(10) NOT NULL,
  `ssc` varchar(10) NOT NULL,
  `hsc` varchar(10) NOT NULL,
  `degree` varchar(10) NOT NULL,
  `pg` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`sid`, `sname`, `saddress`, `sbirthdate`, `smobile`, `smobile2`, `sgender`, `ssc`, `hsc`, `degree`, `pg`) VALUES
(85, 'amruta', 'pune', '0000-00-00', '9067534470', '9067534470', 'female', '99', '66', '66', '87'),
(86, 'rohit', 'pune', '0000-00-00', '8888189565', '8888189565', 'male', '88', '80', '75', '85');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`sid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `sid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=87;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
