
-- Base de datos: tintomax
--
CREATE DATABASE IF NOT EXISTS tintomax;

USE tintomax;


CREATE TABLE IF NOT EXISTS prendas (
  num_prenda int(11) PRIMARY KEY AUTO_INCREMENT,
  nombre varchar(25) NOT NULL UNIQUE,
  limpieza_siva double NOT NULL,
  plancha_siva double NOT NULL
) ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS usuarios (
  id_user int(11) NOT NULL AUTO_INCREMENT,
  t_user ENUM ('admin','empleado','cliente'),
  dni varchar(11) NOT NULL,
  nombre varchar(20) NOT NULL,
  apellidos varchar(25) NOT NULL,
  direccion varchar(50) NOT NULL,
  telf int(11) NOT NULL,
  email varchar(30) NOT NULL,
  fecha_alta date NOT NULL,
  password varchar(5) NOT NULL,
  PRIMARY KEY (id_user),
  UNIQUE KEY DNI_2 (DNI,Nombre)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS ticket (
  num_ticket int(11) NOT NULL,
  id_prenda int(11) NOT NULL,
  prenda varchar(25) NOT NULL,
  cantidad int(11) NOT NULL,
  servicio enum('Limpieza','Plancha') NOT NULL DEFAULT 'Limpieza',
  im_unit_siva double NOT NULL,
  total_siva double NOT NULL,
  observaciones longtext,
  PRIMARY KEY (num_ticket,id_prenda),
  FOREIGN KEY (id_prenda) REFERENCES prendas(num_prenda),
  FOREIGN KEY (prenda) REFERENCES prendas(nombre)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS recibos (
  num_ticket int(11) PRIMARY KEY ,
  tot_prendas int(11) NOT NULL,
  dni_cliente varchar(11) NOT NULL,
  fecha_entrada date NOT NULL, 
  salida_apx date NOT NULL,
  salida_real date,
  estado enum('En proceso','Listo','Recogido') DEFAULT 'En proceso',
  tot_siva double NOT NULL,
  FOREIGN KEY (num_ticket) REFERENCES ticket(num_ticket),
  FOREIGN KEY (dni_cliente) REFERENCES usuarios(dni)
) ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS facturas (
  num_factura int(11) PRIMARY KEY AUTO_INCREMENT,
  dni varchar(11) NOT NULL,
  nombre varchar(20) NOT NULL,
  fecha date NOT NULL,
  num_ticket int(11) NOT NULL,
  importe_siva double NOT NULL,
  FOREIGN KEY (num_ticket) REFERENCES recibos(num_ticket), 
  FOREIGN KEY (dni) REFERENCES usuarios(dni)
) ENGINE=InnoDB;
