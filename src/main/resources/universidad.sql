CREATE TABLE Facultades(
    idfacultad INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    abreviatura VARCHAR(20)
);

CREATE TABLE Carreras(
    idcarrera INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(150) NOT NULL,
    tipo INT NOT NULL,
    idfacultad INT NOT NULL
);

ALTER TABLE Carreras ADD FOREIGN KEY (idfacultad) REFERENCES Facultades (idfacultad) ON UPDATE CASCADE;

INSERT INTO Facultades(nombre,abreviatura) VALUES
("Facultad de Ciencias Exactas y Tecnologías","FCEyT"),
("Facultad de Humanidades, Ciencias Sociales y de la Salud","FHCSyS"),
("Facultad de Agronomía y Agroindustrias","FAyA"),
("Facultad de Ciencias Forestales","FCF"),
("Facultad de Ciencias Médicas","FCM");

INSERT INTO Carreras(nombre,idfacultad,tipo) VALUES
("Ingenieria Civil", 1, 2),        
("Ingeniería Electromecánica", 1, 2),
("Ingeniería Electrónica", 1, 2),
("Ingeniería Eléctrica", 1, 2),
("Ingeniería en Agrimensura", 1, 2),
("Ingeniería Hidráulica", 1, 2),
("Ingeniería Industrial", 1, 2),
("Ingeniería Vial", 1, 2),
("Licenciatura en Hidrología Subterránea", 1, 2),
("Licenciatura en Matemática", 1, 2),
("Licenciatura en Matemática Nivel Terc", 1, 2),
("Licenciatura en Sistemas de Información", 1, 2),
("Profesorado en Informática", 1, 2),
("Profesorado en Matemática", 1, 2),
("Tecnicatura Universitaria en Construcción", 1, 3),
("Tecnicatura Universitaria Vial", 1, 3),
("Tecnicatura Universitaria en Hidrología Subterránea", 1, 3),
("Tecnicatura Universitaria en Organización y Control de la Producción", 1, 3),
("Programador Universitario en Informática", 1, 3),
("Licenciatura en Administración", 2, 2),
("Contador Público Nacional", 2, 2),
("Licenciatura en Letras", 2, 2),
("Licenciatura en Sociologia", 2, 2),
("Licenciatura en Enfermería", 2, 2),
("Lic. y Prof. Ed. para la salud", 2, 2),
("Licenciatura en Obstetricia", 2, 2),
("Licenciatura en Filosofía", 2, 2),
("Lic. en Trabajo Social", 2, 2),
("Lic. en Periodismo", 2, 2),
("Tec, Sup. Adm. y Gestión Universitaria", 2, 3),
("Tec. Edu. Intercultural Bilingue", 2, 3),
("Ingeniería Agronómica", 3, 2),
("Ingeniería en Alimentos", 3, 2),
("Licenciatura en Biotecnología", 3, 2),
("Licenciatura en Química", 3, 2),
("Profesorado en Química", 3, 2),
("Técnico Universitario en Apicultura", 3, 3),
("Ingeniería Forestal", 4, 2),
("Ingeniería en Industrias Forestales", 4, 2),
("Licenciatura en Ecología y Cons. del Med. Amb.", 4, 2),
("Tecnicatura Univ. Fitosanitarista", 4, 3),
("Tecnicatura Univ. en Viveros y Plant. Forestales", 4, 3),
("Tecnicatura Univ. en Aserraderos y Carpineria Ind", 4, 3),
("Medicina", 5, 2);


