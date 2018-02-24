-- --------------------------------------------------------

--
-- Volcado de datos para la tabla `t_usuario`
--

INSERT INTO `t_usuario` (`type_usr`, `name_usr`) VALUES(0, 'Admin');
INSERT INTO `t_usuario` (`type_usr`, `name_usr`) VALUES(3, 'Anonimo');
INSERT INTO `t_usuario` (`type_usr`, `name_usr`) VALUES(1, 'Cliente');
INSERT INTO `t_usuario` (`type_usr`, `name_usr`) VALUES(2, 'Empleado');

--
-- Volcado de datos para la tabla `prendas`
--

INSERT INTO `prendas` (`num_prenda`, `nombre`, `limpieza_siva`, `limpiezac_iva`, `plancha_siva`, `plancha_civa`) VALUES(1, 'pantalon', 5, 6.05, 4.1, 4.85);
INSERT INTO  (`num_prenda`, `nombre`, `limpieza_siva`, `limpiezac_iva`, `plancha_siva`, `plancha_civa`) VALUES(2, 'camisa', 3.02, 3.65, 2.36, 2.85);

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`t_usr`, `DNI`, `Nombre`, `Apellidos`, `Direccion`, `telf`, `email`, `fecha_alta`, `password`) VALUES(0, '00000000A', 'Administrador', 'Admin', 'TintoMax', 0, 'admin@admin.admin', '2018-02-01', 'admin');
INSERT INTO `usuarios` (`t_usr`, `DNI`, `Nombre`, `Apellidos`, `Direccion`, `telf`, `email`, `fecha_alta`, `password`) VALUES(1, '00000001M', 'Marina', 'Fdez. Sues', 'C/ Valladolid', 600000001, 'marina@empleada.email', '2018-02-12', '1-mar');
INSERT INTO `usuarios` (`t_usr`, `DNI`, `Nombre`, `Apellidos`, `Direccion`, `telf`, `email`, `fecha_alta`, `password`) VALUES(2, '00000002A', 'Andrea', 'Ch. Sues', 'C/ Sagunto', 600000002, 'andrea@clienta.email', '2018-02-12', '2-and');
INSERT INTO `usuarios` (`t_usr`, `DNI`, `Nombre`, `Apellidos`, `Direccion`, `telf`, `email`, `fecha_alta`, `password`) VALUES(3, '00000000A', 'Anonimo', 'Anonimo', 'Tintomax', 0, 'anonimo@anonimo.anonimo', '2018-02-01', '');

--
-- Volcado de datos para la tabla `ticket`
--

INSERT INTO `ticket` (`num_ticket`, `id_prenda`, `prenda`, `Cantidad`, `Servicio`, `im_unit_siva`, `imp_unit_civa`, `total_civa`, `estado`, `Observaciones`) VALUES(1, 1, 'pantalon', 1, 'Limpieza', 5, 6.05, 6.05, 'En proceso', NULL);
INSERT INTO `ticket` (`num_ticket`, `id_prenda`, `prenda`, `Cantidad`, `Servicio`, `im_unit_siva`, `imp_unit_civa`, `total_civa`, `estado`, `Observaciones`) VALUES(1, 2, 'camisa', 2, 'Limpieza', 3.02, 3.65, 7.3, 'En proceso', NULL);
INSERT INTO `ticket` (`num_ticket`, `id_prenda`, `prenda`, `Cantidad`, `Servicio`, `im_unit_siva`, `imp_unit_civa`, `total_civa`, `estado`, `Observaciones`) VALUES(2, 1, 'pantalon', 5, 'Plancha', 4.1, 4.85, 24.25, 'Listo', 'Sin ralla.');

--
-- Volcado de datos para la tabla `recibos`
--

INSERT INTO `recibos` (`num_ticket`, `tot_prendas`, `DNI_cliente`, `Atendido`, `fecha_entrada`, `salida_apx`, `salida_real`, `Estado`, `tot_siva`, `tot_civa`) VALUES(1, 3, '00000002A', 'Marina', '2018-02-18', '2018-02-28', '0000-00-00', 'En proceso', 11.04, 13.35);
INSERT INTO `recibos` (`num_ticket`, `tot_prendas`, `DNI_cliente`, `Atendido`, `fecha_entrada`, `salida_apx`, `salida_real`, `Estado`, `tot_siva`, `tot_civa`) VALUES(2, 5, '00000002A', 'Marina', '2018-02-24', '2018-02-24', '0000-00-00', 'Listo', 20.04, 24.25);

--
-- Volcado de datos para la tabla `facturas`
--

INSERT INTO `facturas` (`num_factura`, `dni`, `nombre`, `fecha`, `ticket_asoc`, `importe_siva`, `importe_civa`) VALUES(1, '00000002A', 'Andrea', '2018-02-25', 2, 20.04, 24.25);

--
-- Restricciones para tablas volcadas
--