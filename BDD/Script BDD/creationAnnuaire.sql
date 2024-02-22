CREATE TABLE Sites(
   id bigint auto_increment,
   ville VARCHAR(50),
   Role VARCHAR(50),
   PRIMARY KEY(id)
);

CREATE TABLE Services(
   id bigint auto_increment,
   nom VARCHAR(50),
   PRIMARY KEY(id)
);

CREATE TABLE Salariés(
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
