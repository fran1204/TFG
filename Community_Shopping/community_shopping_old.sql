-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 17-08-2017 a las 09:14:12
-- Versión del servidor: 5.7.19-0ubuntu0.16.04.1
-- Versión de PHP: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `community_shopping`
--
CREATE DATABASE IF NOT EXISTS `community_shopping` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `community_shopping`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `advertising`
--

CREATE TABLE `advertising` (
  `Id` int(10) NOT NULL,
  `Id_provider` int(11) NOT NULL,
  `id_category` int(11) NOT NULL,
  `Image` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `Url` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `Created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Duration` int(11) NOT NULL,
  `deletion_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `advertising`
--

INSERT INTO `advertising` (`Id`, `Id_provider`, `id_category`, `Image`, `Url`, `Created_date`, `Duration`, `deletion_date`) VALUES
(4, 1, 1, '1502883348738.jpg', 'https://www.emergya.com', '2017-08-16 11:35:49', 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `type` varchar(150) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `category`
--

INSERT INTO `category` (`id`, `type`) VALUES
(1, 'Camisetas'),
(2, 'Zapatos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `channel`
--

CREATE TABLE `channel` (
  `Id` int(10) NOT NULL,
  `Social_network` varchar(100) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `channel`
--

INSERT INTO `channel` (`Id`, `Social_network`) VALUES
(1, 'Facebook'),
(2, 'Twitter');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gallery`
--

CREATE TABLE `gallery` (
  `Id` int(11) NOT NULL,
  `Id_lotDetail` int(11) NOT NULL,
  `url` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `deletion_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `interlocutor_order`
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
  `deletion_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `interlocutor_order`
--

INSERT INTO `interlocutor_order` (`Id`, `Id_interlocutor`, `Id_order`, `Id_lotDetail`, `Paid_total`, `Amount`, `Date_purchase`, `Created_date`, `deletion_date`) VALUES
(3, 2, 1, 2, 1, 9, NULL, '2017-08-15 17:14:12', NULL),
(4, 3, 1, 2, 2, 0, NULL, '2017-08-15 17:14:16', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lot`
--

CREATE TABLE `lot` (
  `Id` int(10) NOT NULL,
  `Id_provider` int(11) NOT NULL,
  `id_category` int(11) NOT NULL,
  `title` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `description` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `Num_set` int(11) NOT NULL,
  `quantity_available` int(11) DEFAULT NULL,
  `price` float NOT NULL,
  `expiry_date` date DEFAULT NULL,
  `Create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deletion_date` date DEFAULT NULL,
  `photo` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `lot`
--

INSERT INTO `lot` (`Id`, `Id_provider`, `id_category`, `title`, `description`, `Num_set`, `quantity_available`, `price`, `expiry_date`, `Create_date`, `deletion_date`, `photo`) VALUES
(2, 1, 2, 'Lote de prueba 1', 'Botines Nike para salir', 10, 1, 29.9, '2017-08-20', '2017-08-14 08:05:44', NULL, '1502697943914.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lot_detail`
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
-- Volcado de datos para la tabla `lot_detail`
--

INSERT INTO `lot_detail` (`Id`, `Id_lot`, `Title`, `Publish`, `Quantity`, `color`, `size`, `capacity`, `quantity_available`, `Created_date`, `deletion_date`) VALUES
(2, 2, 'detalle 1', 1, 10, 'Verde', '44', 0, 1, '2017-08-14 08:05:56', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `order`
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
-- Volcado de datos para la tabla `order`
--

INSERT INTO `order` (`Id`, `Id_lot`, `Id_leader`, `state_order`, `Created_date`, `Date_purchase`, `deletion_date`) VALUES
(1, 2, 2, 'Abierto', '2017-08-14 09:21:06', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `payment_method`
--

CREATE TABLE `payment_method` (
  `Id` int(10) NOT NULL,
  `Type` varchar(100) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `payment_method`
--

INSERT INTO `payment_method` (`Id`, `Type`) VALUES
(1, 'Paypal'),
(2, 'MasterCard');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pay_order`
--

CREATE TABLE `pay_order` (
  `Id` int(10) NOT NULL,
  `Id_advertising` int(11) NOT NULL,
  `Payment_date` date NOT NULL,
  `Total` int(11) NOT NULL,
  `Pdf` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `purchase`
--

CREATE TABLE `purchase` (
  `Id` int(10) NOT NULL,
  `Id_order` int(11) NOT NULL,
  `Id_interlocutor` int(11) NOT NULL,
  `Date_purchase` date NOT NULL,
  `Id_paymentmethod` int(11) NOT NULL,
  `Total` int(11) NOT NULL,
  `Pdf` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sector`
--

CREATE TABLE `sector` (
  `id` int(11) NOT NULL,
  `sector` varchar(150) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `sector`
--

INSERT INTO `sector` (`id`, `sector`) VALUES
(1, 'Informatica'),
(2, 'Moda');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `share`
--

CREATE TABLE `share` (
  `Id` int(10) NOT NULL,
  `Id_interlocutor` int(11) NOT NULL,
  `Id_lot` int(11) NOT NULL,
  `Id_channel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `id_sector` int(11) DEFAULT NULL,
  `name` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `photo` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `bank` int(11) DEFAULT NULL,
  `company_name` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,
  `provider` bit(1) NOT NULL,
  `create_date` date NOT NULL,
  `delete_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `id_sector`, `name`, `email`, `password`, `photo`, `bank`, `company_name`, `provider`, `create_date`, `delete_date`) VALUES
(1, 1, 'Proveedor1', 'proveedor1@emergya.com', 'proveedor1', '1502698057671.JPG', 123456789, 'Emergya', b'1', '2017-08-03', NULL),
(2, NULL, 'user1', 'user1@gmail.com', 'user1234', '1502543005110.png', NULL, NULL, b'0', '2017-08-03', NULL),
(3, NULL, 'Francisco', 'user2@gmail.com', 'user1234', 'defecto.jpeg', NULL, NULL, b'0', '2017-08-10', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `advertising`
--
ALTER TABLE `advertising`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_provider` (`Id_provider`),
  ADD KEY `id_category` (`id_category`);

--
-- Indices de la tabla `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `channel`
--
ALTER TABLE `channel`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `gallery`
--
ALTER TABLE `gallery`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_lotDetail` (`Id_lotDetail`);

--
-- Indices de la tabla `interlocutor_order`
--
ALTER TABLE `interlocutor_order`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_interlocutor` (`Id_interlocutor`),
  ADD KEY `Id_order` (`Id_order`),
  ADD KEY `Id_lotDetail` (`Id_lotDetail`);

--
-- Indices de la tabla `lot`
--
ALTER TABLE `lot`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_provider` (`Id_provider`),
  ADD KEY `id_category` (`id_category`);

--
-- Indices de la tabla `lot_detail`
--
ALTER TABLE `lot_detail`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_lot` (`Id_lot`);

--
-- Indices de la tabla `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_offer` (`Id_lot`),
  ADD KEY `Id_leader` (`Id_leader`);

--
-- Indices de la tabla `payment_method`
--
ALTER TABLE `payment_method`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `pay_order`
--
ALTER TABLE `pay_order`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_advertising` (`Id_advertising`);

--
-- Indices de la tabla `purchase`
--
ALTER TABLE `purchase`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_order` (`Id_order`),
  ADD KEY `Payment_method` (`Id_paymentmethod`),
  ADD KEY `Id_interlocutor` (`Id_interlocutor`);

--
-- Indices de la tabla `sector`
--
ALTER TABLE `sector`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `share`
--
ALTER TABLE `share`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_interlocutor` (`Id_interlocutor`),
  ADD KEY `Id_offer` (`Id_lot`),
  ADD KEY `Id_channel` (`Id_channel`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_ojlaaseef8auyyrc5r1w4x7ao` (`id_sector`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `advertising`
--
ALTER TABLE `advertising`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `channel`
--
ALTER TABLE `channel`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `gallery`
--
ALTER TABLE `gallery`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `interlocutor_order`
--
ALTER TABLE `interlocutor_order`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `lot`
--
ALTER TABLE `lot`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `lot_detail`
--
ALTER TABLE `lot_detail`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `order`
--
ALTER TABLE `order`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `payment_method`
--
ALTER TABLE `payment_method`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `pay_order`
--
ALTER TABLE `pay_order`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `purchase`
--
ALTER TABLE `purchase`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `sector`
--
ALTER TABLE `sector`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `share`
--
ALTER TABLE `share`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `advertising`
--
ALTER TABLE `advertising`
  ADD CONSTRAINT `advertising_ibfk_1` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `provider_advertising` FOREIGN KEY (`Id_provider`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `gallery`
--
ALTER TABLE `gallery`
  ADD CONSTRAINT `gallery_lotDetail` FOREIGN KEY (`Id_lotDetail`) REFERENCES `lot_detail` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `interlocutor_order`
--
ALTER TABLE `interlocutor_order`
  ADD CONSTRAINT `FK_69a9ojt5syipjov2m5ehpjouk` FOREIGN KEY (`Id_order`) REFERENCES `order` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Interlocutor_order` FOREIGN KEY (`Id_interlocutor`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `interlocutor_order_ibfk_1` FOREIGN KEY (`Id_lotDetail`) REFERENCES `lot_detail` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `lot`
--
ALTER TABLE `lot`
  ADD CONSTRAINT `lot_ibfk_1` FOREIGN KEY (`Id_provider`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `lot_ibfk_2` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`);

--
-- Filtros para la tabla `lot_detail`
--
ALTER TABLE `lot_detail`
  ADD CONSTRAINT `lot_detail_ibfk_1` FOREIGN KEY (`Id_lot`) REFERENCES `lot` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `FK_omb1t0737o3pyup79s7jmwk2t` FOREIGN KEY (`Id_leader`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `order_ibfk_1` FOREIGN KEY (`Id_lot`) REFERENCES `lot` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pay_order`
--
ALTER TABLE `pay_order`
  ADD CONSTRAINT `Payorder_advertising` FOREIGN KEY (`Id_advertising`) REFERENCES `advertising` (`Id`);

--
-- Filtros para la tabla `purchase`
--
ALTER TABLE `purchase`
  ADD CONSTRAINT `FK_dmjk7vhynv07q96q7uqy6f73a` FOREIGN KEY (`Id_order`) REFERENCES `order` (`Id`),
  ADD CONSTRAINT `Purchase_interlocutor` FOREIGN KEY (`Id_interlocutor`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `Purchase_paymentmethod` FOREIGN KEY (`Id_paymentmethod`) REFERENCES `payment_method` (`Id`);

--
-- Filtros para la tabla `share`
--
ALTER TABLE `share`
  ADD CONSTRAINT `Share_channel` FOREIGN KEY (`Id_channel`) REFERENCES `channel` (`Id`),
  ADD CONSTRAINT `Share_interlocutor` FOREIGN KEY (`Id_interlocutor`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `Share_offer` FOREIGN KEY (`Id_lot`) REFERENCES `lot` (`Id`);

--
-- Filtros para la tabla `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_ojlaaseef8auyyrc5r1w4x7ao` FOREIGN KEY (`id_sector`) REFERENCES `sector` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
