package com.renato.projects.metodopoliglota.controller.exceptionhandler;

public class DeckNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private final Long id;

    public DeckNotFoundException(Long id) {
        super("Deck not found: " + id);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
