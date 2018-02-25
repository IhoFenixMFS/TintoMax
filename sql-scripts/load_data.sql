-- --------------------------------------------------------
--
-- Volcado de datos para la tabla prendas
--

INSERT INTO prendas (nombre, limpieza_siva, plancha_siva ) VALUES('pantalon', 5, 4.1);
INSERT INTO prendas (nombre, limpieza_siva, plancha_siva ) VALUES('camisa', 3.02, 2.36);

--
-- Volcado de datos para la tabla usuarios
--

INSERT INTO usuarios (t_user, dni, nombre, apellidos, direccion, telf, email, fecha_alta, password) VALUES('admin', '00000000A', 'Administrador', 'Admin', 'TintoMax', 0, 'admin@admin.admin', '2018-02-01', 'admin');
INSERT INTO usuarios (t_user, dni, nombre, apellidos, direccion, telf, email, fecha_alta, password) VALUES('empleado', '00000001M', 'Marina', 'Fdez. Sues', 'C/ Valladolid', 600000001, 'marina@empleada.email', '2018-02-12', '1-mar');
INSERT INTO usuarios (t_user, dni, nombre, apellidos, direccion, telf, email, fecha_alta, password) VALUES('cliente', '00000002A', 'Andrea', 'Ch. Sues', 'C/ Sagunto', 600000002, 'andrea@clienta.email', '2018-02-12', '2-and');

--
-- Volcado de datos para la tabla recibos
--

INSERT INTO recibos (tot_prendas, id_user,fecha_entrada, salida_apx, salida_real, Estado, tot_siva) VALUES(3, 3, '2018-02-18', '2018-02-28', '0000-00-00', 'En_proceso', 11.04);
INSERT INTO recibos (tot_prendas, id_user,fecha_entrada, salida_apx, salida_real, Estado, tot_siva) VALUES(5, 3, '2018-02-24', '2018-02-24', '0000-00-00', 'Listo', 20.04);


--
-- Volcado de datos para la tabla ticket
--

INSERT INTO ticket (num_ticket, id_prenda, cantidad, servicio, im_unit_siva, total_siva, observaciones) VALUES(1, 1, 1, 'Limpieza', 5, 5, NULL);
INSERT INTO ticket (num_ticket, id_prenda, cantidad, servicio, im_unit_siva, total_siva, observaciones) VALUES(1, 2, 2, 'Limpieza', 3.02, 6.04, NULL);
INSERT INTO ticket (num_ticket, id_prenda, cantidad, servicio, im_unit_siva, total_siva, observaciones) VALUES(2, 1, 5, 'Plancha', 4.1, 20.50,'Sin ralla.');


--
-- Volcado de datos para la tabla facturas
--

INSERT INTO facturas (id_recibo, nombre, fecha, num_ticket, importe_siva) VALUES(2, 'Andrea', '2018-02-25', 2, 20.04);

--
-- Restricciones para tablas volcadas
--
