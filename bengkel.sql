-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 30, 2020 at 04:40 PM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bengkel`
--

-- --------------------------------------------------------

--
-- Table structure for table `isi`
--

CREATE TABLE `isi` (
  `no_services` varchar(50) NOT NULL,
  `kd_sp` int(11) NOT NULL,
  `jml_item` varchar(20) NOT NULL,
  `discount` varchar(20) NOT NULL,
  `jml_bayar` varchar(50) NOT NULL,
  `nm_pel` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `kd_kr` varchar(2) NOT NULL,
  `nm_kr` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `no_pegawai` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`kd_kr`, `nm_kr`, `username`, `password`, `no_pegawai`) VALUES
('1', 'Budi Hartono', 'budi', 'budi123', 1),
('2', 'Susi', 'susisusi', 'susi123', 2),
('2', 'Abdurrozzaaq Ashshiddiqi ', 'diki', 'diki123', 3);

-- --------------------------------------------------------

--
-- Table structure for table `spareparts`
--

CREATE TABLE `spareparts` (
  `kd_sp` int(11) NOT NULL,
  `nm_sp` varchar(50) NOT NULL,
  `harga` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `spareparts`
--

INSERT INTO `spareparts` (`kd_sp`, `nm_sp`, `harga`) VALUES
(1, 'Ban', '20000'),
(2, 'Oli', '50000'),
(4, 'Kampas Rem', '25000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `isi`
--
ALTER TABLE `isi`
  ADD PRIMARY KEY (`no_services`),
  ADD KEY `kd_sp` (`kd_sp`),
  ADD KEY `no_services` (`no_services`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`no_pegawai`);

--
-- Indexes for table `spareparts`
--
ALTER TABLE `spareparts`
  ADD PRIMARY KEY (`kd_sp`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `no_pegawai` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `spareparts`
--
ALTER TABLE `spareparts`
  MODIFY `kd_sp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `isi`
--
ALTER TABLE `isi`
  ADD CONSTRAINT `isi_ibfk_1` FOREIGN KEY (`kd_sp`) REFERENCES `spareparts` (`kd_sp`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
