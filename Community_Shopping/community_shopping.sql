-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 31, 2017 at 01:42 AM
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
(5, 4, 1, '1504107369315.jpg', 'http://www.marca.com', 1, '2017-08-31', '2017-08-30 15:36:09', 1, NULL);

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
(147, 5, 1, 'Lote final', 'Lote de prueba definitivo', 1, 0, 10, '2017-08-31', '2017-08-30 22:01:49', NULL, '1504021319491.png', NULL),
(181, NULL, NULL, 'Pantalla Lcd + Tactil Con Marco Original Tablet Bq Aquaris M10 HD - Negra', 'Pantalla Lcd + Tactil Con Marco Original Tablet Bq Aquaris M10 HD - Negra', NULL, NULL, 70.34, '2017-09-01', '2017-08-30 22:02:31', NULL, 'https://images.ssstatic.com/pantalla-lcd-tactil-con-marco-original-tablet-bq-aquaris-m10-hd-negra-21226194n0-17262967.jpg', 'http://www.solostocks.com/venta-productos/telefonos-accesorios/pantallas-moviles/pantalla-lcd-tactil-con-marco-original-tablet-bq-aquaris-m10-hd-negra-21226194'),
(182, NULL, NULL, 'Parasol papel bambú blanco', 'Parasol papel bambú blanco', NULL, NULL, 4.48, '2017-09-01', '2017-08-30 22:02:31', NULL, 'https://images.ssstatic.com/parasol-papel-bambu-blanco-26992436n0-14145467.jpg', 'http://www.solostocks.com/venta-productos/regalos-promocionales-campo-playa/parasoles-promocionales/parasol-papel-bambu-blanco-26992436'),
(183, NULL, NULL, 'Mejillones de la Rías Gallegas Benimar 115gr.', 'Fabricación: Conservar Benimar (Valencia) Conserva elaborada con mejillones procedentes de las Rías Gallegas.', NULL, NULL, 1.65, '2017-09-01', '2017-08-30 22:02:31', NULL, 'https://images.ssstatic.com/mejillones-de-la-rias-gallegas-benimar-115gr-28373790n0-11035067.jpg', 'http://www.solostocks.com/venta-productos/conservas/mariscos/mejillones-de-la-rias-gallegas-benimar-115gr-28373790'),
(184, NULL, NULL, 'Pijama punto manga larga Hombre', 'Pijama punto manga larga Hombre,tallas 48-52-56-60,65% poliéster 35% algodón,color cheviot o granate.', NULL, NULL, 14.18, '2017-09-01', '2017-08-30 22:02:31', NULL, 'https://images.ssstatic.com/pijama-punto-manga-larga-hombre-13949791n0-17362267.jpg', 'http://www.solostocks.com/venta-productos/ropa-estar-casa-pijamas/pijamas/pijama-punto-manga-larga-hombre-13949791'),
(185, NULL, NULL, 'Panel De Señalizacion De Carga Posterior- No homologado', 'Panel de señalización de carga posterior NO HOMOLOGADO 50x50cmx', NULL, NULL, 7.99, '2017-09-01', '2017-08-30 22:02:33', NULL, 'https://cdn.ssstatic.com/6.10.6/img/noimg/fotoNoDisponible-67.gif', 'http://www.solostocks.com/venta-productos/seguridad-carretera/material-reflectante/panel-de-senalizacion-de-carga-posterior-no-homologado-28635309'),
(186, NULL, NULL, 'Tomate Deshidratado Seco Mironous 1 kg', 'Tomate Deshidratado Seco 1 kg', NULL, NULL, 5.2, '2017-09-01', '2017-08-30 22:02:33', NULL, 'https://images.ssstatic.com/tomate-deshidratado-seco-mironous-1-kg-9629671n0-00000067.jpg', 'http://www.solostocks.com/venta-productos/frutos-secos-semillas/otros-frutos-secos-semillas/tomate-deshidratado-seco-mironous-1-kg-9629671'),
(187, NULL, NULL, 'Dátiles en Rama Mironous 1 kg', 'Dátiles en Rama Mironous 1 kg para mas información en mironous.com', NULL, NULL, 4.75, '2017-09-01', '2017-08-30 22:02:33', NULL, 'https://images.ssstatic.com/datiles-en-rama-mironous-1-kg-10539713n0-00000067.jpg', 'http://www.solostocks.com/venta-productos/fruta/otras-frutas/datiles-en-rama-mironous-1-kg-10539713'),
(188, NULL, NULL, 'Lote pasahilos o cosedor de madera', 'Lote en liquidación de juegos de coser. Incluye dos unidades, hilo y pasador. En caja de cartón individual y retractilado. A partir de 2 años.', NULL, NULL, 1.25, '2017-09-01', '2017-08-30 22:02:34', NULL, 'https://images.ssstatic.com/lote-pasahilos-o-cosedor-de-madera-26953233n0-11401767.jpg', 'http://www.solostocks.com/venta-productos/juegos-educativos/otros-juegos-educativos/lote-pasahilos-o-cosedor-de-madera-26953233');

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

--
-- Dumping data for table `pay_order`
--

INSERT INTO `pay_order` (`Id`, `Id_advertising`, `Payment_date`, `Total`, `Pdf`) VALUES
(1, 5, '2017-08-30', 30, '150410736989620 minutos.pdf');

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
(1, NULL, 'admin', 'admin@gmail.com', 'admin1234', '1504088309510.jpg', NULL, NULL, b'0', '2017-08-30', NULL),
(2, NULL, 'user1', 'user1@gmail.com', 'user1234', '1502543005110.png', NULL, NULL, b'0', '2017-08-03', NULL),
(3, NULL, 'Francisco', 'user2@gmail.com', 'user1234', 'defecto.jpeg', NULL, NULL, b'0', '2017-08-10', NULL),
(4, 2, 'Nike', 'prov@emergya.com', '12345', 'defecto.jpeg', 'MTIzNDU2Nzg5MTAxMTEy', '20 minutos', b'1', '2017-08-28', NULL),
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
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
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
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=189;
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
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
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
  ADD CONSTRAINT `lot_ibfk_1` FOREIGN KEY (`Id_provider`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
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
