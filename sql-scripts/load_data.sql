-- --------------------------------------------------------
--
-- Volcado de datos para la tabla prendas
--

INSERT INTO garment (name, without_iva_cleaning, without_iva_ironing ) VALUES('pantalon', 5, 4.1);
INSERT INTO garment (name, without_iva_cleaning, without_iva_ironing ) VALUES('camisa', 3.02, 2.36);

--
-- Volcado de datos para la tabla usuarios
--

INSERT INTO user (t_user, dni, name, last_names, address, phone_number, email, sign_up_date, password) VALUES('admin', '00000000A', 'Administrador', 'Admin', 'TintoMax', 0, 'admin@admin.admin', '2018-02-01', 'admin');
INSERT INTO user (t_user, dni, name, last_names, address, phone_number, email, sign_up_date, password) VALUES('empleado', '00000001M', 'Marina', 'Fdez. Sues', 'C/ Valladolid', 600000001, 'marina@empleada.email', '2018-02-12', '1-mar');
INSERT INTO user (t_user, dni, name, last_names, address, phone_number, email, sign_up_date, password) VALUES('cliente', '00000002A', 'Andrea', 'Ch. Sues', 'C/ Sagunto', 600000002, 'andrea@clienta.email', '2018-02-12', '2-and');

--
-- Volcado de datos para la tabla recibos
--

INSERT INTO receipt (total_garments, id_user,entry_date, apx_output, real_output, state, without_iva_total) VALUES(3, 3, '2018-02-18', '2018-02-28', '9999-12-31', 'En_proceso', 11.04);
INSERT INTO receipt (total_garments, id_user,entry_date, apx_output, real_output, state, without_iva_total) VALUES(5, 3, '2018-02-24', '2018-02-24', '9999-12-31', 'Listo', 20.04);



--
-- Volcado de datos para la tabla ticket
--

INSERT INTO ticket (num_ticket, id_garment, quantity, service, without_iva_im_unit, without_iva_total, observations) VALUES(1, 1, 1, 'Limpieza', 5, 5, NULL);
INSERT INTO ticket (num_ticket, id_garment, quantity, service, without_iva_im_unit, without_iva_total, observations) VALUES(1, 2, 2, 'Limpieza', 3.02, 6.04, NULL);
INSERT INTO ticket (num_ticket, id_garment, quantity, service, without_iva_im_unit, without_iva_total, observations) VALUES(2, 1, 5, 'Plancha', 4.1, 20.50,'Sin ralla.');


--
-- Volcado de datos para la tabla facturas
--

INSERT INTO bill (id_receipt, name, bill_date, num_ticket, without_iva_amount) VALUES(2, 'Andrea', '2018-02-25', 2, 20.04);

--
-- Restricciones para tablas volcadas
--

