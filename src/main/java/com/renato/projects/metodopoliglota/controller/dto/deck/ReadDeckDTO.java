package com.renato.projects.metodopoliglota.controller.dto.deck;

import java.time.LocalDateTime;
import java.util.List;

import com.renato.projects.metodopoliglota.controller.dto.lexeme.ReadLexemeDTO;
import com.renato.projects.metodopoliglota.domain.Language;

public record ReadDeckDTO(
		Long id,
		LocalDateTime createdAd,
		Language language,
		String name,
		String description,
		List<ReadLexemeDTO> lexemes) {

}
