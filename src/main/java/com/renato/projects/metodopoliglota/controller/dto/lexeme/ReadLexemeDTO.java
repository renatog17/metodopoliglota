package com.renato.projects.metodopoliglota.controller.dto.lexeme;

import java.util.List;

import com.renato.projects.metodopoliglota.domain.enums.LevelCode;

public record ReadLexemeDTO(
		Long id,
		String lexeme, 
		String description,
		List<LevelCode> levels) {

}
