CREATE VIEW v_transaction_solde AS
SELECT idCINTransaction , SUM(depot) AS depot_total, SUM(retrait) AS retrait_total, SUM(depot) - SUM(retrait) AS solde 
FROM transactions
GROUP BY idCINTransaction;
