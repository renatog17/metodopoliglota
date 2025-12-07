package com.renato.projects.metodopoliglota.controller.dto.deck;

import java.time.LocalDateTime;
import java.util.List;

import com.renato.projects.metodopoliglota.controller.dto.language.ReadLanguageDTO;
import com.renato.projects.metodopoliglota.controller.dto.lexeme.ReadLexemeDTO;

public record ReadDeckDTO(
		Long id,
		LocalDateTime createdAd,
		ReadLanguageDTO readLanguageDTO,
		String name,
		String description,
		List<ReadLexemeDTO> lexemes) {

}
