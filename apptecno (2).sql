-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 08-11-2019 a las 12:01:41
-- Versión del servidor: 5.7.24
-- Versión de PHP: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `apptecno`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

DROP TABLE IF EXISTS `estado`;
CREATE TABLE IF NOT EXISTS `estado` (
  `id` int(11) NOT NULL,
  `estado` varchar(255) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`id`, `estado`) VALUES
(1, 'En espera'),
(2, 'En camino'),
(3, 'Recibido'),
(4, 'No recibido por ausencia'),
(5, 'Error desconocido');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `localizacion`
--

DROP TABLE IF EXISTS `localizacion`;
CREATE TABLE IF NOT EXISTS `localizacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) COLLATE utf8mb4_spanish_ci NOT NULL,
  `tiempo_envio` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `localizacion`
--

INSERT INTO `localizacion` (`id`, `nombre`, `tiempo_envio`, `created_at`, `updated_at`) VALUES
(1, 'Valencia', 1, '2019-11-06 00:00:00', '2019-11-05 23:00:00'),
(2, 'Madrid', 2, '2019-11-06 00:00:00', '2019-11-05 23:00:00'),
(3, 'Barcelona', 3, '2019-11-06 00:00:00', '2019-11-05 23:00:00'),
(4, 'Sevilla', 2, '2019-11-06 00:00:00', '2019-11-05 23:00:00'),
(5, 'Bilbao', 4, '2019-11-06 00:00:00', '2019-11-05 23:00:00'),
(6, 'San Sebastias', 3, '2019-11-06 00:00:00', '2019-11-05 23:00:00'),
(7, 'Zaragoza', 3, '2019-11-06 00:00:00', '2019-11-05 23:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

DROP TABLE IF EXISTS `pedido`;
CREATE TABLE IF NOT EXISTS `pedido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_user` varchar(255) COLLATE utf8mb4_spanish_ci NOT NULL,
  `estado_id` int(11) NOT NULL,
  `incidencia` varchar(255) COLLATE utf8mb4_spanish_ci NOT NULL,
  `fecha` date NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `estado_id` (`estado_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id`, `nombre_user`, `estado_id`, `incidencia`, `fecha`, `created_at`, `updated_at`) VALUES
(1, 'Sergio', 1, '', '2019-11-08', '2019-11-06 00:00:00', '2019-11-06 00:00:00'),
(2, 'A veces tengo hambre', 3, '', '2019-11-15', '2019-11-06 00:00:00', '2019-11-06 00:00:00'),
(3, 'persona 3', 4, 'Error en el pago', '2019-11-15', '2019-11-06 00:00:00', '2019-11-06 00:00:00'),
(5, 'ewsdfewewe', 5, 'rewwewer', '2019-11-15', '2019-11-06 00:00:00', '2019-11-06 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE IF NOT EXISTS `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) COLLATE utf8mb4_spanish_ci NOT NULL,
  `precio` float NOT NULL,
  `marca` varchar(255) COLLATE utf8mb4_spanish_ci NOT NULL,
  `gigabytes` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `nombre`, `precio`, `marca`, `gigabytes`, `created_at`, `updated_at`) VALUES
(1, 'PNY Quadro RTX 6000 24GB GDDR6X\r\n', 4799, 'PNY', 24, '2019-11-07 00:00:00', '2019-11-07 00:00:00'),
(2, 'Nvidia Titan RTX 24GB GDDR6\r\n', 2719, 'Nvidia', 24, '2019-11-07 00:00:00', '2019-11-07 00:00:00'),
(3, 'Asus Rog Matrix RTX 2080Ti P11G Gaming 11GB GDDR6\r\n', 1705.9, 'Asus', 11, '2019-11-06 00:00:00', '2019-11-07 00:00:00'),
(4, 'Gigabyte GeForce RTX 2070 Super Windforce OC 3X 8GB GDDR6\r\n', 549.9, 'Gigabyte', 8, '2019-11-06 00:00:00', '2019-11-06 00:00:00'),
(5, 'PNY GeForce GTX 1660 6GB GDDR5 XLR8 Gaming Overclocked Limited Edition\r\n', 209.9, 'PNY', 6, '2019-11-06 00:00:00', '2019-11-06 00:00:00'),
(6, 'Sapphire Nitro+ Radeon RX 5700 XT 8GB GDDR6\r\n', 469.9, 'Shappire', 8, '2019-11-06 00:00:00', '2019-11-06 00:00:00'),
(7, 'MSI GeForce GTX 1660 Ti Ventus XS 6GB GDDR6\r\n', 304.9, 'MSI', 6, '2019-11-06 00:00:00', '2019-11-06 00:00:00'),
(8, 'Gigabyte GeForce GT 710 2GB GDDR5\r\n', 41.99, 'Gigabyte', 2, '2019-11-06 00:00:00', '2019-11-06 00:00:00'),
(9, 'Gigabyte AMD Radeon RX 5700 XT Gaming OC 8GB GDDR6\r\n', 445.9, 'Gigabyte', 8, '2019-11-06 00:00:00', '2019-11-06 00:00:00'),
(10, 'MSI GeForce RTX 2080 SUPER Gaming X Trio 8 GB GDDR6\r\n', 824.9, 'Msi', 8, '2019-11-06 00:00:00', '2019-11-06 00:00:00');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
