# Practica4DAO

IMAGENES

![admi1](https://user-images.githubusercontent.com/66339650/83952954-4341ad00-a802-11ea-8765-36485bcd238f.jpg)
![admin2](https://user-images.githubusercontent.com/66339650/83952959-49d02480-a802-11ea-9808-6301d759f566.png)
![admin3](https://user-images.githubusercontent.com/66339650/83952968-56ed1380-a802-11ea-8a8f-3c9f506d471d.png)
![admin4](https://user-images.githubusercontent.com/66339650/83952971-5a809a80-a802-11ea-99e8-970c2f92fb90.jpg)
![admin5](https://user-images.githubusercontent.com/66339650/83952974-61a7a880-a802-11ea-8272-3a56f10e223a.jpg)

BASE DE DATOS

-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-05-2020 a las 17:58:59
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_blog`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `blog`
--

CREATE TABLE `blog` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `contenido` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `blog`
--

INSERT INTO `blog` (`id`, `fecha`, `titulo`, `contenido`) VALUES
(5, '2020-05-26', 'Salud', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n			tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\n			quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\n			consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\n			cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\n			proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `usuario`, `password`) VALUES
(1, 'heber', 'heber');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `blog`
--
ALTER TABLE `blog`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `blog`
--
ALTER TABLE `blog`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
