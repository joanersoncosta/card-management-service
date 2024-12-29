CREATE TABLE cartao (
    id_cartao UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    bandeira VARCHAR(255) NOT NULL,
    renda DECIMAL(15, 2) NOT NULL,
    limite_basico DECIMAL(15, 2) NOT NULL
);