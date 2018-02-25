
-- Base de datos: tintomax
--
CREATE DATABASE IF NOT EXISTS tintomax;

USE tintomax;


CREATE TABLE IF NOT EXISTS garment (
  garment_number int(11) PRIMARY KEY AUTO_INCREMENT,
  name varchar(25) NOT NULL UNIQUE,
  without_iva_cleaning double NOT NULL,
  without_iva_ironing double NOT NULL
) ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS user (
  id_user int(11) NOT NULL AUTO_INCREMENT,
  t_user ENUM ('admin','empleado','cliente'),
  dni varchar(11) NOT NULL UNIQUE,
  name varchar(20) NOT NULL,
  last_names varchar(25) NOT NULL,
  address varchar(50) NOT NULL,
  phone_number int(11) NOT NULL,
  email varchar(30) NOT NULL,
  sign_up_date date NOT NULL,
  password varchar(5) NOT NULL,
  PRIMARY KEY (id_user),
  UNIQUE KEY DNI_2 (DNI,name)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS receipt (
  id_receipt int(11) PRIMARY KEY AUTO_INCREMENT,
  total_garments int(11) NOT NULL,
  id_user int(11) NOT NULL,
  entry_date date NOT NULL, 
  apx_output date NOT NULL,
  real_output date,
  state enum('En_proceso','Listo','Recogido') NOT NULL DEFAULT 'En_proceso',
  without_iva_total double NOT NULL,
  FOREIGN KEY (id_user) REFERENCES user(id_user)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS ticket (
  num_ticket int(11) NOT NULL,
  id_garment int(11) NOT NULL,
  quantity int(11) NOT NULL,
  service enum('Limpieza','Plancha') NOT NULL DEFAULT 'Limpieza',
  without_iva_im_unit double NOT NULL,
  without_iva_total double NOT NULL,
  observations longtext,
  PRIMARY KEY (num_ticket,id_garment),
  FOREIGN KEY (id_garment) REFERENCES garment(garment_number),
  FOREIGN KEY (num_ticket) REFERENCES receipt(id_receipt)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS bill (
  num_bill int(11) PRIMARY KEY AUTO_INCREMENT,
  id_receipt int(11) NOT NULL,
  name varchar(20) NOT NULL,
  bill_date date NOT NULL,
  num_ticket int(11) NOT NULL,
  without_iva_amount double NOT NULL,
  FOREIGN KEY (id_receipt) REFERENCES receipt(id_receipt)
) ENGINE=InnoDB;
