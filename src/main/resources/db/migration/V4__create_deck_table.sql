CREATE TABLE deck (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    language_id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    user_id BIGINT NOT NULL,
    
    CONSTRAINT fk_set_language
        FOREIGN KEY (language_id)
        REFERENCES language(id)
        ON DELETE RESTRICT,

    CONSTRAINT fk_set_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
);
