CREATE TABLE Sites(
   id bigint auto_increment,
   ville VARCHAR(50),
   attribution VARCHAR(50),
   PRIMARY KEY(id)
);

INSERT INTO sites (id, ville, attribution) values 
(1, 'Paris', 'Administratif'),
(2, 'Nantes', 'Production'), 
(3, 'Toulouse', 'Production'),
(4, 'Nice', 'Production'),
(5, 'Lille', 'Production');

CREATE TABLE Services(
   id bigint auto_increment,
   nom VARCHAR(50),
   PRIMARY KEY(id)
);

INSERT INTO services (id, nom) values 
(1, 'Comptabilité'),
(2, 'Production'), 
(3, 'Accueil'),
(4, 'Informatique'),
(5, 'Commercial'),
(6, 'Transport'),
(7, 'Juridique');

CREATE TABLE Salaries(
   id bigint auto_increment,
   nom VARCHAR(50),
   prenom VARCHAR(50),
   telephone_fixe VARCHAR(10),
   telephone_portable VARCHAR(10),
   email VARCHAR(50),
   fk_service BIGINT NOT NULL,
   fk_site BIGINT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(fk_service) REFERENCES Services(id),
   FOREIGN KEY(fk_site) REFERENCES Sites(id)
);

DELIMITER //

CREATE PROCEDURE GenerateEmployees(IN numEmployees INT)
BEGIN
    DECLARE i INT DEFAULT 0;
    DECLARE nom VARCHAR(50);
    DECLARE prenom VARCHAR(50);
    DECLARE telephone_fixe VARCHAR(10);
    DECLARE telephone_portable VARCHAR(10);
    DECLARE email VARCHAR(50);
    DECLARE fk_service BIGINT;
    DECLARE fk_site BIGINT;

    SET i = 0;

    WHILE i < numEmployees DO
        SET nom = CONCAT('Nom', i);
        SET prenom = CONCAT('Prenom', i);
        SET telephone_fixe = CONCAT('0', LPAD(FLOOR(RAND() * 100000000), 9, '0'));
        SET telephone_portable = CONCAT('0', LPAD(FLOOR(RAND() * 100000000), 9, '0'));
        SET email = CONCAT('email', i, '@example.com');
        SET fk_service = FLOOR(RAND() * 7) + 1;
        SET fk_site = FLOOR(RAND() * 5) + 1;

        INSERT INTO Salaries (nom, prenom, telephone_fixe, telephone_portable, email, fk_service, fk_site)
        VALUES (nom, prenom, telephone_fixe, telephone_portable, email, fk_service, fk_site);

        SET i = i + 1;
    END WHILE;
END //

DELIMITER ;

CALL GenerateEmployees(1000);