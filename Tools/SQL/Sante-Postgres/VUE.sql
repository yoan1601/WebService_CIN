SELECT
    c.*,
    a.*,
    m.*
FROM
    citoyens c
LEFT JOIN
    allergies a ON c.idCIN = a.idCINAllergie
LEFT JOIN
    maladieChroniques m ON c.idCIN = m.idCINMaladieChronique;