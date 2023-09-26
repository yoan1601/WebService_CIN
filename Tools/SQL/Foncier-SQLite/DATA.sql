-- sqlite3 cin_foncier

CREATE TABLE proprietes (
    idPropriete INTEGER PRIMARY KEY AUTOINCREMENT,
    idCINPropriete varchar(255) NOT NULL,
    descriptionPropriete varchar(255) NOT NULL
);

INSERT INTO proprietes (idCINPropriete, descriptionPropriete)
SELECT '123456', 'Maison a deux etages avec jardin'
UNION ALL
SELECT '123456', 'Appartement en centre-ville'
UNION ALL
SELECT '123456', 'Terrain vacant pres de la plage';

INSERT INTO proprietes (idCINPropriete, descriptionPropriete)
SELECT 'ABC123', 'Condo de luxe avec vue sur la montagne'
UNION ALL
SELECT 'ABC123', 'Maison de famille spacieuse'
UNION ALL
SELECT 'ABC123', 'Appartement en bord de riviere';

INSERT INTO proprietes (idCINPropriete, descriptionPropriete)
SELECT 'DEF456', 'Villa moderne avec piscine'
UNION ALL
SELECT 'DEF456', 'Appartement en copropriete'
UNION ALL
SELECT 'DEF456', 'Petite maison de ville charmante';

INSERT INTO proprietes (idCINPropriete, descriptionPropriete)
SELECT 'GHI789', 'Maison de campagne avec terrain'
UNION ALL
SELECT 'GHI789', 'Appartement en rez-de-chaussee'
UNION ALL
SELECT 'GHI789', 'Condo moderne dans un quartier residentiel';

INSERT INTO proprietes (idCINPropriete, descriptionPropriete)
SELECT 'JKL012', 'Appartement en centre-ville'
UNION ALL
SELECT 'JKL012', 'Maison avec jardin en banlieue'
UNION ALL
SELECT 'JKL012', 'Studio avec vue panoramique';
