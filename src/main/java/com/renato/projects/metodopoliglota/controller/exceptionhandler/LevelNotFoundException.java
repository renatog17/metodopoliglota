package com.renato.projects.metodopoliglota.controller.exceptionhandler;

import com.renato.projects.metodopoliglota.domain.enums.LevelCode;

public class LevelNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private final LevelCode levelCode;

    public LevelNotFoundException(LevelCode levelCode) {
        super("Level Code not found: " + levelCode);
        this.levelCode = levelCode;
    }

    public LevelCode getLevelCode() {
        return levelCode;
    }
}
