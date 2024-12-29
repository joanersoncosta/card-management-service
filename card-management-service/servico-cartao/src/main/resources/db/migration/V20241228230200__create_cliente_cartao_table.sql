CREATE TABLE cliente_cartao (
    id_cliente_cartao UUID PRIMARY KEY,
    cpf VARCHAR(255) NOT NULL,
    id_cartao UUID NOT NULL,
    limite DECIMAL(15, 2) NOT NULL
);