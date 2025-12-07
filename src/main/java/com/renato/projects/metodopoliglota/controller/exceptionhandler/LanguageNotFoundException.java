package com.renato.projects.metodopoliglota.controller.exceptionhandler;

import com.renato.projects.metodopoliglota.domain.enums.LanguageCode;

public class LanguageNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private final LanguageCode languageCode;

    public LanguageNotFoundException(LanguageCode languageCode) {
        super("Language Code not found: " + languageCode);
        this.languageCode = languageCode;
    }

    public LanguageCode getLanguageCode() {
        return languageCode;
    }
}
