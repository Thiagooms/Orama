CREATE TABLE goal (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    amount DECIMAL(12, 2) NOT NULL,
    title VARCHAR(100),
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    client_id BIGINT NOT NULL,
    CONSTRAINT fk_goal_client
        FOREIGN KEY (client_id)
        REFERENCES client(id)
);