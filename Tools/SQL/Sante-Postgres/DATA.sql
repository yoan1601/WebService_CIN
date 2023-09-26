-- DB : cinsante

CREATE SEQUENCE idCitoyen START 1;
CREATE SEQUENCE idAllergie START 1;
CREATE SEQUENCE idMaladieChronique START 1;
 
CREATE TABLE citoyens (
    idCitoyen varchar(255) PRIMARY KEY,
    idCIN varchar(255) NOT NULL,
    nom varchar(255) NOT NULL,
    prenom varchar(255) NOT NULL,
    dateNaissance date NOT NULL
);

INSERT INTO citoyens VALUES (nextval('idCitoyen'), '123456', 'RABARIJAONA', 'Harena Juan', date'2003-01-16');
INSERT INTO citoyens (idCitoyen, idCIN, nom, prenom, dateNaissance) VALUES (nextval('idCitoyen') , 'ABC123', 'Doe', 'John', '1990-01-15');
INSERT INTO citoyens (idCitoyen, idCIN, nom, prenom, dateNaissance) VALUES (nextval('idCitoyen') , 'DEF456', 'Smith', 'Jane', '1985-05-20');
INSERT INTO citoyens (idCitoyen, idCIN, nom, prenom, dateNaissance) VALUES (nextval('idCitoyen') , 'GHI789', 'Johnson', 'David', '1998-09-10');
INSERT INTO citoyens (idCitoyen, idCIN, nom, prenom, dateNaissance) VALUES (nextval('idCitoyen') , 'JKL012', 'Williams', 'Emily', '1993-03-25');

CREATE TABLE allergies (
    idAllergie varchar(255) PRIMARY KEY,
    idCINAllergie varchar(255) NOT NULL,
    descriptionAllergie varchar(255) NOT NULL
);

INSERT INTO allergies (idAllergie, idCINAllergie, descriptionAllergie)
VALUES (nextval('idAllergie'), '123456', 'crevette');

INSERT INTO allergies (idAllergie, idCINAllergie, descriptionAllergie)
VALUES (nextval('idAllergie'), 'ABC123', 'pollen'),
       (nextval('idAllergie'), 'ABC123', 'acariens');

INSERT INTO allergies (idAllergie, idCINAllergie, descriptionAllergie)
VALUES (nextval('idAllergie'), 'DEF456', 'alimentaire'),
       (nextval('idAllergie'), 'DEF456', 'piqures insectes');

INSERT INTO allergies (idAllergie, idCINAllergie, descriptionAllergie)
VALUES (nextval('idAllergie'), 'GHI789', 'medicament'),
       (nextval('idAllergie'), 'GHI789', 'latex');


CREATE TABLE maladieChroniques (
    idMaladieChronique varchar(255) PRIMARY KEY,
    idCINMaladieChronique varchar(255) NOT NULL,
    descriptionMaladieChronique varchar(255) NOT NULL
);

INSERT INTO maladieChroniques (idMaladieChronique, idCINMaladieChronique, descriptionMaladieChronique)
VALUES (nextval('idMaladieChronique'), 'ABC123', 'Diabete de type 2'),
       (nextval('idMaladieChronique'), 'ABC123', 'Hypertension');

INSERT INTO maladieChroniques (idMaladieChronique, idCINMaladieChronique, descriptionMaladieChronique)
VALUES (nextval('idMaladieChronique'), 'DEF456', 'Asthme'),
       (nextval('idMaladieChronique'), 'DEF456', 'Allergie alimentaire severe');

INSERT INTO maladieChroniques (idMaladieChronique, idCINMaladieChronique, descriptionMaladieChronique)
VALUES (nextval('idMaladieChronique'), 'GHI789', 'Arthrite rhumatoide'),
       (nextval('idMaladieChronique'), 'GHI789', 'Depression');

INSERT INTO maladieChroniques (idMaladieChronique, idCINMaladieChronique, descriptionMaladieChronique)
VALUES (nextval('idMaladieChronique'), 'JKL012', 'Allergie aux noix'),
       (nextval('idMaladieChronique'), 'JKL012', 'Migraine chronique');
