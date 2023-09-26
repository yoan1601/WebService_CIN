CREATE TABLE banques (
    idBanque INT IDENTITY(1,1) PRIMARY KEY,
    idCINBanque NVARCHAR(255) NOT NULL,
    descriptionBanque NVARCHAR(255) NOT NULL
);

INSERT INTO banques (idCINBanque, descriptionBanque)
VALUES ('123456', 'Banque Centrale de Madagascar');

INSERT INTO banques (idCINBanque, descriptionBanque)
VALUES ('ABC123', 'Banque Centrale de Madagascar');

INSERT INTO banques (idCINBanque, descriptionBanque)
VALUES ('DEF456', 'Bank of Africa Madagascar');

INSERT INTO banques (idCINBanque, descriptionBanque)
VALUES ('GHI789', 'BNI Madagascar');

INSERT INTO banques (idCINBanque, descriptionBanque)
VALUES ('JKL012', 'BFV-SG Madagascar');

CREATE TABLE transactions (
    idTransaction INT IDENTITY(1,1) PRIMARY KEY,
    nomBanque NVARCHAR(255) NOT NULL,
    idCINTransaction NVARCHAR(255) NOT NULL,
    descriptionTransaction NVARCHAR(255) NOT NULL,
    depot NUMERIC(10,2) DEFAULT 0,
    retrait NUMERIC(10,2) DEFAULT 0,
    dateHeureTransaction DATETIME DEFAULT GETDATE()
);

INSERT INTO transactions (nomBanque, idCINTransaction, descriptionTransaction, depot, retrait)
VALUES
    ('Banque Centrale de Madagascar', '123456', 'Dépôt initial', 1000.00, 0),
    ('Banque Centrale de Madagascar', '123456', 'Retrait mensuel', 0, 200.00),
    ('Banque Centrale de Madagascar', '123456', 'Achat en ligne', 50.00, 0);

INSERT INTO transactions (nomBanque, idCINTransaction, descriptionTransaction, depot, retrait)
VALUES
    ('Banque Centrale de Madagascar', 'ABC123', 'Dépôt initial', 1000.00, 0),
    ('Banque Centrale de Madagascar', 'ABC123', 'Retrait mensuel', 0, 200.00),
    ('Banque Centrale de Madagascar', 'ABC123', 'Achat en ligne', 50.00, 0);

INSERT INTO transactions (nomBanque, idCINTransaction, descriptionTransaction, depot, retrait)
VALUES
    ('Bank of Africa Madagascar', 'DEF456', 'Dépôt initial', 1500.00, 0),
    ('Bank of Africa Madagascar', 'DEF456', 'Retrait mensuel', 0, 300.00),
    ('Bank of Africa Madagascar', 'DEF456', 'Achat en ligne', 100.00, 0);

INSERT INTO transactions (nomBanque, idCINTransaction, descriptionTransaction, depot, retrait)
VALUES
    ('BNI Madagascar', 'GHI789', 'Dépôt initial', 800.00, 0),
    ('BNI Madagascar', 'GHI789', 'Retrait mensuel', 0, 100.00),
    ('BNI Madagascar', 'GHI789', 'Achat en ligne', 30.00, 0);

INSERT INTO transactions (nomBanque, idCINTransaction, descriptionTransaction, depot, retrait)
VALUES
    ('BFV-SG Madagascar', 'JKL012', 'Dépôt initial', 2000.00, 0),
    ('BFV-SG Madagascar', 'JKL012', 'Retrait mensuel', 0, 250.00),
    ('BFV-SG Madagascar', 'JKL012', 'Achat en ligne', 80.00, 0);



