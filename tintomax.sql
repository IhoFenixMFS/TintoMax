-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-02-2018 a las 19:46:30
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
CREATE DATABASE IF NOT EXISTS `tintomax` DEFAULT CHARACTER SET armscii8 COLLATE armscii8_general_ci;
USE `tintomax`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

CREATE TABLE IF NOT EXISTS `facturas` (
  `num_factura` int(11) NOT NULL,
  `dni` varchar(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `fecha` date NOT NULL,
  `ticket_asoc` int(11) NOT NULL,
  `importe_siva` double NOT NULL,
  `importe_civa` double NOT NULL,
  PRIMARY KEY (`num_factura`),
  UNIQUE KEY `num_factura` (`num_factura`),
  UNIQUE KEY `ticket_asoc` (`ticket_asoc`),
  UNIQUE KEY `dni_2` (`dni`,`nombre`),
  KEY `dni` (`dni`,`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

--
-- RELACIONES PARA LA TABLA `facturas`:
--   `dni`
--       `usuarios` -> `DNI`
--   `ticket_asoc`
--       `recibos` -> `num_ticket`
--

--
-- Volcado de datos para la tabla `facturas`
--

INSERT INTO `facturas` (`num_factura`, `dni`, `nombre`, `fecha`, `ticket_asoc`, `importe_siva`, `importe_civa`) VALUES(1, '00000002A', 'Andrea', '2018-02-25', 2, 20.04, 24.25);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prendas`
--

CREATE TABLE IF NOT EXISTS `prendas` (
  `num_prenda` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `limpieza_siva` double NOT NULL,
  `limpiezac_iva` double NOT NULL,
  `plancha_siva` double NOT NULL,
  `plancha_civa` double NOT NULL,
  PRIMARY KEY (`num_prenda`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

--
-- RELACIONES PARA LA TABLA `prendas`:
--

--
-- Volcado de datos para la tabla `prendas`
--

INSERT INTO `prendas` (`num_prenda`, `nombre`, `limpieza_siva`, `limpiezac_iva`, `plancha_siva`, `plancha_civa`) VALUES(1, 'pantalon', 5, 6.05, 4.1, 4.85);
INSERT INTO `prendas` (`num_prenda`, `nombre`, `limpieza_siva`, `limpiezac_iva`, `plancha_siva`, `plancha_civa`) VALUES(2, 'camisa', 3.02, 3.65, 2.36, 2.85);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recibos`
--

CREATE TABLE IF NOT EXISTS `recibos` (
  `num_ticket` int(11) NOT NULL,
  `tot_prendas` int(11) NOT NULL,
  `DNI_cliente` varchar(11) NOT NULL,
  `Atendido` varchar(20) NOT NULL,
  `fecha_entrada` date NOT NULL,
  `salida_apx` date NOT NULL,
  `salida_real` date NOT NULL,
  `Estado` enum('En proceso','Listo','Recogido') DEFAULT 'En proceso',
  `tot_siva` double NOT NULL,
  `tot_civa` double NOT NULL,
  PRIMARY KEY (`num_ticket`),
  KEY `DNI_cliente` (`DNI_cliente`),
  KEY `Atendido` (`Atendido`),
  KEY `DNI_cliente_2` (`DNI_cliente`),
  KEY `Atendido_2` (`Atendido`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

--
-- RELACIONES PARA LA TABLA `recibos`:
--   `DNI_cliente`
--       `usuarios` -> `DNI`
--

--
-- Volcado de datos para la tabla `recibos`
--

INSERT INTO `recibos` (`num_ticket`, `tot_prendas`, `DNI_cliente`, `Atendido`, `fecha_entrada`, `salida_apx`, `salida_real`, `Estado`, `tot_siva`, `tot_civa`) VALUES(1, 3, '00000002A', 'Marina', '2018-02-18', '2018-02-28', '0000-00-00', 'En proceso', 11.04, 13.35);
INSERT INTO `recibos` (`num_ticket`, `tot_prendas`, `DNI_cliente`, `Atendido`, `fecha_entrada`, `salida_apx`, `salida_real`, `Estado`, `tot_siva`, `tot_civa`) VALUES(2, 5, '00000002A', 'Marina', '2018-02-24', '2018-02-24', '0000-00-00', 'Listo', 20.04, 24.25);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket`
--

CREATE TABLE IF NOT EXISTS `ticket` (
  `num_ticket` int(11) NOT NULL,
  `id_prenda` int(11) NOT NULL,
  `prenda` varchar(10) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Servicio` enum('Limpieza','Plancha') NOT NULL DEFAULT 'Limpieza',
  `im_unit_siva` double NOT NULL,
  `imp_unit_civa` double NOT NULL,
  `total_civa` double NOT NULL,
  `estado` enum('En proceso','Listo','Recogido') NOT NULL DEFAULT 'En proceso',
  `Observaciones` longtext,
  PRIMARY KEY (`num_ticket`,`id_prenda`),
  KEY `prenda` (`prenda`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

--
-- RELACIONES PARA LA TABLA `ticket`:
--   `num_ticket`
--       `recibos` -> `num_ticket`
--   `prenda`
--       `prendas` -> `nombre`
--

--
-- Volcado de datos para la tabla `ticket`
--

INSERT INTO `ticket` (`num_ticket`, `id_prenda`, `prenda`, `Cantidad`, `Servicio`, `im_unit_siva`, `imp_unit_civa`, `total_civa`, `estado`, `Observaciones`) VALUES(1, 1, 'pantalon', 1, 'Limpieza', 5, 6.05, 6.05, 'En proceso', NULL);
INSERT INTO `ticket` (`num_ticket`, `id_prenda`, `prenda`, `Cantidad`, `Servicio`, `im_unit_siva`, `imp_unit_civa`, `total_civa`, `estado`, `Observaciones`) VALUES(1, 2, 'camisa', 2, 'Limpieza', 3.02, 3.65, 7.3, 'En proceso', NULL);
INSERT INTO `ticket` (`num_ticket`, `id_prenda`, `prenda`, `Cantidad`, `Servicio`, `im_unit_siva`, `imp_unit_civa`, `total_civa`, `estado`, `Observaciones`) VALUES(2, 1, 'pantalon', 5, 'Plancha', 4.1, 4.85, 24.25, 'Listo', 'Sin ralla.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_usuario`
--

CREATE TABLE IF NOT EXISTS `t_usuario` (
  `type_usr` int(11) NOT NULL AUTO_INCREMENT,
  `name_usr` varchar(8) NOT NULL,
  PRIMARY KEY (`type_usr`),
  UNIQUE KEY `name_usr` (`name_usr`),
  UNIQUE KEY `type_usr` (`type_usr`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=armscii8;

--
-- RELACIONES PARA LA TABLA `t_usuario`:
--

--
-- Volcado de datos para la tabla `t_usuario`
--

INSERT INTO `t_usuario` (`type_usr`, `name_usr`) VALUES(0, 'Admin');
INSERT INTO `t_usuario` (`type_usr`, `name_usr`) VALUES(3, 'Anonimo');
INSERT INTO `t_usuario` (`type_usr`, `name_usr`) VALUES(1, 'Cliente');
INSERT INTO `t_usuario` (`type_usr`, `name_usr`) VALUES(2, 'Empleado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `t_usr` int(11) NOT NULL,
  `DNI` varchar(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Apellidos` varchar(25) NOT NULL,
  `Direccion` varchar(50) NOT NULL,
  `telf` int(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `fecha_alta` date NOT NULL,
  `password` varchar(5) NOT NULL,
  PRIMARY KEY (`t_usr`,`DNI`),
  UNIQUE KEY `DNI_2` (`DNI`,`Nombre`),
  KEY `DNI` (`DNI`,`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

--
-- RELACIONES PARA LA TABLA `usuarios`:
--   `t_usr`
--       `t_usuario` -> `type_usr`
--

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`t_usr`, `DNI`, `Nombre`, `Apellidos`, `Direccion`, `telf`, `email`, `fecha_alta`, `password`) VALUES(0, '00000000A', 'Administrador', 'Admin', 'TintoMax', 0, 'admin@admin.admin', '2018-02-01', 'admin');
INSERT INTO `usuarios` (`t_usr`, `DNI`, `Nombre`, `Apellidos`, `Direccion`, `telf`, `email`, `fecha_alta`, `password`) VALUES(1, '00000001M', 'Marina', 'Fdez. Sues', 'C/ Valladolid', 600000001, 'marina@empleada.email', '2018-02-12', '1-mar');
INSERT INTO `usuarios` (`t_usr`, `DNI`, `Nombre`, `Apellidos`, `Direccion`, `telf`, `email`, `fecha_alta`, `password`) VALUES(2, '00000002A', 'Andrea', 'Ch. Sues', 'C/ Sagunto', 600000002, 'andrea@clienta.email', '2018-02-12', '2-and');
INSERT INTO `usuarios` (`t_usr`, `DNI`, `Nombre`, `Apellidos`, `Direccion`, `telf`, `email`, `fecha_alta`, `password`) VALUES(3, '00000000A', 'Anonimo', 'Anonimo', 'Tintomax', 0, 'anonimo@anonimo.anonimo', '2018-02-01', '');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD CONSTRAINT `facturas_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `usuarios` (`DNI`),
  ADD CONSTRAINT `facturas_ibfk_2` FOREIGN KEY (`ticket_asoc`) REFERENCES `recibos` (`num_ticket`);

--
-- Filtros para la tabla `recibos`
--
ALTER TABLE `recibos`
  ADD CONSTRAINT `recibos_ibfk_1` FOREIGN KEY (`DNI_cliente`) REFERENCES `usuarios` (`DNI`);

--
-- Filtros para la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`num_ticket`) REFERENCES `recibos` (`num_ticket`),
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`prenda`) REFERENCES `prendas` (`nombre`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`t_usr`) REFERENCES `t_usuario` (`type_usr`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
