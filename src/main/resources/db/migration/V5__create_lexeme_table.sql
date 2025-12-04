CREATE TABLE lexeme (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    lexeme VARCHAR(255) NOT NULL,
    description TEXT
);
