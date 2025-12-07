package com.renato.projects.metodopoliglota.controller.dto.deck;

import com.renato.projects.metodopoliglota.domain.enums.LanguageCode;

public record PostDeckDTO(
	    String name,
	    LanguageCode language,
	    String description
	) {}
