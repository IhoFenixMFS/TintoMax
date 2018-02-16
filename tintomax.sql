-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-02-2018 a las 19:40:01
-- Versión del servidor: 10.1.30-MariaDB
-- Versión de PHP: 5.6.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tintomax`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

CREATE TABLE `facturas` (
  `num_factura` int(11) NOT NULL,
  `dni` varchar(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `fecha` date NOT NULL,
  `ticket_asoc` int(11) NOT NULL,
  `importe_siva` double NOT NULL,
  `importe_civa` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prendas`
--

CREATE TABLE `prendas` (
  `num_prenda` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `limpieza_siva` double NOT NULL,
  `limpiezac_iva` double NOT NULL,
  `plancha_siva` double NOT NULL,
  `plancha_civa` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recibos`
--

CREATE TABLE `recibos` (
  `num_ticket` int(11) NOT NULL,
  `tot_prendas` int(11) NOT NULL,
  `DNI_cliente` varchar(11) NOT NULL,
  `Atendido` varchar(20) NOT NULL,
  `fecha_entrada` date NOT NULL,
  `salida_apx` date NOT NULL,
  `salida_real` date NOT NULL,
  `Estado` enum('En proceso','Listo','Recogido') DEFAULT 'En proceso',
  `tot_siva` double NOT NULL,
  `tot_civa` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

--
-- Volcado de datos para la tabla `recibos`
--

INSERT INTO `recibos` (`num_ticket`, `tot_prendas`, `DNI_cliente`, `Atendido`, `fecha_entrada`, `salida_apx`, `salida_real`, `Estado`, `tot_siva`, `tot_civa`) VALUES
(1, 3, '00000001M', 'Marina', '2018-02-18', '2018-02-28', '0000-00-00', 'En proceso', 11.04, 13.35),
(2, 5, '00000001M', 'Marina', '2018-02-24', '2018-02-24', '0000-00-00', 'Listo', 20.04, 24.25);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket`
--

CREATE TABLE `ticket` (
  `num_ticket` int(11) NOT NULL,
  `id_prenda` int(11) NOT NULL,
  `prenda` varchar(10) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Servicio` enum('Limpieza','Plancha') NOT NULL DEFAULT 'Limpieza',
  `im_unit_siva` double NOT NULL,
  `imp_unit_civa` double NOT NULL,
  `total_civa` double NOT NULL,
  `estado` enum('En proceso','Listo','Recogido') NOT NULL DEFAULT 'En proceso',
  `Observaciones` longtext
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

--
-- Volcado de datos para la tabla `ticket`
--

INSERT INTO `ticket` (`num_ticket`, `id_prenda`, `prenda`, `Cantidad`, `Servicio`, `im_unit_siva`, `imp_unit_civa`, `total_civa`, `estado`, `Observaciones`) VALUES
(1, 1, 'pantalon', 1, 'Limpieza', 5, 6.05, 6.05, 'En proceso', NULL),
(1, 2, 'camisa', 2, 'Limpieza', 3.02, 3.65, 7.3, 'En proceso', NULL),
(2, 1, 'pantalon', 5, 'Plancha', 4.1, 4.85, 24.25, 'Listo', 'Sin ralla.'),
(2, 1, 'pantalon', 5, 'Plancha', 4.1, 4.85, 24.25, 'Listo', 'Sin ralla.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_usuario`
--

CREATE TABLE `t_usuario` (
  `type_usr` int(11) NOT NULL,
  `name_usr` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

--
-- Volcado de datos para la tabla `t_usuario`
--

INSERT INTO `t_usuario` (`type_usr`, `name_usr`) VALUES
(0, 'Admin'),
(3, 'Anonimo'),
(1, 'Cliente'),
(2, 'Empleado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `t_usr` int(11) NOT NULL,
  `DNI` varchar(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Apellidos` varchar(25) NOT NULL,
  `Direccion` varchar(50) NOT NULL,
  `telf` int(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `fecha_alta` date NOT NULL,
  `password` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`t_usr`, `DNI`, `Nombre`, `Apellidos`, `Direccion`, `telf`, `email`, `fecha_alta`, `password`) VALUES
(0, '00000000A', 'Administrador', 'Admin', 'TintoMax', 0, 'admin@admin.admin', '2018-02-01', 'admin'),
(1, '00000001M', 'Marina', 'Fdez. Sues.', 'C/ Valladolid', 600000001, 'm.fernandezsu@alumnos.urjc.es', '2018-02-10', '1-mar'),
(2, '00000001M', 'Andrea', 'Ch. Sues.', 'C/ Sagunto', 600000002, 'andrea@clienta.email', '2018-02-12', '2-and'),
(3, '00000000A', 'Anonimo', 'Anonimo', 'Tintomax', 0, 'anonimo@anonimo.anonimo', '2018-02-01', '');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `t_usuario`
--
ALTER TABLE `t_usuario`
  ADD PRIMARY KEY (`type_usr`),
  ADD UNIQUE KEY `name_usr` (`name_usr`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `t_usuario`
--
ALTER TABLE `t_usuario`
  MODIFY `type_usr` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
