package com.renato.projects.metodopoliglota.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renato.projects.metodopoliglota.service.DeckService;

@RequestMapping("decks")
@RestController
public class DeckController {

	private final DeckService deckService;

	public DeckController(DeckService deckService) {
		super();
		this.deckService = deckService;
	}

	@GetMapping
	public ResponseEntity<?> getDecksByUser() {
		return ResponseEntity.ok(deckService.getDecksByAuthenticatedUser());
	}
}
