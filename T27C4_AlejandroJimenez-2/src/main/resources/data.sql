CREATE DATABASE IF NOT EXISTS Asigproy;
USE Asigproy;

DROP TABLE IF EXISTS asignado;
DROP TABLE IF EXISTS cientifico;
DROP TABLE IF EXISTS proyecto;
DROP TABLE IF EXISTS Usuario;

CREATE TABLE IF NOT EXISTS cientifico (
id INT AUTO_INCREMENT,
dni VARCHAR(20) DEFAULT NULL,
nomApels VARCHAR(255) DEFAULT NULL,
PRIMARY KEY(id)
);
					
CREATE TABLE IF NOT EXISTS proyecto (
id INT AUTO_INCREMENT,
nombre VARCHAR(255) DEFAULT NULL,
horas INT DEFAULT NULL,
PRIMARY KEY(id)
);
						
CREATE TABLE IF NOT EXISTS asignado (
id INT AUTO_INCREMENT,
cientifico INT,
proyecto INT,
PRIMARY KEY(id),
KEY(cientifico, proyecto),
CONSTRAINT cientifico_fk FOREIGN KEY (cientifico) REFERENCES cientifico (id)
ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT proyecto_fk FOREIGN KEY (proyecto) REFERENCES proyecto (id)
ON DELETE CASCADE ON UPDATE CASCADE
);
						
CREATE TABLE IF NOT EXISTS Usuario(
id int not null AUTO_INCREMENT,
username Varchar(255),
password Varchar(255),
role Varchar(255),
PRIMARY KEY (id)
    
    );
INSERT INTO cientifico (dni, nomApels) VALUES ('1234769678', 'Jose Marin');
INSERT INTO cientifico (dni, nomApels) VALUES ('2342784489', 'Francisco Parra');
INSERT INTO cientifico (dni, nomApels) VALUES ('34567890', 'Alberto Del Pozo');



INSERT INTO proyecto (nombre, horas) VALUES ('Desarrollo IA', 1000);
INSERT INTO proyecto (nombre, horas) VALUES ('Diseño Web', 20);
INSERT INTO proyecto (nombre, horas) VALUES ('Safein', 300);

INSERT INTO Usuario (username, password, role) VALUES ('admin', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.','admin');

INSERT INTO asignado (cientifico, proyecto) VALUES (2, 2);
INSERT INTO asignado (cientifico, proyecto) VALUES (1, 1);
INSERT INTO asignado (cientifico, proyecto) VALUES (3, 2);
