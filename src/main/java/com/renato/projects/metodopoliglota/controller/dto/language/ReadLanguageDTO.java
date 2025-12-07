package com.renato.projects.metodopoliglota.controller.dto.language;

import com.renato.projects.metodopoliglota.domain.Language;
import com.renato.projects.metodopoliglota.domain.enums.LanguageCode;

public record ReadLanguageDTO(
		LanguageCode languageCode
		) {

	public ReadLanguageDTO(Language language) {
		this(language.getLanguageCode());
	}

}
