CREATE TABLE deck_lexeme (
    id BIGSERIAL PRIMARY KEY,
    deck_id BIGINT NOT NULL,
    lexeme_id BIGINT NOT NULL,

    CONSTRAINT fk_deck_lexeme_deck
        FOREIGN KEY (deck_id)
        REFERENCES deck(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_deck_lexeme_lexeme
        FOREIGN KEY (lexeme_id)
        REFERENCES lexeme(id)
        ON DELETE CASCADE
);
