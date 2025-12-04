CREATE TABLE lexeme_level (
    id BIGSERIAL PRIMARY KEY,
    lexeme_id BIGINT NOT NULL,
    level_id BIGINT NOT NULL,

    CONSTRAINT fk_word_level_lexeme
        FOREIGN KEY (lexeme_id)
        REFERENCES lexeme(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_word_level_level
        FOREIGN KEY (level_id)
        REFERENCES level(id)
        ON DELETE RESTRICT
);
