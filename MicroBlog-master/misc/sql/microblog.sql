-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 25-05-2018 a las 08:33:04
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `microblog`
--
DROP DATABASE IF EXISTS `MicroBlog`;
CREATE DATABASE IF NOT EXISTS `MicroBlog`;
USE `MicroBlog`;

-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS `user` (
  `id_u` int(11) NOT NULL AUTO_INCREMENT,
  `Email` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Profile` text NOT NULL,
  PRIMARY KEY (`id_u`)
);
--
-- Estructura de tabla para la tabla `news`
--

CREATE TABLE IF NOT EXISTS `news` (
  `id_n` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha` datetime NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id_n`),
  FOREIGN KEY (`userId`) REFERENCES user(`id_u`)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `session`
--

CREATE TABLE IF NOT EXISTS `session` (
  `id_s` int(11) NOT NULL AUTO_INCREMENT,
  `cookies` varchar(300) NOT NULL,
  `fecha` datetime NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id_s`),
  FOREIGN KEY (`userId`) REFERENCES user(`id_u`)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--



--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `news`
--


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
