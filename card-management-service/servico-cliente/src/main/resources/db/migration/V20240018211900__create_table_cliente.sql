CREATE TABLE cliente (
    id_cliente UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    email VARCHAR(255) NOT NULL,
    idade INT NOT NULL,
    data_cadastro TIMESTAMP
);