CREATE TABLE transactions (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    amount NUMERIC(12, 2) NOT NULL,
    description VARCHAR(500),
    category VARCHAR(50) NOT NULL,
    client_id BIGINT NOT NULL,
    created_at DATE NOT NULL DEFAULT CURRENT_DATE,
    CONSTRAINT fk_transaction_client FOREIGN KEY (client_id) REFERENCES client(id)
);