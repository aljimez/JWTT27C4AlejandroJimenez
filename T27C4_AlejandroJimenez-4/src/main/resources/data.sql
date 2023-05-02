CREATE DATABASE IF NOT EXISTS Investi;
USE Investi;

DROP TABLE IF EXISTS reserva;
DROP TABLE IF EXISTS equipos;
DROP TABLE IF EXISTS investigadores;
DROP TABLE IF EXISTS facultad;


CREATE TABLE IF NOT EXISTS facultad (
id INT AUTO_INCREMENT,
nombre VARCHAR(100) DEFAULT NULL,
PRIMARY KEY(id)
);
    
    				
CREATE TABLE IF NOT EXISTS Usuario(
id int not null AUTO_INCREMENT,
username Varchar(255),
password Varchar(255),
role Varchar(255),
PRIMARY KEY (id)
    
    );
CREATE TABLE IF NOT EXISTS investigadores (
id INT AUTO_INCREMENT,
dni VARCHAR(20),
nom_apels VARCHAR(255) DEFAULT NULL,
facultad INT,
PRIMARY KEY(id),
CONSTRAINT FK_facultad_investigadores FOREIGN KEY (facultad) REFERENCES facultad (id)
ON DELETE CASCADE ON UPDATE CASCADE
	);
    
CREATE TABLE IF NOT EXISTS equipos (
id INT AUTO_INCREMENT,
numserie CHAR(4),
nombre VARCHAR(100) DEFAULT NULL,
facultad INT,
PRIMARY KEY(id),
CONSTRAINT FK_facultad_equipos FOREIGN KEY (facultad) REFERENCES facultad (codigo)
ON DELETE CASCADE ON UPDATE CASCADE
    );

CREATE TABLE IF NOT EXISTS reserva (
id INT AUTO_INCREMENT,
comienzo DATETIME DEFAULT NULL,
fin DATETIME DEFAULT NULL,
investigador INT,
equipo INT,
PRIMARY KEY(id),
KEY (investigador, equipo),
CONSTRAINT FK_investigador FOREIGN KEY (investigador) REFERENCES investigadores(id)
ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT FK_equipo FOREIGN KEY (equipo) REFERENCES equipos(id)
ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO facultad(nombre) VALUES ('Biología');
INSERT INTO facultad(nombre) VALUES ('Humanidades');
INSERT INTO facultad(nombre) VALUES ('Ciencias Deportivas');


INSERT INTO investigadores (dni, nom_apels, facultad) VALUES ('182993488', 'Alejandro Jiménez Álvarez', 1);
INSERT INTO investigadores (dni, nom_apels, facultad) VALUES ('712343344', 'Marc Rojo', 2);
INSERT INTO investigadores (dni, nom_apels, facultad) VALUES ('1919203455', 'Alberto Del Pozo', 3);


INSERT INTO equipos (numserie, nombre, facultad) VALUES ('01', 'equipo 1', 1);
INSERT INTO equipos (numserie, nombre, facultad) VALUES ('02', 'equipo 2', 2);
INSERT INTO equipos (numserie, nombre, facultad) VALUES ('03', 'equipo 3', 2);


INSERT INTO reserva (comienzo, fin, investigador, equipo) VALUES ('2019-03-27 14:15:37.000000', '2025-12-17 14:15:37', 1, 1);
INSERT INTO reserva (comienzo, fin, investigador, equipo) VALUES ('2020-03-28 14:15:37.000000', '2025-12-17 14:15:37', 2, 2);
INSERT INTO reserva (comienzo, fin, investigador, equipo) VALUES ('2021-03-29 14:15:37.000000', '2025-12-17 14:15:37', 3, 3);

INSERT INTO Usuario (username, password, role) VALUES ('admin', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.','admin');
