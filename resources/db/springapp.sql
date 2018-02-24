--
-- Base de datos: `tintomax`
--
CREATE DATABASE IF NOT EXISTS `tintomax` DEFAULT CHARACTER SET armscii8 COLLATE armscii8_general_ci;

/*GRANT ALL ON springapp.* TO springappuser@'%' IDENTIFIED BY 'pspringappuser';*/
/*GRANT ALL ON springapp.* TO springappuser@localhost IDENTIFIED BY 'pspringappuser';*/

USE `tintomax`;

-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `t_usuario`
--

CREATE TABLE IF NOT EXISTS `t_usuario` (
  `type_usr` int(11) PRIMARY KEY AUTO_INCREMENT,
  `name_usr` varchar(8) NOT NULL UNIQUE,
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=armscii8;

--
-- RELACIONES PARA LA TABLA `t_usuario`:
--

-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `prendas`
--

CREATE TABLE IF NOT EXISTS `prendas` (
  `num_prenda` int(11) PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL UNIQUE,
  `limpieza_siva` double NOT NULL,
  `limpiezac_iva` double NOT NULL,
  `plancha_siva` double NOT NULL,
  `plancha_civa` double NOT NULL,
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

--
-- RELACIONES PARA LA TABLA `prendas`:
--

-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `t_usr` int(11) NOT NULL,
  `DNI` varchar(11) NOT NULL UNIQUE,
  `Nombre` varchar(20) NOT NULL,
  `Apellidos` varchar(25) NOT NULL,
  `Direccion` varchar(50) NOT NULL,
  `telf` int(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `fecha_alta` date NOT NULL,
  `password` varchar(5) NOT NULL,
  PRIMARY KEY (`t_usr`,`DNI`),
  UNIQUE KEY `DNI_2` (`DNI`,`Nombre`),
  FOREIGN KEY (`t_usr`) REFERENCES `t_usuario`(`type_usr`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

--
-- RELACIONES PARA LA TABLA `usuarios`:
--   `t_usr`
--       `t_usuario` -> `type_usr`
--

-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `ticket`
--

CREATE TABLE IF NOT EXISTS `ticket` (
  `num_ticket` int(11) PRIMARY KEY AUTO_INCREMENT,
  `id_prenda` int(11) NOT NULL,
  `prenda` varchar(10) ,
  `Cantidad` int(11) NOT NULL,
  `Servicio` enum('Limpieza','Plancha') NOT NULL DEFAULT 'Limpieza',
  `im_unit_siva` double NOT NULL,
  `imp_unit_civa` double NOT NULL,
  `total_civa` double NOT NULL,
  `fecha_entrada` date NOT NULL,
  `salida_apx` date NOT NULL,
  `salida_real` date,
  `estado` enum('En proceso','Listo','Recogido') NOT NULL DEFAULT 'En proceso',
  `Observaciones` longtext,
  FOREIGN KEY (`prenda`) REFERENCES `prendas`(`nombre`),
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

--
-- RELACIONES PARA LA TABLA `ticket`:
--   `prenda`
--       `prendas` -> `nombre`
--   `estado`
--       `recibos` -> `Estado`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recibos`
--

CREATE TABLE IF NOT EXISTS `recibos` (
  `num_ticket` int(11) PRIMARY KEY ,
  `tot_prendas` int(11) NOT NULL,
  `DNI_cliente` varchar(11) NOT NULL,
  `Atendido` varchar(20) NOT NULL,
  `fecha_entrada` date NOT NULL,
  `salida_apx` date NOT NULL,
  `salida_real` date,
  `Estado` enum('En proceso','Listo','Recogido') DEFAULT 'En proceso',
  `tot_siva` double NOT NULL,
  `tot_civa` double NOT NULL,
  FOREIGN KEY (`num_ticket`) REFERENCES `ticket`(`num_ticket`),
  FOREIGN KEY (`DNI_cliente`) REFERENCES `usuarios`(`DNI`),
  FOREIGN KEY (`Atendido`) REFERENCES `usuarios`(`NOMBRE`),
  FOREIGN KEY (`fecha_entrada`) REFERENCES `ticket`(`fecha_entrada`),
  FOREIGN KEY (`salida_apx`) REFERENCES `ticket`(`salida_apx`),
  FOREIGN KEY (`salida_real`) REFERENCES `ticket`(`salida_real`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

--
-- RELACIONES PARA LA TABLA `recibos`:
--   `DNI_cliente`
--       `usuarios` -> `DNI`
--	
--   `Atendido`
--       `usuarios` -> `NOMBRE`
--
--   `num_ticket`
--       `ticket` -> `num_ticket`

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

CREATE TABLE IF NOT EXISTS `facturas` (
  `num_factura` int(11) PRIMARY KEY AUTOINCREMENT,
  `dni` varchar(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `fecha` date NOT NULL,
  `ticket_asoc` int(11) NOT NULL,
  `importe_siva` double NOT NULL,
  `importe_civa` double NOT NULL,
  FOREIGN KEY (`dni`) REFERENCES `usuarios` (`DNI`),
  FOREIGN KEY (`ticket_asoc`) REFERENCES `recibos` (`num_ticket`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

--
-- RELACIONES PARA LA TABLA `facturas`:
--   `dni`
--       `usuarios` -> `DNI`
--   `ticket_asoc`
--       `recibos` -> `num_ticket`

-- --------------------------------------------------------

--
-- Restricciones para tablas volcadas
--
--
-- Filtros para la tabla `recibos`
--
ALTER TABLE `recibos`
ADD CONSTRAINT `recibos_ibfk_1` FOREIGN KEY (`estado`) REFERENCES `recibos`(`Estado`);
--
--
