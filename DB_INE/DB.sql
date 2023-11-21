CREATE DATABASE INE;
USE INE;

CREATE TABLE admin(
	id_admin INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(50),
    password_admin VARCHAR(8),
    n_votantes INT
);

INSERT INTO admin(id_admin, user_name, password_admin) VALUES (1,'leonardo09', 'leo123');
INSERT INTO admin(id_admin, user_name, password_admin) VALUES (2,'Christian', 'choleg');


CREATE TABLE votante(
	id_votante INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre_votante VARCHAR(50),
    apellidos VARCHAR(50),
    edad INT,
    fecha_nacimiento DATE,
    id_admin INT,
    FOREIGN KEY (id_admin) REFERENCES admin(id_admin)
);


CREATE TABLE partidos(
	id_partido VARCHAR(6) NOT NULL PRIMARY KEY,
    candidato VARCHAR(50)
);

INSERT INTO partidos VALUES
('PRI', 'Enrique Pena Nieto'),
('PAN', 'Ricardo Anaya'),
('MORENA', 'Andres Manuel Lopez Obrador');


    
CREATE TABLE votos(
	id_voto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_votante INT,
    id_partido VARCHAR(6),
    FOREIGN KEY (id_votante) REFERENCES votante(id_votante),
    FOREIGN KEY (id_partido) REFERENCES partidos(id_partido)
);


