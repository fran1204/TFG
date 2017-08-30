-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 30, 2017 at 02:10 AM
-- Server version: 5.7.19-0ubuntu0.16.04.1
-- PHP Version: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `community_shopping`
--
CREATE DATABASE IF NOT EXISTS `community_shopping` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `community_shopping`;

-- --------------------------------------------------------

--
-- Table structure for table `advertising`
--

CREATE TABLE `advertising` (
  `Id` int(10) NOT NULL,
  `Id_provider` int(11) NOT NULL,
  `id_category` int(11) NOT NULL,
  `Image` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `Url` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `pagado` tinyint(1) DEFAULT NULL,
  `purshace_date` date DEFAULT NULL,
  `Created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Duration` int(11) NOT NULL,
  `deletion_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `advertising`
--

INSERT INTO `advertising` (`Id`, `Id_provider`, `id_category`, `Image`, `Url`, `pagado`, `purshace_date`, `Created_date`, `Duration`, `deletion_date`) VALUES
(4, 1, 1, '1502883348738.jpg', 'https://www.emergya.com', NULL, NULL, '2017-08-16 11:35:49', 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `type` varchar(150) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `type`) VALUES
(1, 'Camisetas'),
(2, 'Zapatos');

-- --------------------------------------------------------

--
-- Table structure for table `channel`
--

CREATE TABLE `channel` (
  `Id` int(10) NOT NULL,
  `Social_network` varchar(100) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `channel`
--

INSERT INTO `channel` (`Id`, `Social_network`) VALUES
(1, 'Facebook'),
(2, 'Twitter');

-- --------------------------------------------------------

--
-- Table structure for table `gallery`
--

CREATE TABLE `gallery` (
  `Id` int(11) NOT NULL,
  `Id_lotDetail` int(11) NOT NULL,
  `url` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `deletion_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `interlocutor_order`
--

CREATE TABLE `interlocutor_order` (
  `Id` int(10) NOT NULL,
  `Id_interlocutor` int(11) NOT NULL,
  `Id_order` int(11) NOT NULL,
  `Id_lotDetail` int(11) NOT NULL,
  `Paid_total` float NOT NULL,
  `Amount` int(11) NOT NULL,
  `Date_purchase` date DEFAULT NULL,
  `Created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deletion_date` date DEFAULT NULL,
  `state` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `interlocutor_order`
--

INSERT INTO `interlocutor_order` (`Id`, `Id_interlocutor`, `Id_order`, `Id_lotDetail`, `Paid_total`, `Amount`, `Date_purchase`, `Created_date`, `deletion_date`, `state`) VALUES
(9, 3, 1, 2, 20, 3, '2017-08-29', '2017-08-28 20:14:17', NULL, 'pagado'),
(10, 2, 2, 3, 10, 1, '2017-08-29', '2017-08-29 15:55:02', NULL, 'pagado');

-- --------------------------------------------------------

--
-- Table structure for table `lot`
--

CREATE TABLE `lot` (
  `Id` int(10) NOT NULL,
  `Id_provider` int(11) DEFAULT NULL,
  `id_category` int(11) DEFAULT NULL,
  `title` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `description` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `Num_set` int(11) DEFAULT NULL,
  `quantity_available` int(11) DEFAULT NULL,
  `price` float NOT NULL,
  `expiry_date` date DEFAULT NULL,
  `Create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deletion_date` date DEFAULT NULL,
  `photo` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `url_external` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `lot`
--

INSERT INTO `lot` (`Id`, `Id_provider`, `id_category`, `title`, `description`, `Num_set`, `quantity_available`, `price`, `expiry_date`, `Create_date`, `deletion_date`, `photo`, `url_external`) VALUES
(2, 1, 1, 'Lote de prueba 1', 'Botines Nike para salir', 10, 3, 29.9, '2017-08-30', '2017-08-29 09:46:30', NULL, '1502697943914.jpg', ''),
(130, NULL, NULL, '', 'MOTOSIERRAS DE GASOLINA SOVEREIGN - DEVOLUCION DE LOS CLIENTES', NULL, NULL, 1, '2017-08-29', '2017-08-28 11:01:32', NULL, 'https://img.merkandi.com/imgcache/290x190/offer/arll-sovereign-petrol-chain-saw5-customer-returns-164-1503917565-1503917573.jpg', 'https://merkandi.com/products/motosierras-de-gasolina-sovereign-devolucion-de-los-clientes/141645'),
(131, NULL, NULL, '', 'John Richmond pullovers - nueva colección', NULL, NULL, 16.95, '2017-08-29', '2017-08-28 11:01:32', NULL, 'https://img.merkandi.com/imgcache/290x190/offer/img-3068-1503863993-1503864074.jpg', 'https://merkandi.com/products/john-richmond-pullovers-nueva-coleccion/141616'),
(132, NULL, NULL, '', 'SUDADERAS ,JOVENES (REPORTER)', NULL, NULL, 3.5, '2017-08-29', '2017-08-28 11:01:32', NULL, 'https://img.merkandi.com/imgcache/290x190/offer/3-max-1503854156-1503854186.jpg', 'https://merkandi.com/products/sudaderas-jovenes-reporter/141613'),
(133, NULL, NULL, '', 'Daikin FTXB50C / RXB50C', NULL, NULL, 560, '2017-08-29', '2017-08-28 11:01:32', NULL, 'https://img.merkandi.com/imgcache/290x190/offer/daikinjpg50-1503772806-1503772824.jpg', 'https://merkandi.com/products/daikin-ftxb50c-rxb50c/141608'),
(134, NULL, NULL, '', 'Inverter acondicionador de aire Daikin FTX25KM / RX25KM', NULL, NULL, 300, '2017-08-29', '2017-08-28 11:01:32', NULL, 'https://img.merkandi.com/imgcache/290x190/offer/daikinjpg1-1503772098-1503772157.jpg', 'https://merkandi.com/products/inverter-acondicionador-de-aire-daikin-ftx25km-rx25km/141607'),
(135, NULL, NULL, '', 'Aire acondicionado Lomo - inversor mono-split system', NULL, NULL, 300, '2017-08-29', '2017-08-28 11:01:32', NULL, 'https://img.merkandi.com/imgcache/290x190/offer/lomo-gree-1503770658-1503770900.jpg', 'https://merkandi.com/products/aire-acondicionado-lomo-inversor-mono-split-system/141606'),
(136, NULL, NULL, '', 'Acondicionadores de aire Greer lomo', NULL, NULL, 280, '2017-08-29', '2017-08-28 11:01:32', NULL, 'https://img.merkandi.com/imgcache/290x190/offer/gree-lomo-gwh09qb-k3nn2a-600x600-1503768813-1503769119.jpg', 'https://merkandi.com/products/acondicionadores-de-aire-greer-lomo/141605'),
(137, NULL, NULL, '', 'Chaqueta para hombre John Richmond con un 92% de descuento en PVP', NULL, NULL, 53, '2017-08-29', '2017-08-28 11:01:32', NULL, 'https://img.merkandi.com/imgcache/290x190/offer/img-6280-1503766880-1503766921.jpg', 'https://merkandi.com/products/chaqueta-para-hombre-john-richmond-con-un-92-de-descuento-en-pvp/141604'),
(138, NULL, NULL, '', 'MOTOSIERRAS DE GASOLINA SOVEREIGN - DEVOLUCION DE LOS CLIENTES', NULL, NULL, 1, '2017-08-29', '2017-08-28 11:01:33', NULL, 'https://img.merkandi.com/imgcache/290x190/offer/arll-sovereign-petrol-chain-saw5-customer-returns-164-1503917565-1503917573.jpg', 'https://merkandi.com/products/motosierras-de-gasolina-sovereign-devolucion-de-los-clientes/141645'),
(139, NULL, NULL, '', 'John Richmond pullovers - nueva colección', NULL, NULL, 16.95, '2017-08-29', '2017-08-28 11:01:33', NULL, 'https://img.merkandi.com/imgcache/290x190/offer/img-3068-1503863993-1503864074.jpg', 'https://merkandi.com/products/john-richmond-pullovers-nueva-coleccion/141616'),
(140, NULL, NULL, '', 'SUDADERAS ,JOVENES (REPORTER)', NULL, NULL, 3.5, '2017-08-29', '2017-08-28 11:01:33', NULL, 'https://img.merkandi.com/imgcache/290x190/offer/3-max-1503854156-1503854186.jpg', 'https://merkandi.com/products/sudaderas-jovenes-reporter/141613'),
(141, NULL, NULL, '', 'Daikin FTXB50C / RXB50C', NULL, NULL, 560, '2017-08-29', '2017-08-28 11:01:33', NULL, 'https://img.merkandi.com/imgcache/290x190/offer/daikinjpg50-1503772806-1503772824.jpg', 'https://merkandi.com/products/daikin-ftxb50c-rxb50c/141608'),
(142, NULL, NULL, '', 'Inverter acondicionador de aire Daikin FTX25KM / RX25KM', NULL, NULL, 300, '2017-08-29', '2017-08-28 11:01:33', NULL, 'https://img.merkandi.com/imgcache/290x190/offer/daikinjpg1-1503772098-1503772157.jpg', 'https://merkandi.com/products/inverter-acondicionador-de-aire-daikin-ftx25km-rx25km/141607'),
(143, NULL, NULL, '', 'Aire acondicionado Lomo - inversor mono-split system', NULL, NULL, 300, '2017-08-29', '2017-08-28 11:01:33', NULL, 'https://img.merkandi.com/imgcache/290x190/offer/lomo-gree-1503770658-1503770900.jpg', 'https://merkandi.com/products/aire-acondicionado-lomo-inversor-mono-split-system/141606'),
(144, NULL, NULL, '', 'Acondicionadores de aire Greer lomo', NULL, NULL, 280, '2017-08-29', '2017-08-28 11:01:33', NULL, 'https://img.merkandi.com/imgcache/290x190/offer/gree-lomo-gwh09qb-k3nn2a-600x600-1503768813-1503769119.jpg', 'https://merkandi.com/products/acondicionadores-de-aire-greer-lomo/141605'),
(145, NULL, NULL, '', 'Chaqueta para hombre John Richmond con un 92% de descuento en PVP', NULL, NULL, 53, '2017-08-29', '2017-08-28 11:01:33', NULL, 'https://img.merkandi.com/imgcache/290x190/offer/img-6280-1503766880-1503766921.jpg', 'https://merkandi.com/products/chaqueta-para-hombre-john-richmond-con-un-92-de-descuento-en-pvp/141604'),
(146, NULL, NULL, '', 'LAVADORAS HOOVER / CANDY 8 , 9 , 10 , 12 , 13KG', NULL, NULL, 145, '2017-08-29', '2017-08-28 11:01:34', NULL, 'https://img.merkandi.com/imgcache/290x190/offer/img-20161104-wa0007-1503512226-1503512298.jpg', 'https://merkandi.com/products/lavadoras-hoover-candy-8-9-10-12-13kg/141404'),
(147, 5, 1, 'Lote final', 'Lote de prueba definitivo', 1, 0, 10, '2017-08-30', '2017-08-29 15:41:59', NULL, '1504021319491.png', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `lot_detail`
--

CREATE TABLE `lot_detail` (
  `Id` int(10) NOT NULL,
  `Id_lot` int(11) NOT NULL,
  `Title` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `Publish` tinyint(1) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `color` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `size` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `quantity_available` int(11) DEFAULT NULL,
  `Created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deletion_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `lot_detail`
--

INSERT INTO `lot_detail` (`Id`, `Id_lot`, `Title`, `Publish`, `Quantity`, `color`, `size`, `capacity`, `quantity_available`, `Created_date`, `deletion_date`) VALUES
(2, 2, 'detalle 1', 1, 10, 'Verde', '44', 0, 3, '2017-08-28 16:38:30', NULL),
(3, 147, 'Clase User', 1, 1, 'Verde', 'M', 0, 0, '2017-08-29 15:43:47', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `Id` int(10) NOT NULL,
  `Id_lot` int(11) NOT NULL,
  `Id_leader` int(11) DEFAULT NULL,
  `state_order` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `Created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Date_purchase` date DEFAULT NULL,
  `deletion_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`Id`, `Id_lot`, `Id_leader`, `state_order`, `Created_date`, `Date_purchase`, `deletion_date`) VALUES
(1, 2, 3, 'Abierto', '2017-08-29 09:47:04', NULL, NULL),
(2, 147, 2, 'Pagado', '2017-08-29 23:56:39', '2017-08-30', '2017-08-30');

-- --------------------------------------------------------

--
-- Table structure for table `payment_method`
--

CREATE TABLE `payment_method` (
  `Id` int(10) NOT NULL,
  `Type` varchar(100) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `payment_method`
--

INSERT INTO `payment_method` (`Id`, `Type`) VALUES
(1, 'Paypal'),
(2, 'MasterCard');

-- --------------------------------------------------------

--
-- Table structure for table `pay_order`
--

CREATE TABLE `pay_order` (
  `Id` int(10) NOT NULL,
  `Id_advertising` int(11) NOT NULL,
  `Payment_date` date NOT NULL,
  `Total` float NOT NULL,
  `Pdf` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

CREATE TABLE `purchase` (
  `Id` int(10) NOT NULL,
  `Id_order` int(11) NOT NULL,
  `Id_interlocutor` int(11) NOT NULL,
  `Date_purchase` date NOT NULL,
  `Total` float NOT NULL,
  `Pdf` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `purchase`
--

INSERT INTO `purchase` (`Id`, `Id_order`, `Id_interlocutor`, `Date_purchase`, `Total`, `Pdf`) VALUES
(6, 2, 2, '2017-08-30', 10, '1504051021295Lote final.pdf');

-- --------------------------------------------------------

--
-- Table structure for table `sector`
--

CREATE TABLE `sector` (
  `id` int(11) NOT NULL,
  `sector` varchar(150) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `sector`
--

INSERT INTO `sector` (`id`, `sector`) VALUES
(1, 'Informatica'),
(2, 'Moda');

-- --------------------------------------------------------

--
-- Table structure for table `share`
--

CREATE TABLE `share` (
  `Id` int(10) NOT NULL,
  `Id_interlocutor` int(11) NOT NULL,
  `Id_lot` int(11) NOT NULL,
  `Id_channel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `id_sector` int(11) DEFAULT NULL,
  `name` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `photo` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `bank` varchar(24) COLLATE utf8_spanish_ci DEFAULT NULL,
  `company_name` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,
  `provider` bit(1) NOT NULL,
  `create_date` date NOT NULL,
  `delete_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `id_sector`, `name`, `email`, `password`, `photo`, `bank`, `company_name`, `provider`, `create_date`, `delete_date`) VALUES
(1, 1, 'Proveedor1', 'proveedor1@emergya.com', 'proveedor1', '1502698057671.JPG', '123456789', 'Emergya', b'1', '2017-08-03', NULL),
(2, NULL, 'user1', 'user1@gmail.com', 'user1234', '1502543005110.png', NULL, NULL, b'0', '2017-08-03', NULL),
(3, NULL, 'Francisco', 'user2@gmail.com', 'user1234', 'defecto.jpeg', NULL, NULL, b'0', '2017-08-10', NULL),
(4, 2, '', 'prov@emergya.com', '12345', 'defecto.jpeg', '123456789', '20 minutos', b'1', '2017-08-28', NULL),
(5, 1, 'Fatima', 'pro@gmail.com', 'pro1234', '1504021151833.jpg', 'MTIzNDU2Nzg5MTAxMTEy', 'Dell', b'1', '2017-08-29', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `advertising`
--
ALTER TABLE `advertising`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_provider` (`Id_provider`),
  ADD KEY `id_category` (`id_category`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `channel`
--
ALTER TABLE `channel`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `gallery`
--
ALTER TABLE `gallery`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_lotDetail` (`Id_lotDetail`);

--
-- Indexes for table `interlocutor_order`
--
ALTER TABLE `interlocutor_order`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_interlocutor` (`Id_interlocutor`),
  ADD KEY `Id_order` (`Id_order`),
  ADD KEY `Id_lotDetail` (`Id_lotDetail`);

--
-- Indexes for table `lot`
--
ALTER TABLE `lot`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_provider` (`Id_provider`),
  ADD KEY `id_category` (`id_category`);

--
-- Indexes for table `lot_detail`
--
ALTER TABLE `lot_detail`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_lot` (`Id_lot`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_offer` (`Id_lot`),
  ADD KEY `Id_leader` (`Id_leader`);

--
-- Indexes for table `payment_method`
--
ALTER TABLE `payment_method`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `pay_order`
--
ALTER TABLE `pay_order`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_advertising` (`Id_advertising`);

--
-- Indexes for table `purchase`
--
ALTER TABLE `purchase`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_order` (`Id_order`),
  ADD KEY `Id_interlocutor` (`Id_interlocutor`);

--
-- Indexes for table `sector`
--
ALTER TABLE `sector`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `share`
--
ALTER TABLE `share`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_interlocutor` (`Id_interlocutor`),
  ADD KEY `Id_offer` (`Id_lot`),
  ADD KEY `Id_channel` (`Id_channel`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_ojlaaseef8auyyrc5r1w4x7ao` (`id_sector`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `advertising`
--
ALTER TABLE `advertising`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `channel`
--
ALTER TABLE `channel`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `gallery`
--
ALTER TABLE `gallery`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `interlocutor_order`
--
ALTER TABLE `interlocutor_order`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `lot`
--
ALTER TABLE `lot`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=148;
--
-- AUTO_INCREMENT for table `lot_detail`
--
ALTER TABLE `lot_detail`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `payment_method`
--
ALTER TABLE `payment_method`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `pay_order`
--
ALTER TABLE `pay_order`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `purchase`
--
ALTER TABLE `purchase`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `sector`
--
ALTER TABLE `sector`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `share`
--
ALTER TABLE `share`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `advertising`
--
ALTER TABLE `advertising`
  ADD CONSTRAINT `advertising_ibfk_1` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `provider_advertising` FOREIGN KEY (`Id_provider`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `gallery`
--
ALTER TABLE `gallery`
  ADD CONSTRAINT `gallery_lotDetail` FOREIGN KEY (`Id_lotDetail`) REFERENCES `lot_detail` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `interlocutor_order`
--
ALTER TABLE `interlocutor_order`
  ADD CONSTRAINT `FK_69a9ojt5syipjov2m5ehpjouk` FOREIGN KEY (`Id_order`) REFERENCES `order` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Interlocutor_order` FOREIGN KEY (`Id_interlocutor`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `interlocutor_order_ibfk_1` FOREIGN KEY (`Id_lotDetail`) REFERENCES `lot_detail` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `lot`
--
ALTER TABLE `lot`
  ADD CONSTRAINT `lot_ibfk_1` FOREIGN KEY (`Id_provider`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `lot_ibfk_2` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`);

--
-- Constraints for table `lot_detail`
--
ALTER TABLE `lot_detail`
  ADD CONSTRAINT `lot_detail_ibfk_1` FOREIGN KEY (`Id_lot`) REFERENCES `lot` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `FK_omb1t0737o3pyup79s7jmwk2t` FOREIGN KEY (`Id_leader`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `order_ibfk_1` FOREIGN KEY (`Id_lot`) REFERENCES `lot` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pay_order`
--
ALTER TABLE `pay_order`
  ADD CONSTRAINT `Payorder_advertising` FOREIGN KEY (`Id_advertising`) REFERENCES `advertising` (`Id`);

--
-- Constraints for table `purchase`
--
ALTER TABLE `purchase`
  ADD CONSTRAINT `FK_dmjk7vhynv07q96q7uqy6f73a` FOREIGN KEY (`Id_order`) REFERENCES `order` (`Id`),
  ADD CONSTRAINT `Purchase_interlocutor` FOREIGN KEY (`Id_interlocutor`) REFERENCES `user` (`id`);

--
-- Constraints for table `share`
--
ALTER TABLE `share`
  ADD CONSTRAINT `Share_channel` FOREIGN KEY (`Id_channel`) REFERENCES `channel` (`Id`),
  ADD CONSTRAINT `Share_interlocutor` FOREIGN KEY (`Id_interlocutor`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `Share_offer` FOREIGN KEY (`Id_lot`) REFERENCES `lot` (`Id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_ojlaaseef8auyyrc5r1w4x7ao` FOREIGN KEY (`id_sector`) REFERENCES `sector` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
