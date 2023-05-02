CREATE DATABASE IF NOT EXISTS provlis;
USE provlis;
DROP TABLE  IF EXISTS piezas;
DROP TABLE IF EXISTS proveedores;
DROP TABLE IF EXISTS suministra;

CREATE TABLE IF NOT EXISTS piezas (
    id INT AUTO_INCREMENT,
    nombre VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS proveedores (
    id int NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS suministra (
id INT AUTO_INCREMENT,
    pieza_id INT NOT NULL,
    proveedor_id int NOT NULL,
    precio INT NOT NULL,
    PRIMARY KEY (id),
	KEY(pieza_id, proveedor_id),
    CONSTRAINT FK_piezas FOREIGN KEY (pieza_id) REFERENCES piezas (id)
	ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FK_proveedores FOREIGN KEY (proveedor_id) REFERENCES proveedores (id)
	ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Usuario(

id int not null AUTO_INCREMENT,
username Varchar(255),
password Varchar(255),
role Varchar(255),
PRIMARY KEY (id)
);
INSERT INTO piezas (nombre) VALUES ('Tuerca');
INSERT INTO piezas (nombre) VALUES ('Piston');

INSERT INTO proveedores (nombre) VALUES ('Honda');
INSERT INTO proveedores (nombre) VALUES ('Bosch');

INSERT INTO suministra (pieza_id, proveedor_id, precio) VALUES (1, 2, 20);
INSERT INTO suministra (pieza_id, proveedor_id, precio) VALUES (2, 2, 32);

SELECT * FROM suministra;
SELECT * FROM proveedores;
SELECT * FROM piezas;

INSERT INTO Usuario (username, password, role) VALUES ('admin', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.','admin');
