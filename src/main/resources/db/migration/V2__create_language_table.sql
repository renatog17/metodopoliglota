CREATE TABLE language (
    id BIGSERIAL PRIMARY KEY,
    native_name VARCHAR(100) NOT NULL,
    language_code VARCHAR(5) NOT NULL
);
