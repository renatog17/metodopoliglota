package com.renato.projects.metodopoliglota.controller.dto.lexeme;

import com.renato.projects.metodopoliglota.controller.dto.deck.PostDeckDTO;
import com.renato.projects.metodopoliglota.domain.enums.LevelCode;

public record PostLexemeDTO(

    String lexeme,
    String description,
    LevelCode level,
    Long deckId,
    PostDeckDTO newDeck
		) {
}
