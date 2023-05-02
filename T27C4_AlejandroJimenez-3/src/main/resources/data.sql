CREATE DATABASE IF NOT EXISTS Gralma;
USE Gralma;
DROP TABLE IF EXISTS ventas;
DROP TABLE IF EXISTS maquinas_registradoras;
DROP TABLE IF EXISTS productos;
DROP TABLE IF EXISTS cajeros;


CREATE TABLE IF NOT EXISTS cajeros (
codigo INT AUTO_INCREMENT,
nomApels VARCHAR(255) DEFAULT NULL,
PRIMARY KEY(codigo)
);
					
CREATE TABLE IF NOT EXISTS productos (
codigo INT AUTO_INCREMENT,
nombre VARCHAR(100) DEFAULT NULL,
precio INT DEFAULT NULL,
PRIMARY KEY(codigo)
);
					
CREATE TABLE IF NOT EXISTS maquinas_registradoras (
codigo INT AUTO_INCREMENT,
piso INT DEFAULT NULL,
PRIMARY KEY(codigo)
);
					
					
CREATE TABLE IF NOT EXISTS ventas (
id INT AUTO_INCREMENT,
cajero INT,
maquina INT,
producto INT,
PRIMARY KEY(id),
KEY(cajero, maquina, producto),
                        CONSTRAINT cajero_fk FOREIGN KEY (cajero) REFERENCES cajeros (codigo)
                        ON DELETE CASCADE ON UPDATE CASCADE,
                        CONSTRAINT maquina_fk FOREIGN KEY (maquina) REFERENCES maquinas_registradoras (codigo)
                        ON DELETE CASCADE ON UPDATE CASCADE,
                        CONSTRAINT producto_fk FOREIGN KEY (producto) REFERENCES productos (codigo)
                        ON DELETE CASCADE ON UPDATE CASCADE
						);
						
						
CREATE TABLE IF NOT EXISTS Usuario(
id int not null AUTO_INCREMENT,
username Varchar(255),
password Varchar(255),
role Varchar(255),
PRIMARY KEY (id)
    
    );
INSERT INTO cajeros(nomApels) VALUES		('Francisco Parra'), 
										('Alejandro Jiménez Álvarez'), 
										('Arturo Perez Reverte');
										
									
INSERT INTO productos(nombre, precio) VALUES 	('Macarrones', 700), 
										('Tomate Frito', 500), 
										('Fregona', 800), 
										('Agua', 750);
										
INSERT INTO maquinas_registradoras(piso) VALUES (3),(2),(1),(3),(1),(2),(1),(0),(2),(1);

INSERT INTO venta VALUES (2,2,1),(1,3,2),(1,2,3);
INSERT INTO Usuario (username, password, role) VALUES ('admin', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.','admin');
