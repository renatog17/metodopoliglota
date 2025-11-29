CREATE TABLE users (
    id BIGSERIAL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    
    CONSTRAINT pk_users PRIMARY KEY (id)
);
